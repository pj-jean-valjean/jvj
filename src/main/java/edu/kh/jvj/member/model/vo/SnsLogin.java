package edu.kh.jvj.member.model.vo;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

public class SnsLogin {

	private OAuth20Service oauthService;
	private SnsValue sns;

	public SnsLogin(SnsValue sns) {

		if(sns.isNaver()) {
			this.oauthService = new ServiceBuilder(sns.getClientId())
					.apiSecret(sns.getClientSecret())
					.callback(sns.getRedirectUrl())
					.scope("profile")
					.build(sns.getApi20Instance());

		}  else if(sns.isKakao()) {
			this.oauthService = new ServiceBuilder(sns.getClientId())
					.apiSecret(sns.getClientSecret())
					.callback(sns.getRedirectUrl())
					.build(sns.getApi20Instance());
		}

		this.sns = sns;
	}

	public String getSnsAuthURL() {
		return this.oauthService.getAuthorizationUrl();
	}

	public Member getNaverUserProfile(String code, String snsService) throws Exception{

		OAuth2AccessToken accessToken = oauthService.getAccessToken(code);

		OAuthRequest request = new OAuthRequest(Verb.GET, this.sns.getProfileUrl());
		oauthService.signRequest(accessToken, request);
		Response resp = oauthService.execute(request);

		Member member = new Member();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(resp.getBody());

		JsonNode resNode = rootNode.get("response");

		member.setId(resNode.get("id").asText());
		member.setMemberNickname(resNode.get("nickname").asText());
		member.setMemberEmail(resNode.get("email").asText());
		member.setMemberName(resNode.get("name").asText());
		member.setService(snsService);

		return member;
	}


	public Member getKakaoUserProfile(String code, String snsService) throws Exception{
		String access_Token = "";
		String refresh_Token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";

		URL url = new URL(reqURL);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		//  URL연결은 입출력에 사용 될 수 있고, POST 혹은 PUT 요청을 하려면 setDoOutput을 true로 설정해야함.
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);

		//	POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		StringBuilder sb = new StringBuilder();
		sb.append("grant_type=authorization_code");
		sb.append("&client_id=dce5678c6c2aceeae891719b598cbe3b");  //본인이 발급받은 key
		sb.append("&redirect_uri=http://localhost:8080/jvj/member/kakao/callback");     // 본인이 설정해 놓은 경로
		sb.append("&code=" + code);
		bw.write(sb.toString());
		bw.flush();

		//    결과 코드가 200이라면 성공
		int responseCode = conn.getResponseCode();

		//    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line = "";
		String result = "";


		while ((line = br.readLine()) != null) {
			result += line;
		}

		//    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
        ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(result);
		access_Token = rootNode.get("access_token").asText();
		refresh_Token = rootNode.get("refresh_token").asText();

		String reqInfoURL = "https://kapi.kakao.com/v2/user/me";
		String resultInfo = "";
		URL urlInfo = new URL(reqInfoURL);
		conn = (HttpURLConnection) urlInfo.openConnection();
		conn.setRequestMethod("GET");

		//    요청에 필요한 Header에 포함될 내용
		conn.setRequestProperty("Authorization", "Bearer " + access_Token);

		responseCode = conn.getResponseCode();

		br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		while ((line = br.readLine()) != null) {
			resultInfo += line;
		}
		
		br.close();
		bw.close();
		
		
		System.out.println("response body : " + resultInfo);
		
		JsonNode resultNode = mapper.readTree(resultInfo);
		
		JsonNode kakao_account = resultNode.get("kakao_account");
		JsonNode profile = kakao_account.get("profile");
		
		Member member = new Member();

		member.setId(resultNode.get("id").asText());
		member.setMemberNickname(profile.get("nickname").asText());
		member.setMemberEmail(kakao_account.get("email").asText());
		member.setService(snsService);
		
		return member;
	}

}

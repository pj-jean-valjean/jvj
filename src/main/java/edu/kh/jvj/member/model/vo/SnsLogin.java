package edu.kh.jvj.member.model.vo;


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

	public String getNaverAuthURL() {
		return this.oauthService.getAuthorizationUrl();
	}

	public Member getUserProfile(String code) throws Exception{
		OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
		
		System.out.println("1");
	 
		OAuthRequest request = new OAuthRequest(Verb.GET, this.sns.getProfileUrl());
		oauthService.signRequest(accessToken, request);
		
		System.out.println("2");
		
		Response resp = oauthService.execute(request);
		
		System.out.println("3");
		
		return parseJson(resp.getBody());
	}
	
	public Member parseJson(String body) throws Exception {
		Member member = new Member();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(body);
		
		if(this.sns.isNaver()) {
			
			JsonNode resNode = rootNode.get("response");
		
			String id = resNode.get("id").asText();
			String nickname = resNode.get("nickname").asText();
			String email = resNode.get("email").asText();
			String name = resNode.get("name").asText();
			
//			member.setId(id);
			member.setMemberNickname(nickname);
			member.setMemberEmail(email);
			member.setMemberName(name);
		
		} else if(this.sns.isKakao()) {
			
		}

		return member;
	}
}

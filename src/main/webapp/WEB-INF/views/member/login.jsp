<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
<link rel="stylesheet" href="${contextPath}/resources/css/member/login.css">

<content>
  <div class="login-title">
        <p class="text-center">로그인</p>
    </div> 
    
    <form>  
        <div class="input-info">
            <div class="input-info-div">
                <div class="p-div"><p>Email</p></div>
                <div class="input-div"><input type="text" class="receiver-info"></div>
            </div>
            <div class="input-info-div">
                <div class="p-div"><p>Password</p></div>
                <div class="input-div"><input type="password" class="receiver-info"></div>
            </div>

        </div>

        <div class="saveContent">
            <div>
                <label class="container">아이디 저장
                    <input type="checkbox">
                    <span class="checkmark"></span>
                </label>


                <ul>
                    <li><a href="${contextPath}/member/searchId"><span>아이디 찾기</span></a><div class="updown"></div></li>
                    <li><a href="${contextPath}/member/searchPw"><span>비밀번호 찾기</span></a></li>
                </ul>
            </div>
        </div>

        <div class="login-btn">
            <button type="submit" id="login">로그인</button>
        </div>
    </form> 
        


    

    <div class="login-btns">
        <a href="#">
            <div class="login-kakao">
                <img src="${contextPath}/resources/images/member/kakao-talk.png">
                <p>카카오톡으로 로그인</p>
            </div>
        </a>
        <a href="#">
            <div class="login-naver">
                <img src="${contextPath}/resources/images/member/naver.png">
                <p>네이버로 로그인</p>
            </div>
        </a>
    </div>

    <ul class="goSignUp">
        <li><a href="${contextPath}/member/signUp"><span>아직 회원이 아니신가요?</span></a></li> 
    </ul>
</content>

<jsp:include page="../common/footer.jsp" />
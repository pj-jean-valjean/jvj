<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
<link rel="stylesheet" href="${contextPath}/resources/css/login.css">

<content>

    <div class="login-title">
        <p class="text-center">로그인</p>
    </div> 
    
    <div class="login-img">
        <img src="${contextPath}/resources/images/member/login_main_img.jpg">
    </div>

    <div class="login-btns">
        <a href="#">
            <div class="login-kakao">
                <img src="${contextPath}/resources/images/member/kakao-talk.png">
                <span>카카오톡으로 로그인</span>
            </div>
        </a>
        <a href="#">
            <div class="login-naver">
                <img src="${contextPath}/resources/images/member/naver.png">
                <span>네이버로 로그인</span>
            </div>
        </a>
        <a href="#">
            <div class="login-google">
                <img src="${contextPath}/resources/images/member/google.png">
                <span>구글로 로그인</span>
            </div>
        </a>
    </div>

    <a href="${contextPath}/member/signUp"><p class="goSignUp">회원가입</p></a>
</content>

<jsp:include page="../common/footer.jsp" />
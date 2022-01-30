<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
 <link rel="stylesheet" href="${contextPath}/resources/css/member/searchIdResult.css">

<content>

    <div class="login-title">
        <p class="text-center">찾으시는 이메일</p>
    </div> 

    <div class="login-title">
        <p class="text-center">user01@google.com</p>
    </div> 
    
   
    <div class="flex-div">
        <ul class="goSignUp">
            <li><a href="${contextPath}/member/login"><span>로그인</span></a><div class="updown"></div></li>
            <li><a href="${contextPath}/member/searchPw"><span>비밀번호 찾기</span></a><div class="updown"></div></li>
            <li><a href="${contextPath}/member/signUp"><span>회원가입</span></a></li>
        </ul>
    </div>
</content>

<jsp:include page="../common/footer.jsp" />
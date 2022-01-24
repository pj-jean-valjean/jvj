<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<jsp:include page="../common/header.jsp" />
	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/signUp.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
</head>
<body>
	<main>
        <section class="signUp-title">
                <p>회원가입</p>

                <img src="${contextPath}/resources/images/sub-bread-main.jpg" alt="sub-bread-main">
        </section>
        
        <section class="signUp-content">
            <div class="signUp-btn kakao" onclick="location.href ='#'">
                <img src="${contextPath}/resources/images/kakao-talk.png" alt="kakao-talk">
                <span>카카오톡으로 가입하기</span> 
            </div>
            <div class="signUp-btn naver" onclick="location.href ='#'">
                <img src="${contextPath}/resources/images/naver.png" alt="naver">
                <span>네이버로 가입하기</span> 
            </div>
            <div class="signUp-btn google" onclick="location.href ='#'">
                <img src="${contextPath}/resources/images/google.png" alt="google">
                <span>구글로 가입하기</span>
            </div>
        </section>
        
        <section>          
            <div class="login-link">
                <a href="#">이미 회원이신가요?</a>
            </div>
        </section>
    </main>
    
    
    
	<jsp:include page="../common/footer.jsp" />
	<script type="text/javascript" src="${contextPath}/resources/js/signUp.js"></script>
</body>
</html>
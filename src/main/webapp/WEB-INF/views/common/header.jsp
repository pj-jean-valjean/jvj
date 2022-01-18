<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500;700&display=swap" rel="stylesheet">
	
	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">

</head>
<body>
	<header>
        <section class="nav">
            <ul class="nav-menu">
                <li><a href="">정기 구독</a></li>
                <li>|</li>
                <li><a href="">스토어</a></li>
                <li>|</li>
                <li><a href="">원데이 클래스</a></li>
                <li>|</li>
                <li><a href="">공지사항</a></li>
            </ul>
            
            <div class="nav-logo">
                <img src="{contextPath}/resources/images/jvj_logo.png">
            </div>
            <ul class="nav-login">
                <li>
                    <input class="nav-search" type="text" list="search-options" maxlength="20">
                    <datalist class="search-options" id="search-options">
                        <option value="장발장 바게트" />
                        <option value="장발장 식빵" />
                        <option value="초코 식빵" />
                        <option value="로우키 커피" />
                    </datalist>
                </li>

                <!-- 비로그인 -->
                <!-- <li><a href="">로그인</a></li>  -->

                <!-- 로그인 -->
                <li>
                    <a href="">
                        <img src="{contextPath}/resources/images/user.png" alt="">
                    </a>
                    <a href="">
                        <img class="shopping-img" src="{contextPath}/resources/images/shopping.png" alt="">
                    </a>
                </li>
            </ul>
        </section>
    </header>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500;700&display=swap" rel="stylesheet">
	<link rel="icon" href="${contextPath}/resources/images/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
	
	<!-- swalalert -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

</head>


<body>
	<header>
        <section class="nav">
            <ul class="nav-menu">
                <li><a href="${contextPath}/subscribe/subMain">정기 구독</a></li>
                <li>|</li>
                <li><a href="${contextPath}/store?cp=1&ct=0&op=0">스토어</a></li>
                <li>|</li>
                <li><a href="${contextPath}/onedayclass/list">원데이 클래스</a></li>
                <li>|</li>
                <li><a href="${contextPath}/notice/list">공지사항</a></li>
            </ul>
            
            <div class="nav-logo">
            <a href="${contextPath}">
                <img src="${contextPath}/resources/images/common/jvj_logo.png" alt="jvj_logo">
                </a>
            </div>
            <ul class="nav-login">
                

				<c:choose>
				<c:when test="${empty loginMember}">
	                <!-- 비로그인 -->
	                <li><a href="${contextPath}/member/login">로그인</a></li>
				</c:when>
				<c:otherwise>
                <!-- 로그인 -->
	                <li>
	                    <a href="">
	                        <img src="${contextPath}/resources/images/common/user.png" alt="user">
	                    </a>
	                    <a href="">
	                        <img class="shopping-img" src="${contextPath}/resources/images/common/shopping.png" alt="shopping">
	                    </a>
						<a href="${contextPath}/member/logout" title="logout-icon">
							<img class="logout-img" src="${contextPath}/resources/images/common/icon-logout.png">
						</a>	                    
	                </li>
	             </c:otherwise>
				</c:choose>

                
                <li>
                    <input class="nav-search" type="text" list="search-options" maxlength="20">
                    <datalist class="search-options" id="search-options">
                        <option value="장발장 바게트" />
                        <option value="장발장 식빵" />
                        <option value="초코 식빵" />
                        <option value="로우키 커피" />
                    </datalist>
                </li>
            </ul>
        </section>
    </header>

	
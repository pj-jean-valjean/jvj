<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
    <link rel="stylesheet" href="/reset.css">
   	<link rel="stylesheet" href="${contextPath}/resources/css/admin/adminLogin.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@600&display=swap" rel="stylesheet">
</head>
<body>
    <div id="admin-wraaper">
        <div id="adminlogin-box">
            <h1 class="prjName">Jean Val Jean</h1>
            <h1 class="admin-title">관리자 로그인</h1>
            <form action="" method="POST">
                <div class="login-one-line">
                    <label for="adminId">아이디</label><input type="text" name="adminId" id="adminId" class="admin-input">
                </div>
                <div class="login-one-line">
                    <label for="adminPw">비밀번호</label><input type="password" name="adminPw" id="adminPw" class="admin-input">
                </div>
                <div class="login-one-line loginbtn">
                    <button>로그인</button>
                    <button>취소</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
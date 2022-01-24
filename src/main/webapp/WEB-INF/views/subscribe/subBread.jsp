<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<jsp:include page="../common/header.jsp" />
 	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/subBread.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
</head>
<body>
	
	
	
	
	
	
	
	
	
	<jsp:include page="../common/footer.jsp" />	
	<script type="text/javascript" src="${contextPath}/resources/js/subBread.js"></script>
</body>
</html>
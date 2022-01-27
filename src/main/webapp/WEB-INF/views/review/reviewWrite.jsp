<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JVJ 공지사항</title>
<jsp:include page="../common/header.jsp" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
 	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/admin/reviewWrite.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
</head>
<body>
      <main>
        <section>
            <article>
                <h1 id="classpname">리뷰 작성</h1>
                <form action="" method="get" onsubmit="return validate();">
                <div id="notice-info">
                    <div id="notice-title">
                        <span>제목</span>
                        <input type="text" name="review-title" placeholder="제목을 입력해주세요">
                    </div>
                    <div id="notice-create-dt">
                        <span>평점</span>
                        <label><input type="radio" name="review-point" value="5">
                        <i class="fas fa-star gold"></i>
                        <i class="fas fa-star gold"></i>
                        <i class="fas fa-star gold"></i>
                        <i class="fas fa-star gold"></i>
                        <i class="fas fa-star gold"></i>
                        </label>
                        <label><input type="radio" name="review-point" value="4">
                        <i class="fas fa-star gold"></i>
                        <i class="fas fa-star gold"></i>
                        <i class="fas fa-star gold"></i>
                        <i class="fas fa-star gold"></i>
                        <i class="fas fa-star gray"></i>
                        </label>
                        <label><input type="radio" name="review-point" value="3">
                        <i class="fas fa-star gold"></i>
                        <i class="fas fa-star gold"></i>
                        <i class="fas fa-star gold"></i>
                        <i class="fas fa-star gray"></i>
                        <i class="fas fa-star gray"></i>
                        </label>
                        <label><input type="radio" name="review-point" value="2">
                            <i class="fas fa-star gold"></i>
                            <i class="fas fa-star gold"></i>
                            <i class="fas fa-star gray"></i>
                            <i class="fas fa-star gray"></i>
                            <i class="fas fa-star gray"></i>
                        </label>
                        <label><input type="radio" name="review-point" value="1">
                            <i class="fas fa-star gold"></i>
                            <i class="fas fa-star gray"></i>
                            <i class="fas fa-star gray"></i>
                            <i class="fas fa-star gray"></i>
                            <i class="fas fa-star gray"></i>
                        </label>
                    </div>
                    <div id="notice-content">
                        <textarea name="reviewcontent" id="" placeholder="내용을 입력해주세요"></textarea>
                    </div>
                    <span id="rvbtns">
                        <button type="button" id="gotolist" class="rvbtn">목록으로</button>
                        <button type="submit" id="submitrv" class="rvbtn">등록</button>
                        <button type="reset" id="canclerv" class="rvbtn">취소</button>
                    </span>
                    </div>
                </form>
            </article>
        </section>
    </main>
	<jsp:include page="../common/footer.jsp" />	
		<script type="text/javascript" src="${contextPath}/resources/js/admin/reviewWrite.js"></script>
</body>
</html>
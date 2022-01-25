<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JVJ 공지사항</title>
<jsp:include page="../common/header.jsp" />
 	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/admin/notice.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
</head>
<body>
    <main>
        <section>
            <!-- 공지사항 리스트 -->
            <article>
                <div id="pathline"><a href="">HOME</a>&gt;<a href="">공지사항</a></div>
                <h1 id="classpname" style="font-size: 40px;">공지사항</h1>
                <div id="align-div">
                    <i class="fas fa-map-marker-alt"></i>
                    <select id='selectcate'>
                        <option>전체</option>
                        <option>이벤트</option>
                        <option>프로모션</option>
                        <option>공지사항</option>
                    </select>
                </div>
                <div id="noticebox">
                    <div class="one-line-notice header-notice">
                        <span>번호</span>
                        <span>카테고리</span>
                        <span>제목</span>
                        <span>작성자</span>
                        <span>작성일</span>
                    </div>
                    <div class="one-line-notice">
                        <span>1</span>
                        <span>이벤트</span>
                        <span>설 연휴 배송 안내</span>
                        <span>장발장식빵</span>
                        <span>2022-01-12 11:27:22</span>
                    </div>
                    <div class="one-line-notice">
                        <span>1</span>
                        <span>이벤트</span>
                        <span>설 연휴 배송 안내</span>
                        <span>장발장식빵</span>
                        <span>2022-01-12 11:27:22</span>
                    </div>
                    <div class="one-line-notice">
                        <span>1</span>
                        <span>이벤트</span>
                        <span>설 연휴 배송 안내</span>
                        <span>장발장식빵</span>
                        <span>2022-01-12 11:27:22</span>
                    </div>
                    <div class="one-line-notice">
                        <span>1</span>
                        <span>이벤트</span>
                        <span>설 연휴 배송 안내</span>
                        <span>장발장식빵</span>
                        <span>2022-01-12 11:27:22</span>
                    </div>
                    <div class="one-line-notice">
                        <span>1</span>
                        <span>이벤트</span>
                        <span>설 연휴 배송 안내</span>
                        <span>장발장식빵</span>
                        <span>2022-01-12 11:27:22</span>
                    </div>
                    <div class="one-line-notice">
                        <span>1</span>
                        <span>이벤트</span>
                        <span>설 연휴 배송 안내</span>
                        <span>장발장식빵</span>
                        <span>2022-01-12 11:27:22</span>
                    </div>
                    <div class="one-line-notice">
                        <span>1</span>
                        <span>이벤트</span>
                        <span>설 연휴 배송 안내</span>
                        <span>장발장식빵</span>
                        <span>2022-01-12 11:27:22</span>
                    </div>
                    <div class="one-line-notice">
                        <span>1</span>
                        <span>이벤트</span>
                        <span>설 연휴 배송 안내</span>
                        <span>장발장식빵</span>
                        <span>2022-01-12 11:27:22</span>
                    </div>
                    <div class="one-line-notice">
                        <span>1</span>
                        <span>이벤트</span>
                        <span>설 연휴 배송 안내</span>
                        <span>장발장식빵</span>
                        <span>2022-01-12 11:27:22</span>
                    </div>
                    <div class="one-line-notice">
                        <span>1</span>
                        <span>이벤트</span>
                        <span>설 연휴 배송 안내</span>
                        <span>장발장식빵</span>
                        <span>2022-01-12 11:27:22</span>
                    </div>
                </div>
            </article>
            <!-- 페이지네이션 -->
            <article>
            </article>
        </section>
    </main>
	<jsp:include page="../common/footer.jsp" />	
</body>
</html>
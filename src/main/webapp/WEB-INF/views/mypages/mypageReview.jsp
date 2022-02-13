<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성된 리뷰 관리페이지</title>
<jsp:include page="../common/header.jsp" />
 	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/admin/notice.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/myPage/mypageReview.css">
</head>
<body>
	    <main>
         <div class="titleText">
        <span>리뷰 관리 페이지</span>
    </div>

   

    <section class="bodySection">
    <jsp:include page="mypageMenu.jsp"/>	
       
		 <article>
                <div class="selectDiv">
                    <span>최근 6개월내 작성하신 목록입니다.</span>
                    <select name="" id="selectOption">
                        <option value="">전체</option>
                        <option value="">1개월</option>
                        <option value="">3개월</option>
                        <option value="">6개월</option>
                    </select>
                </div>
    
                <div class="mainTable">
                    <div class="tList thList">
                        <ul class="tname">
                            <li>별점</li>
                            <li>작성 내용</li>
                            <li>작성일</li>
                            <li></li>
                        </ul>
                    </div>
                    <div class="tList tbList">
                        <ul class="tbname">
                            <li>
                                <span>★</span>
                                <span>★</span>
                                <span>★</span>
                                <span>★</span>
                                <span>★</span>
                            </li>
                            <li>빵이 맛이 있엉요</li>
                            <li>2022-01-02</li>
                            <li>
                                <a class="p-btn" id="btn-pur" href="recorrect">리뷰 수정</a>
                                <button class="p-btn" id="btn-del" type="button">리뷰 삭제</button>
                            </li>
                        </ul>
                       
                       
                       
                    </div>
                    
                </div>

            </article>
		

        <article class="pagination-area">
					<ul class="pagination">
		<c:if test="${pagination.startPage !=1 }">
			<li><a class="page-link"
				href="?cp=1&sr=${param.sr}">&lt;&lt;</a></li>
			<li><a class="page-link"
				href="?cp=${pagination.prevPage}&sr=${param.sr}">&lt;</a></li>
		</c:if>

		<%-- 페이지 네이션 번호 목록 --%>
		<c:forEach begin="${pagination.startPage }"
			end="${pagination.endPage}" step="1" var="i">
			<c:choose>
				<c:when test="${i==pagination.currentPage}">
					<li><a class="page-link"
						style="padding: 6px 12px; border-radius: 20px; background-color: #B9845A; color: white;">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li><a class="page-link" style="margin: 5px"
						href="?cp=${i}&sr=${param.sr}">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${pagination.endPage != pagination.maxPage }">
			<li><a class="page-link"
				href="?cp=${pagination.nextPage}&sr=${param.sr}">&gt;</a></li>
			<li><a class="page-link"
				href="?cp=${pagination.maxPage }&sr=${param.sr}">&gt;&gt;</a></li>
		</c:if>
	</ul>
	</article>e>        
    </section>
    </main>
	<jsp:include page="../common/footer.jsp" />	
</body>
</html>
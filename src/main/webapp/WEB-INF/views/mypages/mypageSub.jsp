<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구독 상품 신청 내역</title>
<jsp:include page="../common/header.jsp" />
 	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/admin/notice.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPageSub.css/">
</head>
<body>
	<main>
    <div class="titleText">
        <span>구독 상품 신청 내역</span>
    </div>

    <section>
    
    
    <jsp:include page="mypageMenu.jsp"/>	
    
    
         <article>
                <div class="toDay">
                    <span>최근 주문하신 내역입니다.</span>
                </div>
    			
                <div class="mainTable">
                
                    <div class="tList thList">
                        <ul class="tname">
                            <li>정기 구독명</li>
                            <li>구독 신청일</li>
                            <li>상품 옵션</li>
                            <li></li>
                        </ul>
                    </div>
               
                
                <c:forEach var="subList" items="${subList}">
                
                <c:choose>
                	<c:when test="${empty subList}">
                	</c:when>
                	
                	<c:otherwise>
                	 <div class="tList tbList">
                        <ul class="tbname">
                            <li>${subList.productName}</li>
                            <li>${subList.paymentDate}</li>
                            <li>${subList.orderOption}</li>
                            <li>
                             <button class="p-btn" id="btn-pur" >재구매</button>
                            </li>
                        </ul>
                    </div>
                	</c:otherwise>
                	
                </c:choose>
                   
                   </c:forEach>  
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
	</article>
        
    </section>
    </main>
	<jsp:include page="../common/footer.jsp" />	
	
	<script type="text/javascript">
	
	document.getElementById("btn-pur").addEventListener("click", function(){
		
			location.href = "${contextPath}/subscribe/subMain"
		
	});

	
	</script>
</body>
</html>
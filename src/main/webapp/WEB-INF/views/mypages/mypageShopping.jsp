<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>최근 상품 주문내역</title>
<jsp:include page="../common/header.jsp" />
 	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/admin/notice.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPageShopping.css">
</head>
<body>
	    <main>
         <div class="titleText">
        <span>최근 상품 주문내역</span>
    </div>

   

    <section class="bodySection">
    <jsp:include page="mypageMenu.jsp"/>	
       
		<article>

            <div class="toDay">
                <span>최근 주문하신 내역입니다.</span>
            </div>

            <div class="mainTable">
                <div class="thList">
                    <ul class="tname">
                        <li></li>
                        <li>상품명/옵션</li>
                        <li>날짜/상품번호</li>
                        <li>상품금액/수량</li>
                        <li></li>
                    </ul>
                </div>
					
               
                
                
                <c:forEach var="purchase" items="${purchase}">
                <c:choose>
               
               		<c:when test="${empty purchase}">
	               		<div class="tbList"></div>
	               </c:when>
               
	               <c:otherwise>
	                <div class="tbList">
	               		<ul class="tbname">
	                        <li><img src="${contextPath}/${purchase.productImgPath}/${purchase.productImgName}" alt=""></li>
	                        <li> ${purchase.productName} <br> 옵션: ${purchase.orderOption}</li>
	                        <li>${purchase.paymentDate} <br> ${purchase.productNo}</li>
	                        <li> ${purchase.totalPrice} / ${purchase.productAmount}</li>
	                        <li>
	                            <button class="p-btn" id="btn-pur">구매 내역</button>
	                            <button class="p-btn" id="btn-cc">구매 취소</button>
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
		
		location.href = "${contextPath}/payment/paymentResult"
	
});
	</script>
	
</body>
</html>
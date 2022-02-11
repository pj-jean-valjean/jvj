<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관심 상품 내역</title>
<jsp:include page="../common/header.jsp" />
 	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/admin/notice.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPageLove.css/">
</head>
<body>
	    <main>
         <div class="titleText">
        <span>좋아요 상품 내역</span>
    </div>

   

    <section>
    <div class="divNav">
        <div id="hr"></div>
        <ul>
        	<li class="topText ">회원 관리</li>
        	<li class="subText"><a href="main">마이 페이지</a></li>
        	<li class="subText mbText"><a href="info">회원 정보</a></li>
        	<li class="subText mbText"><a href="coupon">쿠폰 정보</a></li>
        </ul>
        <ul>
        	<li class="topText mTopText">쇼핑정보</li>
        	<li class="subText"><a href="purchase">상품 주문 내역</a></li>
            <li class="subText"><a href="sub">구독 신청 내역</a></li>
            <li class="subText"><a href="class">수강 신청 내역</a></li>
            <li class="subText"><a href="love">좋아요 내역</a></li>
            <li class="subText"><a href="review">작성한 리뷰 내역</a></li>
        </ul>
    </div> 	
       
		<article>
            <article style="height:800px">
                <div class="mainTable">
                    <div class="tList thList">
                        <ul class="tname">
                            <li></li>
                            <li>상품명</li>
                            <li>가격</li>
                            <li></li>
                        </ul>
                    </div>
                    
                    <div class="tList tbList">
                    
                    <c:choose>
	                    <c:when test="${empty likeList}">
							<div style="color:rgba(167, 138, 108, 1); background-color:rgba(167, 138, 108, 0.3); 
										font-size:20px; font-weight:bold; text-align:center; height:600px; 
										display: flex; align-items: center; justify-content: center;">
							좋아요 하신 상품이 존재하지 않습니다.
							</div>	                    	
	                    </c:when>
	                    
	                    <c:otherwise>
	                    
	                    	<c:forEach items="${likeList}" var="like">
	                    	
		                        <ul class="tbname">
		                        
		                            <li><img src="${contextPath}/${like.productImagePath}/${like.productImageName}" alt=""></li>
		                            <li>${like.productName} 
		                            </li>
		                            <li>${like.productPrice}</li>
		                            <li>
			                           <button class="p-btn" id="btn-pur" >바로 구매</button>
			                           <button class="p-btn" id="btn-cc"  onclick="cancelLike(${like.productNo})">좋아요 삭제</button>
		                            </li>
		                        </ul>
	                        </c:forEach>
	                    </c:otherwise>
                     </c:choose>  
                    </div>
                    
                </div>

            </article>
        </article>

       <article>
            <div class="page">
            
                <ul class="pagination">
                
                <c:if test="${paginationLike.startPage != 1}">
                    <li><a href="love?cp=1" class="first pagi">&lt;&lt;</a></li> 
                    <li><a href="love?cp=${pagination.prevPage}" class="previous pagi">&lt;</a></li> 
				</c:if>
				
				<c:forEach begin="${paginationLike.startPage}" end="${paginationLike.endPage}" step="1"  var="l">
					<c:choose>
						<c:when test="${l == paginationLike.currentPage}">
							<li class="pagiList"><a class="pagiLink">${l}</a></li>
						</c:when>
						
						<c:otherwise>
							<li class="pagiList"><a class="pagiLink" href="love?cp=${l}">${l}</a></li>
						</c:otherwise>
						
					</c:choose>
				
				
				</c:forEach>
                   
                	<c:if test="${paginationLike.endPage != paginationLike.maxPage }">
                	
                    <li> <a href="love?cp=${paginationLike.nextPage}" class="next pagi">&gt;</a></li> 
                    <li><a href="love?cp=${paginationLike.maxPage}" class="last pagi">&gt;&gt;</a></li> 
                    </c:if>
                    
                </ul>
            </div>  
        </article>
        
        
    </section>
    </main>
    	
    <script>
	    const contextPath = "${contextPath}";
			
	</script> 
	
	<jsp:include page="../common/footer.jsp" />	
	<script src="${contextPath}/resources/js/mypage/myPageLike.js"></script> 
	
</body>
</html>
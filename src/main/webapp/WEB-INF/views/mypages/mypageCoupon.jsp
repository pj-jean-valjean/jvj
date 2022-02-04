<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보유 쿠폰 내역</title>
<jsp:include page="../common/header.jsp" />
 	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/admin/notice.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPageCoupon.css/">
</head>
<body>
	<main>
    <div class="titleText">
        <span>원데이 클래스 수강 신청 내역</span>
    </div>

    <section>
    
    
    <jsp:include page="mypageMenu.jsp"/>	
    
    
      <article>
      
     	
            <div class="selectDiv">
                <span>쿠폰 보유 내역</span>
                <select name="" id="selectOption">
                    <option value="">사용 가능</option>
                    <option value="">사용 완료</option>
                    <option value="">기간 만료</option>
                    <option value="">전체</option>
                </select>
            </div>
            <table >
                <thead >
                    <tr id="tb-tr" >
                        <td id="td1">쿠폰명</td>
                        <td id="td2">할인율</td>
                        <td id="td3">발급일</td>
                        <td id="td4">유효기간</td>
                        <td id="td5">쿠폰상태</td>
                    </tr>
                </thead>
                <tbody>
                <c:choose>
                
                	<%-- 쿠폰이 존재하지 않을 경우 --%>
                	<c:when test="${empty couponList}">
					  <tr>
						<td colspan="5" 
						style="color:rgba(167, 138, 108, 1); background-color:rgba(167, 138, 108, 0.3); 
						font-size:20px; font-weight:bold; margin-left: auto; margin-right: auto; text-align:center;
						padding-top:236px; padding-bottom:236px;">
						보유중인 쿠폰이 존재하지 않습니다.</td>
					  </tr>       
                	</c:when>
                	
                	
                	<c:otherwise>
	                	<c:forEach items="${couponList}" var="coupon">
	                	<tr class="tb-tbd">
	                        <td>${couponList.couponName}</td>
	                        <td>${couponList.discountPer}</td>
	                        <td>${couponList.provideDate}</td>
	                        <td>${couponList.expireDate}</td>
	                        <td>사용 가능</td>
	                    </tr>
	                    </c:forEach>
                	</c:otherwise>
                </c:choose>
                  
                </tbody>
            </table>
        </article>


        <article>
        
            <div class="page">
                <ul class="pagination">
                
                	<c:if test="${pagination.startPage != 1 }">
						<li><a class="first pagi" href="coupon?cp=1${c}${s}">&lt;&lt;</a></li>
						<li><a class="previous pagi" href="coupon?cp=${pagination.prevPage}${c}${s}">&lt;</a></li>
					</c:if>

                    <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" step="1"  var="i">
					<c:choose>
						<c:when test="${i == pagination.currentPage}">
							<li class="pagiList"><a class="pagiLink" >${i}</a></li>  
						</c:when>
						
						<c:otherwise>
							<li><a class="pagiList" href="coupon?cp=${i}">${i}</a></li>
						</c:otherwise>
						
					</c:choose>
				</c:forEach>
                
                    
                    <c:if test="${pagination.endPage != pagination.maxPage }">
					<li><a class="next pagi" href="list?cp=${pagination.nextPage}${c}${s}">&gt;</a></li>
					<li><a class="last pagi" href="list?cp=${pagination.maxPage}${c}${s}">&gt;&gt;</a></li>
					
				</c:if>
                </ul>
            </div>  
        </article>
        
    </section>
    </main>
	<jsp:include page="../common/footer.jsp" />	
</body>
</html>
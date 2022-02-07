<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
        <span>보유한 쿠폰 목록</span>
    </div>

    <section style="margin-top:60px" >
    
    
    <jsp:include page="mypageMenu.jsp"/>	
    
    
      <article>
      
     	
            <div class="selectDiv">
                <span>쿠폰 보유 내역</span>
                <select name="couponStatus" id="selectOption">
                	<option>전체</option>
                	<c:forEach items="${couponStatus}"  var="c">
	               		<option value="${c.couponStatusCode}">${c.couponStatusName}</option>
	            	</c:forEach>
                </select>
            </div>
            
            <%-- 파라미터 중 cs가 있다면 변수 생성 --%>
			<c:if test="${!empty param.ct}">
				<c:set var="c" value="&cs=${param.ct}"/>
			</c:if>
            
            <table style="height:742.5px">
                <thead >
                    <tr id="tb-tr" >
                        <td id="td1">쿠폰명</td>
                        <td id="td2">할인율</td>
                        <td id="td3">발급일</td>
                        <td id="td4">유효기간</td>
                        <td id="td5">쿠폰상태</td>
                    </tr>
                </thead>
                <tbody >
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
                	
                	
                	<%-- <fmt:parseDate value="${couponList.provideDate}" pattern="yyyy-MM-dd" var="provideDate" />
					<fmt:parseDate value="${couponList.expireDate}" pattern="yyyy-MM-dd" var="expireDate"/>

                	
                	<c:when test="${provideDate == expireDate}">
                					<td style="text-decoration: line-through;">${couponList.couponName}</td>
			                        <td style="text-decoration: line-through;">${couponList.discountPer}</td>
			                        <td style="text-decoration: line-through;">${couponList.provideDate}</td>
			                        <td style="text-decoration: line-through;">${couponList.expireDate}</td>
			                        <td style="text-decoration: line-through;">${couponList.couponStatusName}</td>
                	</c:when> --%>
                	
                	<c:otherwise>
		                	<c:forEach items="${couponList}" var="couponList">
			                	<tr class="tb-tbd">
			                        <td>${couponList.couponName}</td>
			                        <td>${couponList.discountPer}</td>
			                        <td>${couponList.provideDate}</td>
			                        <td>${couponList.expireDate}</td>
			                        <td>${couponList.couponStatusName}</td>
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
						<li><a class="first pagi" href="coupon?cp=1${c}">&lt;&lt;</a></li>
						<li><a class="previous pagi" href="coupon?cp=${pagination.prevPage}${c}">&lt;</a></li>
					</c:if>

                    <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" step="1"  var="i">
					<c:choose>
						<c:when test="${i == pagination.currentPage}">
							<li class="pagiList"><a class="pagiLink">${i}</a></li>  
						</c:when>
						
						<c:otherwise>
							<li><a class="pagiList" href="coupon?cp=${i}${c}">${i}</a></li>
						</c:otherwise>
						
					</c:choose>
				</c:forEach>
                
                    
                    <c:if test="${pagination.endPage != pagination.maxPage}">
					<li><a class="next pagi" href="coupon?cp=${pagination.nextPage}${c}">&gt;</a></li>
					<li><a class="last pagi" href="coupon?cp=${pagination.maxPage}${c}">&gt;&gt;</a></li>
					
				</c:if>
                </ul>
            </div>  
        </article>
        
    </section>
    </main>
	<jsp:include page="../common/footer.jsp" />	
	<script>
		
		// 쿼리스트링에서 파라미터를 얻어와 반환하는 함수
		function getParam(key){
			return new URLSearchParams(location.search).get(key);	
		}
			
		
		// 카테고리 select 세팅하기
		const ctOptions = document.querySelectorAll("select[name=ct] > option");
		for(let option of ctOptions){
			if(option.value == getParam("ct")){
				option.setAttribute("selected", true);
			}
		}
		
		
		// 카테고리 select가 change 됐을 때 
		document.getElementById("selectOption").addEventListener("change", function(){
			console.log(this.value);
			
			if(){
				
			}
		});
		
	</script>
	
</body>
</html>
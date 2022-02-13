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
    

    <section style="margin-top:60px" >
    <div class="titleText">
        <span>보유한 쿠폰 목록</span>
    </div>
    
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
						padding-top:298px; padding-bottom:371px; margin-bottum">
						보유중인 쿠폰이 존재하지 않습니다.</td>
					  </tr>       
                	</c:when>
                	
                	
                	<c:otherwise>
		                	<c:forEach items="${couponList}" var="couponList">
		                	
		                	
		                	<c:if test="${couponList.couponStatusCode == 1}">
			                	<tr class="tb-tbd">
			                        <td>${couponList.couponName}</td>
			                        <td>${couponList.discountPer}</td>
			                        <td>${couponList.provideDate}</td>
			                        <td>${couponList.expireDate}</td>
			                        <td>${couponList.couponStatusName}</td>
			                    </tr>
			                </c:if> 
			                  
			                <c:if test="${couponList.couponStatusCode == 2}">
		                		<tr class="tb-tbd">
			                	<td class="dontCoupon">${couponList.couponName}</td>
						        <td class="dontCoupon">${couponList.discountPer}</td>
						        <td class="dontCoupon">${couponList.provideDate}</td>
						        <td class="dontCoupon">${couponList.expireDate}</td>
						        <td class="dontCoupon">${couponList.couponStatusName}</td>
					        	</tr>
                			</c:if>
                			
			                <c:if test="${couponList.couponStatusCode == 3}">
		                		<tr class="tb-tbd">
			                	<td class="dontCoupon">${couponList.couponName}</td>
						        <td class="dontCoupon">${couponList.discountPer}</td>
						        <td class="dontCoupon">${couponList.provideDate}</td>
						        <td class="dontCoupon">${couponList.expireDate}</td>
						        <td class="dontCoupon">${couponList.couponStatusName}</td>
					        	</tr>
                			</c:if>
		                    </c:forEach>
                	</c:otherwise>
                </c:choose>
                  
                </tbody>
            </table>
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
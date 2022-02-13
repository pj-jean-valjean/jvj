<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>원데이 클래스 수강 신청 내역</title>
<jsp:include page="../common/header.jsp" />
 	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/admin/notice.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPageClass.css/">
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
                <span>최근 6개월내 수강하신 목록입니다.</span>
                <select name="" id="selectOption">
                    <option value="">전체</option>
                    <option value="">수강 전</option>
                    <option value="">수강 완료</option>
                    <option value="">취소</option>
                </select>
            </div>
            <table >
                <thead >
                    <tr id="tb-tr" >
                        <td id="td1"></td>
                        <td id="td2">클래스 강의명</td>
                        <td id="td3">신청일/해당지점/클래스 기간</td>
                        <td id="td4"></td>
                        <td id="td5"></td>
                    </tr>
                </thead>
                <tbody>
                
                <c:choose>
                <c:when test="${!empty classList}">
                
	                <c:forEach var="classList" items="${classList}">
	                    <tr class="tb-tbd">
	                        <td></td>
	                        <td>${classList.productName}</td>
	                        <td>${classList.orderOption}</td>
	                        <td></td>
	                        <td>
	                            <button class="shippingBtn">취소</button>
	                        </td>
	                    </tr>
	                 </c:forEach>
                 
                 </c:when>
                 
                 <c:otherwise>
                 	<tr>
						<td colspan="5" 
						style="color:rgba(167, 138, 108, 1); background-color:rgba(167, 138, 108, 0.3); 
						font-size:20px; font-weight:bold; margin-left: auto; margin-right: auto; text-align:center;
						padding-top:200px; padding-bottom:300px; margin-bottum">
						신청하신 원데이 클래스가 존재하지 않습니다.
						</td>
					 </tr>       
                 
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
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 메인</title>
<jsp:include page="../common/header.jsp" />
 	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/admin/notice.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPageMain.css/">
</head>

<body>
	    <main>
         <div class="titleText">
        <span>마이페이지</span>
    </div>

	
    <section>
   
   
   
   <%-- 메뉴 --%>
    <c:choose>
    	<c:when test="${loginMember.service eq null}">
	    	<div class="divNav">
		        <div id="hr"></div>
		        <ul>
		        	<li class="topText ">회원 관리</li>
		        	<li class="subText"><a href="main">마이 페이지</a></li>
		        	<li class="subText mbText"><a href="info">회원정보 수정</a></li>
		        	<li class="subText mbText"><a href="password">비밀번호 변경</a></li>
		        	<li class="subText mbText"><a href="coupon">쿠폰 정보</a></li>
		        </ul>
		        <ul>
		        	<li class="topText mTopText">쇼핑정보</li>
		        	<li class="subText"><a href="purchase">상품 주문 내역</a></li>
		            <li class="subText"><a href="sub">구독 신청 내역</a></li>
		            <li class="subText"><a href="class">수강 신청 내역</a></li>
		            <li class="subText"><a href="love">좋아요 내역</a></li>
		        </ul>
		    	</div> 
    	</c:when>
    	
    	<c:otherwise>
	    	<div class="divNav">
		        <div id="hr"></div>
		        <ul>
		        	<li class="topText ">회원 관리</li>
		        	<li class="subText"><a href="main">마이 페이지</a></li>
		        	<li class="subText mbText"><a href="info">회원정보 수정</a></li>
		        	<li class="subText mbText"><a href="coupon">쿠폰 정보</a></li>
		        </ul>
		        <ul>
		        	<li class="topText mTopText">쇼핑정보</li>
		        	<li class="subText"><a href="purchase">상품 주문 내역</a></li>
		            <li class="subText"><a href="sub">구독 신청 내역</a></li>
		            <li class="subText"><a href="class">수강 신청 내역</a></li>
		            <li class="subText"><a href="love">좋아요 내역</a></li>
		        </ul>
    		</div> 
    	</c:otherwise>
    </c:choose>	
   
   
   
   <%-- ${mainList} --%>
    	
    	
    	<c:forEach var="mainList" items="${mainList}" begin="1" end="1">
        <article class="mainImg">
        	
            <p class="mainText1" ><span>${mainList.memberName}</span>님 반가워요</p><br>
            <p class="mainText2">고객님과 저희의 인연은 <span>${mainList.edt}일째</span> 입니다.</p>
            
            <div >
            	<img src="${contextPath}/resources/images/mypage/myPage_main_bread.jpg" alt="" id="mainImage">
         	</div>
        </article>
		
    	
        <article id="bottomCategory">
        
      
        <div class="category part1">
            <span>최근 주문내역</span>
            <a href="purchase">자세히</a>
            <hr id="hr2"></hr>
            <table>
             <c:if test="${mainList.productCode eq 1}">
                <tr>
                    <td class="td-title">${mainList.productName}</td>
                    <td class="td-sub">${mainList.createDate}</td>
                </tr>
              </c:if>
            </table>
        </div>
       
        
        <div class="category part2">
            <span>구독한 상품 내역</span>
            <a href="sub">자세히</a>
            <hr id="hr2"></hr>
            <table>
                <c:if test="${mainList.productCode eq 2}">
                <tr>
                    <td class="td-title">${mainList.productName}</td>
                    <td class="td-sub">${mainList.createDate}</td>
                </tr>
              </c:if>
            </table>
        </div>
        
        <div class="category part3">
            <span>클래스 수강 목록</span>
            <a href="class">자세히</a>
            <hr id="hr2"></hr>
            <table>
               <c:if test="${mainList.productCode eq 3}">
                <tr>
                    <td class="td-title">${mainList.productName}</td>
                    <td class="td-sub">${mainList.createDate}</td>
                </tr>
              </c:if>
            </table>
        </div>
    </article>
    </c:forEach>
    </section>
    
    
    </main>
	<jsp:include page="../common/footer.jsp" />	
	
	
</body>
</html>
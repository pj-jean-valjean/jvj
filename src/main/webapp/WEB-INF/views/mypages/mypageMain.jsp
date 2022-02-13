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

   
	<c:forEach var="pur" items="${purList}">
	</c:forEach>
    <section>
    
    <jsp:include page="mypageMenu.jsp"/>
    	
        <article class="mainImg">
            <p class="mainText1">님 반가워요</p><br>
            <p class="mainText2">고객님과 저희의 인연은 888일째 입니다.</p>
            <p class="mainText3">고객님이 보유하신 멤버쉽 포인트는 <span>10000포인트</span> 입니다.</p>  
            <img src="${contextPath}/resources/images/mypage/myPage_main_bread.jpg" alt="">
        </article>
		
        <article id="bottomCategory">
        
        
        <div class="category part1">
            <span>최근 주문내역</span>
            <a href="purchase">click</a>
            <hr id="hr2"></hr>
            <table>
                <tr>
                    <td class="td-title">달고나 식빵</td>
                    <td class="td-sub">2022-01-01</td>
                </tr>
            </table>
        </div>
        <div class="category part2">
            <span>구독한 상품 내역</span>
            <a href="sub">click</a>
            <hr id="hr2"></hr>
            <table>
                <tr>
                <td class="td-title">모듬 식빵</td>
                <td class="td-sub more">자세히 보기</td>
                </tr>
            </table>
        </div>
        <div class="category part3">
            <span>클래스 수강 목록</span>
            <a href="class">click</a>
            <hr id="hr2"></hr>
            <table>
                <tr>
                <td class="td-title">클래스101</td>
                <td class="td-sub more">자세히 보기</td>
                </tr>
            </table>
        </div>
        
    </article>
       
    </section>
    
    </main>
	<jsp:include page="../common/footer.jsp" />	
	
	
</body>
</html>
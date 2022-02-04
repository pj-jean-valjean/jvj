<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <jsp:include page="mypageMenu.jsp"/>	
       
		<article>
            <article>

                <div class="toDay">
                    <span>최근 주문하신 내역입니다.</span>
                    <button type="button" class="dateBtn">오늘</button>
                </div>
    
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
                        <ul class="tbname">
                            <li><img src="${contextPath}/resources/images/mypage/dog.jpg" alt=""></li>
                            <li> 댕식빵/댕댕식빵</li>
                            <li> 10,000,000</li>
                            <li>
                                <button class="p-btn" id="btn-pur" onclick="paymentResult()">바로 구매</button>
                                <button class="p-btn" id="btn-cc">좋아요 삭제</button>
                            </li>
                        </ul>
                        <ul class="tbname">
                            <li><img src="${contextPath}/resources/images/mypage/dog.jpg" alt=""></li>
                            <li> 댕식빵/댕댕식빵</li>
                            <li> 10,000,000</li>
                            <li>
                                <button class="p-btn" id="btn-pur">바로 구매</button>
                                <button class="p-btn" id="btn-cc">좋아요 삭제</button>
                            </li>
                        </ul>
                        <ul class="tbname">
                            <li><img src="${contextPath}/resources/images/mypage/dog.jpg" alt=""></li>
                            <li> 댕식빵/댕댕식빵</li>
                            <li> 10,000,000</li>
                            <li>
                                <button class="p-btn" id="btn-pur">바로 구매</button>
                                <button class="p-btn" id="btn-cc">좋아요 삭제</button>
                            </li>
                        </ul>
                        <ul class="tbname">
                            <li><img src="${contextPath}/resources/images/mypage/dog.jpg" alt=""></li>
                            <li> 댕식빵/댕댕식빵</li>
                            <li> 10,000,000</li>
                            <li>
                                <button class="p-btn" id="btn-pur">바로 구매</button>
                                <button class="p-btn" id="btn-cc">좋아요 삭제</button>
                            </li>
                        </ul>
                        <ul class="tbname">
                            <li><img src="${contextPath}/resources/images/mypage/dog.jpg" alt=""></li>
                            <li> 댕식빵/댕댕식빵</li>
                            <li> 10,000,000</li>
                            <li>
                                <button class="p-btn" id="btn-pur">바로 구매</button>
                                <button class="p-btn" id="btn-cc">좋아요 삭제</button>
                            </li>
                        </ul>
                    </div>
                    
                </div>

            </article>
        </article>

        <article class="page">
            <div>
                <ul class="pagination">
                    <li><a href="#" class="first pagi">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-double-left" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M8.354 1.646a.5.5 0 0 1 0 .708L2.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
                            <path fill-rule="evenodd" d="M12.354 1.646a.5.5 0 0 1 0 .708L6.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
                        </svg></a></li> 
                    <li><a href="#" class="previous pagi">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-left" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
                        </svg>
                    </a></li> 

                    <li class="pagiList"><a class="pagiLink" href="#">1</a></li>
                    <li class="pagiList"><a class="pagiLink" href="#">2</a></li>
                    <li class="pagiList"><a class="pagiLink" href="#">3</a></li>
                    <li class="pagiList"><a class="pagiLink" href="#">4</a></li>
                    <li class="pagiList"><a class="pagiLink" href="#">5</a></li>
                    <li class="pagiList"><a class="pagiLink" href="#">6</a></li>
                    <li class="pagiList"><a class="pagiLink" href="#">7</a></li>
                    <li class="pagiList"><a class="pagiLink" href="#">8</a></li>
                    <li class="pagiList"><a class="pagiLink" href="#">9</a></li>
                    <li class="pagiList"><a class="pagiLink2" href="#">10</a></li>
                
                    <li><a href="#" class="next pagi">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
                        </svg>
                    </a></li> 
                    <li><a href="#" class="last pagi">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-double-right" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M3.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L9.293 8 3.646 2.354a.5.5 0 0 1 0-.708z"/>
                            <path fill-rule="evenodd" d="M7.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L13.293 8 7.646 2.354a.5.5 0 0 1 0-.708z"/>
                      </svg>
                    </a></li> 
                </ul>
            </div>  
        </article>
        
        
               
    </section>
    </main>
	<jsp:include page="../common/footer.jsp" />	
</body>
</html>
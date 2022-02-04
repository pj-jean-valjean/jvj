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
                    <tr class="tb-tbd">
                        <td>신규가입자 전용 쿠폰</td>
                        <td>20%</td>
                        <td>2021-12-01</td>
                        <td>2022-01-31</td>
                        <td>사용 가능</td>
                    </tr>
                    <tr class="tb-tbd overdate">
                        <td>신규가입자 전용 쿠폰</td>
                        <td>20%</td>
                        <td>2021-12-01</td>
                        <td>2022-01-02</td>
                        <td>기간 만료</td>
                    </tr>
                    <tr class="tb-tbd donetd">
                        <td>신규가입자 전용 쿠폰</td>
                        <td>20%</td>
                        <td>2021-12-01</td>
                        <td>2022-01-31</td>
                        <td>사용 완료</td>
                    </tr>
                    <tr class="tb-tbd">
                        <td>신규가입자 전용 쿠폰</td>
                        <td>20%</td>
                        <td>2021-12-01</td>
                        <td>2022-01-31</td>
                        <td>사용 가능</td>
                    </tr>
                    <tr class="tb-tbd">
                        <td>신규가입자 전용 쿠폰</td>
                        <td>20%</td>
                        <td>2021-12-01</td>
                        <td>2022-01-31</td>
                        <td>사용 가능</td>
                    </tr>
                    <tr class="tb-tbd donetd">
                        <td>신규가입자 전용 쿠폰</td>
                        <td>20%</td>
                        <td>2021-12-01</td>
                        <td>2022-01-31</td>
                        <td>사용 완료</td>
                    </tr>
                    <tr class="tb-tbd">
                        <td>신규가입자 전용 쿠폰</td>
                        <td>20%</td>
                        <td>2021-12-01</td>
                        <td>2022-01-31</td>
                        <td>사용 가능</td>
                    </tr>
                    <tr class="tb-tbd">
                        <td>신규가입자 전용 쿠폰</td>
                        <td>20%</td>
                        <td>2021-12-01</td>
                        <td>2022-01-31</td>
                        <td>사용 가능</td>
                    </tr>
                    <tr class="tb-tbd">
                        <td>신규가입자 전용 쿠폰</td>
                        <td>20%</td>
                        <td>2021-12-01</td>
                        <td>2022-01-31</td>
                        <td>사용 가능</td>
                    </tr>
                    <tr class="tb-tbd">
                        <td>신규가입자 전용 쿠폰</td>
                        <td>20%</td>
                        <td>2021-12-01</td>
                        <td>2022-01-31</td>
                        <td>사용 가능</td>
                    </tr>
                </tbody>
            </table>
        </article>


        <article>
            <div class="page">
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
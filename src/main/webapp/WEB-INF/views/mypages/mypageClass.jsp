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
                        <td id="td3">신청일/해당지점</td>
                        <td id="td4">클래스 기간</td>
                        <td id="td5"></td>
                    </tr>
                </thead>
                <tbody>
                    <tr class="tb-tbd">
                        <td></td>
                        <td>초보자를 위한 베이킹 클래스</td>
                        <td>2021-12-01<br>마포점</td>
                        <td>2022-01-02<br>06:00~18:00</td>
                        <td>
                            <button class="shippingBtn">취소</button>
                        </td>
                    </tr>
                    <tr class="tb-tbd">
                        <td></td>
                        <td>초보자를 위한 베이킹 클래스</td>
                        <td>2021-12-01<br>마포점</td>
                        <td>2022-01-02<br>06:00~18:00</td>
                        <td>
                            <button class="shippingBtn">취소</button>
                        </td>
                    </tr>
                    <tr class="tb-tbd">
                        <td></td>
                        <td>초보자를 위한 베이킹 클래스</td>
                        <td>2021-12-01<br>마포점</td>
                        <td>2022-01-02<br>06:00~18:00</td>
                        <td>
                            <button class="shippingBtn">취소</button>
                        </td>
                    </tr>
                    <tr class="tb-tbd">
                        <td></td>
                        <td>초보자를 위한 베이킹 클래스</td>
                        <td>2021-12-01<br>마포점</td>
                        <td>2022-01-02<br>06:00~18:00</td>
                        <td>
                            <button class="shippingBtn">취소</button>
                        </td>
                    </tr>
                    <tr class="tb-tbd">
                        <td></td>
                        <td>초보자를 위한 베이킹 클래스</td>
                        <td>2021-12-01<br>마포점</td>
                        <td>2022-01-02<br>06:00~18:00</td>
                        <td>
                            취소완료
                        </td>
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
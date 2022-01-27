<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JVJ 원데이클래스</title>
<jsp:include page="../common/header.jsp" />
 	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/admin/classList.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
 	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    <div id="classmainimg">
        <img src="${contextPath}/resources/images/onedayclassList/classMain.jpg" alt="">
    </div>
    <main>
    <section>
        <article>
            <div id="pathline"><a href="">HOME</a>&gt;<a href="">원데이 클래스</a></div>
            <h1 id="classpname" style="font-size: 35px;">원데이 클래스<span id="placespan">[클래스 진행 지점] 부천점, 금천점, 남양주점, 창동점, 마포점</span></h1>
            <div id="align-div">
                <button onclick="calmodal()" class='opencal'><i class="far fa-calendar-alt"></i>날짜별 정렬</button>
                <i class="fas fa-map-marker-alt"></i>
                <select id='selectplace'>
                    <option>지점별 정렬</option>
                    <option>부천점</option>
                    <option>금천점</option>
                    <option>남양주점</option>
                    <option>창동점</option>
                    <option>마포점</option>
                </select>
            </div>
            <div id="infinitebox">
            <div class="oneClassLine">
            
                <div class="dateLine">
                    <div class="oneCdate">
                        <span>Tue</span>
                        <span>12.1</span>
                    </div>
                    <div class="oneCdate">
                        <span>Tue</span>
                        <span>12.1</span>
                    </div>
                    <div class="oneCdate">
                        <span>Tue</span>
                        <span>12.1</span>
                    </div>
                </div>
                <hr>
                <ul class="classShowLine">
                    <li class="oneCInfo">
                    	<a href="view">
	                        <img class="classimg" src="${contextPath}/resources/images/onedayclassList/bread.jpg">
	                        <span class="infoLine">
		                        <span class="review-ratings-real">★★★★★</span>
		                        <span class="review-ratings-base">★★★★★</span>
		                        <span> 4.5</span>
	                        	<i class="fas fa-heart"></i><span>113</span>
	                        </span>
	                        <span>초보자를 위한 베이킹 클래스!</span>
	                        <span>50,000원</span>
	                        <span><i class="fas fa-map-marker-alt"></i>마포점</span>
                        </a>
                    </li>
                    <li class="oneCInfo">
                    	<a href="view">
                        <img class="classimg" src="${contextPath}/resources/images/onedayclassList/bread.jpg">
                        <span class="infoLine">
	                        <span class="review-ratings-real">★★★★★</span>
	                        <span class="review-ratings-base">★★★★★</span>
	                        <span> 4.5</span>
                        	<i class="fas fa-heart"></i><span>113</span>
                        </span>
                        <span>초보자를 위한 베이킹 클래스!</span>
                        <span>50,000원</span>
                        <span><i class="fas fa-map-marker-alt"></i>마포점</span>
                        </a>
                    </li>
                    <li class="oneCInfo">
                    	<a href="view">
                        <img class="classimg" src="${contextPath}/resources/images/onedayclassList/bread.jpg">
                        <span class="infoLine">
	                        <span class="review-ratings-real">★★★★★</span>
	                        <span class="review-ratings-base">★★★★★</span>
	                        <span> 4.5</span>
                        	<i class="fas fa-heart"></i><span>113</span>
                        </span>
                        <span>초보자를 위한 베이킹 클래스!</span>
                        <span>50,000원</span>
	                        <span><i class="fas fa-map-marker-alt"></i>마포점</span>
                        </a>
                    </li>
                </ul>
            </div>
            
            <div class="oneClassLine">
                <div class="dateLine">
                    <div class="oneCdate">
                        <span>Tue</span>
                        <span>12.1</span>
                    </div>
                    <div class="oneCdate">
                        <span>Tue</span>
                        <span>12.1</span>
                    </div>
                    <div class="oneCdate">
                        <span>Tue</span>
                        <span>12.1</span>
                    </div>
                </div>
                <hr>
                <ul class="classShowLine">
                   <li class="oneCInfo">
                    	<a href="view">
                        <img class="classimg" src="${contextPath}/resources/images/onedayclassList/bread.jpg">
                        <span class="infoLine">
	                        <span class="review-ratings-real">★★★★★</span>
	                        <span class="review-ratings-base">★★★★★</span>
	                        <span> 4.5</span>
                        	<i class="fas fa-heart"></i><span>113</span>
                        </span>
                        <span>초보자를 위한 베이킹 클래스!</span>
                        <span>50,000원</span>
	                        <span><i class="fas fa-map-marker-alt"></i>마포점</span>
                        </a>
                    </li>
                   <li class="oneCInfo">
                    	<a href="view">
                        <img class="classimg" src="${contextPath}/resources/images/onedayclassList/bread.jpg">
                        <span class="infoLine">
	                        <span class="review-ratings-real">★★★★★</span>
	                        <span class="review-ratings-base">★★★★★</span>
	                        <span> 4.5</span>
                        	<i class="fas fa-heart"></i><span>113</span>
                        </span>
                        <span>초보자를 위한 베이킹 클래스!</span>
                        <span>50,000원</span>
	                        <span><i class="fas fa-map-marker-alt"></i>마포점</span>
                        </a>
                    </li>
                   <li class="oneCInfo">
                    	<a href="view">
                        <img class="classimg" src="${contextPath}/resources/images/onedayclassList/bread.jpg">
                        <span class="infoLine">
	                        <span class="review-ratings-real">★★★★★</span>
	                        <span class="review-ratings-base">★★★★★</span>
	                        <span> 4.5</span>
                        	<i class="fas fa-heart"></i><span>113</span>
                        </span>
                        <span>초보자를 위한 베이킹 클래스!</span>
                        <span>50,000원</span>
	                        <span><i class="fas fa-map-marker-alt"></i>마포점</span>
                        </a>
                    </li>
                </ul>
            </div>
            </div>
        </article>
        <article class="cal">
            <div class="calendar">
                <div class="calhead">
                <button class="month-control" onclick="prev()"><<<</button>
                <span id="today-month"></span>
                <button class="month-control" onclick="next()">>>></button>
                <button id="allcal">전체</button>
                <button id="closecal">닫기</button>
                </div>
                <table id = "selectDate">
                    <thead>
                        <tr>
                            <th>SUN</th>
                            <th>MON</th>
                            <th>TUE</th>
                            <th>WED</th>
                            <th>THU</th>
                            <th>FRI</th>
                            <th>SAT</th>
                        </tr>
                    </thead>
                    <tbody id="month-day">
                    </tbody>
                </table>
            </div>
            </article>
			<article class="loadding">		
	         	<div class="showloading">
	         		<img src="${contextPath}/resources/images/onedayclassList/loadingIMG.gif">
	         	</div>
         	</article>
        </section>
    </main>
	
	<jsp:include page="../common/footer.jsp" />	
	<script>const contextPath = "${contextPath}"</script>
	<script type="text/javascript" src="${contextPath}/resources/js/onedayclass/classList.js"></script>
</body>
</html>
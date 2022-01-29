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
	            <div class="newOneLine">
	            	<div class="newOneclassInfo">
	            		<div class="newDate">
	        			    <span>22.02.02(수)</span>
	                        <span>09:00~11:00</span>
	            		</div>
	            		<div class="newClassInfo">	
	            			<a href="view">
		                        <img class="classimg" src="${contextPath}/resources/images/onedayclassList/greenteabread.jpg">
		                        <span>초보자도 쉽게 배우는 베이킹 클래스!</span>
		                        <span class="newinfoLine">
			                        <span class="review-ratings-reals">★★★★★</span>
			                        <span class="review-ratings-bases">★★★★★</span>
	 		                        <span> (4.5)</span>
		                        	<i class="fas fa-heart"></i><span>113</span>
		                        	<i class="fas fa-map-marker-alt"></i><span>마포점</span>
		                        </span>
		                        <span>50,000원</span>
	                        </a>
	            		</div>
	            	</div>
	            	<div class="newOneclassInfo">
	            		<div class="newDate">
	        			    <span>22.02.02(수)</span>
	                        <span>09:00~11:00</span>
	            		</div>
	            		<div class="newClassInfo">	
	            			<a href="view">
		                        <img class="classimg" src="${contextPath}/resources/images/onedayclassList/macaron.jpg">
		                        <span>초보자도 쉽게 배우는 베이킹 클래스!</span>
		                        <span class="newinfoLine">
			                        <span class="review-ratings-reals">★★★★★</span>
			                        <span class="review-ratings-bases">★★★★★</span>
	 		                        <span> (4.5)</span>
		                        	<i class="fas fa-heart"></i><span>113</span>
		                        	<i class="fas fa-map-marker-alt"></i><span>마포점</span>
		                        </span>
		                        <span>50,000원</span>
	                        </a>
	            		</div>
	            	</div>
	            	<div class="newOneclassInfo">
	            		<div class="newDate">
	        			    <span>22.02.02(수)</span>
	                        <span>09:00~11:00</span>
	            		</div>
	            		<div class="newClassInfo">	
	            			<a href="view">
		                        <img class="classimg" src="${contextPath}/resources/images/onedayclassList/greenteabread.jpg">
		                        <span>초보자도 쉽게 배우는 베이킹 클래스!</span>
		                        <span class="newinfoLine">
			                        <span class="review-ratings-reals">★★★★★</span>
			                        <span class="review-ratings-bases">★★★★★</span>
	 		                        <span> (4.5)</span>
		                        	<i class="fas fa-heart"></i><span>113</span>
		                        	<i class="fas fa-map-marker-alt"></i><span>마포점</span>
		                        </span>
		                        <span>50,000원</span>
	                        </a>
	            		</div>
	            	</div>
	            	<div class="newOneclassInfo">
	            		<div class="newDate">
	        			    <span>22.02.02(수)</span>
	                        <span>09:00~11:00</span>
	            		</div>
	            		<div class="newClassInfo">	
	            			<a href="view">
		                        <img class="classimg" src="${contextPath}/resources/images/onedayclassList/classMain.jpg">
		                        <span>초보자도 쉽게 배우는 베이킹 클래스!</span>
		                        <span class="newinfoLine">
			                        <span class="review-ratings-reals">★★★★★</span>
			                        <span class="review-ratings-bases">★★★★★</span>
	 		                        <span> (4.5)</span>
		                        	<i class="fas fa-heart"></i><span>113</span>
		                        	<i class="fas fa-map-marker-alt"></i><span>마포점</span>
		                        </span>
		                        <span>50,000원</span>
	                        </a>
	            		</div>
	            	</div>
	            	<div class="newOneclassInfo">
	            		<div class="newDate">
	        			    <span>22.02.02(수)</span>
	                        <span>09:00~11:00</span>
	            		</div>
	            		<div class="newClassInfo">	
	            			<a href="view">
		                        <img class="classimg" src="${contextPath}/resources/images/onedayclassList/macaron.jpg">
		                        <span>초보자도 쉽게 배우는 베이킹 클래스!</span>
		                        <span class="newinfoLine">
			                        <span class="review-ratings-reals">★★★★★</span>
			                        <span class="review-ratings-bases">★★★★★</span>
	 		                        <span> (4.5)</span>
		                        	<i class="fas fa-heart"></i><span>113</span>
		                        	<i class="fas fa-map-marker-alt"></i><span>마포점</span>
		                        </span>
		                        <span>50,000원</span>
	                        </a>
	            		</div>
	            	</div>
	            	<div class="newOneclassInfo">
	            		<div class="newDate">
	        			    <span>22.02.02(수)</span>
	                        <span>09:00~11:00</span>
	            		</div>
	            		<div class="newClassInfo">	
	            			<a href="view">
		                        <img class="classimg" src="${contextPath}/resources/images/onedayclassList/classMain.jpg">
		                        <span>초보자도 쉽게 배우는 베이킹 클래스!</span>
		                        <span class="newinfoLine">
			                        <span class="review-ratings-reals">★★★★★</span>
			                        <span class="review-ratings-bases">★★★★★</span>
	 		                        <span> (4.5)</span>
		                        	<i class="fas fa-heart"></i><span>113</span>
		                        	<i class="fas fa-map-marker-alt"></i><span>마포점</span>
		                        </span>
		                        <span>50,000원</span>
	                        </a>
	            		</div>
	            	</div>
	            	<div class="newOneclassInfo">
	            		<div class="newDate">
	        			    <span>22.02.02(수)</span>
	                        <span>09:00~11:00</span>
	            		</div>
	            		<div class="newClassInfo">	
	            			<a href="view">
		                        <img class="classimg" src="${contextPath}/resources/images/onedayclassList/macaron.jpg">
		                        <span>초보자도 쉽게 배우는 베이킹 클래스!</span>
		                        <span class="newinfoLine">
			                        <span class="review-ratings-reals">★★★★★</span>
			                        <span class="review-ratings-bases">★★★★★</span>
	 		                        <span> (4.5)</span>
		                        	<i class="fas fa-heart"></i><span>113</span>
		                        	<i class="fas fa-map-marker-alt"></i><span>마포점</span>
		                        </span>
		                        <span>50,000원</span>
	                        </a>
	            		</div>
	            	</div>
	            	<div class="newOneclassInfo">
	            		<div class="newDate">
	        			    <span>22.02.02(수)</span>
	                        <span>09:00~11:00</span>
	            		</div>
	            		<div class="newClassInfo">	
	            			<a href="view">
		                        <img class="classimg" src="${contextPath}/resources/images/onedayclassList/bread.jpg">
		                        <span>초보자도 쉽게 배우는 베이킹 클래스!</span>
		                        <span class="newinfoLine">
			                        <span class="review-ratings-reals">★★★★★</span>
			                        <span class="review-ratings-bases">★★★★★</span>
	 		                        <span> (4.5)</span>
		                        	<i class="fas fa-heart"></i><span>113</span>
		                        	<i class="fas fa-map-marker-alt"></i><span>마포점</span>
		                        </span>
		                        <span>50,000원</span>
	                        </a>
	            		</div>
	            	</div>
	            </div><!-- 1cp info = 8개 -->
            
            
            
            </div><!-- infinite -->
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
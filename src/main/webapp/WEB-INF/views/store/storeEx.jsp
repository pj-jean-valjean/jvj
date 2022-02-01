<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="${contextPath}/resources/css/store.css">
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/mcart.jsp" />
</head>

<body>
	<div class="main-banner"></div>
	<div class="main-wrapper">

		<div class="category-set">
			<div class="select">
				<select name="format" id="format">
					<option selected disabled>카테고리 선택</option>
					<option value="sick">식빵</option>
					<option value="baget">바게트</option>
					<option value="etc">기타</option>
				</select>
			</div>
			<ul class="main-category">
				<li style="color: #f58c8c;">신상품</li>
				<li>|</li>
				<li>낮은가격</li>
				<li>|</li>
				<li>높은가격</li>
				<li>|</li>
				<li>인기상품</li>
			</ul>
		</div>
		<div class="main-content">



			<c:forEach var="pdt" items="${store}" varStatus="i">
		
				<div class="pdt-box">
					<div class="outer brand-new">
						<div class="pdt-img"></div>
					</div>
					<div style="margin-top: 10px; font-size: 24px; font-weight: bold;">${pdt.storeName}</div>
					<div class="heart-btn">
						<div
							class="content <c:if test="${pdt.likeit eq 1}">heart-active</c:if>">
							<div
								class="heart <c:if test="${pdt.likeit eq 1}">heart-active</c:if>"></div>
						</div>

					</div>

					<div class="pricewon" style="font-size: 20px; margin-top: 5px;">${pdt.price}</div>
					<div style="font-size: 16px; margin-top: 15px;">${pdt.memo}</div>

					<c:if test="${ pdt.stock  eq 0}">
						<div class="pdt-label label-sold">품절</div>
					</c:if>

					<c:if test="${param.cp eq 1 && i.first}">
						
						<div class="pdt-label label-new">NEW</div>
						
					</c:if>

					<c:if test="">
						<div class="pdt-label label-best">BEST</div>
					</c:if>

					<c:if test="${ pdt.discountPer ne 0}">
						<div class="pdt-label label-sale">SALE</div>
					</c:if>
				</div>
			</c:forEach>


		</div>
	</div>
	<ul class="pagination">
		<c:if test="${pagination.startPage !=1 }">
			<li><a class="page-link" href="store?cp=1">&lt;&lt;</a></li>
			<li><a class="page-link" href="store?cp=${pagination.prevPage}">&lt;</a></li>
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
					<li><a class="page-link" style="margin:5px" href="store?cp=${i}">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${pagination.endPage != pagination.maxPage }">
			<li><a class="page-link" href="store?cp=${pagination.nextPage}">&gt;</a></li>
			<li><a class="page-link" href="store?cp=${pagination.maxPage }">&gt;&gt;</a></li>
		</c:if>
	</ul>
	<!-- main-wrapper end-->
</body>
<script type="text/javascript"
	src="${contextPath}/resources/js/store/store.js"></script>
<jsp:include page="../common/footer.jsp" />
</html>
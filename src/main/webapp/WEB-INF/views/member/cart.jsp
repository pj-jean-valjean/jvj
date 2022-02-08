<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<link rel="stylesheet" href="${contextPath}/resources/css/cart.css">
</head>
<body>
	<div class="j-wrapper">
		<h1 style="margin: 35px 0; color: #564334">장바구니</h1>
		<div class="hr"></div>
		<div class="inline-block">

			<div style="width: 486px; height: 50px; text-align: center;">
				<h2>상품정보</h2>
			</div>
			<div
				style="width: 330px; height: 50px; text-align: center; margin: 0 40px">
				<h2>추가상품</h2>
			</div>
			<div style="width: 204px; height: 50px; text-align: center;">
				<h2>합계금액</h2>
			</div>
		</div>



		<div class="hr" style="height: 5px; margin: 20px 0 30px 0"></div>

		<c:forEach items="${cartList}" var="cart">
			
				<c:if test="${cart.parentNo eq 0}">

					<div class="inline-block items">
						<input type="hidden" value="${cart.cartNo}">
						<div
							style="width: 486px; height: 195px; border-right: 1px solid #d3c5b6;"
							class="inline-block">
							<h4 class="x-btn">x</h4>
							<div class="j-img"
								style="background-image: url('${contextPath}${cart.imgPath }');"></div>
							<div>

								<h4 style="margin-bottom: 25px;">${cart.productName }</h4>
								<h5 style="margin-bottom: 15px; display: inline-block; text-decoration:line-through; color:gray">${cart.price}</h5> 
								<h3 style="display: inline-block" class="productPrice">${cart.price * (100-cart.discountPer)/100}</h3>
								
								<br>
								<div class="j-pmbtn">-</div>
								<h4 class="addq" style="display: inline-block; margin: 0 20px;">${cart.addq}</h4>
								<div class="j-pmbtn">+</div>
							</div>
						</div>
						
						<div
							style="width: 330px; margin: 0 40px; height: 195px; border-right: 1px solid #d3c5b6;"
							class="inline-block option-box">
						<c:forEach items="${cartList}" var="cart2">	
							<c:if test="${cart2.parentNo eq cart.cartNo}">
					
								<h4 style="margin: 10px 0 25px 60px;">${cart2.productName}${cart2.price*(100-cart2.discountPer)/100} * ${cart2.addq}</h4>
								<input class="optionPrice" type ="hidden" value="${cart2.price * cart2.addq *(100-cart2.discountPer)/100} ">
								
							</c:if>
							</c:forEach>
						</div>
						<div style="width: 204px; height: 195px; text-align: center;">
							<h2 class="cartSumPrice" style="margin-top: 80px">1000원</h2>

						</div>
						
					</div>
					<div class="hr" style="height: 1px; margin: 30px 0 30px 0"></div>
				</c:if>
			
		</c:forEach>

		<div class="j-notice">


			<p>구매 전 확인해주세요.</p>
			<p>- 구매 금액 합산 30,000원 이상일 경우, 배송비는 무료입니다. (단, [정기구독], [무료배송] 상품은
				구매금액 합산에 포함되지 않습니다.)</p>

		</div>
		<div class="j-sum inline-block">
			<p>
				총 주문 금액 <b class="resultPrice">0원</b> + 배송비 <b class="taxPrice">3,000원</b> =
			</p>
			<h1>총 결제 금액</h1><h1  class="lastMaxPrice"> 0원</h1>
		</div>
		<div class="j-buy" onclick="buyit()">
			<h2>구매하기</h2>
		</div>
	</div>
	<script>
	const specialContextPath = '${contextPath}';
	const carrierList = '${carrierList}';
	</script>
	<script src="${contextPath}/resources/js/member/cart.js"> </script>
	<jsp:include page="../common/footer.jsp" />
</html>
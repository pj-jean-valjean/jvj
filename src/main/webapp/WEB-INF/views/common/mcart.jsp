<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <link rel="stylesheet" href="${contextPath}/resources/css/mcart.css">
    <script src="${contextPath}/resources/js/common/anime_min.js"></script>

   <div class="a">
 
       <div class="open-c">
       <img class="crt" alt="" src="${contextPath}/resources/images/common/shopping.png">
       </div>
       <div class="c-wrapper">
           <div class="c-s-box">
           
           <c:forEach items="${cartList}" var="cart">
           
               <div class="c-ss-box">
                   <div class="c-img" style=" background-image: url('${contextPath}${cart.imgPath }');"></div>
                   <div class="c-sss-box">

                       <h4>${cart.productName }</h4>
                       
                       <h2>${cart.price }원</h2>
                       <button>-</button>
                       <p>1</p>
                       <button>+</button>
                   </div>
                   <h4>추가 옵션 :<c:forEach items="${cartList}" var="cart2" ><c:if test="${cart2.parentNo eq cart.cartNo}">${cart2.productName} ${cart2.addq} ,</c:if></c:forEach></h4>
               </div>
                           </c:forEach>

           </div>
           

       </div>
       
       <div class="c-sum-btn">
           <h3>현재 총 구매 가격 : 148,700원</h3>
           <h3><a href="${contextPath}/cart" style="color:white"><u>구매하기</u></a></h3>
       </div>
   </div>
   <script>
	const contextPath123 = '${contextPath}';
	const loginMember123 = '${loginMember.memberNo}';
   </script>
   <script src="${contextPath}/resources/js/common/mcart.js"></script>

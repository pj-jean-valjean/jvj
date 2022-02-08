<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp" />

<link rel="stylesheet" href="${contextPath}/resources/css/payment/payment.css">

 <main>
${loginMember }
${totalPrice }
${totalPeople }
${oneClass }
        <section class="title-section">
            <p>주문 / 결제 </p>  
        </section>


        <!-- 주문 내역 -->
        <section>
            <p class="listTitle">주문 내역 확인</p>

            <hr>

            <div class="product-list">

                <a href="#"><img src="${contextPath}/${oneClass.classImgList[0].productImgPath}/${oneClass.classImgList[0].productImgName}"></a>
                <div>
                    <a href="#"><p>${oneClass.title}</p></a>
                    <p>
                        지점명 : ${oneClass.title} <br>
                        수강일 : ${oneClass.createDt } <br>
                        수업 시간 : ${oneClass.classtime } <br>
                        신청인원 : ${totalPeople } <br>
                    </p>
                </div>
                <div>
                    <p>${totalPrice}</p>
                </div>
            </div>

            <hr>

            <div class="product-list">

                <a href="#"><img src="${contextPath}/resources/images/140673cf2ef31196c0744a90952e7711.jpg"></a>
                <div>
                    <a href="#"><p>녹차코코넛식빵</p></a>
                    <p>
                        첫 구독일 : 금요일, 2022-02-11 <br>
                        구독내용 : 2개월동안 X 2주마다 <br>
                        수량 1개 <br>
                    </p>
                </div>
                <div>
                    <p>7,000원</p>
                </div>
            </div>

            <!-- 주문자 정보 -->
            <div class="orderer-info-title">
                <p class="listTitle">주문자 정보</p>
                <p class="orderer">${loginMember.memberName}, ${loginMember.memberPhone}</p>
            </div>

            <hr>

            <div class="orderer-info">
                <div>
                    <input type="radio" name="orderer-addr" class="selectInfo" id="member-addr" value="1" checked> 
                    <label for="member-addr">회원정보와 동일</label>
                    <input type="radio" name="orderer-addr" class="selectInfo" value="2" id="new-addr"> 
                    <label for="new-addr">새로운 배송지</label>
                </div>

            <br>
            
            
            	<div class="loginForm">
            	<div class="input-info-div">
                      <div class="p-div"><p>받는 사람<span> *</span></p></div>
                      <div class="span-div"><span>${loginMember.memberName}</span></div>
                </div>
                
                <c:if test="${ empty loginMember.memberAddress}">
                	 <div class="input-info-div">
                        <div class="p-div"><p>주소<span> *</span></p></div>
                        <div class="input-div"><input type="text" id="addr1" class="receiver-info addr"></div>
                        <div class="input-div"><button id="searchAddr" class="input-btn" type="button">주소검색</button></div>
                    </div>
                    <div class="input-info-div">
                        <div class="p-div"></div>
                        <div class="input-div"><input type="text" id="addr2" class="receiver-info"></div>
                    </div>
                    <div class="input-info-div">
                        <div class="p-div"></div>
                        <div class="input-div"><input type="text"  class="receiver-info"></div>
                    </div>
                </c:if>
                
                	<div class="input-info-div">
                        <div class="p-div"><p>휴대폰번호<span> *</span></p></div>
                 		<div class="span-div"><span>${loginMember.memberPhone}</span></div>
                 	</div>
                
                <div class="input-info-div">
                      <div class="p-div"><p>이메일<span> *</span></p></div>
                      <div class="span-div"><span>${loginMember.memberEmail}</span></div>
                </div>
            
            	</div>
            
            
            	<!-- 새로운 배송지 선택시 보이는 div-->
            	<div class="newInfo">
                <div class="input-info">
                    <div class="input-info-div">
                        <div class="p-div"><p>받는 사람<span> *</span></p></div>
                        <div class="input-div"><input type="text" class="receiver-info"></div>
                    </div>
                    <div class="input-info-div">
                        <div class="p-div"><p>주소<span> *</span></p></div>
                        <div class="input-div"><input type="text" id="addr1" class="receiver-info addr"></div>
                        <div class="input-div"><button id="searchAddr" class="input-btn" type="button">주소검색</button></div>
                    </div>
                    <div class="input-info-div">
                        <div class="p-div"></div>
                        <div class="input-div"><input type="text" id="addr2" class="receiver-info"></div>
                    </div>
                    <div class="input-info-div">
                        <div class="p-div"></div>
                        <div class="input-div"><input type="text"  class="receiver-info"></div>
                    </div>

                    <div class="input-info-div">
                        <div class="p-div"><p>휴대폰번호<span> *</span></p></div>
                        <div class="input-div">
                            <select type="text" class="receiver-info-select phone-input">
                                <option>010</option>
                                <option>011</option>
                                <option>016</option>
                                <option>017</option>    
                                <option>019</option>
                            </select>
                        </div> 
                        <span>-</span>
                        <div class="input-div"><input type="text" class="receiver-info phone-input"></div>
                        <span>-</span>
                        <div class="input-div"><input type="text" class="receiver-info phone-input"></div>
                    </div>

                    <div class="input-info-div">
                        <div class="p-div"><p>이메일<span> *</span></p></div>
                        <div class="input-div hidden-email"><input type="text" class="receiver-info email-input hidden-email"></div>
                        <span class="hidden-email">@</span>
                        <div class="input-div hidden-email">
                            <input type="text" class="receiver-info email-input hidden-email" id="email-input-select">
                            <select class="receiver-info hidden-email" id="email-select">
                                <option value="0">직접입력</option>
                                <option value="1">naver.com</option>
                                <option value="2">daum.net</option>
                                <option value="3">gmail.com</option>  
                            </select>
                        </div> 
                    </div>
                    </div>
                    </div>

                    <div class="input-info-div">
                        <div class="p-div"><p>배송메세지</p></div>
                        <div class="input-div">
                            <select class="receiver-info" id="delivery-message-select">
                                <option>-- 메세지 선택 (선택사항) --</option>
                                <option value="1">배송 전에 미리 연락바랍니다.</option>
                                <option value="2">부재 시 경비실에 맡겨주세요.</option>
                                <option value="3">부재시 문 앞에 놓아주세요.</option>  
                                <option value="4">빠른 배송 부탁드립니다.</option>  
                                <option value="5">택배함에 보관해 주세요.</option>  
                                <option value="0">직접입력</option>
                            </select>
                            <br>
                            <input type="text" class="receiver-info" id="delivery-message">
                        </div>
                    </div>

                    <label class="container">기본배송지로 저장
                        <input type="checkbox">
                        <span class="checkmark"></span>
                    </label>
                </div>


            <!--  정기 배송 정보 
             <div class="orderer-info-title">
                 <p class="listTitle">정기 배송 시작일</p>
            </div>

            <hr>
            <div class="orderer-info">
                <div class="input-info-div">
                    <div class="p-div"><p>배송시작일<span> *</span></p></div>
                    <div class="input-div"><button type="button" class="none-border-btn" id="calendar-btn"></button></div>
                    <p class="delivery-info">*화, 수, 목, 금 중 선택(토, 일, 월 선택시 화요일로 일괄배송)<br>
                        (결제일 : 주기별 배송 시작일의 1일전)</p>
                
                </div>
            </div> -->
 

              <!-- 할인/부가결제 -->
            <div class="orderer-info-title">
                <p class="listTitle">할인/부가결제</p>
            </div>


            <hr>

            <div class="price-container">
                <div class="discount-price">
                    <div class="p-div"><p>쿠폰</p></div>
                    <div class="price-won">
                        <select class="receiver-info discount-select">
                            <option>사용가능한 쿠폰</option>
                            <option>5000원 할인</option>
                            <option>1000원 할인</option>
                        </select>
                    </div>
                </div>
                <div class="discount-price">
                    <div class="p-div"><p>마일리지</p></div>
                    <div class="price-won">
                        <input type="text" class="receiver-info discount">
                        <p class="mileage">사용가능 마일리지 : 1000점</p>
                    </div>
                </div>
            </div>

              <!-- 최종 결제 금액 -->
            <div class="orderer-info-title">
                <p class="listTitle">최종 결제 금액</p>
            </div>

            <hr>

            <div class="price-container">
                <div class="price-flex">
                    <div class="p-div"><p>총 상품 금액</p></div>
                    <div class="price-won"><p>13,500원</p></div>
                </div>
                <div class="price-flex">
                    <div class="p-div"><p>배송비</p></div>
                    <div class="price-won"><p>3,000원</p></div>
                </div>
                <div class="price-flex">
                    <div class="p-div"><p>쿠폰할인</p></div>
                    <div class="price-won"><p>-0원</p></div>
                </div>
                <div class="price-flex">
                    <div class="p-div"><p>마일리지</p></div>
                    <div class="price-won"><p>-0원</p></div>
                </div>
            </div>

            <hr class="price-hr">

            <div class="price-container">
                <div class="price-flex">
                    <div class="p-div"><p>총 결제 금액</p></div>
                    <div class="price-won"><p>16,500원</p></div>
                </div>
           </div>

        <!--  <div class="orderer-info-title">
            <p class="listTitle">결제 수단</p>
        </div>

        <hr>
        <div class="give-flex">
            <div class="payment-select-btn">
                <button type="button" class="none-border-btn">신용카드</button>
            </div>
        </div> -->
        <div class="give-flex">
            <div class="payment-select-btn">
                <button type="button" id="payment-btn" onclick="requestPay()">결제하기</button>
            </div>
        </div>

    </section>  

    </main>
    
    


	<jsp:include page="../common/footer.jsp" />

	<!-- iamport.payment.js -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	
	<!-- 다음 지도 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	<script src="${contextPath}/resources/js/payment/payment.js"></script>
  
  

  
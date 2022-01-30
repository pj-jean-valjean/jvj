<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
<link rel="stylesheet" href="${contextPath}/resources/css/payment/paymentResult.css">

  <main>

        <section class="title-section">
            <p>결제완료</p>
        </section>


        <!-- 주문 내역 -->
        <section>

            <!-- 주문자 정보 -->
            <div class="orderer-info-title">
                <p class="listTitle">주문자 정보</p>
            </div>

            <hr>

            <div class="orderer-info">
                <div class="result-info">
                    <div class="result-info-div">
                        <div class="p-div"><p>받는 사람</p></div>
                        <div class="span-div"><span>호가비</span></div>
                    </div>
                    <div class="result-info-div">
                        <div class="p-div"><p>주소</p></div>
                        <div class="span-div"><span>서울특별시 중구 남대문로 120 대일빌딩 2F, 3F</span></div>
                    </div>

                    <div class="result-info-div">
                        <div class="p-div"><p>휴대전화</p></div>
                        <div class="span-div"><span>010-1234-1234</span></div> 
                    </div>

                    <div class="result-info-div">
                        <div class="p-div"><p>이메일</p></div>
                        <div class="span-div"><span>user01@naver.com</span></div>
                    </div>

                    <div class="result-info-div">
                        <div class="p-div"><p>배송메세지</p></div>
                        <div class="span-div"><span>부재시 문 앞에 놓아주세요.</span></div>
                    </div>

                    <div class="result-info-div">
                        <div class="p-div"><p>정기배송시작일</p></div>
                        <div class="span-div"><span>2022-01-28</span></div>
                    </div>
                </div>
            </div>

            <div class="orderer-info-title">
                <p class="listTitle">주문 내역 확인</p>
            </div>
            <hr>

            <div class="product-list">

                <a href="#"><img src="${contextPath}/resources/images/336286d15b2d8401665f9ec0b4640703.jpg"></a>
                <div>
                    <a href="#"><p>통밀식빵</p></a>
                    <p>
                        첫 구독일 : 금요일, 2022-02-11 <br>
                        구독내용 : 2개월동안 X 2주마다 <br>
                        수량 1개 <br>
                    </p>
                </div>
                <div>
                    <p>6,500원</p>
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

        <div class="give-flex">
            <div class="payment-result-btn">
                <button type="button">주문 목록</button>
            </div>
        </div>

    </section>  

    </main>


<jsp:include page="../common/footer.jsp" />
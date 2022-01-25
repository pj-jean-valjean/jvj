<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<jsp:include page="../common/mcart.jsp" />
<jsp:include page="../common/header.jsp" />
 	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/subBread.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
</head>
<body>

	<main>
        <section class="top">
            <section class="main-nav">
                <a href="">HOME</a>
                <img src="${contextPath}/resources/images/common/expand_less.png" alt="expand_less">
                <a href="">정기 구독</a>
                <img src="${contextPath}/resources/images/common/expand_less.png" alt="expand_less">
                <a href="">빵 세트</a>
            </section>     
            
            
            <section class="product-thumbnail">
                <img class="main-thumbnail" src="${contextPath}/resources/images/subscribe/sub-bread-main.jpg" alt="sub-bread-main">
            <div>
                <img class="img-margin"src="${contextPath}/resources/images/subscribe/sub-bread-main.jpg" alt="sub-bread-main">
                <img class="img-margin" src="${contextPath}/resources/images/subscribe/sub-bread-main.jpg" alt="sub-bread-main">
                <img class="img-margin" src="${contextPath}/resources/images/subscribe/sub-bread-main.jpg" alt="sub-bread-main">
                <img src="${contextPath}/resources/images/subscribe/sub-bread-main.jpg" alt="sub-bread-main">
            </div>
            </section>

            <section class="product_detail">
                <article class="category_product">
                    <span>빵 세트</span>
                    <span class="price">20,000원</span>
                </article>

                <div class="bottom-line"></div>

                <article class="delivery-detail">
                    <span>정기구독 전상품, </span>
                    <span>무료배송!</span>
                </article>

                <div class="bottom-line"></div>
                
                <article class="sub-detail">
                    <div class="sub-title">
                        <span>구독 옵션</span>
                        <span>*</span>
                    </div>
                    <div class="btn-area"> 
                        <button type="button" class="sub btn" onclick="">
                            <span>1개월</span>
                        </button>
                        <button type="button" class="sub btn">
                            <span>6개월</span>
                        </button>
                        <button type="button" class="sub btn">
                            <span>정기결제</span>
                        </button>
                    </div>
                </article>

                <div class="bottom-line"></div>

                <article class="sub-detail">
                    <div class="sub-title">
                        <span>빵 종류</span>
                        <span></span>
                    </div>
                    <div class="btn-area"> 
                        <button type="button" class="sub btn" onclick="">
                            <span>식빵</span>
                        </button>
                        <button type="button" class="sub btn">
                            <span>바게트</span>
                        </button>
                    </div>
                </article>
                <div class="bottom-line"></div>

                <article class="sub-detail">
                    <div class="sub-title">
                        <span>맛 종류</span>
                        <span></span>
                    </div>
                    <div class="btn-area"> 
                        <button type="button" class="sub btn" onclick="">
                            <span>장발장</span>
                        </button>
                        <button type="button" class="sub btn">
                            <span>녹차코코넛</span>
                        </button>
                        <button type="button" class="sub btn">
                            <span>초코</span>
                        </button>
                    </div>
                </article>
                
                <article class="buy-total">
                    <!-- 선택한 상품 있을경우 -->
                    <!-- <div class="total-area">
                        <span>구독 상품을 선택해주세요.</span>
                    </div> -->

                    <!-- 선택한 상품 없을경우 -->
                    <div class="total-area">
                        <span>1개월 / 식빵 / 장발장 / 6개입</span>
                    </div>
                    <div class="buy-count">
                        <img class="add-btn" src="${contextPath}/resources/images/subscribe/add btn.png" alt="add btn">
                        <span>1</span>
                        <img class="minus-btn" src="${contextPath}/resources/images/subscribe/minus btn.png" alt="minus btn">
                    </div>
                
                </article>

                <article class="total-price">
                    <p>총 구매 금액</p>
                    <span>0</span>
                    <span>원</span>
                </article>

                <div class="submit-sub">
                    <button class="submit-btn">
                        <span>바로 구독 신청</span>
                    </button>
                </div>
            </section>
        </section>
    

        <!-- contents -->
        <div class="contents-top-line"></div>        
        <section class="detail-contents">
            <ul >
                <li><a href="#contents-exp">상품설명</a></li>
                <li><a href="#contents-review">리뷰</a></li>
                <li><a href="#contents-delievery">배송/교환/환불</a></li>

                <div class="contents-bottom-line"></div>        
            </ul>
            
        </section>
        <section class="content">
            <!-- 상품 설명 -->
            <article id="contents-exp">
                <img class="exp-img" src="${contextPath}/resources/images/subscribe/sub_detail_bread.jpg" alt="sub_detail_bread">
            </article>   

            
            <!-- 리뷰 -->
            <article class="boundary-line" id="contents-review" >
                <div class="header-title review-header ">
                    <p>리뷰</p>
                    <div class="review-header-right">
                        <div class="align-div" id="align-div">
                            <select id='selectcate'>
                                <option>별점높은순</option>
                                <option>별점낮은순</option>
                                <option>최신순</option>
                            </select>
                        </div>
                        <a class="reviewWrite" href="">리뷰쓰기</a>
                    </div>
                </div>
            </article> 
                
            <article id="reviewbox">
                <div class="one-line-review">
                    <div class="star-ratings">
                        <div class="star-ratings-fill " >
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base ">
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                    </div>
                    <span>장발장 바게트 3개월 째 구독중이에요.</span>
                    <span>닉네임</span>
                    <span>2022-01-24</span>
                </div>

                <div class="one-line-review">
                    <div class="star-ratings">
                        <div class="star-ratings-fill " >
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base ">
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                    </div>
                    <span>장발장 바게트 3개월 째 구독중이에요.</span>
                    <span>닉네임</span>
                    <span>2022-01-24</span>
                </div>

                <div class="one-line-review">
                    <div class="star-ratings">
                        <div class="star-ratings-fill " >
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base ">
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                    </div>
                    <span>장발장 바게트 3개월 째 구독중이에요.</span>
                    <span>닉네임</span>
                    <span>2022-01-24</span>
                </div>

                <div class="one-line-review">
                    <div class="star-ratings">
                        <div class="star-ratings-fill " >
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base ">
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                    </div>
                    <span>장발장 바게트 3개월 째 구독중이에요.</span>
                    <span>닉네임</span>
                    <span>2022-01-24</span>
                </div>
                
                <div class="one-line-review">
                    <div class="star-ratings">
                        <div class="star-ratings-fill " >
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base ">
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                    </div>
                    <span>장발장 바게트 3개월 째 구독중이에요.</span>
                    <span>닉네임</span>
                    <span>2022-01-24</span>
                </div>

                <div class="one-line-review">
                    <div class="star-ratings">
                        <div class="star-ratings-fill " >
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base ">
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                    </div>
                    <span>장발장 바게트 3개월 째 구독중이에요.</span>
                    <span>닉네임</span>
                    <span>2022-01-24</span>
                </div>

                <div class="one-line-review">
                    <div class="star-ratings">
                        <div class="star-ratings-fill " >
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base ">
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                    </div>
                    <span>장발장 바게트 3개월 째 구독중이에요.</span>
                    <span>닉네임</span>
                    <span>2022-01-24</span>
                </div>

                <div class="one-line-review">
                    <div class="star-ratings">
                        <div class="star-ratings-fill " >
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base ">
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                    </div>
                    <span>장발장 바게트 3개월 째 구독중이에요.</span>
                    <span>닉네임</span>
                    <span>2022-01-24</span>
                </div>

                <div class="one-line-review">
                    <div class="star-ratings">
                        <div class="star-ratings-fill " >
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base ">
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                    </div>
                    <span>장발장 바게트 3개월 째 구독중이에요.</span>
                    <span>닉네임</span>
                    <span>2022-01-24</span>
                </div>

                <div class="one-line-review">
                    <div class="star-ratings">
                        <div class="star-ratings-fill " >
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base ">
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                    </div>
                    <span>장발장 바게트 3개월 째 구독중이에요.</span>
                    <span>닉네임</span>
                    <span>2022-01-24</span>
                </div>
            </article><!-- 리뷰내용  -->
            
            
            
            <!-- 페이지네이션 -->
            <article class="pagination-area">
                <ul class="pagination">

                    <li><a class="page-link" href="list?cp=1${s}">&lt;&lt;</a></li>
                    <li><a class="page-link"
                        href="list?cp=${pagination.prevPage}${s}">&lt;</a></li>
                    <li class=" page-effect"><a class="page-link" >1</a></li>
                    <li><a class="page-link" href="list?cp=${i}${s}">2</a></li>
                    <li><a class="page-link" href="list?cp=${i}${s}">3</a></li>
                    <li><a class="page-link" href="list?cp=${i}${s}">4</a></li>
                    <li><a class="page-link" href="list?cp=${i}${s}">5</a></li>
                    <li><a class="page-link" href="list?cp=${i}${s}">6</a></li>
                    <li><a class="page-link" href="list?cp=${i}${s}">7</a></li>
                    <li><a class="page-link" href="list?cp=${i}${s}">8</a></li>
                    <li><a class="page-link" href="list?cp=${i}${s}">9</a></li>
                    <li><a class="page-link" href="list?cp=${i}${s}">10</a></li>
                    <li><a class="page-link"
                        href="list?cp=${pagination.nextPage}${s}">&gt;</a></li>
                    <li><a class="page-link"
                        href="list?cp=${pagination.maxPage }${s}">&gt;&gt;</a></li>
                </ul>
            </article>

        </section>  

        <!-- 배송/교환/환불 -->
        <article class=" contents-delievery boundary-line " id="contents-delievery">
            <div class="header-title ">
                <p>배송/교환/환불</p>
            </div>
           
                <div class="delievery-box delievery-area">
                    <div class="delievery-title">
                        <p>배송 정보</p>
                    </div>
                <div class="area-line"></div>
                <div class="delievery-content">
<pre>
DELIVERY / 배송정보
배송 방법 : 택배
배송 지역 : 전국지역
배송 비용 : 3,000원
배송 기간 : 2일 ~ 7일
- 제주, 산간벽지, 도서지방은 배송에서 제외됩니다.
고객님께서 주문하신 상품은 입금 확인후 배송해 드립니다.
다만, 상품종류에 따라서 상품의 배송이 다소 지연될 수 있습니다.
배송은 발송 후 익일 도착을 원칙으로 하며, 금요일 오전 9시 이후 주문분은 월요일 수령 가능합니다.
</pre>                      
                    </div>
                </div>
            
            <div class="refund-box delievery-area">
                <div class="refund-title">
                    <p>교환/환불 정보</p>
                </div>
                <div class="area-line refund-line"></div>
                <div class="refund-content ">
<pre>
교환 및 반품 주소
- 서울특별시 중구 남대문로 120 대일빌딩 2층, 3층 (JeanValJean)

교환 및 반품에 따른 요청 가능 기간
- 구매자 단순 변심은 상품 수령 후 7일 이내 (구매자 반품배송비 부담)
- 표시/광고와 상이, 상품 하자의 경우 상품 수령 후 3개월 이내 혹은 표시/광고와 다른 사실을 안 날로부터 30일 이내 (판매자 반품 배송비 부담)
둘 중 하나 경과 시 반품/교환 불가

교환 및 반품 불가능 사유
1. 반품요청기간이 지난 경우
2. 구매자의 책임 있는 사유로 상품 등이 멸실 또는 훼손된 경우 (단, 상품의 내용을 확인하기 위하여 포장 등을 훼손한 경우는 제외)
3. 구매자의 책임 있는 사유로 포장이 훼손되어 상품 가치가 현저히 상실된 경우 (예: 식품, 화장품, 향수류, 음반 등)
4. 구매자의 사용 또는 일부 소비에 의하여 상품의 가치가 현저히 감소한 경우 (라벨이 떨어진 의류 또는 태그가 떨어진 명품관 상품인 경우)
5. 시간의 경과에 의하여 재판매가 곤란할 정도로 상품 등의 가치가 현저히 감소한 경우
6. 고객의 요청사항에 맞춰 제작에 들어가는 맞춤제작상품의 경우 (판매자에게 회복불가능한 손해가 예상되고,
 그러한 예정으로 청약철회권 행사가 불가하다는 사실을 서면 동의 받은 경우)
7. 복제가 가능한 상품 등의 포장을 훼손한 경우 (CD/DVD/GAME/도서의 경우 포장 개봉 시)
</pre>
                </div>
            </div>
        </article>



    </main>
	
	
	
	
	
	
	
	
	
	<jsp:include page="../common/footer.jsp" />	
	<script type="text/javascript" src="${contextPath}/resources/js/subscribe/subBread.js"></script>
</body>
</html>
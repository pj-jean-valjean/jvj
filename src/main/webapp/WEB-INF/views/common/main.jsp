<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jean val jean</title>
<jsp:include page="../common/header.jsp" />
<link rel="stylesheet" href="${contextPath}/resources/css/main.css">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />

</head>
<body>
	<script>
        AOS.init();
    </script>
	<!-- Swiper -->
	<div class="swiper mySwiper">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<div class="main-banner"></div>
			</div>
			<div class="swiper-slide">
				<div class="main-banner2"></div>
			</div>
			<div class="swiper-slide">
				<div class="main-banner3"></div>
			</div>
			<div class="swiper-slide">
				<div class="main-banner4"></div>
			</div>
			
		</div>
		<div class="swiper-pagination"></div>
		      <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>
      
	</div>

	</div>
	<div class="main-wrapper">

		<div class="story">
			<div data-aos="fade-up" data-aos-duration="1000">
				<div class="store">

					<div class="store-pdt pdt1-img"></div>
					<div class="store-ex" style="margin-left: 126px">
						<h1>식 빵</h1>
						<p>식빵은 빵의 한 종류로, 밀가루, 물, 효모를 반죽해 틀에 넣어 구운 덩어리 빵, 또는 그 덩어리 빵을
							먹기 편하게 미리 잘라놓은 빵이다. 어원은 일본어의 쇼쿠판(食パン)이다. 일본에서는 미술 디자인을 할 때 그림 지우는
							용도로 사용하는 빵을 케시판(消しパン: 지움빵)이라 부르는데, 이에 대응하여 실제로 먹는 빵을 쇼쿠판(食パン:
							먹음빵)이라 부르던 데서 나왔다는 설이 대표적이다.</p>
						<h1>35,000원</h1>
						<div class="moreBtn">+ 더보기</div>
					</div>
				</div>
			</div>
			<div data-aos="fade-up" data-aos-duration="800">
				<div class="store">
					<div class="store-ex" style="margin-right: 126px">
						<h1>바게트 빵</h1>
						<p>원래 프랑스에서 주식용 빵은 동그란 형상의 빵인 캉파뉴가 주류였지만, 19세기 들어 바게트가 일상화되면서
							그 자리를 꿰차게 되었다. 캉파뉴는 발효 과정과 만드는 시간, 과정이 바게트보다 까다롭고 오래 걸린다. 그리고 크기도
							크고 딱딱해서 먹는 것부터가 일이었다. 반면 바게트는 캉파뉴보다 만들기 쉬웠고, 먹기도 편하고 운반하는 데도 더
							유리했다.</p>
						<h1>35,000원</h1>
						<div class="moreBtn">+ 더보기</div>
					</div>
					<div class="store-pdt pdt2-img"></div>

				</div>
			</div>
			<div data-aos="fade-up" data-aos-duration="800">
				<div class="store">
					<div class="store-pdt pdt3-img"></div>
					<div class="store-ex" style="margin-left: 126px">
						<h1>매커롱</h1>
						<p>매커롱을 누가 어디에서 처음 만들었는지는 정확히 알려져 있지 않다. 중세 유럽에서 전해졌다고도 하며,
							이탈리아의 수도원에서 만들었다고도 한다. 공식적인 기록은 1533년 이탈리아 메디치 가문의 카트린 드
							메디시스(Catherine de Médicis)가 프랑스의 앙리 2세와 결혼하게 되면서부터다. 그녀와 함께 프랑스로
							갔던 이탈리아의 요리사들을 통해 매커롱뿐만 아니라 이탈리아의 식문화가 프랑스에 전파되었다고 한다.</p>
						<h1>35,000원</h1>
						<div class="moreBtn">+ 더보기</div>
					</div>

				</div>
			</div>
		</div>
	</div>

	<div class="subscribe">
		<div data-aos="fade-up" data-aos-duration="800">
			<div>

				<h1 style="margin-top: 35px; display: inline-block;">정기구독</h1>
			</div>

			<div class="subs-wrap">
				<div class="subs-item subs-img1"></div>
				<h2>식빵 세트</h2>
			</div>
			<div class="subs-wrap">

				<div class="subs-item subs-img2"></div>
				<h2>식빵 & 커피 세트</h2>

			</div>

		</div>
	</div>
	<div data-aos="fade-up" data-aos-duration="800">
		<div class="main-wrapper">
			<div class="one-day-class">
				<div class="fake-hr"></div>
				<h1 style="display: inline-block; color: #828282;">원데이 클래스</h1>
				<div class="fake-hr"></div>
			</div>
			<div class="class-wrapper">
				<div class="class-wrap bigclass class-img0"></div>
				<div class="class-wrap">
					<div class="smallclass class-img2"></div>
					<div class="class-article">
						<p style="font-size: 26px;">마카롱 클래스</p>
						<p style="font-size: 20px; margin-top: 20px">2/14~2/20</p>
						<p style="font-size: 20px; margin-top: 20px">50,000원</p>
						<div class="black-btn" style="margin-top: 20px">부천점</div>
					</div>

					<div class="fake-hr2"></div>

					<div class="smallclass class-img1"></div>
					<div class="class-article">
						<p style="font-size: 26px;">슈크림 클래스</p>
						<p style="font-size: 20px; margin-top: 20px">2/14~2/20</p>
						<p style="font-size: 20px; margin-top: 20px">50,000원</p>
						<div class="black-btn" style="margin-top: 20px">부천점</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script>
    var swiper = new Swiper(".mySwiper", {
        spaceBetween: 30,
        centeredSlides: true,
        autoplay: {
          delay: 5500,
          disableOnInteraction: false,
        },
        pagination: {
          el: ".swiper-pagination",
          clickable: true,
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
      });
    </script>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>
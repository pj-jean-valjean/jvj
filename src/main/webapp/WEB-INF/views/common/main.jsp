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

</head>
<body>
   <script>
        AOS.init();
    </script>	

    <div class="main-banner">
  
    </div>
    <div class="main-wrapper">

        <div class="story">
            <div data-aos="fade-up">
                <div class="store">

                    <div class="store-pdt"></div>
                    <div class="store-ex" style="margin-left:126px">
                        <h1>페스츄리 빵 1</h1>
                        <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Expedita dolorem exercitationem aut
                            optio, sit maiores distinctio fugiat. Accusamus, perspiciatis rerum fuga nemo, aliquid quod
                            quidem odio vitae magnam dolorem deleniti?</p>
                        <h1>35,000원</h1>
                        <div class="moreBtn">+ 더보기</div>
                    </div>
                </div>
            </div>
            <div data-aos="fade-up">
                <div class="store">
                    <div class="store-ex" style="margin-right:126px">
                        <h1>페스츄리 빵 2</h1>
                        <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Expedita dolorem exercitationem aut
                            optio, sit maiores distinctio fugiat. Accusamus, perspiciatis rerum fuga nemo, aliquid quod
                            quidem odio vitae magnam dolorem deleniti?</p>
                        <h1>35,000원</h1>
                        <div class="moreBtn">+ 더보기</div>
                    </div>
                    <div class="store-pdt"></div>

                </div>
            </div>
            <div data-aos="fade-up">
                <div class="store">
                    <div class="store-pdt"></div>
                    <div class="store-ex" style="margin-left:126px">
                        <h1>페스츄리 빵 3</h1>
                        <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Expedita dolorem exercitationem aut
                            optio, sit maiores distinctio fugiat. Accusamus, perspiciatis rerum fuga nemo, aliquid quod
                            quidem odio vitae magnam dolorem deleniti?</p>
                        <h1>35,000원</h1>
                        <div class="moreBtn">+ 더보기</div>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <div class="subscribe">
        <div data-aos="fade-up">
            <div>

                <h1 style="margin-top:35px;display: inline-block;">정기구독</h1>
            </div>

            <div class="subs-wrap">
                <div class="subs-item"></div>
                <h2> 식빵 세트</h2>
            </div>
            <div class="subs-wrap">

                <div class="subs-item"></div>
                <h2> 식빵 & 커피 세트</h2>
            </div>

        </div>
    </div>
    <div data-aos="fade-up">
        <div class="main-wrapper">
            <div class="one-day-class">
                <div class="fake-hr"></div>
                <h1 style="display: inline-block; color:#828282; ">원데이 클래스</h1>
                <div class="fake-hr"></div>
            </div>
            <div class="class-wrapper">
                <div class="class-wrap bigclass"></div>
                <div class="class-wrap">
                    <div class="smallclass"></div>
                    <div class="class-article">
                        <p style="font-size: 26px;">식빵 만들기</p>
                        <p style="font-size: 20px;margin-top:20px">2/14~2/20</p>
                        <p style="font-size: 20px;margin-top:20px">50,000원</p>
                        <div class="black-btn" style="margin-top:20px">부천점</div>
                    </div>

                    <div class="fake-hr2"></div>

                    <div class="smallclass"></div>
                    <div class="class-article">
                        <p style="font-size: 26px;">식빵 만들기</p>
                        <p style="font-size: 20px;margin-top:20px">2/14~2/20</p>
                        <p style="font-size: 20px;margin-top:20px">50,000원</p>
                        <div class="black-btn" style="margin-top:20px">부천점</div>
                    </div>
                </div>

            </div>
        </div>
    </div>	
<jsp:include page="../common/footer.jsp" />	
</body>
</html>
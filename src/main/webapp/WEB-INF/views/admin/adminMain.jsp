<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JVJ 관리자페이지</title>
    <!-- 초기화css -->
    <link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
    <!-- 폰트 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@600&family=Noto+Sans+KR&display=swap" rel="stylesheet">
   	<link rel="stylesheet" href="${contextPath}/resources/css/admin/adminMain.css">
    <!-- include libraries(jQuery, bootstrap) -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <!-- include summernote css/js -->
   	<link rel="stylesheet" href="${contextPath}/resources/css/admin/summernote-bs4.min.css">
    <script src="${contextPath}/resources/js/admin/summernote-bs4.min.js"></script>
    <script src="${contextPath}/resources/js/admin/summernote-ko-KR.js"></script>
    
<!--     <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script> -->
</head>
<body>
    <header>
        <div class="admin-info"><span>${Admin.nickName}</span> 님 환영합니다! <a>로그아웃</a></div>
        <img src="${contextPath}/resources/images/common/jvj_logo.png">
    </header>
    <main>
        <aside id='showfunc'>
            <div class="one-admin-func" id=querybox>조회 업무
            	<div class="each-querybox">
                    <ul class="eachW">
                        <li class="querywork"><a href="/jvj/admin/board/route/searchMember">회원 정보 조회</a></li>
                        <li class="querywork"><a href="/jvj/admin/board/route/subsMember">구독 회원 조회</a></li>
                        <li class="querywork"><a href="/jvj/admin/board/route/searchOrder">주문 조회</a></li>
                    </ul>
                </div>
            </div>
            <div class="one-admin-func" id="writerP">게시글 작성
                <div class="eachWriter">
                    <ul class="eachW">
                        <li class="adminWriter"><a href="/jvj/admin/board/route/noticeWriter">공지사항 작성</a></li>
                        <li class="adminWriter"><a href="/jvj/admin/board/route/storeSubmit">일반 상품 등록</a></li>
                        <li class="adminWriter"><a href="/jvj/admin/board/route/subsSubmit">구독 상품 등록</a></li>
                        <li class="adminWriter"><a href="/jvj/admin/board/route/classSubmit">클래스 상품 등록</a></li>
                        <li class="adminWriter"><a href="/jvj/admin/board/route/optionSubmit">추가옵션상품 등록</a></li>
                    </ul>
                </div>
            </div>
            <div class="one-admin-func" id="editArticle">글 관리
                <div class="each-article">
                    <ul class="eachW">
                        <li class="modifyArticle"><a href="/jvj/admin/board/route/reviewManage">리뷰 관리</a></li>
                        <li class="modifyArticle"><a href="/jvj/admin/board/route/noticeManage">공지사항 수정</a></li>
                    </ul>
                </div>
            </div>
			<div class="one-admin-func" id="manageP">상품 관리
				<div class="modifyP">
                    <ul class="eachW">
                        <li class="manageP"><a href="/jvj/admin/board/route/productManage">상품 관리</a></li>
                        <li class="manageP">상품 옵션 관리</li>
                    </ul>
                </div>
			</div>
            <div class="one-admin-func">관리자계정 추가</div>
            <div class="one-admin-func">원데이클래스 회원정보</div>
        </aside>
        <section>
            <article id="adminPCont">
            </article>
            <article class="cal">
                    <div class="calendar">
                    <div class="calhead">
                    <button class="month-control" onclick="prev()">&lt;&lt;&lt;</button>
                    <span id="today-month"></span>
                    <button class="month-control" onclick="next()">&gt;&gt;&gt;</button>
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
        </section>
        </main>
	<script>
		const contextPath = "${contextPath}"
	</script>
	<script type="text/javascript" src="${contextPath}/resources/js/admin/adminMain.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/admin/adminMainMethod.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<jsp:include page="../common/header.jsp" />
 	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/admin/notice.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPageInfo.css/">
</head>
<body>
	<main>
    <div class="titleText">
    	<span>회원 정보</span>
    </div>
    <section>
    
    <jsp:include page="mypageMenu.jsp"/>	

            <article>
            <form action="#" class="infoForm">
                    <div id="btnDiv">

                            <label for="name" class="inputLabel">이름</label>
                            <input type="text" class="inputeel nameInput"> <br>

                            <label for="phone" class="inputLabel">전화번호</label>
                            <input type="text" class="inputeel phoneInput" oninput="autoHyphen(this)" maxlength="13"> <br>

                        <div id="addInput">
                            <p>주소</p>
                            <div class="memberAdd addInput1" style=" display: flex; flex-direction: column; justify-content: center;">우편번호</div>
                            <button type="button" class="addBtn" >주소 검색</button>
                            <br>
                            <div class="memberAdd addInput2 addIb">기본 주소</div>
                            <input type="text" placeholder="나머지 주소(선택 입력 가능)" class="memberAdd addInput3 addIb"><br>

                            <div class="chkInput">
                                <input type="checkbox" id="cbInput">
                                <label for="cbInput"></label>
                                <div>기본 배송지로 저장</div>
                            </div>
                        </div>
                    </div>
                <div class="subBtn">
                    <button id="infoUpdate">회원 정보 수정</button><br>
                    <button id="infoDelete">계정 연동 해지하기</button>
                </div>
            </form>

        </article>
        
    </section>
    </main>
	<jsp:include page="../common/footer.jsp" />	
	<script type="text/javascript" src="${contextPath}/resources/js/mypage/myPageInfo.js"></script>
</body>
</html>
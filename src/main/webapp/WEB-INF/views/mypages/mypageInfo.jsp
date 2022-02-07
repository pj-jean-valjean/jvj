<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
            <form method="POST" action="update" class="infoForm" onsubmit="return memberUpdateValidate();" role="form" name="updateForm">
            
            	<c:set var="addr" value="${fn:split(loginMember.memberAddress, ',,') }"/>
				
				<c:set var="ph" value="${fn:split(loginMember.memberPhone, '-') }"/>
            
            
                    <div>
		                    <div class="userInfo">
		                    <p>이름</p>  <p>${loginMember.memberName}</p>
		                    </div>
		                    
							<div class="userInfo">
							<p>이메일</p>  <p>${loginMember.memberEmail}</p>
							</div>
							
                            <label for="nickname" class="inputLabel" id="inputNickname">닉네임</label>
                            <input type="text" class="inputStyle" name="nickname" value="${loginMember.memberNickname}"> <br>

                            <label for="presentPw" class="inputLabel">현재 비밀번호</label>
                            <input type="password" class="inputStyle" id="nowPwd" > <span id="checkPwd"></span><br>

                            <label for="modifyPw" class="inputLabel">수정할 비밀번호</label>
                            <input type="password" class="inputStyle" id="modifyPwd1"> <span id="checkPwd1"></span><br>
                            <label for="modifyPw" class="inputLabel">재입력</label>
                            <input type="password" class="inputStyle" id="modifyPwd2"> <span id="checkPwd2"></span><br>

                            <label for="phone" class="inputLabel">전화번호</label>
                            
                            <select class="phoneNum phoneOpt" id="phoneNum1">
                            	<option>010</option>
		                        <option>011</option>
		                        <option>016</option>
		                        <option>017</option>    
		                        <option>019</option>
                            </select>
                            
                            <input type="text" class="phone phoneNum"  id="phoneNum2" name="phone" value="${ph[1]}">
                            <input type="text" class="phone phoneNum" id="phoneNum3" name="phone" value="${ph[2]}"> <br>

                        <div id="addInput">
                            <p>주소</p>
                            <input type="text" class="memberAdd addInput1" id="postcode" placeholder="우편번호" name="address" value="${addr[0]}">
                            <input type="button" class="addBtn" value="우편번호" onclick="addressFind()" >
                            <br>
                            <input type="text" class="memberAdd addInput2 addIb" id="address" placeholder="기본 주소" name="address" value="${addr[1]}">
                            <input type="text" class="memberAdd addInput3 addIb" id="detailAddress" placeholder="상세 주소" name="address" value="${addr[2]}"><br>

                            <div class="chkInput">
                            <c:if test="${!empty loginMember.memberAddress}">
                                <input type="checkbox" id="cbInput" checked>
                                <label for="cbInput"></label>
                                <div>기본 배송지로 저장</div>
                            </c:if>
                            </div>
                        </div>
                    </div>
                <div class="subBtn">
                    <button type="submit" id="infoUpdate" onclick="memberUpdateValidate()">회원 정보 수정</button><br>
                    <button type="button" id="infoDelete">계정 연동 해지하기</button>
                </div>
            </form>

        </article>
        
    </section>
    </main>
	<jsp:include page="../common/footer.jsp" />	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${contextPath}/resources/js/mypage/myPageInfo.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript">
	
	function addressFind() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            var addr = ''; // 주소 변수
	            var extraAddr = ''; // 참고항목 변수

	            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                addr = data.roadAddress;
	            } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                addr = data.jibunAddress;
	            }

	            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	            if(data.userSelectedType === 'R'){
	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	            
	            } else {
	                document.getElementById("detailAddress").value = '';
	            }

	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            document.getElementById('postcode').value = data.zonecode;
	            document.getElementById("address").value = addr;
	            // 커서를 상세주소 필드로 이동한다.
	            document.getElementById("detailAddress").focus();
	        }
	    }).open();
	}
		
</script>

	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />

    <link rel="stylesheet" href="${contextPath}/resources/css/member/searchPwResult.css">

    <main>

        <section class="title-section">
            <p>비밀번호 변경</p>
        </section>


        <div class="member-form-info">
        
        <form action="${contextPath}/member/searchPwResult" method="POST">
        <div class="input-info"><div class="input-info-div">
            <div class="p-div"><p>비밀번호</p></div>
            <div class="input-div"><input type="password" class="member-info"  id="pwd1" name="memberPw" maxlength="12" placeholder=" 문자, 숫자, 기호를 조합하여 6~20글자를 사용하세요"></div>
        	
        	<span id="checkPwd1"></span>
        </div>
        
        <div class="input-info-div">
            <div class="p-div"><p>비밀번호 확인</p></div>
            <div class="input-div"><input type="password" class="member-info" id="pwd2" maxlength="12" placeholder="비밀번호 확인" required></div>
        	<span id="checkPwd2"></span>
        </div>

        </div>
            <div class="flex-div">
                <div class="signUp-select-btn">
                    <button type="submit" id="search-btn" onclick="updatePwValidate()">확인</button>
                </div>
            </div>
            
            <!-- member값 넘기기용  -->
            <input type="hidden" name="memberEmail" value="${memberEmail}">

        </form>
        </div>

    </main>
    


<jsp:include page="../common/footer.jsp" />

<script>
//새 비밀번호 유효성 검사
//- 영어 대/소문자, 숫자, 특수문자(!,@,#,-,_), 6~20글자
document.getElementById("pwd1").addEventListener("input", (e) => {

 const inputPw = e.target.value; 

 const regExp = /^[a-zA-Z\d\!\@\#\-\_]{6,20}$/; // 정규식

 const checkPwd1 = document.getElementById("checkPwd1"); // 출력용

 if(inputPw.length == 0){ // 빈칸
     checkPwd1.innerText = "";
     signUpCheckObj.pwd1 = false;
 
 }else if(regExp.test(inputPw)){ // 유효할 때
     checkPwd1.innerText = "유효한 비밀번호 입니다.";
     checkPwd1.style.color = "#9CC7F9";
     signUpCheckObj.pwd1 = true;

 }else{
     checkPwd1.innerText = "유효하지 않은 비밀번호 입니다.";
     checkPwd1.style.color = "#F99C9C";
     signUpCheckObj.pwd1 = false;
 }
 
});	
</script>
<script src="${contextPath}/resources/js/member/searchPw.js"></script>
    
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />

    <link rel="stylesheet" href="${contextPath}/resources/css/member/searchPwResult.css">

    <main>

        <section class="title-section">
            <p>비밀번호 변경</p>
        </section>

        <div class="member-form-info">
        
        <form>
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

        </form>
        </div>

    </main>
    


<jsp:include page="../common/footer.jsp" />
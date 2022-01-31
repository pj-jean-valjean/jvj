<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
 <link rel="stylesheet" href="${contextPath}/resources/css/member/searchId.css">


<content>

    <div class="login-title">
        <p class="text-center">아이디 찾기</p>
    </div> 
    
    <%-- action="${contextPath}/member/searchIdResult"> --%>
    <form method="post">
        <div class="input-info">
            <div class="input-info-div">
                <div class="p-div"><p>이름</p></div>
                <div class="input-div name-div"><input type="text" class="search-info"  id="name" name="memberName" maxlength="5" required></div>
            </div>
            <!-- 이름 유효성 검사 -->
            <span id="checkName"></span>
            	
            	
            <div class="input-info-div">
                <div class="p-div"><p>휴대폰번호</p></div>
                        <div class="input-div">
                            <select class="search-info-select phone-input" id="phone1" name="phone" required>
                                <option>010</option>
                                <option>011</option>
                                <option>016</option>
                                <option>017</option>    
                                <option>019</option>
                            </select>
                        </div> 
                        <span>-</span>
                        <div class="input-div"><input type="text" class="search-info phone-input" id="phone2" name="phone" required></div>
                        <span>-</span>
                        <div class="input-div"><input type="text" class="search-info phone-input" id="phone3" name="phone" required></div>
            </div>
			<!-- 이름 유효성 검사 -->
            <span id="checkPhone"></span>
        </div>



        <div class="search-btn">
            <button type="submit" id="search-id" onclick="searchIdResult">확인</button>
        </div>
    </form> 

    <div class="flex-div">
        <ul class="goSignUp">
            <li><a href="${contextPath}/member/login"><span>로그인</span></a><div class="updown"></div></li>
            <li><a href="${contextPath}/member/searchPw"><span>비밀번호 찾기</span></a><div class="updown"></div></li>
            <li><a href="${contextPath}/member/signUp"><span>회원가입</span></a></li>
        </ul>
    </div>
</content>

<jsp:include page="../common/footer.jsp" />

 <script src="${contextPath}/resources/js/member/searchId.js"></script>
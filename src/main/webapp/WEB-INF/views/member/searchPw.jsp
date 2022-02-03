<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
 <link rel="stylesheet" href="${contextPath}/resources/css/member/searchPw.css">


    <main>

        <section class="title-section">
            <p>비밀번호 찾기</p>
        </section>

        <div class="member-form-info">
        
	        <form method="post" action="${contextPath}/member/searchPw" name="searchPwForm" onsubmit="return validate();">
			<div class="input-info">
				<div class="input-info-div">
					<div class="p-div">
						<p>이메일</p>
					</div>
					<div class="input-div">
						<input type="text" class="member-info email-input" name="memberEmail" id="email-input" autocomplete="off" maxlength="20" required>
					</div>

					<span>@</span>
					<div class="input-div">
						<input type="text" class="member-info email-input" id="email-input-select" name="memberEmail"> 
						<select class="member-info" id="email-select">
							<option value="0">직접입력</option>
							<option value="1">naver.com</option>
							<option value="2">daum.net</option>
							<option value="3">gmail.com</option>
						</select>
					</div>


					<div class="input-div">
						<button type="button" id="sendEmail">이메일인증</button>
					</div>
					<p id="checkEmail"></p>
				</div>


				<div class="input-info-div" id="email-checkNum">
					<div class="p-div">
						<p>
							인증번호
						</p>
					</div>
					<div class="input-div">
						<input type="number" class="member-info" id="email-Authentication" placeholder="인증번호를 입력해주세요." maxlength="12" required>
					</div>
					<div class="input-div">
	                    <button type="button" class="email-check-btn"  id="check-email-Authentication" >확인</button>
	               		<input type="hidden" id="certificationYN" value="false">
	                </div>   
					<span id="timeCount"></span>
					<span id="signUpEmailCheck"></span>
				</div>

			</div>


			<div class="flex-div">
	                <div class="signUp-select-btn">
	                    <button type="submit" id="search-btn">확인</button>
	                </div>
	            </div>
			
	
	        </form>
        </div>

        <div class="flex-div">
            <ul class="goSignUp">
                <li><a href="${contextPath}/member/login"><span>로그인</span></a><div class="updown"></div></li>
                <li><a href="${contextPath}/member/searchId"><span>아이디 찾기</span></a><div class="updown"></div></li>
                <li><a href="${contextPath}/member/signUp"><span>회원가입</span></a></li>
            </ul>
        </div>


    </main>
    
<jsp:include page="../common/footer.jsp" />


    <script> 

    </script>
    
    <script src="${contextPath}/resources/js/member/searchPw.js"></script>
    
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
	
    <link rel="stylesheet" href="${contextPath}/resources/css/member/signUp.css">

    <main>

        <section class="title-section">
            <p>회원가입</p>
        </section>

        <div class="member-form-info">
        
        <form>
        <div class="input-info">
            <div class="input-info-div">
                <div class="p-div"><p>이메일<span> *</span></p></div>
                <div class="input-div"><input type="text" class="member-info email-input" name="memberEmail" id="email-input" required></div>

                <span>@</span>
                <div class="input-div">
                    <input type="text" class="member-info email-input" id="email-input-select">
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
            </div>
            <!-- 버튼 클릭 유효성 검사 확인 -->
			<p id="checkEmail"></p>
			
			
            <div class="input-info-div" id="email-checkNum">
                <div class="p-div"><p>인증번호<span> *</span></p></div>
                <div class="input-div">
                    <input type="text" class="member-info" id="email-Authentication" placeholder="인증번호를 입력해주세요.">
                </div>   
                	<span id="check-email-Authentication"></span>
            </div>


            <div class="input-info-div">
                <div class="p-div"><p>비밀번호<span> *</span></p></div>
                <div class="input-div"><input type="password" class="member-info" id="pwd1" name="memberPw" maxlength="12" placeholder="영어 대/소문자, 숫자, 특수문자(!,@,#,-,_) 포함 6~20글자" required></div>
            	
            	<!-- 비밀번호 유효성 검사1 -->
            	<span id="checkPwd1"></span>
            </div>
            <div class="input-info-div">
                <div class="p-div"><p>비밀번호 확인<span> *</span></p></div>
                <div class="input-div"><input type="password" class="member-info" id="pwd2" maxlength="12" placeholder="비밀번호 확인" required></div>
            	
            	<!-- 비밀번호 유효성 검사2 -->
            	<span id="checkPwd2"></span>
            </div>
            <div class="input-info-div">
                <div class="p-div"><p>닉네임<span> *</span></p></div>
                <div class="input-div"><input type="text" class="member-info" id="nickname" name="memberNickname" required></div>
                
                <!-- 닉네임 유효성 검사 -->
            	<span id="checkNickname"></span>
            </div>
            <div class="input-info-div">
                <div class="p-div"><p>이름<span> *</span></p></div>
                <div class="input-div"><input type="text" class="member-info" id="name" name="memberName" maxlength="5" required></div>
            	<!-- 이름 유효성 검사 -->
            	<span id="checkName"></span>
            </div>
           

            <div class="input-info-div">
                <div class="p-div"><p>휴대전화<span> *</span></p></div>
                <div class="input-div">
                    <select  class="member-info-select phone-input phone" id="phone1" name="phone" required>
                        <option>010</option>
                        <option>011</option>
                        <option>016</option>
                        <option>017</option>    
                        <option>019</option>
                    </select>
                </div> 
                <span>-</span>
                <div class="input-div"><input type="number" class="member-info phone-input phone" id="phone2" name="phone" required></div>
                <span>-</span>
                <div class="input-div"><input type="number" class="member-info phone-input phone" id="phone3" name="phone" required></div>
            	
            	<!-- 전화번호 유효성 검사 -->
            	<span id="checkPhone"></span>
            </div>

            <div class="input-info-div">
                <div class="p-div"><p>주소</p></div>
                <div class="input-div"><input type="text"class="member-info addr"></div>
                <div class="input-div"><button class="input-btn" type="button">주소검색</button></div>
            </div>
            <div class="input-info-div">
                <div class="p-div"></div>
                <div class="input-div"><input type="text" class="member-info"></div>
            </div>
            <div class="input-info-div">
                <div class="p-div"></div>
                <div class="input-div"><input type="text"  class="member-info"></div>
            </div>
            

        </div>
            <div class="give-flex">
                <div class="signUp-select-btn">
                    <button type="submit" id="signUp-btn" onclick="return validate();">회원가입</button>
                </div>
            </div>


        </form>
        </div>

    </main>

 
<jsp:include page="../common/footer.jsp" />


 <script> 


 </script>
   
   
   
   
<script src="${contextPath}/resources/js/member/signUp.js"></script>
	
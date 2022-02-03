
const searchPwResult = {
	"email" : false,
    "checkEmailNum" : false
}

function validate(){

	for (key in searchPwResult) {
		if (!searchPwResult[key]) {

			let message;

			switch (key) {
				case "email": message = "이름이 유효하지 않습니다."; break;
				case "checkEmailNum": message = "이름이 유효하지 않습니다."; break;
			}

			alert(message);

			// 유효하지 않은 input 요소로 포커스 이동
			document.getElementById(key).focus();

			// form태그 submit 기본 이벤트 제거
			return false;
		}
	}
}



//이메일 입력방식 선택 
$('#email-select').change(function() {
	$("#email-select option:selected").each(function() {
		if ($(this).val() == '0') { //직접입력일 경우 
			$("#email-input-select").val(''); //값 초기화 
			$("#email-input-select").attr("disabled", false); //활성화 
		} else { //직접입력이 아닐경우 
			$("#email-input-select").val($(this).text()); //선택값 입력 
			$("#email-input-select").attr("disabled", true); //비활성화 
		}
	});
});


// 이메일 인증 버튼 인증번호 input 태그 보여줌 
document.querySelector("#sendEmail").addEventListener("click", function() {
	
	const inputEmail = document.getElementById("email-input").value;
    const selectEmail = document.getElementById("email-input-select").value;
	
	if( inputEmail.length == 0  && selectEmail.length == 0){ // 둘다 빈 칸일 경우
        searchPwResult.email = false;
   	
    }else{ 
        signUpCheckObj.email = true;
    }
});


// 새 비밀번호 유효성 검사
// - 영어 대/소문자, 숫자, 특수문자(!,@,#,-,_), 6~20글자
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

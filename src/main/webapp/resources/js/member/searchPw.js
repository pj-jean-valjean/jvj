
const searchPwResult = {
	"name" : false,
    "phone3" : false
}

function validate(){

	for (key in searchPwResult) {
		if (!searchPwResult[key]) {

			let message;

			switch (key) {
				case "email": message = "이름이 유효하지 않습니다."; break;
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

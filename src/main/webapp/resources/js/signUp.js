///////////////
const signUpCheckObj = {
    "email" : false,
    "pwd1" : false,
    "pwd2" : false,
	   
    "name" : false,
    "phone3" : false
}

/* // 회원 가입 버튼 클릭 시 유효성검사 판단 */
function validate(){
	
for( key  in signUpCheckObj ){

        // signUpCheckObj 객체의 속성 중 키가 key인 속성의 value를 얻어와
        // !를 붙여서 조건이 참인지 확인
        if( !signUpCheckObj[key] ){
            
            let message;

            switch(key){
            case "id" : message = "아이디가 유효하지 않습니다."; break;
            case "name" : message = "이름이 유효하지 않습니다."; break;
            case "email" : message = "이메일이 유효하지 않습니다."; break;
            case "pwd1" : message = "비밀번호가 유효하지 않습니다."; break;
            case "pwd2" : message = "비밀번호가 일치하지 않습니다."; break;
            case "phone3" : message = "전화번호가 유효하지 않습니다."; break;
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

/* 인증번호 input 태그 보여줌 */
document.querySelector("#sendEmail").addEventListener("click", function() {
	document.querySelector("#email-checkNum").style.display = "block";
});



/*
// 인증번호 input 태그 보여줌 
document.querySelector("#sendEmail").addEventListener("click", function() {
	
	const inputEmail = document.getElementById("email-input").value;
    const selectEmail = document.getElementById("email-input-select").value;
	
	const regExp1 = /^[\w]{4,}$/;
	const regExp2 = /^[\w]+(\.[\w]+){1,3}$/;
	
	if( inputEmail.length == 0  && selectEmail.length == 0){ // 둘다 빈칸일 경우
		alert("빈칸");
		
        signUpCheckObj.email = false;
    }else if(regExp1.test(inputEmail) && regExp2.test(selectEmail) ){ // 둘다 유효
	    alert("유효");
	    document.querySelector("#email-checkNum").style.display = "block";
        signUpCheckObj.email = true;

    }else{ // 둘 중 하나라도 유효 X
        signUpCheckObj.email = false;
    }

});*/




/* 이메일 인증 버튼 */
/*document.

email-input-select*/

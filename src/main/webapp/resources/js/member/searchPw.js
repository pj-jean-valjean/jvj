
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



//이메일 인증 버튼 인증번호 input 태그 보여줌 
document.querySelector("#sendEmail").addEventListener("click", function() {
	
	const inputEmail = document.getElementById("email-input").value;
    const selectEmail = document.getElementById("email-input-select").value;
	const checkEmail = document.getElementById("checkEmail");
	
	const regExp1 = /^[\w]{4,}$/;
	const regExp2 = /^[\w]+(\.[\w]+){1,3}$/;
	
	if( inputEmail.length == 0  && selectEmail.length == 0){ // 둘다 빈칸일 경우
    	document.querySelector("#email-checkNum").style.display = "none";
		checkEmail.innerText ="이메일을 입력해주세요.";
		checkEmail.style.color = "#F99C9C";
        signUpCheckObj.email = false;
   	
    }else if(regExp1.test(inputEmail) && regExp2.test(selectEmail) ){ 
		checkEmail.innerText ="";
	    document.querySelector("#email-checkNum").style.display = "block";
        signUpCheckObj.email = true;

    }else{ // 둘 중 하나라도 유효 X
    	document.querySelector("#email-checkNum").style.display = "none";
		checkEmail.innerText ="이메일을 확인해주세요.";
		checkEmail.style.color = "#F99C9C";
        signUpCheckObj.email = false;
    }
});


// 이메일 인증번호 검사
document.querySelector("#email-Authentication").addEventListener("input", function() {
	
	// 인증번호 작성했는가
	
	// 인증번호가 맞다면
	
	// 인증번호가 틀렸다면	

});

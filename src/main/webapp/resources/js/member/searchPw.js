
const searchPwResult = {
	"email" : false,
    "checkEmail" : false
}

function validate(){

	for (key in searchPwResult) {
		if (!searchPwResult[key]) {

			let message;

			switch (key) {
				case "email": message = "이메일이 유효하지 않습니다."; break;
				case "checkEmail": message = "인증번호가 유효하지 않습니다."; break;
			}

			alert(message);

			// 유효하지 않은 input 요소로 포커스 이동
			document.getElementById(key).focus();

			// form태그 submit 기본 이벤트 제거
			return false;
		}
	}
	// input type="hidden" 태그 생성 및 추가 
    const email = document.getElementsByName("email");

    // input태그 생성
    // email 진행
	const input1 = document.createElement("input");
    input1.setAttribute("type", "hidden");
    input1.setAttribute("name", "memberEmail");
    input1.value = email[0].value + "@" + email[1].value;
    document.signUpForm.append(input1);
	
	
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
  	const checkEmail = document.getElementById("checkEmail");
  	const memberEmail = inputEmail + '@' + selectEmail;
  	
  	
  	const regExp1 = /^[\w]{4,}$/;
  	const regExp2 = /^[\w]+(\.[\w]+){1,3}$/;
  	
  	if( inputEmail.length == 0  && selectEmail.length == 0){ // 둘 다 빈칸일 경우
  		
      	document.querySelector("#email-checkNum").style.display = "none";
  		checkEmail.innerText ="";
          searchPwResult.email = false;
     	
      }else if(!regExp1.test(inputEmail) || !regExp2.test(selectEmail) ){ // 둘 중 하나라도 유효 X
      	document.querySelector("#email-checkNum").style.display = "none";
  		checkEmail.innerText ="이메일을 확인해주세요.";
  		checkEmail.style.color = "#F99C9C";
          searchPwResult.email = false;
      
      } else { 
  		//checkEmail.innerText ="유효한 이메일 입니다";
  		//checkPwd1.style.color = "#9CC7F9";
  	    document.querySelector("#email-checkNum").style.display = "block";
          searchPwResult.email = true;
          
          
      
      	$.ajax({
  			type:"POST",
  			url :"email",
  			data :{"memberEmail":memberEmail},
  			success : function(data){
  			}, error : function(request, status, error){
  				alert("오류입니다.");
  			}
  		});
  		
      }
      
      
      
      
  });

  // 인증번호 확인
  document.querySelector("#check-email-Authentication").addEventListener("click", function() {

  	let inputEmail = document.getElementById("email-input").value;
      let selectEmail = document.getElementById("email-input-select").value;
      
      let memberEmail = inputEmail + '@' + selectEmail;
      
      let inputCode= document.getElementById("email-Authentication").value;
      
      
      
      $.ajax({
  		type:"POST",
  		url :"certification",
  		data :{"memberEmail":memberEmail, "inputCode":inputCode},
  		success : function(result){
  			console.log(result);
  			if(result == true){
  				$("#email-Authentication").attr("disabled", true); // 입력창 비활성화
  				
  				document.getElementById("certificationYN").value = "true";
  				searchPwResult.checkEmail= true;
  				
  				memberEmail.onchange = function(){
  					document.getElementById("certificationYN").value = "false";
  					searchPwResult.checkEmail = true;
  				}
  			} else{
  				$("#email-Authentication").css("background-color", "#F99C9C");
  				
  				searchPwResult.checkEmail = false;
  			}
  			
  		}, error : function(request, status, error){
  			alert("인증 확인 중 오류입니다.");
  		}
  	
  	
  	
  	});
      
      
  });




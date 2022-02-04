const modifyInfomationChk = {
    phoneInput : true,
    nicknameInput : true,
    pwInput : true,
    pwd1 : true,
    pwd2 : true
}


let phoneNumber;

// 전화번호 입력되는 글자 수 제한
$(".phone").on("input", function(e){
    
    if(  $(this).val().length > 4  ){
        const num = $(this).val().slice(0,4);
        $(this).val(num);
    }

    // e 입력 방지
    if(e.originalEvent.data == "e"){
        $(this).val(phoneNumber);
    }else{
        phoneNumber = $(this).val();
    }

});

// 전화번호가 변했을 경우 유효성 검사
$(".phone").on("change", function(){

    const phoneNum2 = document.getElementById("phoneNum2").value;
    const phoneNum3 = document.getElementById("phoneNum3").value;

    const regExp2 = /^\d{3,4}$/;
    const regExp3 = /^\d{4}$/;

    if( phoneNum2.length == 0  || phoneNum3.length == 0){ // 둘 중 하나라도 빈칸일 경우
        modifyInfomationChk.phoneInput = false;

    }else if(regExp2.test(phoneNum2) && regExp3.test(phoneNum3) ){ // 둘다 유효
        modifyInfomationChk.phoneInput = true;

    }else{ // 둘 중 하나라도 유효 X
        alert("유효하지 않는 전화번호 입니다.");
        modifyInfomationChk.phoneInput = false;
        this.focus();
    }

});

// 닉네임 유효성 검사
const formerNm = document.getElementById("inputNickname").value;

document.getElementById("inputNickname").addEventListener("change",(e)=>{

    const inputName = e.target.value;
    const regExp = /^[가-힣ㄱ-ㅎa-zA-Z0-9._ -]{2,5}$/;

    if( formerNm == inputName){ // 기존 닉네임과 같을경우
        modifyInfomationChk.nicknameInput = true;

    }else if(regExp.test(inputName)){ // 유효한 닉네임일 경우
        modifyInfomationChk.nicknameInput = true;

    }else if(inputName == 0){ // 유효하지 않을 경우
        modifyInfomationChk.nicknameInput = false;
        alert("이름을 작성해주세요");
        this.focus();
    }else{
        modifyInfomationChk.nicknameInput = false;
        alert("유효하지 않는 닉네임 입니다.");
        this.focus();
    }
});


// 비밀번호 유효성 검사
let formerPw = document.getElementById("password").value

document.getElementById("password").addEventListener("change",(e)=>{
    
    const inputPw = e.target.value;
    
    if(inputPw == formerPw){
        modifyInfomationChk.pwInput = true;
    }else{
        alert("비밀번호가 일치하지 않습니다.");
        modifyInfomationChk.pwInput = false;
    }

});

document.getElementById("repassword1").addEventListener("input",(e)=>{

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

$("#repassword2, #repassword1").on("input", function(){

    const pwd1 = document.getElementById("repassword1").value;
    const pwd2 = document.getElementById("repassword2").value;
    const checkPwd2 = document.getElementById("checkPwd2"); // 출력용

    if( pwd2.trim().length == 0 ){ // 비밀번호 확인이 빈칸일 경우
        checkPwd2.innerText = "";
        signUpCheckObj.pwd2 = false;

    }else if(pwd1 == pwd2){ // 유효한 경우
        checkPwd2.innerText = "비밀번호가 일치합니다.";
        checkPwd2.style.color = "#9CC7F9";
        signUpCheckObj.pwd2 = true;
        
    }else { // 유효하지 않은 경우
        checkPwd2.innerText = "비밀번호가 일치하지 않습니다.";
        checkPwd2.style.color = "#F99C9C";
        signUpCheckObj.pwd2 = false;
    }
});


function memberUpdateValidate(){

    for( key in modifyInfomationChk ){

        if(!modifyInfomationChk[key]){
            // updateCheckObj에 저장된 value중 false가 있는 경우

            let message;

            switch(key){
            case "phoneInput" : message = "전화번호가 유효하지 않습니다.";   break;
            case "nicknameInput" : message = "닉네임이 유효하지 않습니다.";   break;
            case "pwInput"  : message = "비밀번호가 일치하지 않습니다.";  break;
            case "pwd1"  : message = "수정할 비밀번호가 유효하지 않습니다.";  break;
            case "pwd2"  : message = "수정할 비밀번호가 일치하지 않습니다.";  break;
            }

            alert(message);

            // 유효하지 않은 input요소로 포커스 이동
            document.getElementById(key).focus(); 

            return false; // submit 이벤트 제거

        }
    }
}

/*
const modifyInfomationChk = {
    nameInput : true,
    phoneInput : true
}


// 이전에 작성된 이름 임시 저장
const existingName = document.getElementById("nameInput").value;

document.getElementById("nameInput").addEventListener("change", (e)=>{

    const inputName = e.target.value;
    const reqExp = /^[가-힣]{2,5}$/;

    if(inputName == existingName){
        modifyInfomationChk.nameInput = true;

    }else if(reqExp.test(inputName) == true){
        modifyInfomationChk.nameInput = true;

    }else{
        alert("이름을 잘못 입력하셨습니다.");
        modifyInfomationChk.nameInput = false;
    }
});



// 이전에 작성된 전화번호 임시 저장
let phoneNum;

document.getElementById("phoneInput").addEventListener("input", (e)=>{

    const phone = document.getElementById("phoneInput");

    if(  phone.value.length > 11  ){
        const num = phone.value.slice(0,11);
        phone.value(num);
    }

    // e 입력 방지
    if(e.originalEvent.data == "e"){
        phone.value(temp);
    }else{
        temp = phone.value;
    }
    

});


// 전화번호 유효성 검사
document.getElementById("phoneInput").addEventListener("change", (e)=>{

    const inputPhone = e.targe.value;
    const reqExp = /^\d{10,11}$/;
        
    if( reqExp.test(inputPhone) == true ){
        modifyInfomationChk.phoneInput = true;
    }else{
        alert("전화번호를 잘못 입력하셨습니다.");
        modifyInfomationChk.phoneInput = false;
    }

});

 

function memberModifydata(){
    
    for( key in modifyInfomationChk[key]){

        if(!modifyInfomationChk[key])

        let msg;

        switch(key){
            case "nameInput" : msg = "이름이 유효하지 않습니다."; break;
            case "phoneInput" : msg = "전화번호가 유효하지 않습니다."; break; 
        }

        alert(msg);

        document.getElementById(key).focus();

        return false;
    }
}
*/

const autoHyphen = (target) => {
    target.value = target.value
      .replace(/[^0-9]/, '')
      .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
}

function loginValidate(){
    const memberId = document.querySelector("#memberId");
    const memberPw = document.querySelector("#memberPw");

    if(memberId.value.trim().length == 0){
        memberId.focus();
        alert("아이디를 입력해주세요.");
        return false;
    } else if(memberPw.value.trim().length == 0){
        memberPw.focus();
        alert("비밀번호를 입력해주세요.");
        return false;
    } 
};
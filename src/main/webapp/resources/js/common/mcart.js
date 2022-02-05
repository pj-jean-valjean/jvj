let cartOpenDefaultOne = 1;
var elements = document.querySelectorAll('.a>*');

let am = anime({
  targets: elements,
  translateX: -420,
  autoplay: false

});

let am2 = anime({
    targets: elements,
    translateX: 0,
    autoplay: false
  
  });

function openc(){
   
    setTimeout(function() {
        console.log('Works!');
      }, 3000);
}
document.querySelector('.open-c').addEventListener("click",()=>{
  if(loginMember == ""){
    swal({title: "로그인 필요",text:"로그인 후 장바구니에 담기가 가능합니다.",icon:"info",buttons:'확인'}).then((value)=>{
      if(value){
        location.href=contextPath+"/member/login";
        
      }
    });
  }else{
    if(cartOpenDefaultOne == 1 ){
      am.restart();
      cartOpenDefaultOne= 0;}
      else{
        am2.restart();
        cartOpenDefaultOne= 1;
      }

  }
});
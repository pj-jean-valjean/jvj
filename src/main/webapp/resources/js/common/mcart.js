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
  if(cartOpenDefaultOne == 1 ){
    am.restart();
    cartOpenDefaultOne= 0;}
    else{
      am2.restart();
      cartOpenDefaultOne= 1;
    }
});
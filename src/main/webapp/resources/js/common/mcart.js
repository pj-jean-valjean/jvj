
var elements = document.querySelectorAll('.a>*');

let am = anime({
  targets: elements,
  translateX: -420,
  autoplay: false

});


function openc(){
   
    setTimeout(function() {
        console.log('Works!');
      }, 3000);
}
document.querySelector('.open-c').addEventListener("click",()=>{
  am.play();
  am.finished.then(() => {
    am.reverse();
  });    
});
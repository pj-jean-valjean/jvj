
// 조아요
  $(document).ready(function () {
    $('.content').click(function () {
      $(this).toggleClass("heart-active");
      $(this).next().toggleClass("heart-active");
      $(this).children().toggleClass("heart-active");
    });
  });
  
  
  // 우리팀 1등을 위한 도약 1
   $(".pdt-img").click(function(){
    $(this).addClass("outer");
    let storeNo = $(this).next().val();
    $(this).addClass("bingel").toggleClass("emphasized");
    $(this).css({ "position": "fixed", "top": "41%", "left":"43%"}).css("z-index","999");    
    setTimeout(() => {location.href ="store/info/"+storeNo}, 1500);
  });


  // 가격에 콤마표시
 let prices = $('.pricewon');
 for(let i = 0; i<prices.length; i++){
	prices[i].textContent = parseInt(prices[i].textContent).toLocaleString('ko-KR')+"원";
};
 

$("#format").change(function(){
  let selectedValue = $(this).val();
  location.href=contextPath+"/store?cp=1&op=0&ct="+selectedValue;
})
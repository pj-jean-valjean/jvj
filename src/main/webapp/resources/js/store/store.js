
// 조아요
  $(document).ready(function () {
    $('.content').click(function (e) {
      let productNo;
      
      // 로그인 했을때
      if(loginMember != ''){
        // 하트있을때
        if($(this).hasClass('heart-active')){
          productNo=$(e.target).parent().parent().parent().children().children()[1].value;
          
          $.ajax({
            url : contextPath+"/store/doesntLikeit",
            type:"POST",
            data:{"productNo":productNo},
            success:function(result){
             console.log(result);
            
             
            },
            error:function(error){
              console.log(error);
            }
            
          });
          $(this).removeClass("heart-active");
          $(this).next().removeClass("heart-active");
          $(this).children().removeClass("heart-active");
        }else{
          productNo =  $(e.target).parent().parent().children().children()[1].value;
         $.ajax({
           url : contextPath+"/store/likeit",
           type:"POST",
           data:{"productNo":productNo},
           success:function(result){
            console.log(result);
          
            
           },
           error:function(error){
             console.log(error);
           }
         });
         $(this).toggleClass("heart-active");
         $(this).next().toggleClass("heart-active");
         $(this).children().toggleClass("heart-active");
        } 

        }
       
      // 로그인 안했을때
      else{
        swal("로그인 후 좋아요 가능합니다.","","info");
        
      }

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
 
// 비급 - 순간이동
$("#format").change(function(){
  let selectedValue = $(this).val();
  location.href=contextPath+"/store?cp=1&op=0&ct="+selectedValue;
});

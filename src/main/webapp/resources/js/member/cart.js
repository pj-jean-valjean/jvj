
// 장바구니 비우기
$(".x-btn").on("click", (e) => {
  console.log($(e.target).parent().parent().children().val());
  const cartNo= $(e.target).parent().parent().children().val();
  $.ajax({
      url:specialContextPath+"/cart/deleteCart",
      type:"POST",
      data: {"cartNo":cartNo},
      success:function(result){
        console.log(result);
        if(result>0){
            console.log(cartNo+'장바구니 비우기');
            
        }

      },
      error: function(err,message){
          console.log(err+message);

      }
  });
  $(e.target).parent().parent().next().fadeOut(500);
  $(e.target).parent().parent().fadeOut(500);
});


// 장바구니 비우기
$(".x-btn").on("click", (e) => {
  console.log($(e.target).parent().parent().children().val());
  const cartNo= $(e.target).parent().parent().children().val();
  let itemp = $(e.target).parent().parent().find('.cartSumPrice').text();
  const itemPrice = parseInt(itemp.substr('원',itemp.length-1));
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
  console.log(itemp);
  resultPrice -=itemPrice;
  paging();

});


// 미니 합계
const cartSumPrice = $('.cartSumPrice');
const productPrice = $('.productPrice');
const optionPrice = $('.optionPrice');
const items = $('.items');
const addq = $('.addq');
const rp = $('.resultPrice');
const optionBox = $('.option-box');
let resultPrice = 0;
let lastMaxPrice = $('.lastMaxPrice');
let taxPrice = $('.taxPrice');
for(let i = 0 ; i<items.length;i++){
    let pp =  parseInt(productPrice[i].textContent);
    let aq = parseInt(addq[i].textContent);
    let arr = [];
    let tempsum = 0;
    for(let j=0; j<optionBox[i].children.length;j++){
       if(j%2 == 1){
        
           arr.push(optionBox[i].children[j].value);
            tempsum += parseInt(optionBox[i].children[j].value);

       }
         

    }
    console.log(arr);
    console.log(tempsum);
    resultPrice += pp * aq + tempsum;
 
    cartSumPrice[i].textContent = pp * aq + tempsum +"원";
    
}

// 결산
function paging(){
    rp.text(resultPrice+"원") ;
        
    if(resultPrice>=30000){
        taxPrice.text(0+'원');
        lastMaxPrice.text(resultPrice+"원");
    }else{
        taxPrice.text(3000+'원');
        lastMaxPrice.text(resultPrice+3000+"원");
    }

}
paging();

function buyit(){
    updateCart();
    
    location.href = specialContextPath + "/payment/payment";
}

function updateCart(){
    $.ajax({
        url:specialContextPath+"/cart/updateCart",
        type:'POST',
        success : function(result){
        if(result>0){
            swal({
                title: "재고 부족",
                text: "현재 상품 수량이 재고 수량보다 많아, 장바구니에 다시 담아주시길 바랍니다.",
                icon: "info",
                buttons: "확인",
              }).then((value) => {
                // 확인눌렀을때 실행
                if (value) {
                  location.reload();
                }
              });
        }
        },
        error : function(err){
            console.log(err);
        }
    });
}
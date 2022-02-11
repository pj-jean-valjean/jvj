
const orderInfoObject ={
    "productCd" : productCd,
    "productName" : "",
    "productNo" : productNo,
    "productOption" : "",
    "amount" : "",
    "totalPrice" : "",
    "memberNo" : loginMember,
    "shippingAddr" : "",
    "usedCouponNo" : "",
    "store_imp_uid" : "",
}



//결제성공 시 메서드
function saveOrderInfo(){
    //클래스의 경우
    if(productCd==3){
        orderInfoObject.productCd = 3;
        orderInfoObject.productName = document.getElementsByClassName("classTitle")[0].innerText;
        
        const option = 
        document.getElementsByClassName("classTitle")[0].innerText + " / "+
        document.getElementsByClassName("classDt")[0].innerText + " / "+
        document.getElementsByClassName("classtime")[0].innerText + " / ";
        document.getElementsByClassName("totalPeople")[0].innerText ;
        
        orderInfoObject.productOption = option;
        orderInfoObject.amount = document.getElementsByClassName("totalPeople")[0].innerText ;
        const won = document.getElementsByClassName("classPrice")[0].innerText;
        orderInfoObject.totalPrice =  won.substr(0, won.length -1);
        orderInfoObject.productNo = productNo;
    }



    $.ajax({
        url : "savePaymentInfo",
        type : "post",
        data : orderInfoObject,
        dataType: "json",
        success : function(){

        },
        error: function(){

        }
    })
}
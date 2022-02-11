$(document).ready(function () {
    $("#btn-cc").on("click",function(){
      if (loginMember != "") {
          $.ajax({
            url: contextPath + "/mypage/deletelike",
            type: "POST",
            data: { "productNo" : productNo },
            success: function (result) {
              console.log(result);
            },
            error: function (error) {
              console.log(error);
            },
          });
      }
    });
    });
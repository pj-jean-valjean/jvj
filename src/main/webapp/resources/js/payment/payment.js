//이메일 입력방식 선택 
    $('#email-select').change(function(){ 
        $("#email-select option:selected").each(function () { 
            if($(this).val() == '0'){ //직접입력일 경우 
                $("#email-input-select").val(''); //값 초기화 
                $("#email-input-select").attr("disabled",false); //활성화 
            }else{ //직접입력이 아닐경우 
                $("#email-input-select").val($(this).text()); //선택값 입력 
                $("#email-input-select").attr("disabled",true); //비활성화 
            } 
        }); 
    }); 

    $('#delivery-message-select').change(function(){ 
        $("#delivery-message-select option:selected").each(function () { 
            if($(this).val() == '0'){ //직접입력일 경우 
                $("#delivery-message").val(''); //값 초기화 
                $("#delivery-message").show(); //활성화 
            }else{ //직접입력이 아닐경우 
                $("#delivery-message").val($(this).text()); //선택값 입력 
                $("#delivery-message").hide(); //비활성화 
            } 
        }); 
    }); 


    /* 정기 배송 현재 날짜 가져오기 */

    // let today = new Date();

    // let year = today.getFullYear();
    // let month = ('0' + (today.getMonth() + 1)).slice(-2);
    // let day = ('0' + today.getDate()).slice(-2);

    // let dateString = year + '-' + month  + '-' + day;
    // document.querySelector("#calendar-btn").innerHTML = dateString;
    
 	// 주소
    document.querySelector("#searchAddr").addEventListener("click", function(){
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
                // 예제를 참고하여 다양한 활용법을 확인해 보세요.
     
     			document.querySelector("#addr1").value = data.zonecode;
     			document.querySelector("#addr2").value = data.address;
            }
        }).open();
    });
    
    

  function requestPay() {
	  var IMP = window.IMP; // 생략가능
	  IMP.init('imp64541030');
	  // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
	  // i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
	  IMP.request_pay({
	  pg: 'inicis', // version 1.1.0부터 지원.
	  /*
	  'kakao':카카오페이,
	  html5_inicis':이니시스(웹표준결제)
	  'nice':나이스페이
	  'jtnet':제이티넷
	  'uplus':LG유플러스
	  'danal':다날
	  'payco':페이코
	  'syrup':시럽페이
	  'paypal':페이팔
	  */
	  pay_method: 'card',
	  /*
	  'samsung':삼성페이,
	  'card':신용카드,
	  'trans':실시간계좌이체,
	  'vbank':가상계좌,
	  'phone':휴대폰소액결제
	  */
	  merchant_uid: 'merchant_' + new Date().getTime(),
	  /*
	  merchant_uid에 경우
	  https://docs.iamport.kr/implementation/payment
	  위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
	  참고하세요.
	  나중에 포스팅 해볼게요.
	  */
	  name: '주문명:결제테스트',
	  //결제창에서 보여질 이름
	  amount: 100,
	  //가격
	  buyer_email: 'jdy9146@naver.com',
	  buyer_name: '호가비',
	  buyer_tel: '010-1234-1234',
	  buyer_addr: '서울특별시 중구 남대문로 120 대일빌딩 2F, 3F',
	  buyer_postcode: '04540',
	  m_redirect_url: 'https://localhost:8080/payments/complete'
	  /*
	  모바일 결제시,
	  결제가 끝나고 랜딩되는 URL을 지정
	  (카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
	  */
  }, 
  function (rsp) {
  		console.log(rsp);
  	if (rsp.success) {
  		var msg = '결제가 완료되었습니다.';
	  		msg += '고유ID : ' + rsp.imp_uid;
	  		msg += '상점 거래ID : ' + rsp.merchant_uid;
	  		msg += '결제 금액 : ' + rsp.paid_amount;
	  		msg += '카드 승인번호 : ' + rsp.apply_num;
  } else {
  	var msg = '결제에 실패하였습니다.';
  		msg += '에러내용 : ' + rsp.error_msg;
  }
  	alert(msg);
  });

  }


  // 주소
document.querySelector("#searchAddr").addEventListener("click", function(){
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
 
 			document.querySelector("#addr1").value = data.zonecode;
 			document.querySelector("#addr2").value = data.address;
        }
    }).open();
});



$(".selectInfo").change(function() {

	console.log($(this).val());
	if($(this).val() == 1){
		$(".loginForm").css("display", "block");
		$(".newInfo").css("display", "none");
	} else if($(this).val() == 2){
		$(".loginForm").css("display", "none");
		$(".newInfo").css("display", "block");
	}
});
// 제출 시 유효성 검사
function validate(){
    
    // 기간(1주, 2주)버튼 선택하지 않았을때
    if( !$(".period-btn").hasClass('active')){ 

        alert("구독 옵션을 선택해주세요");
        return false;
    }
    // 빵 선택 버튼 선택하지 않았을때
    if( !$(".bread-btn").hasClass('active')){ 

        alert("빵 종류를 선택해주세요");
        return false;
    }
    
    // 맛 선택 버튼 선택하지 않았을때
    if( !$(".taste-btn").hasClass('active')){ 

        alert("맛 종류를 선택해주세요");
        return false;
    }
    // 요일 선택 버튼 선택하지 않았을때
    if( !$(".deliveryDay-btn").hasClass('active')){ 

        alert("수령 희망일을 선택해주세요");
        return false;
    }
	
	// 로그인인 경우
	
    document.subBreadForm.submit();
}



const contextPath = getContextPath();

/* 사진교체 */
window.onload = function(){
    changeImg();
    reviewDetail();
}

const tempThumb = document.querySelector(".main-thumbnail").getAttribute("src");
function changeImg(){
    const subImgs = document.querySelectorAll(".img-margin");
    const thumb = document.querySelector(".main-thumbnail");
    for(let i = 0; i< subImgs.length ; i++){
        subImgs[i].addEventListener("click", function(){
            thumb.setAttribute("src",subImgs[i].getAttribute("src"))
        })
    }
}

//좋아요 함수
$(document).ready(function() {
	$('.heart-content').click(function() {
		$(this).toggleClass("heart-active");
		$(this).next().toggleClass("heart-active");
		$(this).children().toggleClass("heart-active");
	});
});


/*----------------------- 버튼 이름 받아오기,input hidden 값 넘기기 ------------------------*/
// 빵
$(".bread-btn").on("click", function() {
    $(this).addClass('active').siblings().removeClass('active');
    
    document.getElementById("bread").innerText 
    	= $(".bread-btn.active").find('span').text()+ ' / ';
    	
    $("input[name='chooseBreadCode").val($(this).val());
});

// 맛
$(".taste-btn").on("click", function() {
    $(this).addClass('active').siblings().removeClass('active');
    
    document.getElementById("taste").innerText 
    	= $(".taste-btn.active").find('span').text()+ ' / ';
    	
     $("input[name='chooseTasteCode").val($(this).val());
});

// 구독 기간 (1주 2주)
$(".period-btn").on("click", function() {
    $(this).addClass('active').siblings().removeClass('active');
    
    document.getElementById("period").innerText
        = $(".period-btn.active").find('span').text() + ' / ';
	$("input[name='choosePeriodCode").val($(this).val());
});

// 수령 희망일 
$(".deliveryDay-btn").on("click", function() {
    $(this).addClass('active').siblings().removeClass('active');
    
    document.getElementById("deliveryDay").innerText 
    	= $(".deliveryDay-btn.active").find('span').text();
    	
    $("input[name='chooseDeliveryDayCode").val($(this).val());
});





/*----------------------- 수량 증감 버튼 -----------------------*/
/* 수량 / 기본 금액 */
let resultNum = document.getElementById('result').innerText;
const price = document.querySelector(".price").innerText.replace(",","").replace("원","");


/* 수량 증가 */
function plusCount(){
	let resultCount = document.getElementById("result");
    let totalprice= document.getElementById("totalprice");
    
    resultCount.innerText = ++resultNum;
    /* 원화 단위 콤마포함한 값 대입*/					 
    totalprice.innerText = (resultNum*parseInt(price)).toLocaleString('ko-KR');
}

/* 수량 감소 */
function minusCount(){
	if(resultNum!=0){
		let resultCount = document.getElementById("result");
	    let totalprice= document.getElementById("totalprice");
	    
	    resultCount.innerText = --resultNum;				 
	    totalprice.innerText = (resultNum*parseInt(price)).toLocaleString('ko-KR');
    }
}


// 결제 페이지 이동
function reconfirim(){
    if(loginMemberNo==''){
        alert("로그인 후 가능합니다");
        return false;
    }
    if(resultNum==0){
        alert("구매 수량을 선택해주세요");
        return false;
    }
    if(loginMemberNo !='' && resultNum !=0){
        const totalAmount= $("#result").text();
        const totalPrice= $("#totalprice").text();
        
        $("#totalAmount").val(totalAmount);
        $("#hiddenTotalPrice").val(totalPrice);
        return true;
    } else{
        return false;
    }
}



/* 스크롤 - 페이지 내 이동 */
function scrollExp(){
	document.querySelector('#contents-exp').scrollIntoView();	
	
	
	/*
	
	var location = document.querySelector('#contents-exp').offsetTop;
	var menuHeight = document.querySelector(".detail-contents").offsetHeight;
	window.scrollTo({top:location - menuHeight, behavior:'smooth'});*/
}
function scrollReview(){
	document.querySelector('#contents-review').scrollIntoView();
	
}
function scrollDelievery(){
	document.querySelector('#contents-delievery').scrollIntoView();
}






/* 리뷰 */


/* 상세리뷰 토글check */
let reviewtoggle = false;
let temp = -1;
/* 댓글보기 func */
function reviewDetail(){
    const reviewLines = document.querySelectorAll(".one-line-review>span:first-of-type");
    for(let i =0 ; i<reviewLines.length ; i++){
        reviewLines[i].addEventListener("click", function(){
            const box = $(this).parent();
            if(!reviewtoggle){
                const reviewDetail = document.createElement("div");
                reviewDetail.className = "reviewBox";
                reviewDetail.innerHTML = "<h1>리뷰열림</h1>";
                /* reviewDetail.innerHTML = returnReviewContent(글번호); */
                box.after(reviewDetail);
                temp = i;
                reviewtoggle = true;
            }
            else{
                if(temp == i){
                    temp = -1
                    reviewtoggle = false;
                    $(".reviewBox").remove();
                }
                else{
                    $(".reviewBox").remove();
                    const reviewDetail = document.createElement("div");
                    reviewDetail.className = "reviewBox";
                    reviewDetail.innerHTML = "<h1>리뷰열림</h1>";
                    /* reviewDetail.innerHTML = returnReviewContent(글번호); */
                    temp= i;
                    box.after(reviewDetail);
                }
            }
        })
    }
}

/* review  Contents ajax 
    리뷰 list 시 constent span 에  value=글번호 넣어놓기
    or display none으로 글번호 작성
*/
function returnReviewContent(글번호){
    /* ajax */
    return ajax;
}



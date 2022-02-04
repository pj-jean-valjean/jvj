
/* 사진교체 */
window.onload = function(){
    changeImg();
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

/* 수량 증감 버튼*/
function count(type) {
    const result = document.getElementById('result');

    let resultNum = result.innerText;

    if (type === "add") {
        resultNum = parseInt(resultNum) + 1;
    } else if (type === "minus") {
        resultNum = parseInt(resultNum) - 1;
    }

    if (resultNum < 1) {
        resultNum = 1;
    }

    result.innerText = resultNum;
}
 
/* 추가 옵션 수량 증감 버튼*/
function totalCount(type) {
    const result = document.getElementById('total-result');

    let resultNum = result.innerText;

    if (type === "add") {
        resultNum = parseInt(resultNum) + 1;
    } else if (type === "minus") {
        resultNum = parseInt(resultNum) - 1;
    }

    if (resultNum < 1) {
        resultNum = 1;
    }

    result.innerText = resultNum;
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
  $(document).ready(function () {
    $('.contentss').click(function () {
      $(this).toggleClass("heart-active");
      $(this).next().toggleClass("heart-active");
      $(this).children().toggleClass("heart-active");
    });
  });
  
   // 가격에 콤마표시
 let prices = $('.prices');
 for(let i = 0; i<prices.length; i++){
	prices[i].textContent = parseInt(prices[i].textContent).toLocaleString('ko-KR')+"원";
};


/* 스크롤 - 페이지 내 이동 */
function scrollExp(){
	document.querySelector('#contents-exp').scrollIntoView();	
}
function scrollReview(){
	document.querySelector('#contents-review').scrollIntoView();
}
function scrollDelievery(){
	document.querySelector('#contents-delievery').scrollIntoView();
}
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


 
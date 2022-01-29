// 기간, 빵, 맛, 종류 버튼 선택  
$(".period-btn").on("click", function() {
    $(this).addClass('active').siblings().removeClass('active');
});

$(".bread-btn").on("click", function() {
    $(this).addClass('active').siblings().removeClass('active');
});

$(".taste-btn").on("click", function() {
    $(this).addClass('active').siblings().removeClass('active');
});



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

    if (resultNum < 0) {
        resultNum = 0;
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
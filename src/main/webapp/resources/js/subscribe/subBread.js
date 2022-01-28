
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
 
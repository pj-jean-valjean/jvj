
/* 사진교체 */
window.onload = function(){
    changeImg();
    reviewDetail();
}
    $('.contentss').click(function () {
        $(this).toggleClass("heart-active");
        $(this).next().toggleClass("heart-active");
        $(this).children().toggleClass("heart-active");
    });

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
const totalNum = document.querySelector(".product_detail > article.total-price > div:nth-child(1) > input");
const totalPrice = document.querySelector(".total-price > div:nth-child(2) > input");
const onePrice = document.querySelector(".product_detail > article:nth-child(13) > div > span").innerText.replace(",","");
function plusP(btn){
    let people = btn.previousElementSibling;
    const num = parseInt(people.innerText);
    const nowAppl = document.querySelector(".product_detail > article:nth-child(9) > div > span:nth-child(1)").innerText;
    const maxAppl = document.querySelector(".product_detail > article:nth-child(9) > div > span:nth-child(3)").innerText;
    
    let possible = maxAppl-nowAppl;

    if(possible > num){
        people.innerText = num+1;
        totalNum.value = num+1;
        totalPrice.value = parseInt(onePrice)*(num+1);
    }
    else{
        alert("가능 인원 초과");
    }
}
function minusP(btn){
    let people = btn.nextElementSibling;
    const num = parseInt(people.innerText);
    if(num >1){
        people.innerText = num-1;
        totalNum.value = num-1;
        totalPrice.value = parseInt(onePrice)*(num-1);
    }
}

//이미 좋아요 했을 시 함수 제거 function 추가 필요
function changeHeart1(btn){
    btn.className="fas fa-heart like-heart";
}
function changeHeart2(btn){
    btn.className="far fa-heart like-heart";
}

function showMaps(){
	
    document.getElementById("cal").style.display = "block";
	
	var container = document.getElementById('map');
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
		level: 2 //지도의 레벨(확대, 축소 정도)
	};

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch('제주특별자치도 제주시 첨단로 242', function(result, status) {
	
    // 정상적으로 검색이 완료됐으면 
    if (status === kakao.maps.services.Status.OK) {
        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">지점 위치</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
}); 
		
}
function hideMaps(){
    document.getElementById("cal").style.display = "none";
    document.getElementById('map').innerHTML="";
}

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

/* 사진교체 */
window.onload = function(){
    changeImg();
    reviewDetail();
}

    //좋아요 함수
    $('.contentss').click(function () {
        $(this).toggleClass("heart-active");
        $(this).next().toggleClass("heart-active");
        $(this).children().toggleClass("heart-active");
    });

    //사진 교체
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

    const possibleppl = document.querySelector(".product_detail > article:nth-child(11) > div.subdetail-content > span > span:nth-child(3)").innerText
    - document.querySelector(".product_detail > article:nth-child(11) > div.subdetail-content > span > span:nth-child(1)").innerText;
    const price = document.querySelector(".price").innerText.replace(",","").replace("원","");
    
    let nownum = 0;
    //인원 증감
    function plusppl(){
        if(possibleppl>nownum){
            let pplpick = document.getElementById("result");
            let totalprice= document.getElementById("totalprice");
            const checkppl = document.getElementById("ppl");
            pplpick.innerText = ++nownum;
            totalprice.innerText = nownum*parseInt(price);
            checkppl.innerText = nownum;
        }
        else{
            alert("가능 인원을 초과했습니다!");
        }
    }
    function minusppl(){
        if(nownum!=0){
            let pplpick = document.getElementById("result");
            let totalprice= document.getElementById("totalprice");
            const checkppl = document.getElementById("ppl");
            pplpick.innerText = --nownum;
            totalprice.innerText = nownum*parseInt(price);
            checkppl.innerText = nownum;
        }
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
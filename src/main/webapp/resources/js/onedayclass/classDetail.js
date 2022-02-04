
/* 사진교체 */
let likedone=0;
window.onload = function(){
    changeImg();
    reviewDetail();
    likecheck();
}
function likecheck(){
    if(loginNo=="") return;
    $.ajax({
        url: contextPath+'/onedayclass/likecheck',
        method: 'post',
        data : {
            "loginNo" : loginNo,
            "productNo" : productNo
        },
        success: function(result){
            console.log(result);
            if(result>0){
                hearttoggle()
                likedone = 1;
            }
        },
        error : function(){

        }
    })
}
    function hearttoggle(){
        const hearts = $('.heart-btn');
        hearts.children().toggleClass("heart-active");
        hearts.children().next().toggleClass("heart-active");
        hearts.children().children().toggleClass("heart-active");
    }

    //좋아요 함수
    $('.heart-btn').click(function () {
        if(loginNo==""){
            alert("로그인 후 이용해주세요!");
            return;
        }
        if(likedone==1){
            if(confirm("좋아요를 취소하시겠어요?")){
                likeCancle();
            }
            else return;
        }
        else{
            doLike();
        }
    });
    function doLike(){
        $.ajax({
            url: contextPath+'/onedayclass/likeclass',
            method: 'post',
            data : {
                "loginNo" : loginNo,
                "productNo" : productNo
            },
            success: function(result){
                if(result>0){
                    hearttoggle()
                    likedone = 1;
                }
                else{
                    alert("이미 좋아요를 누르셨어요!");
                }
            },
            error : function(){

            }
        }) 
    }
    function likeCancle(){
        $.ajax({
            url: contextPath+'/onedayclass/undolike',
            method: 'post',
            data : {
                "loginNo" : loginNo,
                "productNo" : productNo
            },
            success: function(result){
                if(result>0){
                    hearttoggle()
                    likedone = 0;
                }
            },
            error : function(){
                alert("취소실패");
            }
        })
    }
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
            totalprice.innerText = (nownum*parseInt(price)).toLocaleString('ko-KR');
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
            totalprice.innerText = (nownum*parseInt(price)).toLocaleString('ko-KR');
            checkppl.innerText = nownum;
        }
    }



function showMaps(){
    var geocoder = new kakao.maps.services.Geocoder();
                
                // 주소로 좌표를 검색합니다
                geocoder.addressSearch(mapAddress, function(result, status) {
                
                // 정상적으로 검색이 완료됐으면 
                if (status === kakao.maps.services.Status.OK) {
                    document.getElementById("cal").style.display = "block";
                
                    var container = document.getElementById('map');
                    var options = { //지도를 생성할 때 필요한 기본 옵션
                        center: new kakao.maps.LatLng(result[0].x, result[0].y), //지도의 중심좌표.
                        level: 2 //지도의 레벨(확대, 축소 정도)
                    };
    
                    // 지도를 생성합니다    
                    var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

                    console.log('x: '+result[0].x +' y: '+result[0].y);
                    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                    // 결과값으로 받은 위치를 마커로 표시합니다
                    var marker = new kakao.maps.Marker({
                        map: map,
                        position: coords
                    });
                    // 인포윈도우로 장소에 대한 설명을 표시합니다
                    var infowindow = new kakao.maps.InfoWindow({
                        content: '<div style="width:150px;text-align:center;padding:6px 0;">'+
                        'Jean Val Jean'+
                        '</div>'
                    });
                    infowindow.open(map, marker);

                    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
                    map.setCenter(coords);
                } 
            });  

            /* 
    //위도경도 얻기
    let placex;
    let placey;
    let httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = () =>{
        //readyState가 변화했을 때 함수 실행
        if(httpRequest.readyState === XMLHttpRequest.DONE){
            //readyState가 Done이고 응답값이 200이면
            if(httpRequest.status ===200){

                const redirectAddr = httpRequest.response;
                placex = parseFloat(redirectAddr.documents[0].address.x);
                placey =redirectAddr.documents[0].address.y;
                
                console.log('x는 '+placex + ' y는 ' + placey);
                // 주소-좌표 변환 객체를 생성합니다
            }
            else{
                console.log(httpRequest.status+"error!");
            }
        }
    }
    httpRequest.open("POST", "getPlace?mapAddress="+mapAddress , true);
    httpRequest.responseType = "json";
    httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    httpRequest.send(); */
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
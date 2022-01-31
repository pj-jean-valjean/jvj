    let selectMonth = 0;
    let pagination = 0;
    const tempDate = new Date();
    let getType = 'total';
    let selectdate ='';
    let lastpage = false;
    window.onload = function(){
        calmodal();
        //스크롤함수 실행
        addClassLine();
        classScroll();
    }
    //달력모달 동작
    function calmodal(){
        const closecal = document.querySelector('#closecal');
        const btnOpenPopup = document.querySelector('.opencal'); 
        const cal = document.querySelector('.cal'); 
        btnOpenPopup.addEventListener('click', () => {
            cal.style.display = 'block';
            displaycal(); });
        closecal.addEventListener('click', ()=>{
            const monthday = document.getElementById("month-day");
            monthday.innerHTML="";
            cal.style.display = 'none';
            selectMonth=0;
        })
        /*  $("#month-day > tr > td") */
    }

        //날짜선택 달력 함수
        function displaycal(){
        const today = new Date();
        const origindate = today.getDate();
        //기존 일 저장
        //1일로 초기화해야 다음달 오류 제거됨
        today.setDate(1);

        today.setMonth((today.getMonth()+selectMonth));
        let year = today.getFullYear();
        let month=today.getMonth()+1;
        let firstDay = new Date(year, month-1 , 1).getDay();
        
        let day = today.getDay();
        const monthDays = Array(31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

        /* 2월의 마지막 날 설정 */
        if (year % 400 == 0)
            monthDays[1] = 29;
        else if (year % 100 == 0)
            monthDays[1] = 28;
        else if (year % 4 == 0)
            monthDays[1] = 29;
        else
            monthDays[1] = 28;

        let lastDate =  monthDays[month-1];
        
        let count = 1;
        let week =1;
        let notLast= true; //마지막 날짜 검사 boolean;
        const tmonth = document.getElementById("today-month");
        const monthday = document.getElementById("month-day");
        monthday.innerHTML="";
        let showmonth = ""+month;
        if(month<10) {
            showmonth = "0"+showmonth;
        }
        tmonth.innerText = year+"-" +showmonth;
        while(notLast){
            const tr = document.createElement("tr");
            for(let i = 0 ; i<7 ; i++){
                const td = document.createElement("td");
                    //첫번째 주는 해당 요일에서부터 1이 들어감
                    if(week==1&&i<firstDay){
                        td.innerText = " ";
                    }
                    else{

                        td.innerText = count;
                        let checkPossibleDay = false;
                        if(year>tempDate.getFullYear()){
                            checkPossibleDay = true;
                        }
                        else if(year==tempDate.getFullYear() && month-1>tempDate.getMonth()){
                            checkPossibleDay = true;
                        }
                        else if(year==tempDate.getFullYear() && month-1==tempDate.getMonth()){
                            if(count>tempDate.getDate()) checkPossibleDay = true;
                        }
                        if(checkPossibleDay) td.setAttribute("class","possible");
                        else td.setAttribute("class","impossible");
                        count= count+1;
                    }
                    tr.append(td);
                    tr.style.textAlign = "center";
                    //해당 월의 마지막 날짜까지 표기됐는지 검사
                    if(count == lastDate+1) {
                        notLast = false;
                        break;
                    }
            }
                week = week+1;//for문 1번 == 1주일
                monthday.append(tr);
            }

            const days = document.getElementsByClassName("possible");
            for(day of days){
                addDaySelector(day);
            }

        }
        function addDaySelector(day){
            day.addEventListener("click", function(){
                const count = day.innerText;
                let showday = ""+count;
                if(count<10){showday = '0'+showday}
                const yymmdd = document.querySelector("#today-month").innerText +"-" +showday;
                console.log(yymmdd);
                selectdate=yymmdd;
                getType='date';
                document.querySelector(".cal").style.display = "none";
                infinitebox.innerHTML ="";
                pagination = 0;
                lastpage = false;
                addClassLine();
            })
        }
        //이전달btn
        const prev = function(){
            selectMonth=selectMonth - 1;
            const monthday = document.getElementById("month-day");
            monthday.innerHTML = "";
            displaycal();
        }
        //다음달btn
        const next = function(){
            selectMonth=selectMonth +1;
            const monthday = document.getElementById("month-day");
            monthday.innerHTML = "";
            displaycal(); 
        }
        function showAllDay(){
            getType = 'total';
            pagination = 0;
            document.querySelector('#closecal').click();
            infinitebox.innerHTML ="";
            lastpage = false;
            addClassLine();
        }
        /* 무한스크롤 구현 */
        //모든 내용을 감싼 공간 = infinitebox
        const infinitebox = document.getElementById("infinitebox");


        function classScroll(){
            const screenHeight = screen.height;/* 화면크기 */

            let oneTime = false; // 일회성 보장 변수

            document.addEventListener('scroll',OnScroll,{passive:true}) // 스크롤 이벤트함수정의

            function OnScroll () { //스크롤 이벤트 함수
            const fullHeight = infinitebox.clientHeight; // infinite 클래스의 높이   , 스크롤 이벤트 안에서 정의해야 추가된 높이가 다시 계산된다
            const scrollPosition = scrollY; // 스크롤 위치
                if (fullHeight-screenHeight*1/4 <= scrollPosition && !oneTime) { // 만약 전체높이-화면높이1/4가 스크롤포지션보다 작아진다면, 그리고 oneTime 변수가 거짓이라면
                    oneTime = true; // oneTime 변수를 true로 변경해주고,
                    if(!lastpage){
                        addClassLine();//컨텐츠 추가 발동
                    }
                    setTimeout(function() {
                        classScroll();
                    }, 500);
                }
            }
        }
        const KoreanDay = ['일','월', '화','수','목','금','토'];
        //컨텐츠 추가함수
        function addClassLine(){
            ++pagination;//페이지네이션 증가
            
            //**자바스크립트방식 ajax**
            const reqJson = {
                "getType" : getType,
                "pagination" : pagination,
                "selectdate" :selectdate
            }
            const url = "list";
            let httpRequest = new XMLHttpRequest();
            //통신에 사용될 XMLHttpRequest 객체 정의

            httpRequest.onreadystatechange = ()=>{
                //readyState가 변화했을 때 함수 실행
                if(httpRequest.readyState === XMLHttpRequest.DONE){
                    //readyState가 Done이고 응답값이 200이면
                    if(httpRequest.status ===200){
                        console.log("추가 정보 불러오기 성공")
                        var classList = httpRequest.response;
                        console.log(classList);
                        if(classList.length ==0){
                            if(!lastpage){
                                console.log("더이상 수강 가능한 클래스가 없습니다!");
                                lastpage = true;
                            }
                            return;
                        }
                        else{
                            //ONEBOX = 8EA
                            const onebox = document.createElement("div");
                            onebox.className = "newOneLine";

                            for(oneclass of classList){
                                const oneNewClass =  document.createElement("div");
                                oneNewClass.className = "newOneclassInfo";
                                const newDate =  document.createElement("div");
                                newDate.className = "newDate";
                                const newClassInfo =  document.createElement("div");
                                newClassInfo.className = "newClassInfo";
                                

                                /* 날짜 info */
                                const date = document.createElement("span");
                                date.innerText = oneclass.classDt.substr(2) + "("+KoreanDay[new Date(oneclass.classDt).getDay()]+")";
                                const time = document.createElement("span");
                                time.innerText=oneclass.classtime;
                                newDate.append(date,time);

                                /* 클래스 info */
                                const atag = document.createElement("a");
                                atag.href = "view"; 
                                
                                    const thumb = document.createElement("img");
                                    thumb.src = contextPath+ oneclass.imgPathName;
                                    thumb.className = "classimg";

                                    const title = document.createElement("span");
                                    title.innerText = oneclass.title;

                                    const newinfoLine = document.createElement("span");
                                    newinfoLine.className = "newinfoLine";
                                        const basesta = document.createElement("span");
                                        basesta.className = "review-ratings-reals";
                                        basesta.innerText="★★★★★";
                                        const realstar = document.createElement("span");
                                        realstar.className = "review-ratings-reals";
                                        realstar.innerText="★★★★★";
                                        const rating = document.createElement("span")
                                        rating.innerText = " (" + oneclass.ratingAgv +")";
                                        const heartshape = document.createElement("i");
                                        heartshape.className="fas fa-heart";
                                        const likecount = document.createElement("span")
                                        likecount.innerText = oneclass.likecount;
                                        const mapshape = document.createElement("i");
                                        mapshape.className="fas fa-map-marker-alt";
                                        const place = document.createElement("span")
                                        place.innerText = oneclass.placeName;
                                    newinfoLine.append(basesta,realstar,rating,heartshape,likecount,mapshape,place);

                                    const price = document.createElement("span");
                                    price.innerText = oneclass.price.toLocaleString('ko-KR')+" 원";

                                atag.append(thumb,title,newinfoLine,price)
                                newClassInfo.append(atag);
                                oneNewClass.append(newDate,newClassInfo);
                                onebox.append(oneNewClass);
                            }

                            infinitebox.append(onebox);
                        }
                    }
                    else{
                        alert("문제 발생!");
                    }
                }
            }
            /* Post 방식으로 요청 */
            httpRequest.open("POST", "list" , true);
            /* Response Type 을 Json으로  */
            httpRequest.responseType = "json";
            /* 요청 헤더에 컨텐츠 타입 json 명시 */
            httpRequest.setRequestHeader("Content-Type", "application/json");
            httpRequest.send(JSON.stringify(reqJson));
}

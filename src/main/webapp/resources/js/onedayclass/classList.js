    let selectMonth = 0;
    let pagination = 1;
    const tempDate = new Date();
    window.onload = function(){
        calmodal();
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
        
        let temp = new Date()
        let today = new Date(
            temp.getFullYear(),temp.getMonth()+selectMonth ,temp.getDate(), 
            temp.getHours() , temp.getMinutes() , temp.getSeconds());
        let year = today.getFullYear();
        let month = today.getMonth()+1;
        let date = today.getDate();
        let firstDay = new Date(year, month-1 , 1).getDay();
        let day = today.getDay();
        var monthDay = Array(31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

        /* 2월의 마지막 날 설정 */
        if (year % 400 == 0)
            monthDay[1] = 29;
        else if (year % 100 == 0)
            monthDay[1] = 28;
        else if (year % 4 == 0)
            monthDay[1] = 29;
        else
            monthDay[1] = 28;

        let lastDate =  monthDay[month-1];

        var enMonthName = new Array('1','2','3','4','5','6',
            '7','8','9','10','11','12');

        let count = 1;
        let week =1;
        let notLast= true; //마지막 날짜 검사 boolean;

        const tmonth = document.getElementById("today-month");
        const monthday = document.getElementById("month-day");
        monthday.innerHTML="";
        tmonth.innerText = year+"/" +enMonthName[month-1] 
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
                const ymonth = document.querySelector("#today-month").innerText;
                const dday = day.innerText;
                console.log(ymonth+"/"+dday);
            })
        }
        //다음달btn
        const prev = function(){
            selectMonth=selectMonth - 1;
            const monthday = document.getElementById("month-day");
            monthday.innerHTML = "";
            displaycal();
        }
        //이전달btn
        const next = function(){
            selectMonth=selectMonth +1;
            const monthday = document.getElementById("month-day");
            monthday.innerHTML = "";
            displaycal();
        }

        /* 무한스크롤 구현 */
        //모든 내용을 감싼 공간 = infinitebox
        const infinitebox = document.getElementById("infinitebox");
        //스크롤함수 실행
        classScroll();
        function classScroll(){
            const pagination = document.querySelector('.pagination');/* 페이지네이션 정보 */
            const screenHeight = screen.height;/* 화면크기 */
            let oneTime = false; // 일회성 보장 변수

            document.addEventListener('scroll',OnScroll,{passive:true}) // 스크롤 이벤트함수정의

            function OnScroll () { //스크롤 이벤트 함수
            const fullHeight = infinitebox.clientHeight; // infinite 클래스의 높이   , 스크롤 이벤트 안에서 정의해야 추가된 높이가 다시 계산된다
            const scrollPosition = scrollY; // 스크롤 위치
                if (fullHeight-screenHeight*1/3 <= scrollPosition && !oneTime) { // 만약 전체높이-화면높이/2가 스크롤포지션보다 작아진다면, 그리고 oneTime 변수가 거짓이라면
                    oneTime = true; // oneTime 변수를 true로 변경해주고,
                    addClassLine();//컨텐츠 추가 발동
                    classScroll();
                }
            }
        }

        //컨텐츠 추가함수
        function addClassLine(){
            ++pagination;//페이지네이션 증가

            //로딩 이미지 추가
            

            //박스 추가
            const box = document.createElement("div");
            box.className="oneClassLine";
            box.setAttribute("value", pagination);
                const dateLine = document.createElement("div");
                dateLine.className="dateLine"; //날짜라인
                const hr = document.createElement("hr");
                const showLine = document.createElement("div");
                showLine.className="classShowLine"; //클래스정보라인
                box.append(dateLine, hr, showLine);


            //로딩 이미지 삭제


/*             $.ajax({
                url : "morelist",
                data: {"cp" : pagination},
                type : "POST",
                dataType : 'JSON',
                success : function(classList){
                    if(classList != null){
                        ++pagination;//페이지네이션 증가
                        //3개 * 2줄
                        for(let i = 0 ; i<2 ; i++){
                            const box = document.createElement("div");
                            box.className="oneClassLine";
                            box.setAttribute("value", pagination);

                                const dateLine = document.createElement("div");
                                dateLine.className="dateLine"; //날짜라인
                                const hr = document.createElement("hr");
                                const showLine = document.createElement("div");
                                showLine.className="classShowLine"; //클래스정보라인
                                box.append(dateLine, hr, showLine);
                                
                            }
                        }
                    }
            }) */
            infinitebox.append(box);
            oneTime = false;
        }


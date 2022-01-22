     //네비게이션 함수
        let writingcheck = false;
        let selectMonth = 0;
        const filecheck = [0 , 0 , 0 , 0 , 0];
        const contentbox = document.getElementById("adminPCont");
        window.onload = function(){
            memberInfo();
        }
        //1-회원 정보 조회
        $(".one-admin-func")[0].addEventListener("click",memberInfo);
        //2-구독 회원 조회
        $(".one-admin-func")[1].addEventListener("click",subscribingInfo);
        //3-주문 조회
        $(".one-admin-func")[2].addEventListener("click",orderInfo);
        //4-게시글 작성
        $(".adminWriter")[0].addEventListener("click",function(){
            noticeboardWriter('공지사항 등록');
        });
        $(".adminWriter")[1].addEventListener("click",function(){
            commonWriter('일반 상품 등록');
            makeNormalPWritePage();});
        $(".adminWriter")[2].addEventListener("click",function(){
            commonWriter('구독 상품 등록');
            makeSubscribePWritePage();});
        $(".adminWriter")[3].addEventListener("click",function(){
            commonWriter('클래스 상품 등록');
            makeClassPWritePage();});
        //5- 후기 관리
        $(".one-admin-func")[4].addEventListener("click",reviewManage);
        //6- 관리자계정 추가
        $(".one-admin-func")[5].addEventListener("click",addManagerId);
        //7- 원데이클래스 회원 정보
        //$(".one-admin-func")[6].addEventListener("click",onedayClassMember);
        //8- 공지사항 관리
        $(".one-admin-func")[7].addEventListener("click",modifyWrite);

        //1. 회원정보 조회---------------------------------------------------
        function memberInfo(){
            contentbox.innerHTML="";
             //이름
            const funcName = document.createElement("div");
            funcName.setAttribute("class", "oneLine");
            funcName.innerHTML="<h2>"+"회원정보 조회"+"</h2>"

            const searchDiv = document.createElement("div");
            searchDiv.setAttribute("class", "oneLine search-member");
            searchDiv.innerHTML="<select><option>회원아이디</option><option>회원명</option></select><input type='text'><button class='opencal'>회원검색</button>";

            const SearchResult = document.createElement("ul");
            SearchResult.setAttribute("class", "ResultLine");
            SearchResult.innerHTML=
            "<li class='resultTitle oneMemberResult'>"+
                "<span class='oneMemberInfo'>아이디</span>"+
                "<span class='oneMemberInfo'>닉네임</span>"+
                "<span class='oneMemberInfo'>가입일</span>"+
                "<span class='oneMemberInfo'>누적구매금액</span>"+
                "<span class='oneMemberInfo'>탈퇴여부</span>"+
            "</li>";
            
            contentbox.append(funcName,searchDiv,SearchResult)
        }
        //-----------------------------------------------------------------//
        //2. 구독 회원 조회---------------------------------------------------
        function subscribingInfo(){
            contentbox.innerHTML="";
             //이름
            const funcName = document.createElement("div");
            funcName.setAttribute("class", "oneLine");
            funcName.innerHTML="<h2>"+"구독회원 조회"+"</h2>"
            const searchDiv = document.createElement("div");
            searchDiv.setAttribute("class", "oneLine subscribe-search");
            searchDiv.innerHTML="<select>"+
            "<option>구독상품1</option>"+
            "<option>구독상품2</option>"+
            "</select>";
            
            const SearchResult = document.createElement("ul");
            SearchResult.setAttribute("class", "ResultLine");
            SearchResult.innerHTML=
            "<li class='resultTitle oneMemberResult'>"+
                "<span class='oneMemberInfo'>구독상품명</span>"+
                "<span class='oneMemberInfo'>아이디</span>"+
                "<span class='oneMemberInfo'>닉네임</span>"+
                "<span class='oneMemberInfo'>구독시작일</span>"+
                "<span class='oneMemberInfo'>구독회차</span>"+
                "<span class='oneMemberInfo'>구독중 여부</span>"+
            "</li>";
            contentbox.append(funcName,searchDiv,SearchResult);
        }
        //-----------------------------------------------------------------//
        //3. 주문 조회--------------------------------------------------------
        function orderInfo(){
            contentbox.innerHTML="";
             //이름
            const funcName = document.createElement("div");
            funcName.setAttribute("class", "oneLine");
            funcName.innerHTML="<h2>"+"주문 내역 조회"+"</h2>"

            const searchDiv = document.createElement("div");
            searchDiv.setAttribute("class", "oneLine order-search");
            searchDiv.innerHTML="<select>"+
            "<option>회원ID로 검색</option>"+
            "<option>주문번호로 검색</option>"+
            "</select>"+
            "<select>"+
            "<option>결제완료+환불</option>"+
            "<option>결제완료</option>"+
            "<option>환불</option>"+
            "</select>"+
            "<input type='text'><button class='opencal'>검색</button>";
            
            const SearchResult = document.createElement("ul");
            SearchResult.setAttribute("class", "ResultLine");
            SearchResult.innerHTML=
            "<li class='resultTitle oneMemberResult'>"+
                "<span class='oneMemberInfo'>주문 번호</span>"+
                "<span class='oneMemberInfo'>아이디</span>"+
                "<span class='oneMemberInfo'>배송지</span>"+
                "<span class='oneMemberInfo'>구매금액</span>"+
                "<span class='oneMemberInfo'>결제일</span>"+
                "<span class='oneMemberInfo'>주문상태</span>"+
            "</li>";
            

            contentbox.append(funcName,searchDiv,SearchResult);
        }
        //-----------------------------------------------------------------//

        //4-1. 공지사항 작성------------------------------------------
        //카테고리 / 제목 / 내용
        function noticeboardWriter(writename){
            //초기화
            contentbox.innerHTML="";
            //폼태그
            const adminwriteform = document.createElement("form")
            adminwriteform.setAttribute("id","writerForm");
            adminwriteform.setAttribute("method","POST");

            //폼태그 append
            contentbox.append(adminwriteform)

             //이름
            const funcName = document.createElement("div");
            funcName.setAttribute("class", "oneLine");
            funcName.innerHTML="<h2>"+writename+"</h2>"
            
             //이름
            const noticecate = document.createElement("div");
            noticecate.setAttribute("class", "oneLine");
            noticecate.innerHTML="<label class='labels'>카테고리</label>"+
            "<select>"+
            "<option value='promotion'>프로모션</option>"+
            "<option value='notice'>공지사항</option>" +
            "<option value='event'>이벤트</option>" +
            "</select>";
            //제목
            const title = document.createElement("div");
            title.setAttribute("class", "oneLine");
            title.innerHTML="<label class='labels'>제목</label><input type='text' name='title'>";

            //썸머노트
            const div4 = document.createElement("div");
            div4.setAttribute("class", "oneLine contnote");
            div4.innerHTML="<label class='labels'>내용</label><textarea id='summernote' name='editordata'></textarea>";

            $("#writerForm").append(funcName,title,noticecate,div4,subcanBTN());
            notesummer();
            //썸머노트 실행
            $("#writerForm").attr("action","/noticeWrite");
        }
        //-----------------------------------------------------------------//

        //4-2. 일반 상품 게시글 작성
        //사진 5장 / 제목 / 가격  / 내용
        function makeNormalPWritePage(){
            //수강인원
            const stock = document.createElement("div");
            stock.setAttribute("class", "oneLine");
            stock.innerHTML="<label class='labels'>재고</label><input type='number' name='stock'><span class='won'>개</span>";
            
            //썸머노트
            const div4 = document.createElement("div");
            div4.className= "oneLine contnote";
            div4.innerHTML="<label class='labels'>내용</label><br><textarea id='summernote' name='editordata'></textarea>";
            
            const writecate = document.createElement("input");
            writecate.setAttribute("type", "hidden");
            writecate.setAttribute("name", "writecate");
            writecate.setAttribute("value", "normal");
            $("#writerForm").append(stock,div4,subcanBTN(),writecate);
            $("#writerForm").attr("action","productWrite");
            //썸머노트 실행
            notesummer();
            //이미지 함수 실행
            showImg();
        }
        //-----------------------------------------------------------------//

        //4-3. 구독 상품 게시글 작성
        //사진 1장 / 제목 / 빵 or 커피  / 가격 / 식빵 종류 
        function makeSubscribePWritePage(){
            //썸머노트
            const div4 = document.createElement("div");
            div4.setAttribute("class", "oneLine contnote");
            div4.innerHTML="<label class='labels'>내용</label><textarea id='summernote' name='editordata'></textarea>";
            
            const div5 = document.createElement("div");
            div5.className= "oneLine";
            div5.setAttribute("id", "uppercate");
            div5.innerHTML="<label class='labels'>상품 대분류</label>"+
            "<label class='labels'>식빵세트 <input type='radio' name='breadCoffee' value='bread'></label>"+
            "<label class='labels'>식빵&커피 세트 <input type='radio' name='breadCoffee' value='coffee'></label>";

            const div6 = document.createElement("div");
            div6.className= "oneLine";
            div6.innerHTML="<label class='labels'>빵 종류</label>"+
            "<input type='text' class='input-smallcate'><button type='button' class='addBreadType'>빵 종류 추가</button>";
            const div7 = document.createElement("div");
            div7.className= "oneLine";
            div7.innerHTML="<label class='labels'>맛 종류</label>"+
            "<input type='text' class='input-taste'><button type='button' class='addBreadType'>맛 추가</button>";
            const writecate = document.createElement("input");
            writecate.setAttribute("type", "hidden");
            writecate.setAttribute("name", "writecate");
            writecate.setAttribute("value", "subscribe");
            $("#writerForm").append(div5,div6,div7,div4,subcanBTN(),writecate);
            $("#writerForm").attr("action","productWrite");

            //썸머노트 실행
            notesummer();
            //이미지 함수 실행
            showImg();
            addE();
        }
        //-----------------------------------------------------------------//
        function addE(){
            $("input[name='breadCoffee']").on("change",function(){
                if(this.value=='coffee'){
                    console.log(1111);
                    const addcoffee = document.createElement("div");
                    addcoffee.setAttribute("class", "oneLine addCoffee");
                    addcoffee.innerHTML="<label class='labels'>커피 용량</label>"+
                    "<input type='text' class='input-smallcate'><button type='button' class='addBreadType'>커피용량 추가</button>";
                    $("#uppercate").after(addcoffee);
                }
                else{
                    $(".addCoffee").remove();
                }
            })
        }
        //4-4.클래스 상품 
        //사진 1장 / 제목 / 가격 / 지점 / 가능수강일 /  
        function makeClassPWritePage(){
            const place = document.createElement("div");
            place.setAttribute("class", "oneLine");
            place.innerHTML="<label class='labels'>클래스 지점</label>"+
            "<select name='place'>"+
            "<option value='bucheon'>부천점</option>"+
            "<option value='geumcheon'>금천점</option>" +
            "<option value='namyangju'>남양주점</option>" +
            "<option value='changdong'>창동점</option>" +
            "<option value='mapo'>마포점</option>" +
            "</select>";
            
            const classDate = document.createElement("div");
            classDate.setAttribute("class", "oneLine");
            classDate.innerHTML="<label class='labels'>클래스 날짜</label>"+
            "<input type='text' id='classdate' name='classdate' readonly placeholder='날짜를 선택해주세요'>"+
            "<button type='button' class='opencal'>날짜 선택</button>";
            
            //수강인원
            const people = document.createElement("div");
            people.setAttribute("class", "oneLine");
            people.innerHTML="<label class='labels'>수강 인원</label><input type='number' name='people'><span class='won'>명</span>";

            //썸머노트
            const div4 = document.createElement("div");
            div4.setAttribute("class", "oneLine contnote");
            div4.innerHTML="<label class='labels'>내용</label><textarea id='summernote' name='editordata'></textarea>";
            const writecate = document.createElement("input");
            writecate.setAttribute("type", "hidden");
            writecate.setAttribute("name", "writecate");
            writecate.setAttribute("value", "onedayclass");
            $("#writerForm").append(place,people,classDate,div4,subcanBTN(),writecate);
            $("#writerForm").attr("action","productWrite");
                
            //썸머노트 실행
            notesummer();
            //이미지 함수 실행
            showImg();
            //달력모달 함수
            calmodal();
        }
        //-----------------------------------------------------------------//

        //4 게시글작성 common  일반 + 구독 + 클래스 공통부분
        function commonWriter(writename){
            //초기화
            contentbox.innerHTML="";
            //폼태그
            const adminwriteform = document.createElement("form")
            adminwriteform.setAttribute("id","writerForm");
            adminwriteform.setAttribute("enctype","multipart/form-data");
            adminwriteform.setAttribute("method","POST");
            //이름
            const funcName = document.createElement("div");
            funcName.setAttribute("class", "oneLine");
            funcName.innerHTML="<h2>"+writename+"</h2>"
            //제목
            const title = document.createElement("div");
            title.setAttribute("class", "oneLine");
            title.innerHTML="<label class='labels'>제목</label><input type='text' name='title'>";

            //가격
            const price = document.createElement("div");
            price.setAttribute("class", "oneLine");
            price.innerHTML="<label class='labels'>가격</label><input type='number' name='price'><span class='won'>원</span>";
            const div3 = document.createElement("div");
            div3.setAttribute("class", "oneLine imgline");
            div3.innerHTML="<label class='labels'>썸네일</label><div class='images'><img></div>"+
            "<input type='file' name='images' class='imagesinput'>" ;

            //일반이미지 4장
            const div33 = document.createElement("div")
            div33.setAttribute("class", "oneLine imgline");
            div33.innerHTML="<label class='labels'>일반이미지</label>"+"<div class='images'><img></div>"+"<div class='images'><img></div>"
            +"<div class='images'><img></div>"+"<div class='images'><img></div>"+
            "<input type='file' name='images' class='imagesinput'>" +
            "<input type='file' name='images' class='imagesinput'>" +
            "<input type='file' name='images' class='imagesinput'>" +
            "<input type='file' name='images' class='imagesinput'>";

            adminwriteform.append(funcName,title,price,div3,div33);
            contentbox.append(adminwriteform);
        }
        //-----------------------------------------------------------------//
        
        //4 게시글작성 common  게시글 등록 취소 공통버튼
        function subcanBTN(){
             //제출 취소 버튼
            const div5 = document.createElement("div");
            div5.innerHTML="<label class='labels'>&nbsp;</label>";
            div5.setAttribute("class", "oneLine write-btns");
            const span = document.createElement("span");
            div5.setAttribute("id", "btns");
            const btn1 = document.createElement("button");
            btn1.setAttribute("class", "admin-write-btn opencal");
            btn1.innerText = "제출";
            const btn2 = document.createElement("button");
            btn2.setAttribute("class", "admin-write-btn opencal");
            btn2.setAttribute("type", "reset");
            btn2.innerText = "취소";
            span.append(btn1,btn2)
            div5.append(span)
            return div5;
        }
        //-----------------------------------------------------------------//

        //5. 후기 관리
        function reviewManage(){
            contentbox.innerHTML="";
             //이름
            const funcName = document.createElement("div");
            funcName.setAttribute("class", "oneLine");
            funcName.innerHTML="<h2>"+"후기 관리"+"</h2>"

            const searchDiv = document.createElement("div");
            searchDiv.setAttribute("class", "oneLine search-review");
            searchDiv.innerHTML="<select>"+
            "<option>All</option>"+
            "<option>일반 상품 별</option>"+
            "<option>구독 상품 별</option>"+
            "<option>클래스 상품 별</option>"+
            "<option>아이디 별</option>"+
            "<input type='text'><button class='opencal'>검색</button>";
            
            const SearchResult = document.createElement("ul");
            SearchResult.setAttribute("class", "ResultLine");
            SearchResult.innerHTML=
            "<li class='resultTitle oneMemberResult'>"+
                "<span class='oneMemberInfo'>상품명</span>"+
                "<span class='oneMemberInfo'>아이디</span>"+
                "<span class='oneMemberInfo'>후기 내용</span>"+
                "<span class='oneMemberInfo'>블라인드 여부</span>"+
                "<span class='oneMemberInfo'>후기 처리</span>"+
            "</li>";
            contentbox.append(funcName,searchDiv,SearchResult);
        }
        //-----------------------------------------------------------------//
        
        //6. 관리자 계정 추가
        function addManagerId(){
            contentbox.innerHTML="";

            const adminwriteform = document.createElement("form")
            adminwriteform.setAttribute("id","writerForm");
            adminwriteform.setAttribute("method","POST");
            contentbox.append(adminwriteform)
             //이름
            const funcName = document.createElement("div");
            funcName.setAttribute("class", "oneLine");
            funcName.innerHTML="<h2>"+"관리자 계정 추가"+"</h2>";
            
            //관리자명
            const adminname = document.createElement("div");
            adminname.setAttribute("class", "oneLine addAdmin");
            adminname.innerHTML="<label class='labels'>관리자명</label><input type='text' name='adminname'>";
            
            //아이디
            const adminID = document.createElement("div");
            adminID.setAttribute("class", "oneLine addAdmin");
            adminID.innerHTML="<label class='labels'>관리자ID</label><input type='text' name='adminid'>";
            
            //비밀번호
            const adminPW = document.createElement("div");
            adminPW.setAttribute("class", "oneLine addAdmin");
            adminPW.innerHTML="<label class='labels'>비밀번호</label><input type='password' name='adminpw'>";
            
            $("#writerForm").append(funcName,adminname,adminID,adminPW,subcanBTN());
            $("#writerForm").attr("action","/addadminid");
        }
        //-----------------------------------------------------------------//
        
        //9. 공지사항 관리
        function modifyWrite(){
            contentbox.innerHTML="";
             //이름
            const funcName = document.createElement("div");
            funcName.setAttribute("class", "oneLine");
            funcName.innerHTML="<h2>"+"공지사항 관리"+"</h2>"

            const searchDiv = document.createElement("div");
            searchDiv.setAttribute("class", "oneLine search-review");
            searchDiv.innerHTML="<select>"+
            "<option>All</option>"+
            "<option>공지사항</option>"+
            "<option>프로모션</option>"+
            "<option>이벤트</option>"+
            "<input type='text'><button class='opencal'>검색</button>";
            
            const SearchResult = document.createElement("ul");
            SearchResult.setAttribute("class", "ResultLine");
            SearchResult.innerHTML=
            "<li class='resultTitle oneMemberResult'>"+
                "<span class='oneMemberInfo'>카테고리</span>"+
                "<span class='oneMemberInfo notice-title'>제목</span>"+
                "<span class='oneMemberInfo'>처리</span>"+
            "</li>"+
            "<li class='oneMemberResult'>"+
                "<span class='oneMemberInfo'>공지사항</span>"+
                "<span class='oneMemberInfo notice-title'>공지사항입니다.</span>"+
                "<span class='oneMemberInfo'>처리</span>"+
            "</li>";
            contentbox.append(funcName,searchDiv,SearchResult);
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
        //썸머노트 실행 함수
        function notesummer(){
            //썸머노트 실행
            $('#summernote').summernote({
            lang:"ko-KR",
            placeholder: '내용을 입력해주세요',
            tabsize: 2,
            width : 1200,
            height: 600,
            toolbar: [
                ['style', ['style']],
                ['font', ['bold', 'underline', 'clear']],
                ['color', ['color']],
                ['para', ['ul', 'ol', 'paragraph']],
                ['table', ['table']],
                ['insert', ['link', 'picture', 'video']],
                ['view', ['fullscreen', 'codeview', 'help']]
            ],
            callbacks : { 
                //onImageUpload = 이미지 업로드시 작동하는 콜백함수
                onImageUpload : function(files, editor, welEditable) {
            // 파일 업로드(다중업로드를 위해 반복문 사용)
                for (var i = files.length - 1; i >= 0; i--) {
                    console.log("이미지 업로드");
                        uploadSummernoteImageFile(files[i],
                        this);
                        }
                }
            }//end callbacks 
            });
            // 이미지 업로드시 ajax로 파일 업로드를 하고 성공 후 파일 경로를 return받음
            function uploadSummernoteImageFile(file, editor) {
            data = new FormData();
            data.append("file", file);
            console.log(data);
            $.ajax({
                url : "summernoteImage",
                data : data,
                type : "POST",
                dataType : 'JSON',
                contentType : false,
                processData : false,
                success : function(data) {
                    //항상 업로드된 파일의 url이 있어야 한다.
                    console.log(data);
                    console.log(data.url);
                    $(editor).summernote('insertImage', contextPath+data.url);
                }
            });
            } 
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
        let tempDate = new Date();
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
            dateclick();
            function dateclick(){
                $(".possible").on("click",function(){
                    $("#classdate").val(tmonth.innerText+"/"+this.innerText);
                    $("#closecal").click();
                })
            };
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
        //클릭하면 이미지 첨부 / 삭제되도록
        function showImg(){
            $(".images").on("click", function(){
                var index = $(".images").index(this);
                console.log(index);
                if(filecheck[index]==0){
                    $("input[name=images]").eq(index).click()
                }
                else{
                    if(confirm("이미지를 삭제하시겠습니까?")){
                        $(this).children("img").removeAttr("src");
                        $(this).children("img").css("display","none");
                        $("input[name=images]").eq(index).val("");
                        filecheck[index]=0;
                    }
                }
            })
            //이미지 첨부되면 미리보기 뜨도록
            $("input[name=images]").on("input",function(){
                var index = $("input[name=images]").index(this);
                
                if(this.files[0]){
                    console.log("done"+index);
                    filecheck[index]=1;
                    console.log(filecheck[index]);
                    var reader = new FileReader();
                    reader.readAsDataURL(this.files[0]);
                    reader.onload = function(e){
                        $(".images").eq(index).children("img").attr("src", e.target.result);
                        $(".images").eq(index).children("img").css("display", "block");
                    }
                }
            })
        }
        
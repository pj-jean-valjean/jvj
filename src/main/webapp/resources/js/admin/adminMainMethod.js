

       /* router 구현 */
        const routes = [
                /* 조회 업무 */
            { path: '/jvj/admin/board/route/searchMember', component: function(){
                memberInfo();} },
            { path: '/jvj/admin/board/route/subsMember', component: function(){
                subscribingInfo();} },
            { path: '/jvj/admin/board/route/searchOrder', component: function(){
                orderInfo();} },
                /* 공지사항 / 상품등록 */
            { path: '/jvj/admin/board/route/noticeWriter', component: function(){
                noticeboardWriter('공지사항 등록');} },
            { path: '/jvj/admin/board/route/storeSubmit', component: function(){
                commonWriter('일반 상품 등록'); makeNormalPWritePage();} },
            { path: '/jvj/admin/board/route/subsSubmit', component: function(){
                commonWriter('구독 상품 등록');  makeSubscribePWritePage();} },
            { path: '/jvj/admin/board/route/classSubmit', component: function(){
                commonWriter('클래스 상품 등록'); makeClassPWritePage();} },
            { path: '/jvj/admin/board/route/optionSubmit', component: function(){
                optionProductWrite(); } },
            { path: '/jvj/admin/board/route/productManage', component: function(){
                modifyProduct();} },
                /* 글관리 */
            { path: '/jvj/admin/board/route/reviewManage', component: function(){
                reviewManage();} },
            { path: '/jvj/admin/board/route/noticeManage', component: function(){
                modifyWrite();} },
            
        ];
        
		function render(path){
            try {
                for(let route of routes){
                    if(route.path === path){
                        route.component();
                        return;
                    }
                }
            } catch (err) {
                console.error(err);
            }
		};
        const allNavi = document.querySelectorAll(".eachW");
        allNavi.forEach(
            function(navi){
                navi.addEventListener("click", e=>{
                    if(!e.target.matches('.eachW > li >a')) 
                    {
                        console.log("안맞음");
                        return;
                    }
                    e.preventDefault();
                    //이동 방지
        
                    const path = e.target.getAttribute('href');
                     // pushState는 주소창의 url을 변경하지만 HTTP 요청을 서버로 전송하지는 않는다.
                    window.history.pushState({}, null, path);
                    render(path);
                });
            }
        )


        // pjax 방식은 hash를 사용하지 않으므로 hashchange 이벤트를 사용할 수 없다.
        // popstate 이벤트는 pushState에 의해 발생하지 않고 앞으로/뒤로 가기 버튼을 클릭하거나
        // history.forward/back/go(n)에 의해 history entry가 변경되면 발생한다.
        window.addEventListener('popstate', () => {
        console.log('[popstate]', window.location.pathname);

        // 앞으로/뒤로 가기 버튼을 클릭하면 window.location.pathname를 참조해 뷰를 전환한다.
        render(window.location.pathname);
        });

        // 웹페이지가 처음 로딩되면 window.location.pathname를 확인해 페이지를 이동시킨다.
        // 새로고침을 클릭하면 현 페이지(예를 들어 localhost:8080/~~)가 서버에 요청된다.
        // 이에 응답하는 처리는 서버에서 구현해야 한다.
        render(window.location.pathname);
        
        //1. 회원정보 조회---------------------------------------------------
        function memberInfo(){
            contentbox.innerHTML="";
             //이름
            const funcName = document.createElement("div");
            funcName.setAttribute("class", "oneLine");
            funcName.innerHTML="<h2>"+"회원정보 조회"+"</h2>"

            const searchDiv = document.createElement("div");
            searchDiv.setAttribute("class", "oneLine search-member");
            searchDiv.innerHTML="<select name='searchSelector'><option value='searchById'>회원아이디</option><option value='searchByName'>회원명</option><option value='searchByNickName'>닉네임</option></select><input type='text' class='inputboxs'><button class='opencal' onclick='firstMemberSearch()'>회원검색</button>";

            const SearchResult = document.createElement("ul");
            SearchResult.setAttribute("class", "ResultLine");
            SearchResult.innerHTML=
            "<li class='resultTitle oneMemberResult'>"+
                "<span class='oneMemberInfo'>아이디</span>"+
                "<span class='oneMemberInfo'>닉네임</span>"+
                "<span class='oneMemberInfo'>이름</span>"+
                "<span class='oneMemberInfo'>가입일</span>"+
                "<span class='oneMemberInfo'>누적구매금액</span>"+
                "<span class='oneMemberInfo'>탈퇴여부</span>"+
            "</li>";
            contentbox.append(funcName,searchDiv,SearchResult);
            enterfunc();
        }
        function enterfunc(){
            document.querySelector(".inputboxs").addEventListener("keyup",function(){
                if (window.event.keyCode == 13) {
                    document.querySelector(".opencal").click();
                }
            })
        }
        //-----------------------------------------------------------------//
        let tempData;
        let tempSearchBy
        function firstMemberSearch(){
            $(".added").remove();
            const searchBy = document.getElementsByName("searchSelector")[0].value;
            const data = document.querySelector(".inputboxs").value;
            const jsonObj ={
                "searchBy" : searchBy,
                "data" : data,
                "page" : 0
            }
            console.log(jsonObj);
            searchMember(jsonObj);
        }
        function pageMemberSearch(){
            jsonObj.page = jsonObj.page+1;
            searchMember(jsonObj);
        }
        function searchMember(jsonObj){

            let httpRequest = new XMLHttpRequest();

            httpRequest.open("POST", contextPath+'/admin/board/searchMember', true);
            httpRequest.responseType = "json";
            httpRequest.setRequestHeader("Content-Type", "application/json");
            httpRequest.send(JSON.stringify(jsonObj));
            
            httpRequest.onreadystatechange = ()=>{
                if(httpRequest.readyState===XMLHttpRequest.DONE){
                    if(httpRequest.status ===200){
                        tempSearchBy =jsonObj.searchBy;
                        tempData=jsonObj.data;
                        
                        const resultData = httpRequest.response;
                        if(resultData.length==0){
                            alert("조회결과 없음");
                            return; 
                        }
                        const parentUl = document.getElementsByClassName("ResultLine")[0];
                        for(oneLi of resultData){

                            const li = document.createElement("li");
                            li.className ="oneMemberResult added";

                            const id = document.createElement("span");
                            id.innerText = oneLi.memberEmail;
                            const nick = document.createElement("span");
                            nick.innerText = oneLi.memberNickName;
                            const name = document.createElement("span");
                            name.innerText = oneLi.memberName;
                            const enrollDt = document.createElement("span");
                            enrollDt.innerText = oneLi.enrollDt;
                            const buying = document.createElement("span");
                            buying.innerText = '10000';
                            const statusCode = document.createElement("span");
                            if(oneLi.statusCode =='1') statusCode.innerText = '정상';
                            else statusCode.innerText = '탈퇴';

                            li.append(id,nick,name,enrollDt,buying,statusCode);
                            parentUl.append(li);
                        }
                    }
                    else{

                    }
                }
            }
        }

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
                "<span class='oneMemberInfo notice-title'>구독상품명</span>"+
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
                "<span class='oneMemberInfo sequence'>주문 번호</span>"+
                "<span class='oneMemberInfo'>아이디</span>"+
                "<span class='oneMemberInfo notice-title'>배송지</span>"+
                "<span class='oneMemberInfo'>구매금액</span>"+
                "<span class='oneMemberInfo'>결제일</span>"+
                "<span class='oneMemberInfo'>주문상태</span>"+
            "</li>";
            contentbox.append(funcName,searchDiv,SearchResult);
        }
        //-----------------------------------------------------------------//
        //글관리1- 후기 관리
        function reviewManage(){
            contentbox.innerHTML="";
            //이름
            const funcName = document.createElement("div");
            funcName.setAttribute("class", "oneLine");
            funcName.innerHTML="<h2>"+"리뷰 관리"+"</h2>"
            const searchDiv = document.createElement("div");
            searchDiv.setAttribute("class", "oneLine search-review");
            searchDiv.innerHTML="<select>"+
            "<option>All</option>"+
            "<option>일반 상품 별</option>"+
            "<option>구독 상품 별</option>"+
            "<option>클래스 상품 별</option>"+
            "<option>아이디 별</option>"+
            "<input type='text' class='inputboxs'><button class='opencal'>검색</button>";
            const SearchResult = document.createElement("ul");
            SearchResult.setAttribute("class", "ResultLine");
            SearchResult.innerHTML=
            "<li class='resultTitle oneMemberResult'>"+
                "<span class='oneMemberInfo sequence'>글 번호</span>"+
                "<span class='oneMemberInfo'>상품명</span>"+
                "<span class='oneMemberInfo'>아이디</span>"+
                "<span class='oneMemberInfo notice-title'>후기 내용</span>"+
                "<span class='oneMemberInfo'>블라인드 여부</span>"+
                "<span class='oneMemberInfo'>후기 처리</span>"+
            "</li>";
            contentbox.append(funcName,searchDiv,SearchResult);
            enterfunc();
        }



        //-----------------------------------------------------------------//

        //글관리2- 공지사항 관리
        function modifyWrite(){
            contentbox.innerHTML="";
             //이름
            const funcName = document.createElement("div");
            funcName.setAttribute("class", "oneLine");
            funcName.innerHTML="<h2>"+"공지사항 관리"+"</h2>"

            const searchDiv = document.createElement("div");
            searchDiv.setAttribute("class", "oneLine search-review");
            searchDiv.innerHTML="<select name='noticecate'>"+
            "<option>All</option>"+
            "<option value='1'>프로모션</option>"+
            "<option value='2'>공지사항</option>"+
            "<option value='3'>이벤트</option>"+
            "<input type='text' class='inputboxs'><button class='opencal' id='noticeSearch'>검색</button>";
            
            const SearchResult = document.createElement("ul");
            SearchResult.setAttribute("class", "ResultLine");
            SearchResult.innerHTML=
            "<li class='resultTitle oneMemberResult'>"+
                "<span class='oneMemberInfo sequence'>글 번호</span>"+
                "<span class='oneMemberInfo'>카테고리</span>"+
                "<span class='oneMemberInfo notice-title'>제목</span>"+
                "<span class='oneMemberInfo'>처리</span>"+
            "</li>"+
            "<li class='oneMemberResult'>"+
                "<span class='oneMemberInfo sequence'>1</span>"+
                "<span class='oneMemberInfo'>공지사항</span>"+
                "<span class='oneMemberInfo notice-title'>공지사항입니다.</span>"+
                "<span class='oneMemberInfo'>처리</span>"+
            "</li>";
            contentbox.append(funcName,searchDiv,SearchResult);
            enterfunc();
            document.getElementById("noticeSearch").addEventListener("click", function(){
                searchNotice();
            })
                    
        }
        function searchNotice(){
            console.log(1);

            const httpRequest = new httpRequest();


        }
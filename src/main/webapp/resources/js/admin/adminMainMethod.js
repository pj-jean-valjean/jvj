

        const routepath = '/jvj/admin/board/route/';
       /* router 구현 */
        const routes = [
                /* 조회 업무 */
            { path: routepath+'searchMember', component: function(){
                memberInfo();firstMemberSearch();} },
            { path: routepath+'subsMember', component: function(){
                subscribingInfo();} },
            { path: routepath+'searchOrder', component: function(){
                orderInfo();} },
                /* 공지사항 / 상품등록 */
            { path: routepath+'noticeWriter', component: function(){
                noticeboardWriter('공지사항 등록');} },
            { path: routepath+'storeSubmit', component: function(){
                commonWriter('일반 상품 등록'); makeNormalPWritePage();} },
            { path: routepath+'subsSubmit', component: function(){
                commonWriter('구독 상품 등록');  makeSubscribePWritePage();} },
            { path: routepath+'classSubmit', component: function(){
                commonWriter('클래스 상품 등록'); makeClassPWritePage();} },
            { path: routepath+'optionSubmit', component: function(){
                optionProductWrite(); } },
                /* 상품 관리(수정) */
            { path: routepath+'productManage', component: function(){
                modifyProduct();} },
                /* 글관리 */
            { path: routepath+'reviewManage', component: function(){
                reviewManage();} },
            { path: routepath+'noticeManage', component: function(){
                modifyWrite();searchNotice();} },
            { path: routepath+'modifyNotice', component: function(){
                if(modifyNo==0){
                    alert("새로고침시 수정내용이 초기화됩니다")
                    location.href='noticeManage';
                    return;
                }
                noticeboardWriter('공지사항수정');
                modifyThisNotice();
            } },
            
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
        const allNavi = document.querySelectorAll(".eachW > li >a");
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
        // 앞으로/뒤로 가기 버튼을 클릭하면 window.location.pathname를 참조해 뷰를 전환한다.
        render(window.location.pathname);
        });

        // 웹페이지가 처음 로딩되면 window.location.pathname를 확인해 페이지를 이동시킨다.
        // 새로고침을 클릭하면 현 페이지(예를 들어 localhost:8080/~~)가 서버에 요청된다.
        // 이에 응답하는 처리는 서버에서 구현해야 한다.
        render(window.location.pathname);

        //---------------------------------------------------

        /* input 엔터시 동작 함수 */
        function enterfunc(){
            document.querySelector(".inputboxs").addEventListener("keyup",function(){
                if (window.event.keyCode == 13) {
                    document.querySelector(".opencal").click();
                }
            })
        }

        //---------------------------------------------------
        //1. 회원정보 조회---------------------------------------------------
        function memberInfo(){
            contentbox.innerHTML="";
             //이름
            const funcName = document.createElement("div");
            funcName.setAttribute("class", "oneLine");
            funcName.innerHTML="<h2>"+"회원정보 조회"+"</h2>"

            const searchDiv = document.createElement("div");
            searchDiv.setAttribute("class", "oneLine search-member");
            searchDiv.innerHTML="<select name='searchSelector'><option value='1'>회원아이디</option><option value='2'>회원명</option><option value='3'>닉네임</option></select><input type='text' class='inputboxs'><button class='opencal' onclick='firstMemberSearch()'>회원검색</button>";

            const SearchResult = document.createElement("ul");
            SearchResult.setAttribute("class", "ResultLine");
            contentbox.append(funcName,searchDiv,SearchResult);
            enterfunc();
        }

        
        function firstMemberSearch(){
            cp =1;
            cate = document.getElementsByName("searchSelector")[0].value;
            search = document.querySelector(".inputboxs").value;
            searchMember();
        }
        function searchMember(){
            let httpRequest = new XMLHttpRequest();
            const jsonObj ={
                "search": search,
                "cate" : cate,
                "cp" : cp
            }
            httpRequest.open("POST", contextPath+'/admin/board/searchMember', true);
            httpRequest.responseType = "json";
            httpRequest.setRequestHeader("Content-Type", "application/json");
            httpRequest.send(JSON.stringify(jsonObj));
            
            httpRequest.onreadystatechange = ()=>{
                if(httpRequest.readyState===XMLHttpRequest.DONE){
                    if(httpRequest.status ===200){
                        
                        const resultData = httpRequest.response;

                        const memberList = JSON.parse(resultData.memberList);
                        const page = JSON.parse(resultData.pagination);

                        const parentUl = document.getElementsByClassName("ResultLine")[0];
                        parentUl.innerHTML = '<li class="resultTitle oneMemberResult"><span class="oneMemberInfo">아이디</span><span class="oneMemberInfo">닉네임</span><span class="oneMemberInfo">이름</span><span class="oneMemberInfo">가입일</span><span class="oneMemberInfo">누적구매금액</span><span class="oneMemberInfo">탈퇴여부</span></li>';
                        if(memberList.length ==0){
                            console.log("결과없음");
                            const li = document.createElement("li");
                            li.className = "oneMemberResult";
                            li.innerHTML="<div style='font-size:20px;'>조회되는 회원이 없습니다</div>";
                            parentUl.append(li);
                            return;
                        }
                        for(oneLi of memberList){
                            const li = document.createElement("li");
                            li.className = "oneMemberResult";
                            let inner =
                            "<span class='oneMemberInfo sequence'>"+oneLi.memberEmail+"</span>"+
                            "<span class='oneMemberInfo'>"+oneLi.memberNickName+"</span>"+
                            "<span class='oneMemberInfo'>"+oneLi.memberName+"</span>"+
                            "<span class='oneMemberInfo'>"+oneLi.enrollDt+"</span>"+
                            "<span class='oneMemberInfo'>"+"100000"+"</span>";
                            if(oneLi.statusCode ==1) inner+="<span class='oneMemberInfo'>"+"정상"+"</span>";
                            else  inner+="<span class='oneMemberInfo'>"+"탈퇴"+"</span>";
                            li.innerHTML = inner;
                            parentUl.append(li);
                        }
                        cate = resultData.cate;
                        search = resultData.search;

                        /* 페이지네이션 생성 및 동작  */
                        parentUl.append(makePagination(page));
                        addPageFunc(searchMember, page,cate,search); 
                    }
                    else{

                    }
                }
            }
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
            cate=''
            search=''
            cp=1;
            contentbox.innerHTML="";
             //이름
            const funcName = document.createElement("div");
            funcName.setAttribute("class", "oneLine");
            funcName.innerHTML="<h2>"+"공지사항 관리"+"</h2>"

            const searchDiv = document.createElement("div");
            searchDiv.setAttribute("class", "oneLine search-review");
            searchDiv.innerHTML="<select name='noticecate'>"+
            "<option value='0'>All</option>"+
            "<option value='1'>프로모션</option>"+
            "<option value='2'>공지사항</option>"+
            "<option value='3'>이벤트</option>"+
            "<input type='text' class='inputboxs'><button class='opencal' id='noticeSearch' value='1'>검색</button>";
            
            const SearchResult = document.createElement("ul");
            SearchResult.setAttribute("class", "ResultLine");
            contentbox.append(funcName,searchDiv,SearchResult);
            enterfunc();
            document.getElementById("noticeSearch").addEventListener("click", function(){
                cp = this.value;
                cate = document.querySelector("select[name='noticecate']").value;
                search = document.querySelector(".inputboxs").value;
                searchNotice();
            })
        }

        /* 공지사항 리스트 조회 ajax */
        function searchNotice(){

            let httpRequest = new XMLHttpRequest();
            const reqJson  = {
                "search": search,
                "cate" : cate,
                "cp" : cp
            } 

            /* Post 방식으로 요청 */
            httpRequest.open("POST", contextPath+'/admin/board/noticeselect' , true);

            /* Response Type 을 Json으로  */
            httpRequest.responseType = "json";

            /* 요청 헤더에 컨텐츠 타입 json 명시 */
            httpRequest.setRequestHeader("Content-Type", "application/json");

            /* 데이더 json으로 변환 후 전송하기 */
            httpRequest.send(JSON.stringify(reqJson));

            //readyState가 변화했을 때 함수 실행
            httpRequest.onreadystatechange = ()=>{
                if(httpRequest.readyState === XMLHttpRequest.DONE){
                //readyState가 Done이고 응답값이 200이면
                    if(httpRequest.status ===200){
                        //성공
                        const result = httpRequest.response;
                        const noticeList = JSON.parse(result.noticeList);
                        const page = JSON.parse(result.pagination);

                        const ul = document.querySelector(".ResultLine");
                        ul.innerHTML=
                        "<li class='resultTitle oneMemberResult'>"+
                            "<span class='oneMemberInfo numberformat'>글 번호</span>"+
                            "<span class='oneMemberInfo'>카테고리</span>"+
                            "<span class='oneMemberInfo notice-title'>제목</span>"+
                            "<span class='oneMemberInfo'>수정</span>"+
                        "</li>";
                        if(noticeList.length ==0){
                            console.log("결과없음");
                            const li = document.createElement("li");
                            li.className = "oneMemberResult";
                            li.innerHTML="<div style='font-size:20px;'>조회되는 결과가 없습니다</div>";
                            ul.append(li);
                            return;
                        }
                        for(notice of noticeList){
                            const li = document.createElement("li");
                            li.className = "oneMemberResult";
                            const inner =
                            "<span class='oneMemberInfo numberformat'>"+notice.noticeNo+"</span>"+
                            "<span class='oneMemberInfo'>"+notice.noticeCateName+"</span>"+
                            "<span class='oneMemberInfo  notice-title'><a target='_blank' href='"+contextPath+
                            "/notice/view?noticeNo="+notice.noticeNo+"&cate="+result.cate+"&cp="+page.currentPage+"'"+
                            ">"+notice.noticeTitle+"</a></span>"+
                            "<span class='oneMemberInfo'>"
                            +"<a href='modifyNotice' class='modifyBtn'>수정하기</a>";
                            li.innerHTML = inner;
                            ul.append(li);
                        }
                        cate = result.cate;
                        search = result.search;
                        /* 페이지네이션 생성 및 동작  */
                        ul.append(makePagination(page));
                        addPageFunc(searchNotice, page,cate,search);

                        /* 수정동작 실행 함수 */
                        const allModifyBtn = document.querySelectorAll(".modifyBtn");
                        allModifyBtn.forEach(
                            function(Btn){
                                Btn.addEventListener("click", e=>{
                                    modifyNo = Btn.parentElement.parentElement.firstElementChild.innerText;
                                    if(!e.target.matches('.modifyBtn')) 
                                    {
                                        console.log("안맞음");
                                        return;
                                    }
                                    e.preventDefault();
                                    //이동 방지
                                    const path = e.target.getAttribute('href');
                                    // pushState는 주소창의 url을 변경하지만 HTTP 요청을 서버로 전송하지는 않는다.
                                    window.history.pushState({}, null, path);
                                    render(routepath+path);
                                });
                            }
                        )
                    }
                    else{
                        //실패
                    }
                }
            }
        }

        /* 공지사항 수정 동작 */
        function modifyThisNotice(){
                const goback = document.createElement("button");
                const reload = document.createElement("button");
                goback.setAttribute("type", "button");
                reload.setAttribute("type", "button");
                goback.setAttribute("onclick","window.history.back()");
                reload.setAttribute("onclick","loadNoticeDetail()");
                goback.innerText = "목록으로 돌아가기";
                reload.innerText = "다시불러오기";
                const modifyNoInput = document.createElement("input");
                modifyNoInput.name = "noticeNo";
                modifyNoInput.type="hidden";
                modifyNoInput.value = modifyNo;
                document.querySelector("#writerForm").prepend(goback,reload,modifyNoInput);
                /* 공지사항 내용 불러오기   */
                loadNoticeDetail();
                const submitbtn= document.querySelector(".admin-write-btn");
                const cancelbtn= document.querySelector("button[type='reset']");
                submitbtn.setAttribute("onclick", "updateNotice()");
                cancelbtn.setAttribute("onclick", "window.history.back()"); 
        }
        function loadNoticeDetail(){
            $.ajax({
                url : contextPath+"/admin/board/ajaxNoticeDetail",
                data : {"noticeNo":modifyNo},
                type : "POST",
                dataType : 'JSON',
                success : function(data) {
                    console.log(data);
                    console.log(data.noticeTitle);
                    document.querySelector("input[name='title']").value = data.noticeTitle;
                    document.querySelector("select[name='noticecate']").value = data.noticeCd;
                    if(document.querySelector(".note-placeholder") !=null){
                        document.querySelector(".note-placeholder").innerText=""; 
                    }
                    document.querySelector(".note-editable").innerHTML = data.content; 
                    document.querySelector("textarea[name='editordata']").innerHTML = data.content; 
                }
            })
        }
        function updateNotice(){
            if(document.querySelector("input[name='title']").value.trim().length==0){
                alert("제목을 입력해주세요!");
                document.querySelector("input[name='title']").focus();
                return;
            }
            const form = $("#writerForm"); 
            const formData = new FormData(form[0]);
            $.ajax({
                url : contextPath+"/admin/board/noticeUpdate",
                type : "POST",
                data : formData,
                contentType: false,
                processData: false,
                cache: false,
                success : function(result){
                    console.log("결과: " + result);
                    alert("수정 성공!");
                    url = contextPath + '/notice/view?noticeNo=' + modifyNo;
                    window.open(url, '등록클래스상품', ''+result); 
                    location.href='noticeManage';
                },
                error: function(result){
                    alert("오류 발생");
                }
            })
        }
        //-----------------------------------------------------------------//
        //9. 상품 관리
        function modifyProduct(){
            contentbox.innerHTML="";
            //이름
            const funcName = document.createElement("div");
            funcName.setAttribute("class", "oneLine");
            funcName.innerHTML="<h2>"+"상품 관리"+"</h2>"

            const searchDiv = document.createElement("div");
            searchDiv.setAttribute("class", "oneLine search-review");
            searchDiv.innerHTML="<select name='productCate'>"+
            "<option value='0'>All</option>"+
            "<option value='1'>스토어 상품</option>"+
            "<option value='2'>구독 상품</option>"+
            "<option value='3'>클래스 상품</option>"+
            "<option value='4'>추가옵션 상품</option>"+
            "<input type='text' class='inputboxs'><button class='opencal' id='searchProduct'>검색</button>";

            const SearchResult = document.createElement("ul");
            SearchResult.setAttribute("class", "ResultLine");
            contentbox.append(funcName,searchDiv,SearchResult);
            enterfunc();
            document.getElementById("searchProduct").addEventListener("click", function(){
                cate = document.querySelector("select[name='productCate']").value;
                search = document.querySelector(".inputboxs").value;
                searchProduct();
            })
        }
        /* 상품정보조회 ajax */
        function searchProduct(){
            let httpRequest = new XMLHttpRequest();
            const reqJson  = {
                "search": search,
                "cate" : cate,
                "cp" : cp
            }
            httpRequest.open("POST", contextPath+'/admin/board/productselect' , true);
            httpRequest.responseType = "json";
            httpRequest.setRequestHeader("Content-Type", "application/json");
            httpRequest.send(JSON.stringify(reqJson));
            httpRequest.onreadystatechange = ()=>{
                if(httpRequest.readyState === XMLHttpRequest.DONE){
                    if(httpRequest.status ===200){
                        const result = httpRequest.response;
                        const productList = JSON.parse(result.productList);
                        const page = JSON.parse(result.pagination);
                        const ul = document.querySelector(".ResultLine");
                        ul.innerHTML=
                        "<li class='resultTitle oneMemberResult'>"+
                        "<span class='oneMemberInfo numberformat'>상품 번호</span>"+
                        "<span class='oneMemberInfo'>카테고리</span>"+
                        "<span class='oneMemberInfo notice-title'>이름</span>"+
                        "<span class='oneMemberInfo'>가격</span>"+
                        "<span class='oneMemberInfo'>수정하기</span>"+
                        "</li>";
                        if(productList.length ==0){
                            console.log("결과없음");
                            const li = document.createElement("li");
                            li.className = "oneMemberResult";
                            li.innerHTML="<div style='font-size:20px;'>조회되는 결과가 없습니다</div>";
                            ul.append(li);
                            return;
                        }
                        console.log(productList);
                        for(product of productList){
                            const li = document.createElement("li");
                            li.className = "oneMemberResult";
                            if(product.writecate == 3){
                                titleAtag="<a target='_blank' href="+contextPath+"/onedayclass/view/"+product.productNo+">"+
                                product.title+"</a>"
                            }
                            else if(product.writecate == 1){
                                titleAtag="<a target='_blank' href="+contextPath+"/store/info/"+product.productNo+">"+
                                product.title+"</a>"
                            }
                            else{
                                titleAtag = "<a>"+product.title+"</a>";
                            }
                            const inner =
                            "<span class='oneMemberInfo numberformat'>"+product.productNo+"</span>"+
                            "<span class='oneMemberInfo'>"+product.cateName+"</span>"+
                            "<span class='oneMemberInfo notice-title'>"+titleAtag+"</span>"+
                            "<span class='oneMemberInfo'>"+product.price+"</span>"+
                            "<span class='oneMemberInfo'><a href='modifyProduct' class='modifyProductBtn'>수정하기</a></span>";
                            li.innerHTML = inner;
                            ul.append(li);
                        }
                        cate = result.cate;
                        search = result.search;
                        ul.append(makePagination(page));
                        addPageFunc(searchProduct, page,cate,search);
                        const allModifyBtn = document.querySelectorAll(".modifyProductBtn");
                        allModifyBtn.forEach(
                            function(Btn){
                                Btn.addEventListener("click", e=>{
                                    modifyNo = Btn.parentElement.parentElement.firstElementChild.innerText;
                                    if(!e.target.matches('.modifyProductBtn')) 
                                    {
                                        console.log("안맞음");
                                        return;
                                    }
                                    e.preventDefault();
                                    const path = e.target.getAttribute('href');
                                    window.history.pushState({}, null, path);
                                    render(routepath+path);
                                });
                            }
                        )
                    }
                    else{
                        //실패
                    }
                }
            }
        }
        //-----------------------------------------------------------------//
        /* 페이지네이션 생성 */
        function makePagination(page){
            const pageli = document.createElement("li");
            pageli.className = "pagination";
            if(page.startPage !=1){
                const prev = document.createElement("span");
                prev.innerText = '<';
                prev.className = "goPrevPage";
                const firstspan = document.createElement("span");
                firstspan.innerText = '<<';
                firstspan.className = "goFirstPage";
                pageli.append(firstspan,prev);
            }
            for(let i = 0; i < page.pageSize ; i++){
                if(page.maxPage < page.startPage + i){
                    break;
                } 
                const pagespan = document.createElement("span");
                pagespan.innerText = page.startPage + i;
                pageli.append(pagespan);
                if(page.startPage + i == page.currentPage){
                    pagespan.setAttribute("id","currPage");
                    continue;
                }
                else{
                    pagespan.className="goThisPage";
                }
            }

            if(page.endPage != page.maxPage){
                const next = document.createElement("span");
                next.innerText = '>';
                next.className = "goNextPage";
                const endspan = document.createElement("span");
                endspan.innerText = '>>';
                endspan.className = "goLastPage";
                pageli.append(next,endspan);
            }
            return pageli;
        }
        function addPageFunc(func, page,noticecateN,searchN){
            cate = noticecateN;
            search = searchN;
            if(document.querySelector(".goPrevPage") != null){
                document.querySelector(".goPrevPage").addEventListener("click", function(){
                    cp= page.prevPage
                    func();
                })
                document.querySelector(".goFirstPage").addEventListener("click", function(){
                    cp= 1;
                    func();
                })
            }
            if(document.querySelector(".goNextPage") != null){
                document.querySelector(".goNextPage").addEventListener("click", function(){
                    cp= page.nextPage
                    func();
                })
                document.querySelector(".goLastPage").addEventListener("click", function(){
                    cp= page.maxPage;
                    func();
                })
            }
            if(document.querySelector(".goThisPage") != null){
                const pages = document.querySelectorAll(".goThisPage");
                pages.forEach(
                    function(Element){
                        Element.addEventListener("click", function(){
                            cp= Element.innerText;
                            func();
                        })
                    }
                )
            }
        }
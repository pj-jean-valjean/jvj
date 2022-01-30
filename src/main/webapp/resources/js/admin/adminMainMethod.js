        //조회업무1-회원 정보 조회
        $(".querywork")[0].addEventListener("click",memberInfo);  
        //조회업무2-구독 회원 조회
        $(".querywork")[1].addEventListener("click",subscribingInfo); 
        //조회업무3-주문 조회
        $(".querywork")[2].addEventListener("click",orderInfo);

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
            contentbox.append(funcName,searchDiv,SearchResult);
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
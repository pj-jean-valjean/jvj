<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />

    <link rel="stylesheet" href="${contextPath}/resources/css/member/searchPwResult.css">

    <main>

        <section class="title-section">
            <p>비밀번호 변경</p>
        </section>

        <div class="member-form-info">
        
        <form>
        <div class="input-info"><div class="input-info-div">
            <div class="p-div"><p>비밀번호</p></div>
            <div class="input-div"><input type="password" class="member-info"></div>
        </div>
        <div class="input-info-div">
            <div class="p-div"><p>비밀번호 확인</p></div>
            <div class="input-div"><input type="password" class="member-info"></div>
        </div>

        </div>
            <div class="flex-div">
                <div class="signUp-select-btn">
                    <button type="submit" id="search-btn">확인</button>
                </div>
            </div>

        </form>
        </div>

    </main>
    


<jsp:include page="../common/footer.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500;700&display=swap" rel="stylesheet">
	<link rel="icon" href="${contextPath}/resources/images/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
	
	<!-- swalalert -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

	<script type="text/javascript" charset="utf-8">
		sessionStorage.setItem("contextPath", "${contextPath}");
	</script>

	<script src="${contextPath}/resources/js/main.js"></script>
</head>


<body>
	<header>
        <section class="nav">
            <ul class="nav-menu">
                <li><a href="${contextPath}/subscribe/subMain">정기 구독</a></li>
                <li>|</li>
                <li><a href="${contextPath}/store?cp=1&ct=0&op=0">스토어</a></li>
                <li>|</li>
                <li><a href="${contextPath}/onedayclass/list">원데이 클래스</a></li>
                <li>|</li>
                <li><a href="${contextPath}/notice/list">공지사항</a></li>
            </ul>
            
            <div class="nav-logo">
            <a href="${contextPath}">
                <img src="${contextPath}/resources/images/common/jvj_logo.png" alt="jvj_logo">
                </a>
            </div>
            <ul class="nav-login">
                

				<c:choose>
				<c:when test="${empty loginMember}">
	                <!-- 비로그인 -->
	                <li><a href="${contextPath}/member/login">로그인</a></li>
				</c:when>
				<c:otherwise>
                <!-- 로그인 -->
	                <li>
	                    <a href="${contextPath}/mypage/main">
	                        <img src="${contextPath}/resources/images/common/user.png" alt="user">
	                    </a>
	                    <a href="${contextPath}/cart">
	                        <img class="shopping-img" src="${contextPath}/resources/images/common/shopping.png" alt="shopping">
	                    </a>
						<a href="${contextPath}/member/logout" title="logout-icon">
							<img class="logout-img" src="${contextPath}/resources/images/common/icon-logout.png">
						</a>	                    
	                </li>
	             </c:otherwise>
				</c:choose>

                
                <li>
                	<!-- <form action="searchList" method="GET" id="searchForm"> -->
	                    <!-- <select class="search-options" id="searchOptions" name="sk">
	                        <option value="장발장 바게트" />
	                        <option value="장발장 식빵" />
	                        <option value="초코 식빵" />
	                        <option value="로우키 커피" />
	                    </select> -->
	                    <input type="text" name="sv" class="nav-search" id="inputSearch"  maxlength="20">
                    <!-- </form> -->
                </li>
            </ul>
        </section>
        
        <!-- modal -->
		<div class="modal-area hidden">
			<div class="modal-overlay"> </div>
			<div class="modal-content">
			
				<%-- 값이 있을 경우 --%>
                <c:choose>
					<c:when test="${ !empty sv }">
						<div>${searchVO.sv }</div>
						<table>
							<tr>
								<td>상품명</td>
								<td>내용</td>
								<td>가격</td>
							</tr>
							<tr>
								<td>식빵</td>
								<td>굿</td>
								<td>5,00</td>
							</tr>
						</table>
					</c:when>
					<c:otherwise>
						<table>
							<tr>
								<td>상품명</td>
								<td>내용</td>
								<td>가격</td>
							</tr>
							
							<tr>
								<td>식빵</td>
								<td>굿</td>
								<td>5,00</td>
							</tr>


						</table>
					</c:otherwise>
				</c:choose>
				
				<button>x</button>
			</div>
			
		</div>

	</header>

	<script>
	
		const contextPath = "${contextPath}";
		
		// const btnSubmit = document.getElementById("open");
		// const modal = document.querySelector(".modal-area");
		// const overlay = modal.querySelector(".modal-overlay");
		// const closeBtn = modal.querySelector("button");
		
		// const openModal = () => {
		// 			modal.classList.remove("hidden");
		// 		}
		// const closeModal = () => {
		// 	modal.classList.add("hidden");
		// }
		// overlay.addEventListener("click", closeModal);
		// closeBtn.addEventListener("click", closeModal);
		// btnSubmit.addEventListener("click", openModal);
		
		let input = document.getElementById("inputSearch");
		const modal = document.querySelector(".modal-area");
		const overlay = modal.querySelector(".modal-overlay");
		const closeBtn = modal.querySelector("button");

		input.focus()
		input.addEventListener("keyup",function(e){
			
			if (e.code == "Enter") { //엔터키 입력 시 
				modal.classList.remove('hidden');
				search();
			}
		});

		const closeModal = () => {
		 	modal.classList.add("hidden");
		}
		overlay.addEventListener("click", closeModal);
		closeBtn.addEventListener("click", closeModal);



		function search(){
			const sv = $("#inputSearch").val();
			
			$.ajax({
				url: contextPath + "/subscribe/main/search",
				dataType : "json",
				data : {"sv" : sv},
				success:function(list){
					/* 데이터값 가져오기*/
					console.log("list"+list);
				
				}	
				
			});
		}	

	</script>
	</body>
	</html>
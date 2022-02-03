<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JVJ 공지사항 상세</title>
<jsp:include page="../common/header.jsp" />
 	<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/admin/notice.css">
 	<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
 	<style>
 	        body{
            width: 100%;
            margin: 0 auto;
        }
        section{
            width: 1200px;
            margin: 0 auto;
        }
        #classpname{
            color: #A78A6C;
            text-align: center;
            margin-top: 35px;
            padding-bottom: 35px;
            border-bottom: 5px solid rgba(167, 138, 108, 0.5);
        }
        #notice-info{
            width: 100%;
        }
        #notice-info>div{
            border-bottom: 1px solid #B7B7B7;
            display: flex;
        }
        #notice-info>div>span{
            height: 60px;
            line-height: 60px;
        }
        #notice-info>div>span:first-of-type{
            width: 15%;
            font-weight: bold;
        }
        #gotolist{
            background: #A78A6C;
            border: 3px solid #A78A6C;
            box-sizing: border-box;
            border-radius: 5px;
            color: white;
            margin-top: 20px;
        }
        #notice-content{
            padding: 10px;
        }
        </style>
</head>
<body>
    <main>
        <section>
            <article>
                <h1 id="classpname" style="font-size: 40px;">공지사항</h1>
                <div id="notice-info">
                    <div id="notice-title">
                        <span>제목</span>
                        <span>${notice.noticeTitle}</span>
                    </div>
                    <div id="notice-create-dt">
                        <span>작성일</span>
                        <span>${notice.createDt}</span>
                    </div>
                    <div id="notice-content">
                        ${notice.content}
                    </div>
                    <a id="gotolist" href="list?cate=${cate}&cp=${cp}">목록으로</a>
                </div>
            </article>
        </section>
    </main>
	<jsp:include page="../common/footer.jsp" />	
	
	<script>
		document.getElementById("selectcate").addEventListener("change",function(){
			location.href="list?cate="+this.value;
		})
	</script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page import="java.net.URLDecoder"%>
<%@ page session="false"%>
<c:set var="logInId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}" />
<c:set var="loginOutLink" value="${logInId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="LogInOut" value="${logInId=='' ? '로그인' : '로그아웃'}"/>
<c:set var="registerLink" value="${logInId=='' ? '/register/add' : '/mypage/mypage'}"/>
<c:set var="registerMy" value="${logInId=='' ? '회원가입' : 'mypage'}"/>

<html>
<head>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    <title>Board</title>
    <script>
        let msg = "${msg}";
        if(msg=="WRT_ERR") alert("게시물 등록에 실패하였습니다. 다시 시도해 주세요.");
        if(msg=="MOD_ERR") alert("게시물 수정에 실패하였습니다. 다시 시도해 주세요.");
    </script>
</head>
<body>
<div class="menu">
    <div class="logo"><a href="<c:url value="/"/>">쇼핑몰 이름</a></div>
    <div class="search">
        <input class="search_in" type="text">
        <button>검색</button>
    </div>

    <div class="user">
        <a href="<c:url value="${loginOutLink}"/>">${LogInOut}</a>
        <a href="<c:url value="${registerLink}"/>">${registerMy}</a>
        <a href="<c:url value="/payment/cart"/> ">장바구니</a>
    </div>
    <div class="list">
        <ul>
            <li><a href="<c:url value="/cap"/> ">모자</a></li>
            <li><a href="<c:url value="/mantoman"/>">맨투맨</a></li>
            <li><a href="<c:url value="/shirts"/>">셔츠</a></li>
            <li><a href="<c:url value="/pants"/>">바지</a></li>
            <li><a href="<c:url value="/shoes"/>">신발</a></li>
        </ul>
    </div>
    <div class="board"><a href="<c:url value="/board/list/0/1"/>">Q&A</a></div>
</div>
<h1>Q&A</h1>
<form action="<c:url value="/board/board"/>" method="post">

    <p>
        <label for="">title</label>
        <input type="text" name=title id="title"placeholder="title" ${mode=="read" ? 'readonly' : ''} value="${mode=="read" ? boardDto.title:''}">
        <label for="">content</label>
        <textarea name="content" id="content" cols="30" rows="10"placeholder="내용을 입력해주세요.">${mode=="read" ? boardDto.content:''}</textarea>
        <input type="hidden" name="n" value="${n}">
        <input type="hidden" name="offset" value="${offset}">
        <button${mode=="read" ? 'hidden':''}>등록</button>
    </p>
</form>
    <c:if test="${mode eq 'read'}">
    <div>
        <input name="bno" id="bno" type="hidden" value="${boardDto.bno}">
        <input name="commentIn" id="commentIn">
        <button class="commentBtn">댓글</button>
    </div>
    </c:if>
<div name="id" id="id">${commentsDto.id}</div>
<div name="comment" id="commentread">${commentsDto.comment}</div>
    <c:forEach var="commentsDto" items="${list}">
        <input type="hidden" name="cno" value="${commentsDto.cno}">
        <div name="id">${commentsDto.id}</div>
        <div name="comment">${commentsDto.comment}</div>
    </c:forEach>
<script>
    $(document).ready(function(){
        $(document).on("click",".commentBtn",function (){
            let commentsDto={bno : $("#bno").val(), comment : $("#commentIn").val()};
            let param2={};
            alert(commentsDto.bno)
            alert(commentsDto.comment)
            $.ajax({
                type:'POST',
                url: '/shop/comment',
                headers : { "content-type": "application/json"},
                dataType: 'text',
                data: JSON.stringify(commentsDto),
                success : function (result){
                    alert("success")
                    param2=JSON.parse(result);
                    $("#id").html(param2.id);
                    $("#commentread").html(param2.comment);
                },
                error   : function(){ alert("실패했습니다") } // 에러가 발생했을 때, 호출될 함수
            });
        });
    });
</script>
</body>
</html>

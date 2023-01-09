<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
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
    <title>Payment</title>
    <style>
        img{
            width: 400px;
            height: 440px;
        }

    </style>
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
<div class="main">

    <div class="top">

    </div>
    <div class="middle">
        <form action="<c:url value="/payment/pay"/> " method="post">
            <img src="<c:url value='/image/${goodsDto.goodsimg}'/> ">
            <div>${goodsDto.goodsname}</div>
            <div>가격 : ${price}</div>
            <div>수량 : ${count}</div>
            <input type="hidden" name="count" value="${count}">
            <input type="hidden" name="price" value="${price}"/>
            <input type="hidden" name="bno" value="${goodsDto.bno}">
            <input type="hidden" name="cno" value="${cno}">
            <a href="<c:url value="/address/modify?toUrl=/payment/${cno}"/> ">주소설정하기</a>
            <button>결제</button>
            <button name="delete" value="true">삭제</button>
        </form>
    </div>

</div>



</body>
</html>

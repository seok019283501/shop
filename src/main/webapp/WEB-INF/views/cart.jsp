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
    <title>Home</title>
    <style>
        select{
            width: 800px;
            height: 800px;
        }
        .delete{
            width: 80px;
            height: 80px;
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

    <h1>장바구니</h1>

    <div class="cart">
        <form action="<c:url value="/payment/delete"/> "method="post">
            <c:forEach var="cartDto" items="${list}">
                <p>
                    <a href="<c:url value="/payment/${cartDto.cno}"/> ">
                            ${cartDto.goodsname} 가격 : ${cartDto.price * cartDto.count} 개수 : ${cartDto.count}
                    </a>
                    <button class="delete" name="cno" value="${cartDto.cno}">삭제</button>
                </p>
            </c:forEach>
        </form>
    </div>
</div>



</body>
</html>

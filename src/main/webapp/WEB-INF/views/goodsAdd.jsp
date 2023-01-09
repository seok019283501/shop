
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
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    <title>goodsAdd</title>
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
</div>
<div class="board"><a href="<c:url value="/board/list/0/1"/>">Q&A</a></div>
<div class="main">
    <h1 class="title">상품 등록</h1>
    <div class="add">
        <form action="<c:url value="/goods/add"/>" method="post" class="goodsBox1" enctype="multipart/form-data">
            <div id="msg">
                <c:if test="${not empty param.msg}">
                    <i class="fa fa-exclamation-circle"> ${URLDecoder.decode(param.msg)}</i>
                </c:if>
            </div>
            <div class="goods1">
                파일선택:<input type="file" name="file">
                <input name="goodsname" class="goods_in" placeholder="제품 이름"/>
                <input name="price" class="goods_in" placeholder="가격" value="0"/>
                <select name="clazz">
                    <option>cap</option>
                    <option>shirts</option>
                    <option>mantoaman</option>
                    <option>pants</option>
                    <option>shoes</option>
                </select>
            </div>
            <button>등록</button>
        </form>

    </div>
</div>
</body>
</html>

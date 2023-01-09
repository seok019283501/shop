
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="false"%>
<c:set var="logInId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}" />
<c:set var="loginOutLink" value="${logInId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="LogInOut" value="${logInId=='' ? '로그인' : '로그아웃'}"/>
<c:set var="registerLink" value="${logInId=='' ? '/register/add' : '/mypage/mypage'}"/>
<c:set var="registerMy" value="${logInId=='' ? '회원가입' : 'mypage'}"/>
<c:set var="payment" value="/payment/cartpost"/>
<c:set var="managerCheck" value="${logInId=='asdf' ? '/goods/delete':payment}"/>
<c:set var="buttonName" value="${logInId=='asdf' ? '삭제':'구매'}"/>
<html>
<head>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/goodsSt.css'/>">
    <title>Goods</title>
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
            <form action="<c:url value="${managerCheck}"/> " method="post">
                <img src="<c:url value='/image/${goodsDto.goodsimg}'/>" alt="">
                <div name="goodsname" class="goods_name"><c:out value="${goodsDto.goodsname}"/></div>
                <div name="price" class="price"><c:out value="${goodsDto.price}"/>원</div>

                <input name="bno" type="hidden" value="${goodsDto.bno}">
                <c:if test="${logInId=='asdf'}">
                    <input name="goodsurl" type="hidden" value="${goodsDto.goodsimg}">
                </c:if>
                <select name="count">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                </select>
                <button>${buttonName}</button>
            </form>
        </div>
    </div>

</body>
</html>

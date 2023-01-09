
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
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    <style>
        .boardBox{
            margin: auto;
            display: flex;
            flex-direction: column;
            border-left: 1px solid black;
            border-right: 1px solid black;
        }

    </style>
    <title>BoardList</title>

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
    <div class="boardBox">

        <table>
            <tr>
                <th class="no">번호</th>
                <th class="title">제목</th>
                <th class="writer">작성자</th>
                <th class="reg_date">등록일</th>
                <th class="viewcount">조회수</th>
                <a href="<c:url value="/board/board/${n}/${offset}"/>"><button class="write">글쓰기</button></a>
            </tr>
            <c:forEach var="boardDto" items="${list}">
                <tr>
                    <td><a href="<c:url value="/board/read/${n}/${offset}/${boardDto.bno}"/>" >${boardDto.bno}</a></td>
                    <td>${boardDto.title}</td>
                    <td>${boardDto.writer}</td>
                    <td>${boardDto.reg_date}</td>
                    <td>${boardDto.viewcount}</td>
                    <td><a href="<c:url value="/board/board?bno=${boardDto.bno}"/>"><button>수정</button></a></td>
                </tr>

            </c:forEach>

        </table>
        <div>

            <a ${front>9 ? '':'hidden'} href="<c:url value="/board/list/${n-1}/${front*10-9}"/> "><</a>

            <c:forEach var="n" begin="${front}" end="${end > count ? count : end}">
                 <a style="background: ${now==n ? 'gray' : 'none'}" href="<c:url value="/board/list/${n}/${n*10+1}"/>"> ${n+1} </a>
            </c:forEach>
            <a ${end<count ? '':'hidden'} href="<c:url value="/board/list/${n+1}/${end*10+11}"/> ">></a>
        </div>
    </div>
</div>
</body>

</html>

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

</head>
<body>
<div class="menu">
	<div class="logo"><a href="<c:url value="/"/>">쇼핑몰 이름</a></div>
	<form action="<c:url value="/search"/> "method="post">
		<div class="search">
			<input name="search_in" class="search_in" type="text">
			<button>검색</button>
		</div>
	</form>

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
		<div class="goodsBox">
			<a ${logInId=='asdf' ?  '' :'hidden'} href="<c:url value="/goods/add"/> ">추가</a>
			<c:forEach var="goodsDto" items="${list}" varStatus="n" begin="0" end="4">
				<a class="goodsLink" href="<c:url value='/goods/read/${goodsDto.bno}'/>">
					<div class="goods">
						<img src="<c:url value='/image/${goodsDto.goodsimg}'/>" alt="">
						<div name="goodsname" class="goods_name"><c:out value="${goodsDto.goodsname}"/></div>
						<div name="price" class="price"><c:out value="${goodsDto.price}"/></div>
					</div>
				</a>
			</c:forEach>
		</div>
		<div class="goodsBox">
			<c:forEach var="goodsDto" items="${list}" varStatus="n" begin="5" end="9">
				<a class="goodsLink" href="<c:url value='/goods/read/${goodsDto.bno}'/>">
					<div class="goods">
						<img src="<c:url value='/image/${goodsDto.goodsimg}'/>" alt="">
						<div name="goodsname" class="goods_name"><c:out value="${goodsDto.goodsname}"/></div>
						<div name="price" class="price"><c:out value="${goodsDto.price}"/></div>
					</div>
				</a>
			</c:forEach>
		</div>
	</div>
</div>



</body>
</html>


<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="false"%>
<c:set var="logInId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}" />
<c:set var="loginOutLink" value="${logInId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="LogInOut" value="${logInId=='' ? '로그인' : '로그아웃'}"/>
<c:set var="registerLink" value="${logInId=='' ? '/register/add' : '/mypage/mypage'}"/>
<c:set var="registerMy" value="${logInId=='' ? '회원가입' : 'mypage'}"/>
<c:set var="cl_deli" value="${logInId=='asdf' ? '배송' : '주문 취소'}"/>
<html>
<head>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    <style>
        .mypage{
            display: flex;
            flex-direction: column;
        }
        .delivery{
            display: flex;
            flex-direction: column;

        }
        .btn{
            margin: auto;
            height: 50px;
        }
    </style>
    <title>MyPgae</title>
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
<div class="mypage">
    <h2>사용자 정보</h2>
        <label for="">아이디 : </label>
        <div>${userDto.id}</div>
        <label for="">이름</label>
        <div>${userDto.name}</div>
        <label for="">email : </label>
        <div>${userDto.email}</div>
        <label for="">우편번호</label>
        <div name="postcode" type="text" id="postcode">${addressDto.postcode}</div>
        <label for="">도로명주소</label>
        <div name="road_address"type="text" id="road_address">${addressDto.road_address}</div>
        <label for="">지번주소</label>
        <div name="jibun_address" type="text" id="jibun_address">${addressDto.jibun_address}</div>
        <span id="guide" style="color:#999;display:none"></span>
        <label for="">상세주소</label>
        <div name="detail_address" type="text" id="detail_address">${addressDto.detail_address}</div>
        <label for="">참고항목</label>
        <div name="extra_address" type="text" id="extra_address">${addressDto.extra_address}</div>
        <a href="<c:url value="/address/modify?toUrl=/mypage/mypage"/>"><button>수정</button></a>
</div>
<div class="delivery">
    <h2>결제 목록</h2>
    <div>배송 전</div>

        <div class="delivery">

            <c:forEach var="paymentDto" items="${incompleteList}">
                <form action="<c:url value="/payment/delivery"/> "method="post">
                <p>
                    <c:if test="${logInId=='asdf'}">
                        ${paymentDto.id}
                    </c:if>
                            | ${paymentDto.goodsname} | 가격 : ${paymentDto.price} | 개수 : ${paymentDto.count}
                            | 주소 : 우편번호 ${paymentDto.postcode} | 도로명주소 ${paymentDto.road_address}
                            | 지번주소 ${paymentDto.jibun_address}  | 상세주소 ${paymentDto.detail_address}
                            | 참고항목 ${paymentDto.extra_address}
                    <input name="bno" type="hidden" value="${paymentDto.bno}">
                    <input name="id" type="hidden" value="${paymentDto.id}">
                </p> <button class="btn" name="btn" value="${logInId=="asdf" ? 'true' : 'false'}">${cl_deli}</button>
                </form>
            </c:forEach>
        </div>

    <div style="border-top: 1px solid black">배송 완료</div>
    <div class="delivery">
        <c:forEach var="paymentDto" items="${completeList}">
            <p>
                <c:if test="${logInId=='asdf'}">
                    ${paymentDto.id}
                </c:if>
                ${paymentDto.goodsname} | 가격 : ${paymentDto.price} | 개수 : ${paymentDto.count}
                | 주소 : 우편번호 ${paymentDto.postcode} | 도로명주소 ${paymentDto.road_address}
                    | 지번주소 ${paymentDto.jibun_address}  | 상세주소 ${paymentDto.detail_address} | 참고항목 ${paymentDto.extra_address}
            </p>
        </c:forEach>
    </div>
    <form action="<c:url value="/mypage/withdrawal"/> " method="post">
        <button>회원탈퇴</button>
    </form>
</div>
</body>
</html>

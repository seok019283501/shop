<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page import="java.net.URLDecoder"%>
<%@ page session="false"%>
<c:set var="logInId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}" />
<c:set var="loginOutLink" value="${logInId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="LogInOut" value="${logInId=='' ? '로그인' : '로그아웃'}"/>
<c:set var="registerLink" value="${logInId=='' ? '/register/add' : '/mypage/mypage'}"/>
<c:set var="registerMy" value="${logInId=='' ? '회원가입' : 'mypage'}"/>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <title>Register</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
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

<form action="<c:url value="/regiser/add"/>" method="post">
    <div class="title">Register</div>
    <div id="msg">
        <c:if test="${not empty param.msg}">
            <i class="fa fa-exclamation-circle"> ${URLDecoder.decode(param.msg)}</i>
        </c:if>
    </div>
    <p>
        <label for="">아이디</label>
        <input type="text" name="id" placeholder="id">
        <label for="">비밀번호</label>
        <input type="password" name="psw">
        <label for="">이름</label>
        <input type="text" name="name">
        <label for="">생일</label>
        <input type="text"  name="birth" placeholder="yyyy-mm-dd">
        <label for="">휴대폰 번호 인증</label>
        <input type="text" name="phon" id="phon" placeholder="01012345678">
        <button id="phonBtn" name="phonBtn" type="button">인증번호 발송</button>
        <input type="text" name="certified" id="certified">
        <div id="result"></div>
        <button type="button" id="compare">확인</button>
        <label for="">email</label>
        <input type="text" name="email" placeholder="aaaa@aaa.com">
        <button id="register" type="button" onclick="register_check()">회원 가입</button>
    </p>
</form>



<script>
    function certified_check(){


    }
    function register_check(){
        if($("input[name=id]").val()==""){
            $("#msg").html("아이디를 적어주세요.")
            return false
        }else if($("input[name=psw]").val()==""){
            $("#msg").html("비밀번호를 적어주세요.")
            return false
        }else if($("input[name=name]").val()==""){
            $("#msg").html("이름을 적어주세요.")
            return false
        }else if($("input[name=birth]").val()==""){
            $("#msg").html("생일을 적어주세요.")
            return false
        }else if($("input[name=phon]").val()==""){
            $("#msg").html("전화번호를 적어주세요.")
            return false
        }else if($("input[name=certified]").val()==""){
            $("#msg").html("인증번호를 적어주세요.")
            return false
        }else if($("input[name=email]").val()==""){
            $("#msg").html("email을 적어주세요.")
            return false
        }
        $("form").submit();
    }
    $(document).ready(function(){
        $(document).on("click","#rePhonBtn",function (){
            if($("input[name=phon]").val()=="") {
                $("#msg").html("전화번호를 적어주세요.")
                return false
            }
            var param = $("#phon").val();
            $.ajax({
                type:'POST',
                url: '/shop/resend',
                headers : { "content-type": "application/json"},
                dataType: 'text',
                data: JSON.stringify(Number(param)),
                success : function (result){
                    hcertified=JSON.parse(result);
                    $("#hcert").val(hcertified);
                    alert("전송되었습니다.")
                },
                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
            });
        })
        $(document).on("click","#compare",function (){

            var certified = $("#certified").val()
            $.ajax({
                type:'POST',
                url: '/shop/compare',
                headers : { "content-type": "application/json"},
                dataType: 'text',
                data: JSON.stringify(Number(certified)),
                success : function (result){
                        $("#result").html("인증되었습니다.");
                },
                error   : function(){ alert("인증에 실패했습니다") } // 에러가 발생했을 때, 호출될 함수
            });

        })
        $(document).on("click","#phonBtn",function (){
            if($("input[name=phon]").val()=="") {
                $("#msg").html("전화번호를 적어주세요.")
                return false
            }
            var param = $("#phon").val();
            $.ajax({
                type:'POST',
                url: '/shop/send',
                headers : { "content-type": "application/json"},
                dataType: 'text',
                data: JSON.stringify(Number(param)),
                success : function (result){
                    hcertified=JSON.parse(result);
                    $("#hcert").val(hcertified);
                    $("#phonBtn").text("인증번호 재발송")
                    $("#phonBtn").attr('id','rePhonBtn')

                    alert("전송되었습니다.")
                },
                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
            });
        });
    });
</script>
</body>
</html>

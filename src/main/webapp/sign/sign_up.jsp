<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/header.css" />
<link rel="stylesheet" href="../resources/css/footer.css" />
<link rel="stylesheet" href="../resources/css/body.css" />
<link rel="stylesheet" href="../resources/css/sign/sign_up.css" />
<title>sign up</title>
</head>
<body>
    <!--include header-->
    <header></header>

    <div id="mc">
      <div id="mch">회원가입</div>
      <div id="mcp">회원정보를 입력해 주세요.</div>
      <form id="mcf" action="" method="post">
        <input type="text" id="mcf-id" placeholder="아이디를 입력해 주세요." />
        <div id="id-dupl">이미 존재하는 아이디입니다.</div>
        <input
          type="password"
          name=""
          id="mcf-p1"
          placeholder="비밀번호를 입력해 주세요."
        />
        <div id="pwd-check">
          비밀번호는 영문자, 숫자를 포함해 8 글자 이상을 입력해야합니다.
        </div>
        <input
          type="password"
          name=""
          id="mcf-p2"
          placeholder="비밀번호를 다시 입력해 주세요."
        />
        <div id="pwd-dupl">새 비밀번호가 일치하지 않습니다.</div>
        <input type="text" name="" id="" placeholder="이름을 입력해 주세요." />
        <input
          type="email"
          name=""
          id=""
          placeholder="이메일을 입력해 주세요."
        />

        <div id="mcf-cb">
          <input type="checkbox" name="" id="" />
          <p>이용약관 동의</p>
          <input type="checkbox" name="" id="" />
          <p>전자금융거래 이용약관 동의</p>
          <input type="checkbox" name="" id="" />
          <p>개인정보 수집 및 이용 동의</p>
        </div>
        <input type="submit" value="회원가입" />
      </form>
    </div>

    <!--include footer-->
    <footer></footer>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../report/js/jquery.js"></script>
<script type="text/javascript" src="../report/js/gdel.js"></script>
<link rel="stylesheet" type="text/css" href="../report/css/guest.css" />

<meta charset="UTF-8">
<title>MVC 방명록 삭제</title>
</head>
<body>
 <form method="post" action="guest_del_ok.do"
 onsubmit="return del_check();">
  <input type="hidden" name="guest_no" value="${gcont.no}" />
  <input type="hidden" name="page" value="${page}" />
  <table id="gDel_t" align="center" border="1">
   <tr>
    <th id="gDel_title" colspan="2">MVC 게시판 삭제</th>
   </tr>
   <tr>
    <th>비밀번호</th>
    <td>
    <input type="password" name="del_pwd" id="del_pwd"
    size="14" />
    </td>
   </tr>
   <tr>
    <th colspan="2">
    <input type="submit" value="삭제" />
    <input type="reset" value="취소" 
    onclick="$('#del_pwd').focus();" />
    <input type="button" value="뒤로" onclick="history.go(-1)">
    </th>
   </tr>
  </table>   
 </form>
</body>
</html>
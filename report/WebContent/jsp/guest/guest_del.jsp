<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 방명록 삭제</title>
<script src="./js/jquery.js"></script>
<script>
  function del_check(){
	  if($.trim($("#del_pwd").val())==""){
		  alert("비번을 입력하세요!");
		  $("#del_pwd").val("").focus();
		  return false;
	  }
  }
</script>
</head>
<body>
 <form method="post" action="guest_del_ok.do"
 onsubmit="return del_check();">
  <input type="hidden" name="guest_no" value="${gcont.no}" />
  <input type="hidden" name="page" value="${page}" />
  <table align="center" border="1">
   <tr>
    <th colspan="2">MVC 게시판 삭제</th>
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
    </th>
   </tr>
  </table>   
 </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿 get연습</title>
<script src="../js/jquery.js"></script>
<script src="../js/get.js"></script>
</head>
<body>
 <form method="get" action="/mvc/g2" onsubmit="return get_check();">
 <!-- <form method="get" action="/mvc/GetOK01" onsubmit="return get_check();"> -->
  <%-- method속성을 생략하면 기본값으로 get방식이다. --%>
  <table align="center" border="1">
   <tr>
    <th colspan="2">서블릿 get실습</th>
   </tr>
   <tr>
    <th>이름</th>
    <td><input name="name" id="name" size="14" /></td>
   </tr>
   <tr>
    <th>주소</th>
    <td>
    <input name="addr" id="addr" size="30" />
    </td>
   </tr>
   <tr>
    <th>폰번호</th>
    <td>
    <input name="phone" id="phone" size="24" />
    </td>
   </tr>
   <tr>
    <th>전자우편</th>
    <td>
    <input type="text" name="email" id="email" size="30" />
    </td>
   </tr>
   <tr>
    <th colspan="2">
    <input type="submit" value="get전송" />
    <input type="reset" value="취소"
    onclick="$('#name').focus();" />
    </th>
   </tr>
  </table>
 </form>
</body>
</html>
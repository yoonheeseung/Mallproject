<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>서블릿 post연습</title>
<script src="../js/jquery.js"></script>
<script>
function post_check(){
	if($.trim($("#name").val())==""){
		alert("이름을 입력하세요!");
		$(this).val("").focus();
		return false;
	}
	if($.trim($("#cont").val())==""){
		alert("내용을 입력하세요!");
		$(this).val("").focus();
		return false;
	}
	
	
	
}


</script>
</head>
<body>
<form method="post" action="/mvc/p" onsubmit="return post_check();">
<table align="center" border="1">
 <tr>
 <th colspan="2">서블릿 post연습</th>
 </tr>
 <tr>
 <th>이름</th>
 <td>
 <input name="name" id="name" size="14" />
 </td>
 </tr>
 <tr>
 <th>내용</th>
 <td>
 <textarea name="cont" id="cont" rows="9" cols="32" ></textarea>
 </td>
 </tr>
 <tr>
 <th colspan="2">
 <input type="submit" value="post전송" />
 <input type="reset" value="취소" onclick="$('#name').focus();"  />
 </th>
 </tr>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자단 공지내용</title>
</head>
<body>
<table align="center" border="1">
<tr>
<th colspan="2">공지내용</th>
</tr>
<tr>
<th>공지제목</th>
<td>${g.gongji_title}</td>
</tr>
<tr>
<th>공지내용</th>
<td>${gongji_cont}</td>
</tr>
<tr>
<th>조회수</th>
<td>${g.gongji_hit}</td>
</tr>
<tr>
<th colspan="2">
<input type="button" value="공지목록"
 onclick="location='gongji_list.html?page=${page}'" />
</th>
</tr>
</table>
</body>
</html>
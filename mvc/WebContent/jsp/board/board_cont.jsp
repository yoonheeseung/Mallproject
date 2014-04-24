<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC 게시판</title>
</head>
<body>
	<table align="center" border="1">
		<tr>
			<th colspan="2">MVC 게시판 내용보기</th>
		</tr>
		<tr>
			<th>제목</th>
			<td>${bcont.board_title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${bcont.board_cont}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${bcont.board_hit}</td>
		</tr>
		<tr>
			<th colspan="2"><input type="button" value="답변"
				onclick="location='board_cont.do?board_no=${bcont.board_no}&page=${page}&state=reply'" />

				<input type="button" value="수정"
				onclick="location='board_cont.do?board_no=${bcont.board_no}&page=${page}&state=edit'" />

				<input type="button" value="삭제"
				onclick="location='board_cont.do?board_no=${bcont.board_no}&page=${page}&state=del'" />

				<input type="button" value="목록"
				onclick="location='board_list.do?page=${page}'" /></th>
		</tr>


	</table>
</body>
</html>
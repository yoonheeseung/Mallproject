<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../report/js/jquery.js"></script>
<script type="text/javascript" src="../report/js/g.js"></script>
<link rel="stylesheet" type="text/css" href="../report/css/guest.css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC 게시판</title>
</head>
<body>
<div id="gCont_wrap">
	<table id="gCont_t" align="center" border="1">
		<tr>
			<th id="gCont_title" colspan="2">MVC 방명록 내용보기</th>
		</tr>
		<tr>
			<th >제목</th>
			<td id="gCont_t_title">${gcont.guest_title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td id="gCont_cont">${gcont.guest_cont}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td id="gCont_t_hit">${gcont.guest_hit}</td>
		</tr>
		<tr id="gCont_menu">
			<th colspan="2"><input class="inp" type="button" value="답변"
				onclick="location='guest_cont.do?guest_no=${gcont.no}&page=${page}&state=reply'" />

				<input class="inp" type="button" value="수정"
				onclick="location='guest_cont.do?guest_no=${gcont.no}&page=${page}&state=edit'" />

				<input class="inp" type="button" value="삭제"
				onclick="location='guest_cont.do?guest_no=${gcont.no}&page=${page}&state=del'" />

				<input class="inp" type="button" value="목록"
				onclick="location='guest_list.do?page=${page}'" /></th>
		</tr>
	</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 방명록</title>
<script type="text/javascript" src="../report/js/jquery.js"></script>
<script type="text/javascript" src="../report/js/g.js"></script>
<link rel="stylesheet" type="text/css" href="../report/css/guest.css" />
</head>
<body>
	<div id="bWrite_wrap">
		<h2 class="bWrite_title">MVC 방명록</h2>
		<form method="post" action="guest_write_ok.do"
			onsubmit="return write_check();">
			<table id="bWrite_t">
				<tr>
					<th>이름</th>
					<td><input name="guest_name" id="guest_name" size="14" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input name="guest_title" id="guest_title" size="36" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="guest_pwd" id="guest_pwd"
						size="14" /></td>
				</tr>
				<tr>
					<th>글내용</th>
					<td><textarea name="guest_cont" id="guest_cont" rows="9"
							cols="36"></textarea></td>
				</tr>

			</table>
			<div id="bWrite_menu">
				<input type="submit" value="저장" /> <input type="reset" value="취소"
					onclick="$('#guest_name').focus()" />
			    <input type="button" value="목록" 
			    onclick="location='guest_list.do?page=${page}'"/>
			</div>

		</form>

	</div>
</body>
</html>
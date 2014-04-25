<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MCV 방명록 수정</title>
<link rel="stylesheet" type="text/html" href="./css/guest.css" />
<script src="./js/jquery.js"></script>
<script src="./js/guest.js"></script>
</head>
<body>
	<div id="bEdit_wrap">
		<h2 class="bEdit_title">MVC 방명록 수정</h2>
		<form method="post" action="guest_edit_ok.do"
			onclick="return write_check();">
			<input type="hidden" name="guest_no" value="${gcont.guest_no}" /> 
			<inputtype="hidden" name="page" value="${page}" />
			<%--히든은 웹상에 만들어 지지 않는다. 글번호를 넘길 수 있다. --%>
			<table id="bEdit_t">
				<tr>
					<th>이름</th>
					<td><input name="guest_name" id="guest_name" size="14"
						value="${gcont.guest_name}" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input name="guest_title" id="guest_title" size="36"
						value="${gcont.guest_title}" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="guest_pwd" id="guest_pwd"
						size="14" /></td>
				</tr>
				<tr>
					<th>글내용</th>
					<td><textarea name="guest_cont" id="guest_cont" rows="9"
							cols="36">${gcont.guest_cont}</textarea></td>
				</tr>
			</table>
			<div id="bEdit_menu">
				<input type="submit" value="수정" /> <input type="reset" value="취소"
					onclick="${'#guest_name'}.focus();" />
			</div>
		</form>

	</div>
</body>
</html>
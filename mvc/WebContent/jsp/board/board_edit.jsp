<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MCV 게시판 수정</title>
<link rel="stylesheet" type="text/html" herf="./css/board.css" />
<script src="./js/jquery.js"></script>
<script src="./js/board.js"></script>
</head>
<body>
	<div id="bEdit_wrap">
		<h2 class="bEdit_title">MVC 게시판 수정</h2>
		<form method="post" action="board_edit_ok.do"
			onclick="return write_check();">
			<input type="hidden" name="board_no" value="${bcont.board_no}" /> 
			<inputtype="hidden" name="page" value="${page}" />
			<%--히든은 웹상에 만들어 지지 않는다. 글번호를 넘길 수 있다. --%>
			<table id="bEdit_t">
				<tr>
					<th>이름</th>
					<td><input name="board_name" id="board_name" size="14"
						value="${bcont.board_name}" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input name="board_title" id="board_title" size="36"
						value="${bcont.board_title}" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="board_pwd" id="board_pwd"
						size="14" /></td>
				</tr>
				<tr>
					<th>글내용</th>
					<td><textarea name="board_cont" id="board_cont" rows="9"
							cols="36">${bcont.board_cont}</textarea></td>
				</tr>
			</table>
			<div id="bEdit_menu">
				<input type="submit" value="수정" /> <input type="reset" value="취소"
					onclick="${'#board_name'}.focus();" />
			</div>
		</form>

	</div>
</body>
</html>
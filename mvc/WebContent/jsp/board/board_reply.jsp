<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변달기</title>
<script src="./js/jquery.js"></script>
<script src="./js/board.js"></script>
</head>
<body>
<form method="post" action="board_reply_ok.do" onsubmit="return write_check();">
<%--답변달기 폼 히든 값 --%>
<input type="hidden" name="board_no" value="${bcont.board_no}" />
<input type="hidden" name="board_ref" value="${bcont.board_ref}" /><%--글그룹번호 --%>
<input type="hidden" name="board_step" value="${bcont.board_step}" /><%--답변글 위치번호 --%>
<input type="hidden" name="board_level" value="${bcont.board_level}" /><%--답변글 레벨값 --%>

<%--페이징 관련 히든 --%>
<input type="hidden" name="page" value="${page}" />
<%-- 페이지 번호 값 --%>
<table align="center" border="1">
<tr>
<th colspan="2">답변 MVC 게시판 </th>
</tr>
<tr>
<th>이름</th>
<td>
<input name="board_name" id="board_name" size="14" />
</td>
</tr>
<tr>
<th>제목</th>
<td>
<input name="board_title" id="board_title" size="36" value="Re: ${bcont.board_title}" />
</td>
</tr>
<tr>
<th>비밀번호</th>
<td>
<input type="password" name="board_pwd" id="board_pwd" size="14" />
</td>
</tr>
<tr>
<th>내용</th>
<td>
<textarea name="board_cont" id="board_cont" rows="10" cols="35"></textarea>
</td>
</tr>
<tr>
<th colspan="2">
<input type="submit" value="답변" />
<input type="reset" value="취소" onclick="${'#board_name'}.focus();" />
</th>
</tr>
</table>
</body>
</html>
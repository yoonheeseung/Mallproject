<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변달기</title>
<script src="./js/jquery.js"></script>
<script src="./js/guest.js"></script>
</head>
<body>
<form method="post" action="guest_reply_ok.do" onsubmit="return write_check();">
<%--답변달기 폼 히든 값 --%>
<input type="hidden" name="guest_no" value="${gcont.no}" />
<input type="hidden" name="guest_ref" value="${gcont.guest_ref}" /><%--글그룹번호 --%>
<input type="hidden" name="guest_step" value="${gcont.guest_step}" /><%--답변글 위치번호 --%>
<input type="hidden" name="guest_level" value="${gcont.guest_level}" /><%--답변글 레벨값 --%>

<%--페이징 관련 히든 --%>
<input type="hidden" name="page" value="${page}" />
<%-- 페이지 번호 값 --%>
<table align="center" border="1">
<tr>
<th colspan="2">MVC 방명록 답변 </th>
</tr>
<tr>
<th>이름</th>
<td>
<input name="guest_name" id="guest_name" size="14" />
</td>
</tr>
<tr>
<th>제목</th>
<td>
<input name="guest_title" id="guest_title" size="36" value="Re: ${gcont.guest_title}" />
</td>
</tr>
<tr>
<th>비밀번호</th>
<td>
<input type="password" name="guest_pwd" id="guest_pwd" size="14" />
</td>
</tr>
<tr>
<th>내용</th>
<td>
<textarea name="guest_cont" id="guest_cont" rows="10" cols="35"></textarea>
</td>
</tr>
<tr>
<th colspan="2">
<input type="submit" value="답변" />
<input type="reset" value="취소" onclick="${'#guest_name'}.focus();" />
</th>
</tr>
</table>
</body>
</html>
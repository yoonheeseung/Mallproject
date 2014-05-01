<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- JSTL 태그라이브러리 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
<link rel="stylesheet" type="text/css" src="./css/index.css" />
</head>
<body>
	<div id="index_rwap">
		<h2 class="index_title">최신공지목록 5개 보기</h2>
		<table id="index_t">
			<tr>
				<th>공지제목</th>
				<th>날짜</th>
			</tr>
			<c:if test="${!empty glist}">
				<c:forEach var="g" items="${glist}">
					<tr>
					<th>
						<%-- <th>
						<a href="gongji_cont.html?no=${g.gongji_no}">${g.gongji_title}</a></th> --%>
						<a href="gongji_cont.html?no=${g.gongji_no}">
						${g.gongji_no}
						<c:if test="${fn:length(g.gongji_title) >16 }">
						  ${fn:substring(g.gongji_title,0,16)}...
						  <%--공지제목을 0이상 16미만 사이의 제목만 출력하고 나머지는 ...으로 표현 --%>
						</c:if>
						<c:if test="${fn:length(g.gongji_title) < 16 }">
						  ${g.gongji_title}
						  <%--공지제목을 0이상 16미만 사이의 제목만 출력하고 나머지는 ...으로 표현 --%>
						</c:if>
						</a>
						</th>
						<th>${g.gongji_date}</th>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty glist}">
				<tr>
					<th colspan="2">공지목록이 없습니다</th>
				</tr>
			</c:if>
		</table>
	</div>
</body>
</html>
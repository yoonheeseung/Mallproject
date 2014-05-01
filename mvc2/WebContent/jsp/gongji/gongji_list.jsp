<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<link rel="stylesheet" type="text/css" href="./css/admin.css" />

<!-- 관리자 메인 본문 -->
<div id="bIndex_cont">
	<div id="aGongji_list">
		<h2 class="aGongji_title" align="center">공지목록</h2>
		<div class="aGongji_count">게시물수: ${listcount}개</div>
		<%--복사 시작 --%>
		<table id="aGongji_t3">
			<tr>
				<th width="6%">번호</th>
				<th width="40%">제목</th>
				<th width="14%">작성자</th>
				<th width="17%">작성일</th>
				<th width="10%">조회수</th>
			</tr>

			<c:if test="${!empty glist}">
				<c:forEach var="list" items="${glist}">
					<tr>
						<td align="center">
						${list.gongji_no}</td>

						<td align="left">
<a	href=
"gongji_cont.html?no=${list.gongji_no}&page=${page}">${list.gongji_title}</a>
							<%-- 복수개 피마미터 값을 GET방식으로 넘기는 법.
              *.html?피라미터이름=값&피라미터이름=값&... &기호로 구분해서
              값을 넘김. --%></td>

						<td align="center">${list.gongji_name}</td>
						<td align="center">${list.gongji_date}</td>
						<td align="center">${list.gongji_hit}</td>
					</tr>
				</c:forEach>
			</c:if>

			<c:if test="${empty glist}">
				<tr>
					<th colspan="5">공지목록이 없습니다!</th>
				</tr>
			</c:if>
		</table>

		<!-- 자료실 페이징 추가 -->
		<div id="bList_paging">

			<!-- 일반 페이징 -->
			<c:if test="${(empty find_field) && (empty find_name)}">
				<c:if test="${page <= 1 }">
			[이전]&nbsp;
			</c:if>
				<c:if test="${page > 1 }">
					<a href="gongji_list.html?page=${page-1}">[이전]</a>&nbsp;
			</c:if>


				<c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
					<c:if test="${a == page}">
					<${a}>
					<%--페이지 번호 클릭 선택시 실행되는 부분 --%>
					</c:if>

					<c:if test="${a != page}">
						<%-- 페이지번호가 선택되지 않았을때 실행되는 부분 --%>
						<a href="gongji_list.html?page=${a}">[${a}]</a>&nbsp;
				</c:if>
					<!-- 쪽번호 출력되는 부분 -->
				</c:forEach>


				<c:if test="${page >= maxpage}">
			 [다음]
			</c:if>
				<c:if test="${page < maxpage }">
					<a href="gongji_list.html?page=${page+1}">[다음]</a>
				</c:if>
			</c:if>
		</div>
	</div>
</div>


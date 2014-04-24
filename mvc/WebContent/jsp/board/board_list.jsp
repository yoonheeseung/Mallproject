<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<%-- html5 문서정의 태그 --%>
<html>
<head>
<meta charset="UTF-8">
<%-- html5 언어코딩 타입 설정 부분 --%>
<title>MVC 게시판 목록</title>
<link rel="stylesheet" type="text/css" href="./css/board.css" />
</head>
<body>
 <div id="bList_wrap">
  
    <h2 class="bList_title">게시판 목록</h2>
    <div class="bList_count">글개수:${listcount}</div>
    <table id="bList_t">
      <tr class="table_title">
        <th width="6%" height="26">번호</th> 
        <th width="50%">제목</th> 
        <th width="14%">작성자</th> 
        <th width="17%">작성일</th> 
        <th width="14%">조회수</th>
      </tr>
      
      <c:if test="${!empty boardlist}">
        <c:forEach var="list" items="${boardlist}">
          <tr>
            <td align="center">
              <c:if test="${list.board_step == 0}">
              <%--원본글일때만 글그룹번호를 출력하게 한다. --%>
                ${list.board_ref}
              </c:if>
              &nbsp;
            </td>
            
            <td class="left_box" align="left">
              <c:if test="${list.board_step !=0 }">
              <%--답변글일때만 실행 --%>
                <c:forEach begin="1" end="${list.board_step}" step="1">
                <!-- 답변글 달때마다 1부터 시작해서 1씩증가하는
                JSTL 반복문.들여쓰기 -->
                  &nbsp;
                </c:forEach>
                <img src="./images/AnswerLine.gif"/>
                <%--답변글 이미지 출력 --%>
              </c:if>
              <a href="board_cont.do?board_no=${list.board_no}&page=${page}&state=cont"
              >${list.board_title}</a>
              <%-- 복수개 피마미터 값을 GET방식으로 넘기는 법.
              *.do?피라미터이름=값&피라미터이름=값&... &기호로 구분해서
              값을 넘김. --%>
            </td>
            
            <td align="center">${list.board_name}</td>
	  		<td align="center">${list.board_date}</td>	
	  		<td align="center">${list.board_hit}</td>
          </tr>
        </c:forEach>
      </c:if>
      
      <c:if test="${empty boardlist}">
        <tr>
          <th colspan="5">목록이 없습니다!!</th>
        </tr>
      </c:if>
    </table>
    
    <!-- 자료실 페이징 추가 -->
	<div id="bList_paging">  
	      
	      <!-- 일반 페이징 -->
	      <c:if test="${(empty find_field) && (empty find_name)}">
			<c:if test = "${page <= 1 }">
			[이전]&nbsp;
			</c:if>
			<c:if test = "${page > 1 }">
			<a href="board_list.do?page=${page-1}">[이전]</a>&nbsp;
			</c:if>	
			
			
			<c:forEach  var="a" begin = "${startpage}" end = "${endpage}" step = "1">
			 	<c:if test = "${a == page}">
					<${a}>
					<%--페이지 번호 클릭 선택시 실행되는 부분 --%>
				</c:if>
				
                <c:if test = "${a != page}">
                <%-- 페이지번호가 선택되지 않았을때 실행되는 부분 --%>
				 <a href="board_list.do?page=${a}">[${a}]</a>&nbsp;
				</c:if>
				<!-- 쪽번호 출력되는 부분 -->
			</c:forEach>	
			
			
			<c:if test = "${page >= maxpage}">
			 [다음]
			</c:if>
			<c:if test = "${page < maxpage }">
			 <a href="board_list.do?page=${page+1}">[다음]</a>
			</c:if>
	      </c:if> 		
	</div>
	
	<div id="bListW_menu">
	   	<input type="button" value="글쓰기" class="input_b"
		onclick="location='board_write.do?page=${page}'" />		
   </div>
  </div>   
</body>
</html>
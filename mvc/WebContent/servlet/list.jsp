<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*,java.util.*" %>
<%
  List<PostBean> list=(List<PostBean>)request.getAttribute("list");
  out.println(list.size()+"개");//목록갯수 출력
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>서블릿으로 목록보기</title>
</head>
<body>
 <table align="center" border="1">
<tr>
<th>번호</th> <th>이름</th> <th>내용</th>
</tr>
<%
 if((list !=null) && (list.size()>0)){
	 for(PostBean p:list){
%>
<tr>
<th><%=p.getNo()%></th>
<th><%=p.getName()%></th>
<th><%=p.getCont()%></th>
</tr>
<% }}else{%>
<tr>
<th colspan="3">목록이 없습니다.</th>
</tr>
<%}%>
</table>
</body>
</html>
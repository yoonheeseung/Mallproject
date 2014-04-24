<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="score" value="<%=new int[]{90,100,80,85,95,75} %>"/>

<c:forEach var="s" items="${score}" begin="0" end="5">
	${s}&nbsp;
	<c:set var="tot" value="${tot+s}" />
</c:forEach>
<hr/>
점수의 총합=><c:out value="${tot}"/>
<hr/>
** 홀 수 **<br/>
<c:forEach var="i" begin="1" end="10" step="2">
	${i}&nbsp;
</c:forEach>
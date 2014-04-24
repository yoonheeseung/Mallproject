<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="msg" value="${'안녕하세요'}" />

<c:set var="age">
${30}
</c:set>

<c:set var="user" value="<%=new model.User()%>" />
<!-- user객체 생성 -->
<c:set target="${user}" property="firstName" value="${'홍'}" />
<c:set target="${user}" property="lastName">${'길동'}</c:set>

<c:out value="${msg}" />
<c:out value="${user.firstName}" />
<c:out value="${user.lastName}" />
<%-- JSTL에서 출력할려면 <c:out value />로 한다.(월말평가) --%>
<hr />
나이는?
<c:out value="${age}" />

<hr />

<c:catch var="errmsg">
예외 발생 전
<%=1 / 0%>
</c:catch>

<hr>
<c:out value="${errmsg}" /><br>
예외 발생 후
<%-- 자바에서 1 즉 숫자를 0으로 나누면 예외가 발생 --%>

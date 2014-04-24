<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="test" value="../images/a.jpg"/><%--value속성값을 test에 저장 --%>
<h3><c:out value="${test }" /></h3>
<img src="${test}" width="100" height="100" />

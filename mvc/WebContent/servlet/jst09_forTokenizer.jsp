<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forTokens var="city" items="서울,부산,대전,대구,부산,광주,평양" delims=",">
<c:out value="${city }" /><br/>
</c:forTokens>
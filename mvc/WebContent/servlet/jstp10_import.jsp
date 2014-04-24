<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="http://localhost:8787/mvc/servlet/name.jsp" var="data" />
<%-- name.jsp 출력결과물을 data에 저장 --%>
${data}

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="fruit" value="${param.name}" />
<%-- 웹주소창에 *.jsp?name=값 형태의 get방식으로 값을 넘기면 fruit에 저장한다. --%>

 파라미터 name에 실려온 값=>
 <c:if test="${!empty fruit }">
  <c:out value="${fruit}" />
  </c:if>
  
  <hr/>
  
  <c:choose>
    <c:when test="${fruit=='apple' }">
    <c:out value="${fruit}" />:사과
    </c:when>
    <c:when test="${fruit=='banana' }">
    <c:out value="${fruit}" />:바나나
    </c:when>
    <c:when test="${fruit=='orange' }">
    <c:out value="${fruit}" />:오렌디
    </c:when>
    <c:otherwise> 해당 사항 없음 </c:otherwise>

  </c:choose>
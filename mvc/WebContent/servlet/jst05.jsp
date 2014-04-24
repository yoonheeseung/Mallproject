<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%--
 JSTL은 JSP Standard Tag Libary의 약자이다. xml기반으로 작성되어 있기 때문에
 엄격한 형 검사를 한다.JSTL을 커스텀 태그라고한다.
 EL 즉 표현언어는 *.jar 라이브러리 파일이 없어도 실행 되지만 JSTL은 반드시
 라이브러리 파일이 있어야 실행이 된다.
 JSTL 라이브러리 다운로드 주소는 :jakarta.apache.org

 --%>    
<jsp:useBean id="user" class="model.User"/>
<jsp:setProperty name="user" property="firstName" value="홍" />
<jsp:setProperty name="user" property="lastName" value=" 길동" />

<form>
  <table align="center" border="1">
  <tr>
  <th colspan="2">jsp 스크립트릿과 표현식 문법(mvc에서는 권장사항 아님)</th>
  </tr>
  <% if(user.getFirstName() !=null){ %>
 	 <tr>
 	 <th>성</th>
 	 <td>
 	 <input name="firstName" size="3" value="<%=user.getFirstName() %>" />
 	 </td>
 	 </tr>
  <% } %>
  <% if(user.getLastName() !=null){ %>
  <tr>
  <th>이름</th>
  <td><input name="lastName" size="10" value="<%=user.getLastName() %>" />
  </td>
  </tr>
  <%} %>
  <hr/>
  <table align="center" border="1">
  <tr>
  <th colspan="2">JTSL</th>
  </tr>
  
  <c:if test="${!empty user.firstName}">
  <tr>
  <th>성</th>
  <td><input name="firstName" size="3" value="${user.firstName}" /></td>
  </tr>
  </c:if>
  
  <c:if test="${!empty user.lastName}">
   <tr>
   <th>이름</th>
   <td><input name="lastName" size="10" value="${user.lastName}" /></td>
   </tr>
  </c:if>
  </table>
 </form>
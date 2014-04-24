<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%-- JSTL 데이터베이스 연동을 하려면 sql 테그 라이브러리를 추가한다. --%>

<sql:setDataSource var="con" driver="oracle.jdbc.OracleDriver"
							  url="jdbc:oracle:thin:@127.0.0.1:1521:xe"
							  user="hr"
							  password="123456" />
							  
<sql:update dataSource="${con}">
 insert into test values(1,'홍길동')
</sql:update>							  

<sql:update dataSource="${con}">
 insert into test values(2,'유관순')
</sql:update>							  

<sql:query var="rs" dataSource="${con}">
  select * from test
</sql:query>							  

<c:forEach var="data" items="${rs.rows}">
${data['num']}
${data['name']}<br/>
</c:forEach>


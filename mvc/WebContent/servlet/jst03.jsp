<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>[유즈빈 액션태그와 표현언어]</h3>
<hr/>
<jsp:useBean id="user" class="model.User" />
<%-- jsp 유즈빈 액션태그이다. 자바코드로 표현하면 model.User user= new model.User();
와 같다. 즉 새로운 객체 user를 만듬 --%>
<jsp:setProperty name="user" property="firstName" value="홍" /><%-- firstName변수에 "홍" 값을 저장--%>
<jsp:setProperty name="user" property="lastName" value="길동" />

"성:"<jsp:getProperty name="user" property="firstName" /><br/>
"이름:"<jsp:getProperty name="user" property="lastName" />

<hr/>
"성:"${user.firstName}<br>"이름:"${user.lastName}
<hr/>
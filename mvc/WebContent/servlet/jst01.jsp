<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>표현언어 에서 사용가능한 자료형타입</h3>
<%-- 표현언어(Expression Language:EL어라고 한다.)--%>
[1] 정수형 : ${10} <hr/>
[2] 실수형 : ${7.9} <hr/>
[3] 문자열형 : ${"홍길동"} <hr/>
[4] 논리형 : ${true} <hr/>
<%--
    표현언어 즉 EL에서는 출력할때 JSP문법인 <%= 표현식을 사용하지 않고 
   ${}로 출력한다. MVC는 일명 모델2라고 한다.
   M은 Model의 약자고,
   V는 화면에 보여지는 *.jsp 뷰페이지 영역 즉,View의 약자고,
   Controller은 모델과 뷰의 분기 제어 역할을 한다.
   MVC게시판 뷰페이지 표현문법은 
   EL(표현언어)와 JSTL(커스텀태그)을 사용한다.
 --%>
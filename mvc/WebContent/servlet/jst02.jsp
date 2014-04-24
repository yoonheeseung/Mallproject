<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h3>[표현언어 연산자]</h3>
    ${5+2}:${5+2}<hr/>
    ${5/2}:${5/2}<hr/>
  <%-- 자바에서는 나눗셈을 하면 몫만 구하지마느 EL에서는 몫과 나머지까지 구함 --%>
  ${5 mod 2}:${5 mod 2}<hr/>
  <%-- mod는 나머지를 구함 --%>
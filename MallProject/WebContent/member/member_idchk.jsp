<%@ page contentType="text/html; charset=euc-kr" %>
<%
	String id=(String)request.getAttribute("id");
	int check=((Integer)(request.getAttribute("check"))).intValue();
%>
<html>
<head>
<title>���θ�</title>
<script>
function windowclose(){
	opener.document.joinform.MEMBER_ID.value="<%=id %>";
	self.close();
}
</script>
</head>
<body bgcolor="#f5f5f5">
<% if(check == 1){ %>
<table width="360" border="0" cellspacing="0" cellpadding="5">
	<tr align="center">
	<td height="30">
		<font size="2"><%=id %> �� �̹� ��� ���� ���̵��Դϴ�.</font>
	</td>
	</tr>
</table>

<form action="./MemberIDCheckAction.me" method="post" name="checkForm" >
<table width="360" border="0" cellspacing="0" cellpadding="5">
	<tr>
	<td align="center">
		<font size="2">�ٸ� ���̵� �����ϼ���.</font><p>
		<input type="text" size="10" maxlength="12" name="MEMBER_ID"/>
		<input type="submit" value="�ߺ�Ȯ��" />
	</td>					
	</tr>
</table>
</form>
<% }else{ %>
<table width="360" border="0" cellspacing="0" cellpadding="5">
	<tr>
		<td align="center">
		<font size="2">�Է��Ͻ� <%=id %> �� ����� �� �ִ� ���̵��Դϴ�.</font>
		<br/><br/>
		<input type="button" value="�ݱ�" onclick="windowclose()" />
		</td>
	</tr>
</table>
<% } %>
</body>
</html>
<%@ page contentType="text/html; charset=euc-kr" %>
<% 
	String id=(String)request.getAttribute("id"); 
	String passwd=(String)request.getAttribute("passwd"); 
%>

<html>
<head>
<script>
function windowclose(){
	self.close();
}
</script>
</head>
<body>
<table width="450px" height="35px">
	<tr><td align="left">
	<b>���̵�/��й�ȣ ã��</b>
	</td></tr>
</table>
	
<table width="440px">
	<thead>�˻��� ���̵�/��й�ȣ�Դϴ�.<br/><br/><br/></thead>
	<tr><td align="left">���̵� : <%=id %></td></tr>
	<tr><td align="left">��й�ȣ : <%=passwd %></td></tr>
</table>

<table width="450px">
	<tr>
		<td align="center">	
			<hr/><br/><input type="button" value="�ݱ�" onclick="windowclose()"/>
		</td>
	</tr>
</table>
</body>
</html>
<%@ page contentType="text/html; charset=euc-kr"%>
<html>
<head>
<title>���θ�</title>
<script>
function check(){
	var id=loginform.MEMBER_ID.value;
	var pass=loginform.MEMBER_PW.value;
	
	if(id.length == 0){
		alert("���̵� �Է��ϼ���.");
		loginform.MEMBER_ID.focus();
		return false;
	}
	if(pass.length == 0){
		alert("��й�ȣ�� �Է��ϼ���.");
		loginform.MEMBER_PW.focus();
		return false;
	}
	
	return true;
}
function openConfirmId(loginform){	
	var url="./MemberFind.me";
	open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,"+
						 "scrollbars=no,resizable=no,width=450px,height=300");
}
</script>
</head>
<body>
<table width="960" cellspacing="0" cellpadding="0" border="0"
	align="center">
<tr>
<td colspan=2 align=center>
<table border=0 cellpadding=0 cellspacing=0 width=500>
<!--ȸ�� �α��� -->
<tr>
<form action="./MemberLoginAction.me" method=post name=loginform
	onsubmit="return check()">
<td><br><br>
<table width="400" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td bgcolor="f6f6f6">
		<table width="400" border="0" cellspacing="4" cellpadding="0">
		<tr>
		<td valign="top" bgcolor="#FFFFFF">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
		<td align="center">
		<table cellpadding=0 cellspacing=0 border=0>
			<tr>
			<td width=73>���̵�</td>
			<td width=9>:</td>
			<td width=103>
				<input type=text name="MEMBER_ID" size=12 maxlength=20>
			</td>
			<td width=66 rowspan=3><input type="submit" value="�α���">
			</td>
			<td width=26 rowspan=3></td>
			</tr>
			<tr>
			<td height=4 colspan=3></td>
			</tr>
			<tr>
			<td width=73>��й�ȣ</td>
			<td width=9>:</td>
			<td width=103>
			<input type=password name="MEMBER_PW" size=12 maxlength=12>
			</td>
			</tr>
			<tr>
			<td height=35 colspan=6 align="center">
			<input
				type="button" value="ȸ������"
				onclick="javascript:window.location='./MemberJoin.me'">
			<a href="#">
			<input type="button" value="���̵�/��й�ȣ ã��"
				onclick="openConfirmId(this.form)">
			</a>
			</td>
			</tr>
		</table>
		</td>
		</tr>
		<tr>
			<td style="padding: 15 0 15 70;">
			<table width="400" border="0" cellspacing="0" cellpadding="0">
				<tr>
				<td width="8"><img src="#" width="8" height="7">
				</td>
				<td width="392">
				<font size=2 color="565656">
				���̵� ���� ��� 'ȸ������'�� Ŭ���Ͻʽÿ�.
				</font>
				</td>
				</tr>
				<tr>
				<td><img src="#" width="8" height="7"></td>
				<td>
				<font size=2 color="565656">
				���̵� �Ǵ� ��й�ȣ�� �ؾ������ ��� '���̵�/��й�ȣ ã��'�� Ŭ���Ͻʽÿ�.
				</font>
				</td>
				</tr>
			</table>
			</td>
		</tr>
		</table>
		</td>
		</tr>
		</table>
		</td>
	</tr>
</table>
</td>
</form>
</tr>
</table>
<!-- ȸ�� �α��� -->
</td>
</tr>
</table>
</body>
</html>
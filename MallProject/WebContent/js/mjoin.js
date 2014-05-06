/**
 *  member_join.jsp jquery
 */
 function check(){
	var id=joinform.MEMBER_ID.value;
	var password1=joinform.MEMBER_PW.value;
	var password2=joinform.MEMBER_PW2.value;	
	var email1=joinform.MEMBER_EMAIL1.value;
	var email2=joinform.MEMBER_EMAIL2.value;
	var phone=joinform.MEMBER_PHONE.value;
	var addr1=joinform.MEMBER_ADDR1.value;
	var addr2=joinform.MEMBER_ADDR2.value;
	var mobile=joinform.MEMBER_MOBILE.value;
	
	var forms = document.getElementById("joinform");

	if ((forms.MEMBER_NAME.value=="")||(forms.MEMBER_NAME.value.length<=1)){
		alert("이름을 제대로 입력해 주세요.");
		forms.MEMBER_NAME.focus();
         		return false;
	}
	if(id.length == 0){
		alert("아이디를 입력하세요.");
		joinform.MEMBER_ID.focus();
		return false;
	}
	if(password1.length == 0){
		alert("비밀번호를 입력하세요.");
		joinform.MEMBER_PW.focus();
		return false;
	} 
	if(password1 != password2){
		alert("비밀번호가 일치하지 않습니다.");
		joinform.MEMBER_PW.value="";
		joinform.MEMBER_PW2.value="";
		joinform.MEMBER_PW.focus();
		return false;
	}
	if((forms.MEMBER_JUMIN1.value=="")||(forms.MEMBER_JUMIN1.value.length<6)){
		alert("주민등록번호 앞의 6자리를 입력해 주세요.");
      	forms.MEMBER_JUMIN1.focus();
        return false;
 	}
 	if((forms.MEMBER_JUMIN2.value=="")||(forms.MEMBER_JUMIN2.value.length<7)){
		alert("주민등록번호 뒤의 7자리를 입력해 주세요.");
      	forms.MEMBER_JUMIN2.focus();
        return false;
	} 
	if(email1.length == 0 || email2.length ==0){
		alert("이메일을 제대로 입력하세요.");
		joinform.MEMBER_EMAIL1.focus();
		return false;
	}
	if(phone.length == 0){
		alert("집 전화를 입력하세요.");
		joinform.MEMBER_PHONE.focus();
		return false;
	} 
	if((forms.MEMBER_ZIPCODE1.value=="")||(forms.MEMBER_ZIPCODE1.value.length<3)){
		alert("우편번호 앞의 3자리를 입력해 주세요.");
      	forms.MEMBER_ZIPCODE1.focus();
        return false;
 	}
 	if((forms.MEMBER_ZIPCODE2.value=="")||(forms.MEMBER_ZIPCODE2.value.length<3)){
		alert("우편번호 뒤의 3자리 입력해 주세요.");
      	forms.MEMBER_ZIPCODE2.focus();
        return false;
	}  
	if(addr1.length == 0){
		alert("집 주소를 입력하세요.");
		joinform.MEMBER_ADDR1.focus();
		return false;
	} 
	if(addr2.length == 0){
		alert("상세 주소를 입력하세요.");
		joinform.MEMBER_ADDR2.focus();
		return false;
	} 
	if(mobile.length == 0){
		alert("휴대폰 번호를 입력하세요.");
		joinform.MEMBER_MOBILE.focus();
		return false;
	}
	
	return true;
}

function openConfirmId(joinform){			
	var id=joinform.MEMBER_ID.value;
	var url="./MemberIDCheckAction.me?MEMBER_ID="+joinform.MEMBER_ID.value;
	
	if(id.length == 0){
		alert("아이디를 입력하세요.");
		joinform.MEMBER_ID.focus();
		return false;
	}
	open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,"+
						 "scrollbars=no,resizable=no,width=400,height=200");
}

function openZipcode(joinform){			
	var url="./Zipcode.me"
	open(url, "confirm", "toolbar=no,location=no,"
						+"status=no,menubar=no,"
						+"scrollbars=yes,resizable=no,"
						+"width=410,height=400");
}	

function gNumCheck(){
	if(event.keyCode >=48 && event.keyCode <=57) {
		return true;
	}else{
		event.returnValue=false;	
	}
}
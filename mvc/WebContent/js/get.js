/**
 * get.js
 */

function get_check(){
	if($.trim($("#name").val())==""){
		alert("이름을 입력하세요!");
		$("#name").val("").focus();
		return false;
	}
	if($.trim($("#addr").val())==""){
		alert("주소를 입력하세요!");
		$("#addr").val("").focus();
		return false;
	}
	if($.trim($("#phone").val())==""){
		alert("폰번호를 입력하세요!");
		$("#phone").val("").focus();
		return false;
	}
	if($.trim($("#email").val())==""){
		alert("전자우편을 입력하세요!");
		$("#email").val("").focus();
		return false;
	}
}

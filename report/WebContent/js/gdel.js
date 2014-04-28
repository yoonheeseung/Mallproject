/**
 * 
 */

$(document).ready(function(){
	$("#del_pwd").focus();
});

  function del_check(){
	  if($.trim($("#del_pwd").val())==""){
		  alert("비번을 입력하세요!");
		  $("#del_pwd").val("").focus();
		  return false;
	  }
  }


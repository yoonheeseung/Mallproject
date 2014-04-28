package com.mtory.action;


public class ActionForward {
	private boolean isRedirect=false;
	private String path=null;//이동경로 뷰페이지가 저장
	
	public boolean isRedirect(){
		return isRedirect;
	}
	
	public String getPath(){
		return path;
	}
	
	public void setRedirect(boolean b){
		isRedirect=b;
	}
	
	public void setPath(String string){
		path=string;
	}
}
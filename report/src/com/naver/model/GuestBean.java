package com.naver.model;

public class GuestBean {
	private int no;
	private String guest_name;
	private String guest_title;
	private String guest_pwd;
	private String guest_cont;
	private int guest_hit;
	private int guest_ref;
	private int guest_step;
	private int guest_level;
	private String guest_date;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getGuest_name() {
		return guest_name;
	}

	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}

	public String getGuest_title() {
		return guest_title;
	}

	public void setGuest_title(String guest_title) {
		this.guest_title = guest_title;
	}

	public String getGuest_pwd() {
		return guest_pwd;
	}

	public void setGuest_pwd(String guest_pwd) {
		this.guest_pwd = guest_pwd;
	}

	public String getGuest_cont() {
		return guest_cont;
	}

	public void setGuest_cont(String guest_cont) {
		this.guest_cont = guest_cont;
	}

	public int getGuest_hit() {
		return guest_hit;
	}

	public void setGuest_hit(int guest_hit) {
		this.guest_hit = guest_hit;
	}

	public int getGuest_ref() {
		return guest_ref;
	}

	public void setGuest_ref(int guest_ref) {
		this.guest_ref = guest_ref;
	}

	public int getGuest_step() {
		return guest_step;
	}

	public void setGuest_step(int guest_step) {
		this.guest_step = guest_step;
	}

	public int getGuest_level() {
		return guest_level;
	}

	public void setGuest_level(int guest_level) {
		this.guest_level = guest_level;
	}

	public String getGuest_date() {
		return guest_date.substring(0,10);
	}

	public void setGuest_date(String guest_date) {
		this.guest_date = guest_date.substring(0, 10);
	}

}

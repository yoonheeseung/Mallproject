package com.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.member.model.MemberBean;

public class MemberDAO {
	DataSource ds;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String instSql="insert into member values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public MemberDAO() {
		try{
			Context initCtx=new InitialContext();
			ds= (DataSource) initCtx.lookup("java:comp/env/jdbc/xe");
			con=ds.getConnection();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	//회원저장
	public boolean insertMember(MemberBean b) {
		try{
			pstmt=con.prepareStatement(instSql);
			
			pstmt.setString(1, b.getMEMBER_ID());
			pstmt.setString(2, b.getMEMBER_PW());
			pstmt.setString(3, b.getMEMBER_NAME());
			pstmt.setInt(4, b.getMEMBER_JUMIN1());
			pstmt.setInt(5, b.getMEMBER_JUMIN2());
			pstmt.setString(6, b.getMEMBER_EMAIL());
			pstmt.setString(7, b.getMEMBER_EMAIL_GET());
			pstmt.setString(8, b.getMEMBER_MOBILE());
			pstmt.setString(9, b.getMEMBER_PHONE());
			pstmt.setString(10, b.getMEMBER_ZIPCODE());
			pstmt.setString(11, b.getMEMBER_ADDR1());
			pstmt.setString(12, b.getMEMBER_ADDR2());
			pstmt.setInt(13, b.getMEMBER_ADMIN());
			pstmt.setTimestamp(14, b.getMEMBER_JOIN_DATE());
			
			pstmt.executeUpdate();
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return false;
	}


}

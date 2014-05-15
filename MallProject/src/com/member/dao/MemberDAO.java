package com.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	String userChekSql="select MEMBER_PW from member where MEMBER_ID=?";
	String isAdmSql="select MEMBER_ADMIN from MEMBER where MEMBER_ID=?";
	String memberCheckSql="select MEMBER_ID from member where MEMBER_ID=? ";
	String memberFindSql="select MEMBER_ID, MEMBER_PW, MEMBER_JUMIN1,MEMBER_JUMIN2 from member where MEMBER_NAME=?";
	String getMemberSql="select * from member where MEMBER_ID=?";
		
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

	//회원여부확인
	public int userCheck(String id, String pass) {
		String sql=null;
		int x=-1;
		
		try{
			pstmt=con.prepareStatement(userChekSql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				String memberpw=rs.getString("MEMBER_PW");	
				if(memberpw.equals(pass)){
					x=1;
				}else{
					x=0;
				}
			}else{
				x=-1;
			}
			
			return x;
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return -1;
	}

	public boolean isAdmin(String id) {
		int member_admin=0;
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(isAdmSql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
			member_admin=rs.getInt("MEMBER_ADMIN");
			if(member_admin==1){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		return false;
	}

	public int confirmId(String id) {
		int x=-1;
		
		try{
			pstmt=con.prepareStatement(memberCheckSql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				x=1;
			}else{
				x=-1;
			}
			
			return x;
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return -1;
	}

	public List searchZipcode(String searchdong) {
			String sql="select * from zipcode where dong like ?";
			List zipcodeList=new ArrayList();
			System.out.println("searchdong: "+searchdong);
			try{
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, "%"+searchdong+"%");
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					String sido=rs.getString("sido");
					String gugun=rs.getString("gugun");
					String dong=rs.getString("dong");  
					String ri=rs.getString("ri"); 
					String bunji=rs.getString("bunji");
					if(ri == null) ri="";
					if(bunji == null) bunji="";
					
					String zipcode=rs.getString("zipcode");
					String addr=sido+ " "+gugun+ " "+dong+ " "+ri+ " "+bunji;
					
					zipcodeList.add(zipcode+","+addr);
				}
				
				return zipcodeList;
			} catch (SQLException e){
				e.printStackTrace();
			}
			finally{
				try{
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
				}catch(Exception ex) {}
			}
			return null;
	}

	//회원검색
	public MemberBean findId(String name, String jumin1, String jumin2) {
		MemberBean member=new MemberBean();
		try{
			pstmt=con.prepareStatement(memberFindSql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				String memberjumin1=rs.getString("MEMBER_JUMIN1");
				String memberjumin2=rs.getString("MEMBER_JUMIN2");
				System.out.println("memberjumin1:"+memberjumin1);
				System.out.println("memberjumin2:"+memberjumin2);
				if(memberjumin1.equals(jumin1) && memberjumin2.equals(jumin2)){
					member.setMEMBER_ID(rs.getString("MEMBER_ID"));
					member.setMEMBER_PW(rs.getString("MEMBER_PW"));
					return member;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		return null;
	}//findId()

	//회원검색
	public MemberBean getMember(String id) {
		MemberBean member=null;
		String sql=null;
		
		try{
			con = ds.getConnection();
			
			pstmt=con.prepareStatement(getMemberSql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				member=new MemberBean();
				
				member.setMEMBER_ID(rs.getString("MEMBER_ID"));
				member.setMEMBER_NAME(rs.getString("MEMBER_NAME"));
				member.setMEMBER_JUMIN1(rs.getInt("MEMBER_JUMIN1"));
				member.setMEMBER_JUMIN2(rs.getInt("MEMBER_JUMIN2"));
				member.setMEMBER_EMAIL(rs.getString("MEMBER_EMAIL"));
				member.setMEMBER_EMAIL_GET(rs.getString("MEMBER_EMAIL_GET"));
				member.setMEMBER_MOBILE(rs.getString("MEMBER_MOBILE"));
				member.setMEMBER_PHONE(rs.getString("MEMBER_PHONE"));
				member.setMEMBER_ZIPCODE(rs.getString("MEMBER_ZIPCODE"));
				member.setMEMBER_ADDR1(rs.getString("MEMBER_ADDR1"));
				member.setMEMBER_ADDR2(rs.getString("MEMBER_ADDR2"));
				
				return member;
			}
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return null;
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.AddrBean;

public class AddrDAO {

	/*
	 * jdbc JNDI 커넥션 풀에 의해서 데이터베이스를 연결.
	 * JNDI 커넥션 풀의 장점
	 *  1.필요한 커넥션만 연결이 되고 사용하지 않는 커넥션은 알아서 
	 *  반환된다.그러므로 효율적인 데이터베이스 연결을 할수 있다.
	 */
	Connection con=null; //데이터 베이스 연결 레퍼런스
	PreparedStatement pstmt=null; //쿼리문 실행 레퍼런스
	ResultSet rs=null;//검색 결과 레코드를 저장할 레퍼런스
	DataSource ds=null;//JNDI 커넥션 풀 레퍼런스
	String sql=null; //쿼리문 저장변수
	
	public AddrDAO(){
		try{
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/xe");
			//커넥션풀 객체 생성
		}catch(Exception e){
			e.printStackTrace();
		}
	}//생성자 정의
	
	/*저장*/
	public void insertAddr(AddrBean ab) {
		try{
			con=ds.getConnection();//커넥션 풀로 디비 연결 객체 생성
			sql="insert into addr7 values(addr_no_seq.nextval,?,?,?"
            +",?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,ab.getName());
			pstmt.setString(2,ab.getAddr());
			pstmt.setString(3,ab.getPhone());
			pstmt.setString(4,ab.getEmail());
			
			pstmt.executeUpdate();//저장 쿼리문 실행
			
			pstmt.close(); con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

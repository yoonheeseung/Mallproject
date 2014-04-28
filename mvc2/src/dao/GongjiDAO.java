package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GongjiDAO {

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	DataSource ds=null;
	String sql=null;
	
	public GongjiDAO() {
	      Context ctx;
		try {
			ctx = new InitialContext();
			ds=(DataSource) ctx.lookup("java:comp/env/jdbc/xe");//JNDI 커넥션 풀 객체 생성
			con=ds.getConnection(); 
		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	     
	}
	
	
}

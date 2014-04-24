package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.PostBean;



public class PostDAO {
     Connection con=null;
     DataSource ds=null;
     PreparedStatement pstmt=null;
     String sql=null;
     ResultSet rs=null;
     Statement stmt=null;
     
     public PostDAO(){
    	 try {
			Context ctx=new InitialContext();
			ds=(DataSource) ctx.lookup("java:comp/env/jdbc/xe");
		} catch (Exception e) {
			e.printStackTrace();
		}
     }//PostDAO()생성자
     
     /* 저장 */
     public void insertPost(PostBean pb){
    	 try {
			con=ds.getConnection();//커넥션풀로 디비 연결 객체 생성
			sql="insert into post7(no,name,cont) values(addr7_no_seq.nextval,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pb.getName());
			pstmt.setString(2, pb.getCont());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt !=null)pstmt.close();
				if(con !=null)con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
     }

     /* 목록 */
	public List<PostBean> getPList() {
		List<PostBean> plist=new ArrayList<PostBean>();
		//업케스팅하면서 컬렉션 제네릭 객체 생성
		try {
			con=ds.getConnection();//JNDI 커넥션 풀로 디비 연결 객체 생성
			sql="select * from post7 order by no desc";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				PostBean pb=new PostBean();
				pb.setNo(rs.getInt("no"));
				pb.setName(rs.getString("name"));
				pb.setCont(rs.getString("cont"));
				
				plist.add(pb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return plist;
	}//getPList()
     
}

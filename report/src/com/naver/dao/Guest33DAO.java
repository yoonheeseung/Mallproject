package com.naver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



import com.naver.model.GuestBean;

public class Guest33DAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = null;
	ResultSet rs = null;
	DataSource ds = null;// JNDI 커넥션 풀 레퍼런스

	public Guest33DAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/xe");
			// 커넥션 풀 객체 생성
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// 생성자
  
	/*저장 메서드 */
	public void insertG(GuestBean gb) {
		try {
			con = ds.getConnection();
			sql="insert into guest77(no,guest_name,guest_title,guest_pwd,guest_cont,"
					             + "guest_ref,guest_step,guest_level,guest_date)"
			   + "values(guest77_no_seq.nextval,?,?,?,?,guest77_no_seq.nextval,0,0,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gb.getGuest_name());
			pstmt.setString(2, gb.getGuest_title());
			pstmt.setString(3, gb.getGuest_pwd());
			pstmt.setString(4, gb.getGuest_cont());

			pstmt.executeUpdate();

			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
/****************************************************************************/
	public int getListCount() {
		int i = 0;
		try {
			con = ds.getConnection();
			sql = "select count(*) from guest77";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {// 검색 레코드가 하나인 경우 if문, 검색결과 레코드가 2개이상일때는 while문 사용
				i = rs.getInt(1);// 1은 select문 뒤에 검색되는 첫 번째 필드를 가리킴.
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return i;
	}

	/* List */
	public List<GuestBean> getGuestList(int page, int limit) {
		List<GuestBean> list = new ArrayList<GuestBean>();
		int startrow = (page - 1) * 10 + 1; // 읽기 시작할 row 번호.
		int endrow = startrow + limit - 1; // 읽을 마지막 row 번호.
		try {
			con = ds.getConnection();
			sql = "select * from (select rownum rnum,no,guest_name,guest_title,guest_cont,"
					+ " guest_ref,guest_step,guest_level,guest_hit,guest_date "
					+ " from (select * from guest77 order by guest_ref desc,guest_level asc))"
					+ " where rnum>=? and rnum<=?";
			

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();// 쿼리문 실행

			while (rs.next()) {
				GuestBean guest = new GuestBean();
			
				guest.setNo(rs.getInt("no"));
				guest.setGuest_name(rs.getString("guest_name"));
				guest.setGuest_title(rs.getString("guest_title"));
				guest.setGuest_cont(rs.getString("guest_cont"));
				guest.setGuest_ref(rs.getInt("guest_ref"));
				guest.setGuest_step(rs.getInt("guest_step"));
				guest.setGuest_level(rs.getInt("guest_level"));
				guest.setGuest_hit(rs.getInt("guest_hit"));
				guest.setGuest_date(rs.getString("guest_date"));

				list.add(guest);// 컬렉션에 추가
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	/* 조회수 증가 */
	public void updateHit(int guest_no) {
		try {
			con = ds.getConnection();
			sql = "update guest77 set guest_hit = guest_hit + 1"
					+ " where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, guest_no);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	/* 내용보기+답변글폼+수정폼+삭제폼*/ 
	public GuestBean getGuestCont(int guest_no) {
		GuestBean gb = new GuestBean();		   
		try {
			con = ds.getConnection();
			sql = "select * from guest77 where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, guest_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				gb.setNo(rs.getInt("no"));
				gb.setGuest_name(rs.getString("guest_name"));
				gb.setGuest_title(rs.getString("guest_title"));
				gb.setGuest_cont(rs.getString("guest_cont"));
				gb.setGuest_pwd(rs.getString("guest_pwd"));
				gb.setGuest_hit(rs.getInt("guest_hit"));
				gb.setGuest_ref(rs.getInt("guest_ref"));
				gb.setGuest_step(rs.getInt("guest_step"));
				gb.setGuest_level(rs.getInt("guest_level"));
				gb.setGuest_date(rs.getString("guest_date"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return gb;
	}

	/* 답변 */
	public void replyGuest(GuestBean gr) {
		int guest_ref = gr.getGuest_ref();
		int guest_step = gr.getGuest_step();
		int guest_level = gr.getGuest_level();

		try {

			con = ds.getConnection();
			sql = "update guest77 set guest_level=guest_level+1 "
					+ "where guest_ref=? and guest_level > ?";
			// 답변글 달때 레벨값 1씩 증가
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, guest_ref);// 글그룹번호 저장
			pstmt.setInt(2, guest_level);// 답변글 레벨값 저장 
		    System.out.println("업데이트시!");
			pstmt.executeUpdate();
			System.out.println("업데이트 카운트:");

			// insert
			guest_step = guest_step + 1;
			guest_level = guest_level + 1;

			sql = "insert into guest77(no,guest_name,guest_title,guest_pwd,guest_cont,guest_ref,guest_step,guest_level,guest_date) "
					+ "values(guest77_no_seq.nextval,?,?,?,?,?,?,?,sysdate)";

			System.out.println("6");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gr.getGuest_name());
			pstmt.setString(2, gr.getGuest_title());
			pstmt.setString(3, gr.getGuest_pwd());
			pstmt.setString(4, gr.getGuest_cont());
			pstmt.setInt(5, guest_ref);
			pstmt.setInt(6, guest_step);
			pstmt.setInt(7, guest_level);

			System.out.println("7");
			pstmt.executeUpdate();

		} catch (Exception e) {
		  e.printStackTrace();
		}
		
	}

	/* 수정 */
	public void editGuest(GuestBean eb) {
			try {
				con = ds.getConnection();
				sql = "update guest77 set guest_name=?,guest_title=?,gust_cont=? where no=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, eb.getGuest_name());
				pstmt.setString(2, eb.getGuest_title());
				pstmt.setString(3, eb.getGuest_cont());
				pstmt.setInt(4, eb.getNo());

				pstmt.executeQuery();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//editGuest()


	/* 삭제 */
	public void deleteGuest(int guest_no) {
		try {
			con=ds.getConnection();
			sql="delete from guest77 where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, guest_no);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//deleteGuest()
}

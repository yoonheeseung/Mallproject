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

import com.naver.model.BoardBean;

public class Board76DAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = null;
	ResultSet rs = null;
	DataSource ds = null;// JNDI 커넥션 풀 레퍼런스

	public Board76DAO() {
		try {

			/*
			 * Context ctx=new InitialContext();
			 * ds=(DataSource)ctx.lookup("java:comp/env/jdbc/xe");
			 */
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/xe");
			// 커넥션 풀 객체 생성

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// 생성자

	public void insertBoard(BoardBean b) {
		try {
			con = ds.getConnection();
			sql = "insert into board76(board_no,board_name,board_title,board_pwd,board_cont,board_ref,board_step,board_level,board_date)"
					+ "       values(board_no_seq.nextval,?,?,?,?,board_no_seq.nextval,0,0,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, b.getBoard_name());
			pstmt.setString(2, b.getBoard_title());
			pstmt.setString(3, b.getBoard_pwd());
			pstmt.setString(4, b.getBoard_cont());

			pstmt.executeUpdate();

			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getListCount() {
		int i = 0;
		try {
			con = ds.getConnection();
			sql = "select count(*) from board76";
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
				// TODO: handle exception
			}
		}
		return i;
	}

	public List<BoardBean> getBoardList(int page, int limit) {
		List<BoardBean> list = new ArrayList<BoardBean>();
		int startrow = (page - 1) * 10 + 1; // 읽기 시작할 row 번호.
		int endrow = startrow + limit - 1; // 읽을 마지막 row 번호.
		try {
			con = ds.getConnection();
			sql = "select * from "
					+ "(select rownum rnum,board_no,board_name,board_title,"
					+ "board_cont,board_ref,board_step,"
					+ "board_level,board_hit,board_date from "
					+ "(select * from board76 order by board_ref desc,board_level asc)) "
					+ "where rnum>=? and rnum<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();// 쿼리문 실행

			while (rs.next()) {
				BoardBean board = new BoardBean();
				board.setBoard_no(rs.getInt("board_no"));
				board.setBoard_name(rs.getString("board_name"));
				board.setBoard_title(rs.getString("board_title"));
				board.setBoard_cont(rs.getString("board_cont"));
				board.setBoard_ref(rs.getInt("board_ref"));
				board.setBoard_step(rs.getInt("board_step"));
				board.setBoard_level(rs.getInt("board_level"));
				board.setBoard_hit(rs.getInt("board_hit"));
				board.setBoard_date(rs.getString("board_date"));

				list.add(board);// 컬렉션에 추가
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public void updateHit(int board_no) {
		try {
			con = ds.getConnection();
			sql = "update board76 set board_hit = board_hit + 1"
					+ " where board_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	/* 내용보기+답변글폼+수정폼+삭제폼 */
	public BoardBean getBoardCont(int board_no) {
		BoardBean db = new BoardBean();
		try {
			con = ds.getConnection();
			sql = "select * from board76 where board_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				db.setBoard_no(rs.getInt("board_no"));
				db.setBoard_name(rs.getString("board_name"));
				db.setBoard_title(rs.getString("board_title"));
				db.setBoard_cont(rs.getString("board_cont"));
				db.setBoard_pwd(rs.getString("board_pwd"));
				db.setBoard_hit(rs.getInt("board_hit"));
				db.setBoard_ref(rs.getInt("board_ref"));
				db.setBoard_step(rs.getInt("board_step"));
				db.setBoard_level(rs.getInt("board_level"));
				db.setBoard_date(rs.getString("board_date"));
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
		return db;
	}

	public void replyBoard(BoardBean br) {

		int board_ref = br.getBoard_ref();
		int board_step = br.getBoard_step();
		int board_level = br.getBoard_level();

		try {

			con = ds.getConnection();
			sql = "update board76 set board_level=board_level+1 "
					+ "where board_ref=? and board_level > ?";
			// 답변글 달때 레벨값 1씩 증가
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_ref);// 글그룹번호 저장
			pstmt.setInt(2, board_level);// 답변글 레벨값 저장 */
			System.out.println("업데이트시!");
			pstmt.executeUpdate();
			System.out.println("업데이트 카운트:");

			// insert
			board_step = board_step + 1;
			board_level = board_level + 1;

			sql = "insert into board76(board_no,board_name,board_title,board_pwd,board_cont,board_ref,board_step,board_level,board_date) "
					+ "values(board76_no_seq.nextval,?,?,?,?,?,?,?,sysdate)";

			System.out.println("6");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, br.getBoard_name());
			pstmt.setString(2, br.getBoard_title());
			pstmt.setString(3, br.getBoard_pwd());
			pstmt.setString(4, br.getBoard_cont());
			pstmt.setInt(5, board_ref);
			pstmt.setInt(6, board_step);
			pstmt.setInt(7, board_level);

			System.out.println("7");
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* 수정 */
	public void editBoard(BoardBean eb) {
		try {
			con = ds.getConnection();
			sql = "update board76 set board_name=?,board_title=?,board_cont=?"
					+ " where board_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, eb.getBoard_name());
			pstmt.setString(2, eb.getBoard_title());
			pstmt.setString(3, eb.getBoard_cont());
			pstmt.setInt(4, eb.getBoard_no());

			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//editBoard()

	/* 게시판 삭제 */
	public void deleteBoard(int board_no) {
		try {
			con=ds.getConnection();
			sql="delete from board76 where board_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//deleteBoard()

}

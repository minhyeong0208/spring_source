package pack.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Autowired
	private DataSource ds;
	
	public DataDao() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<JikwonDto> selectAll(String jik) {
		ArrayList<JikwonDto> list = new ArrayList<JikwonDto>();
		
		try {
			String sql = "select jikwon_no,jikwon_name,jikwon_gen,jikwon_pay from jikwon where jikwon_jik=?";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jik);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				JikwonDto dto = new JikwonDto();
				dto.setJikwon_no(rs.getString("jikwon_no"));
				dto.setJikwon_name(rs.getString("jikwon_name"));
				dto.setJikwon_gen(rs.getString("jikwon_gen"));
				dto.setJikwon_pay(rs.getString("jikwon_pay"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("selectAll err : " + e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {}
		}
		
		return list;
	}	
	
	public int countJikwon(String jik) {
		int cnt = 0;
		
		try {
			String sql = "select count(*) as cnt from jikwon where jikwon_jik=?";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jik);
			rs = pstmt.executeQuery();
			
			if(rs.next()) cnt = rs.getInt("cnt");
		} catch (Exception e) {
			System.out.println("selectAll err : " + e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {}
		}
		
		return cnt;
	}
}

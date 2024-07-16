package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pack.controller.MemberBean;

@Repository
public class MemberDao extends JdbcDaoSupport {
	
	@Autowired
	public MemberDao(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	// 전체 자료 읽기
	public List<MemberDto> getMemberList() {
		String sql = "select * from membertab";
		
		// 방법 1 : 내부 무명 클래스 사용
//		List<MemberDto> list = getJdbcTemplate().query(sql, new RowMapper() {
//			@Override
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				MemberDto member = new MemberDto();
//				member.setId(rs.getString("id"));
//				member.setName(rs.getString("name"));
//				member.setPasswd(rs.getString("passwd"));
//				member.setReg_date(rs.getString("reg_date"));
//				return member;
//			}
//		});
		
		// 방법 2 : 람다 표현식을 사용
		List<MemberDto> list = getJdbcTemplate().query(sql, (ResultSet rs, int rowNum) -> {
			MemberDto member = new MemberDto();
			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setPasswd(rs.getString("passwd"));
			member.setReg_date(rs.getString("reg_date"));
			return member;
		});
		return list;
	}
	
	// 데이터 추가
	public void insertData(MemberBean bean) {
		String sql = "insert into membertab values(?,?,?, now())";
		
		Object[] params = {bean.getId(),bean.getName(),bean.getPasswd()};
		// insert를 위해 update 메소드를 사용.
		getJdbcTemplate().update(sql, params);  // 두 번째 인자로 bean을 직접 넣는 것이 아닌, Object 객체로 변환해서 삽입해야 한다.
	}
	
	// 데이터 수정
	
	// 데이터 삭제
	
}

package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao extends JdbcDaoSupport {  // dataSource와 JDBC 템플릿(쿼리를 위해)을 가지고 있다?
	
	// 상속을 받고 있기 때문에 필드 주입 X, 생성자가 만들어지기 전에 JdbcDaoSupport에 datasource를 전달해야 하기 때문.
	@Autowired
	public DataDao(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	public List<JikwonDto> selectJikList(String jik) {
		String sql = "select jikwon_no,jikwon_name,jikwon_gen,jikwon_pay from jikwon where jikwon_jik=?";
		//return (List)getJdbcTemplate().query(sql, new ItemRowMapper());
		
		// 바인딩 변수 배열
		Object[] 파라미터 = {jik};
		// 바인딩 변수의 타입 배열
		int[] argTypes = {java.sql.Types.VARCHAR};
		
		return (List)getJdbcTemplate().query(sql, 파라미터, argTypes, (ResultSet rs, int rowNum) -> {
			JikwonDto dto = new JikwonDto();
			dto.setJikwon_no(rs.getString("jikwon_no"));
			dto.setJikwon_name(rs.getString("jikwon_name"));
			dto.setJikwon_gen(rs.getString("jikwon_gen"));
			dto.setJikwon_pay(rs.getString("jikwon_pay"));
			return dto;
		});
	}
}

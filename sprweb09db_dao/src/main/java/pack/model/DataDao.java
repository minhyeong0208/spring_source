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
	
	public List<SangpumDto> getDataAll() {
		String sql = "select * from sangdata";
		return (List)getJdbcTemplate().query(sql, new ItemRowMapper());
	}
	
	class ItemRowMapper implements RowMapper<Object> {
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			SangpumDto dto = new SangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			return dto;
		}
	}
}

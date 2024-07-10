package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class GogekImpl extends JdbcDaoSupport implements GogekInter{
	@Autowired(required=true)
	private DataSource dataSource;
	
	
	@PostConstruct //생성자 다음에 수행됨
	public void abcd() {
		setDataSource(dataSource);
	}
	
	@Override
	public List<GogekDto> selectList(String buserNum,String name) throws DataAccessException {
		RowMapper rowMapper = new JikwonMapper();
		
		String sql= "SELECT jikwon_name, jikwon_jik, jikwon_gen"
				+ " FROM jikwon INNER JOIN gogek ON jikwon.jikwon_no=gogek.gogek_damsano where gogek_no=" + buserNum+" and gogek_name="+
				 "'" +  name + "'";
		
		
		
		return getJdbcTemplate().query(sql, rowMapper);
	}
	
	class JikwonMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return new GogekDto() {
				{ // 내부 무명 클래스
					setJikwon_name(rs.getString("jikwon_name"));
					setJikwon_jik(rs.getString("jikwon_jik"));
					setJikwon_gen(rs.getString("jikwon_gen"));
					
				}
			};
		}
	}
}

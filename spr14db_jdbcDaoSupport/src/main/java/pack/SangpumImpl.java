package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SangpumImpl extends JdbcDaoSupport implements SangpumInter {
	// JdbcDaoSupport 클래스란?
	// JdbcDaoSupport 클래스는 Spring 프레임워크에서 제공하는 추상 클래스로, 
	// 데이터베이스와 상호 작용하는 DAO를 개발할 때 편리한 기능을 제공. 
	// 이 클래스는 JdbcTemplate을 사용하여 데이터베이스 작업을 처리하고, 
	// 템플릿 메소드 패턴을 활용하여 일반적인 데이터 액세스 작업을 구현
	
	// JdbcDaoSupport 클래스는 멤버 메소드 다음 두 가지가 있다.
	// getJdbcTemplate() 
	// setDataSource() : DB 연결 정보를 적어주는 용도
	
	
	@Override
	public ArrayList<SangpumDto> selectAll() {
		RowMapper rowMapper = new SangpumRowMapper();
		// JdbcDaoSupport 추상 클래스는 getJdbcTemplate() 메소드를 가지고 있다.
		// getJdbcTemplate() 메소드는 query() 메소드를 가지고 있다.
		
		// 이 리턴값은 rs.next()를 끝났을 떄 비로소 리턴.
		return (ArrayList)getJdbcTemplate().query("select * from sangdata", rowMapper); 
	}
	
	// 내부 클래스 -> 밖에 선언할 수도 있음.
	class SangpumRowMapper implements RowMapper {
		
		// 매개변수 rs로 하나씩 받아오는 것과 동일?
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// PreparedStatement에 의해 select의 실행 결과가 mapRow로 전달됨.
			// rs.next() 구문을 작성할 필요가 없다.
			System.out.println("rowNum : " + rowNum);
			SangpumDto dto = new SangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			
			return dto;  // Object으로 반환되므로 23행에서 casting 함.
			
			// rowMapper에 의해 dto가 List 컬렉션에 저장된다. 레코드 자료가 소진될 때까지
		}
	}
}

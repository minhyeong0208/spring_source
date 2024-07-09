package pack.mybatis;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	public static SqlSessionFactory sqlSession; // DB의 SQL명령을 실행시킬 때 필요한 메소드를 갖고 있다.
	// SqlSession Factory는 데이터베이스 별로 하나를 가질 수 있다.
	// 두 개 이상의 데이터베이스에 연결하고 싶다면 SqlSessionFactory 인스턴스를 추가적으로 만들어야 한다.

	// XML 의존적인 방식
	static {
		String resource = "pack/mybatis/Configuration.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);   
			sqlSession = new SqlSessionFactoryBuilder().build(reader, "dev1");   // 두 번째 인자는 환경을 명시하기 위해 사용한다. Configuration.xml에 id 속성이 'dev1'인 environment 태그 환경이 잡히고 있다. 
			// SqlSessionFactory 자체는 위와 같이 XML, 애노테이션 또는 자바 설정에서 SqlSessonFactory를 생성할 수 있는 SqlSessionFactoryBuilder를 통해 만들어진다.
			
			// bulid() 메소드
			// 
			reader.close();
		} catch (Exception e) {
			System.out.println("SqlMapConfig 오류 : " + e);
		}
	}

	public static SqlSessionFactory getSqlSession() {
		return sqlSession;
	}
}
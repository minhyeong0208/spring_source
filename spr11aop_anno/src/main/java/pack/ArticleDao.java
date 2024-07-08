package pack;

import org.springframework.stereotype.Repository;

@Repository  // persistence. DB와 연결해서 작업을 처리하는 모델 영역의 클래스.
public class ArticleDao implements ArticleInter {
	
	@Override
	public void selectAll() {
		System.out.println("테이블 자료 읽기");	
	}
}

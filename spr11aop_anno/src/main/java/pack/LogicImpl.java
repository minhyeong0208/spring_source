package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 핵심 로직 : target에 해당
@Service // 비즈니스 로직을 처리
public class LogicImpl implements LogicInter {
	@Autowired  // @Autowired : 매개변수가 있는 생성자 대체 가능
	private ArticleInter articleInter;
	
	public LogicImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void selectDataProcess1() {
		System.out.println("selectDataProcess1 메소드 수행");  // 비즈니스 로직
		articleInter.selectAll();  // 모델 클래스 수행 결과가 출력 : 모델
	}
	
	@Override
	public void selectDataProcess2() {
		System.out.println("----------");
		System.out.println("selectDataProcess2 메소드 처리");  // 비즈니스 로직
		articleInter.selectAll();  // 모델 클래스 수행 결과가 출력 : 모델
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("3초 지연 처리");
	}
}
package pack;

// 핵심 로직 : target에 해당
public class LogicImpl implements LogicInter {
	private ArticleInter articleInter;
	
	public LogicImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public LogicImpl(ArticleInter articleInter) {
		this.articleInter = articleInter;
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

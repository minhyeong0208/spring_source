package pack;


public class ArticleDao implements ArticleInter {
	
	@Override
	public void selectAll() {
		System.out.println("테이블 자료 읽기");	
	}
}

package pack;

public class Message implements MessageInter {
	// 핵심 로직을 담당할 클래스 : AOP에서 Target에 해당
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void sayHi() {
		System.out.println("안녕, " + name + "님! 여기는 비즈니스 로직을 처리하는 곳");
	
		// 현재 메소드 처리 시간이 길다고 가정하고 인위적으로 지연시간 부여
		int t = 0;
		while(t < 5) {
			try {
				Thread.sleep(1000);
				System.out.print(".");
				t++;
			} catch (Exception e) { }
		}
		System.out.println("\nsayHi() 메소드 처리 완료!");
	}
}

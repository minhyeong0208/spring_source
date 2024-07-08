package pack.model;

public class MyInfo implements MyInfoInter {
	// MyInfo 클래스는 MyInfoInter 타입의 파생 클래스 중 하나
	@Override
	public String myData() {
		return "취미는 운동(축구)";
	}
}

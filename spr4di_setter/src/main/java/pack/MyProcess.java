package pack;

public class MyProcess {  // Setter Injection
	private int age;
	private String name;
	private ShowData showData;  // 참조형, 클래스의 포함관계
	
	public MyProcess() {
		// 생성자를 통해 값을 받을 수도 있음. -> spr3 참조
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setShowData(ShowData showData) {
		this.showData = showData;
	}
	
	public void displayData() {
		System.out.println("이름은 " + name 
				+ ", 나이는 " + age
				+ ", 별명은 " + showData.processNickName()
				+ ", 취미는 " + showData.processHobby());
	}
}

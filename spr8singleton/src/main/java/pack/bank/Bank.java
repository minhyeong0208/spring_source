package pack.bank;

// 인터페이스는 어노테이션 사용 불가 -> 인스턴스가 불가하기 때문!
public interface Bank {
	void inputMoney(int money);  // 입금
	void outputMoney(int money);  // 출금
	int getMoney();  // 잔고 확인
}

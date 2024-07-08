package pack.customer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pack.bank.Bank;
import pack.bank.HanaBank;
import pack.bank.ShinhanBank;

@Service
@ComponentScan("pack.bank")  // 고객이 bank 패키지를 Scan함
@Scope("prototype")
public class Customer {
	private Bank bank;
	
	@Autowired(required = true)  // type으로 연결 -> shinhanBank 인스턴스가 없으면 에러 발생!
	private ShinhanBank shinhanBank;
	
	@Resource(name="Hana")       // name으로 연결 
	private HanaBank hanaBank;
	
	// 은행 선택을 위한 메소드
	public void selectBank(String sel) {
		if(sel.equals("shinhan")) bank = shinhanBank;
		else if(sel.equals("hana")) bank = hanaBank; 
	}
	
	
	// 입금을 위한 메소드
	public void playInputMoney(int money) {
		bank.inputMoney(money);  // 객체 변수 bank는 고객이 선택한 은행에 따라 변경됨.
	}
	
	// 출금을 위한 메소드
	public void playOutputMoney(int money) {
		bank.outputMoney(money); 
	}
	
	private String msg;
	
	@PostConstruct  // 생성자 처리 후 자동 호출
	public void printMsg() {
		msg = "계좌 잔고 : ";
	}
	
	@PreDestroy  // 웹 서비스 종료 직전 자동 호출 : 마무리 작업을 담당
	public void def() {
		if(shinhanBank != null) shinhanBank = null;
		if(hanaBank != null) hanaBank = null;
	}
	
	// 고객의 잔고 확인을 위한 메소드
	public void showMoney() {
		System.out.println(msg + bank.getMoney());
	}
}

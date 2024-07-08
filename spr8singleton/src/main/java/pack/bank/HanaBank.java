package pack.bank;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Hana")
@Scope("prototype")
public class HanaBank implements Bank {
	private int money = 5000;
	
	@Override
	public void inputMoney(int money) {
		this.money = this.money + money;
	}
	
	@Override
	public void outputMoney(int money) {
		int temp = money;
		this.money -= temp;
	}
	
	@Override
	public int getMoney() {
		return money;
	}
	
}

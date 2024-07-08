package pack.model;

public class MoneyCalc implements MoneyInter {
	
	@Override
	public int[] calcMoney(int money) {  // 다섯 자리의 금액을 인수로 전달
		int re[] = new int[5];
		int divisor = 10000;
	
		for(int i = 0; i < re.length; i++) {
			re[i] = money / divisor;
			money %= divisor;
			divisor /= 10;
			
		}
		
		return re;
	}
}

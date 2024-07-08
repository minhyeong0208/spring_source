package pack.model;

public class SangpumImpl implements SangpumInter {
	
	@Override
	public String[] calcMoney(String sang, int su, int dan) {
		String res[] = new String[2];
		
		res[0] = sang;
		res[1] = Integer.toString(su * dan);
		
		return res;
	}
}

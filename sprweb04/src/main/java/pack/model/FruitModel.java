package pack.model;

import org.springframework.stereotype.Service;

import pack.controller.FruitBean;

@Service
public class FruitModel {
	public String computePrice(FruitBean bean) {
		//String data = "품명 : " + bean.getSang()
		//			+ "금액 : " + (bean.getSu() * bean.getDan());
		int price = 0;
		if(bean.getQuality().equals("상")) {
			price = bean.getPrice() * 2;
		} else if(bean.getQuality().equals("하")) {
			price = bean.getPrice() * 1;
		}
		return bean.getSang() + " 금액은 " + (price * bean.getSu());
	}
}

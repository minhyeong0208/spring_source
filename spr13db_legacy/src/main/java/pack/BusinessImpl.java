package pack;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BusinessImpl implements BusinessInter {
	// 모델 클래스를 사용
	
	@Autowired 
	@Qualifier("sangpumImpl") // 인터페이스를 구현한 파생 클래스가 여러 개인 경우 사용, 현재 하나이므로 작성할 필요 없음.
	private SangpumInter inter;
	
	@Override
	public void selectProcess() {
		ArrayList<SangpumDto> slist = inter.selectAll();
		
		for(SangpumDto s: slist) {
			System.out.println(s.getCode() + " " 
							+ s.getSang() + " " 
							+ s.getSu() + " " 
							+ s.getDan());
		}
	}
}

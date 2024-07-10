package pack.business;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pack.model.GogekDto;
import pack.model.GogekInter;


@Service
public class BusinessImpl implements BusinessInter{
	// model을 포함관계로 호출
	@Autowired

	private GogekInter gogekInter;
	
	@Override
	public void jikwonList() {
		System.out.println("고객번호 입력:");
		Scanner scanner = new Scanner(System.in);
		String buserNum = scanner.next();
		System.out.println("고객이름 입력:");
		
		String name= scanner.next();
		scanner.close();
		List<GogekDto> list =gogekInter.selectList(buserNum,name);
		if(list.isEmpty()) {
			System.out.println("로그인 실패띠");
			System.exit(0);
		}
		

		
		for(GogekDto j:list) {
			System.out.println(j.getJikwon_name() + " " + 
							j.getJikwon_jik() + " "+
							j.getJikwon_gen());
			
		}
				
		
	}
}

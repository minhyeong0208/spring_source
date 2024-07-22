package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.DataInterface;
import pack.model.GogekDto;
import pack.model.MemDto;

@Service
public class BusinessImpl implements BusinessInter {
	@Autowired
	private DataInterface dataInterface;
	
	@Override
	public void dataPrint() {
		List<MemDto> list = dataInterface.selectDataAll();  // DataImpl 클래스의 selectDataAll() 매소드를 호출
		
		//System.out.println("dataPrint 메소드에서 출력");
		for(MemDto m : list) {
			System.out.println(m.getNumber() + " " + m.getName() + " " + m.getAddr());
		}
	}
}

package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessServiceImpl implements ProcessService {
	@Autowired
	private DataDao dataDao;	// 클래스의 포함 관계, DataDao는 부모 클래스

	public ProcessServiceImpl(DataDao dataDao) {
		this.dataDao = dataDao;
	}
	
	@Override
	public void selectProcess() {
		System.out.println("selectProcess 처리 시작");
		
		dataDao.selectData(); // model 영역의 클래스가 수행됨.
		
		System.out.println("selectProcess 처리 끝");
	}
}

package controller;

import model.DataDao;

public class ProcessServiceImpl implements ProcessService {
	private DataDao dataDao;	// 클래스의 포함 관계, DataDao는 부모 클래스
	
	public ProcessServiceImpl() {
		// 스프링에서는 내용이 없는 생성자 선언을 권장
	}

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

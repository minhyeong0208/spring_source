package spr12aop_login;

import org.springframework.stereotype.Service;

@Service("bImpl")
public class BusinessLogicImpl implements BusinessLogicInter{
	
	public BusinessLogicImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void startProcess() {
		System.out.println("검증 완료. 핵심 로직 수행");
	}
}

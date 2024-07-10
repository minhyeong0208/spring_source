package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonInter;
import pack.model.BuserDto;
import pack.model.JikwonDto;

@Service
public class BusinessImpl implements BusinessInter {
	@Autowired
	private JikwonInter jikwonInter;
	
	@Override
	public void dataPrint() {
		List<JikwonDto> jlist = jikwonInter.selectDataAll(); 
		
		System.out.println("사번\t이름\t부서번호\t입사년월일");
		for(JikwonDto j : jlist) {
			System.out.println(j.getJikwon_no() + "\t" + j.getJikwon_name() + "\t" + j.getBuser_num() + "\t" + j.getJikwon_ibsail());
		}
		
		List<BuserDto> jlist2 = jikwonInter.countPart(); 
		
		System.out.println("부서별 인원수");
		for(BuserDto j : jlist2) {
			System.out.println(j.getBuser_num() + "\t" + j.getCountPart());
		}
	}
}

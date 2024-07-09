package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.CountPartDto;
import pack.model.JikwonDto;
import pack.model.JikwonInter;



@Service
public class BusinessImpl implements BusinessInter  {
	// Model 클래스를 호출
	@Autowired
	private JikwonInter inter;
	
	@Override
	public void dataPrint() {
		List<JikwonDto> list = inter.selectDataAll();
		System.out.println("직원자료");
		System.out.println("사번\t이름\t부서명\t입사년");
		for(JikwonDto j : list) {
			System.out.println(j.getJikwon_no() + "\t" + j.getJikwon_name() + "\t"
							+ j.getBuser_name() + "\t" + j.getJikwon_ibsail());
		}
		
		System.out.println();
		List<CountPartDto> list2 = inter.countPart();
		System.out.println("부서별 인원수");
		System.out.println("부서\t인원수");
		for(CountPartDto j : list2) {
			System.out.println(j.getBuser_name() + "\t" + j.getCountPart());
		}
		
		System.out.println();
		List<JikwonDto> list3 = inter.maxPay();
		System.out.println("부서별 최대 급여자");
		
		for(JikwonDto j : list3) {
			System.out.println(j.getBuser_name() + "\t" + j.getJikwon_name() + "(" + j.getJikwon_pay() + ")");
		}
	}
	
}

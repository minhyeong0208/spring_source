package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SqlMapperInter {
	@Select("select jikwon_no,jikwon_name,buser_name,substr(jikwon_ibsail,1,4) as jikwon_ibsail from jikwon inner join buser on buser_num=buser_no")
	public List<JikwonDto> selectDataAll();
	
	@Select("select buser_name, count(*) as countPart from jikwon inner join buser on buser_num=buser_no group by buser_num")
	public List<CountPartDto> countPart();
	
	@Select("SELECT buser_name, jikwon_name, jikwon_pay FROM jikwon inner join buser on buser_num = buser_no, (SELECT buser_num, MAX(jikwon_pay) maxpay FROM jikwon GROUP BY buser_num) maxtab WHERE jikwon.buser_num = maxtab.buser_num AND jikwon_pay = maxtab.maxpay")
	public List<JikwonDto> maxPay();
	
}

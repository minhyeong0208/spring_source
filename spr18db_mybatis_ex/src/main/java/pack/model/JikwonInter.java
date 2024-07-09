package pack.model;

import java.util.List;


public interface JikwonInter {
	List<JikwonDto> selectDataAll();
	List<CountPartDto> countPart();
	List<JikwonDto> maxPay();
}

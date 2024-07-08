package anno3_etc;

import org.springframework.stereotype.Component;

@Component
public class DataInfo {
	private String name ="아이유";
	private String part = "전산부";
	
	public String job = "가수";
	
	public String getName() {
		return name;
	}
	
	public String getPart() {
		return part;
	}
}

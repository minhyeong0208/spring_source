package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Jikwon;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JikwonDto {
	private int jno;
	private String jname;
	private String bname;
	private String jik;
	private String pay;
	
	public static JikwonDto toDto(Jikwon jikwon) {
		return JikwonDto.builder()
				.jno(jikwon.getJno())
				.jname(jikwon.getJname())
				.jik(jikwon.getJik())
				.bname(jikwon.getBuser().getBname())
				.pay(jikwon.getPay())
				.build();
	}
	
}

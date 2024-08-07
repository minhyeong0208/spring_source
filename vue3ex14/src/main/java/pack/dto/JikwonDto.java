package pack.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias(value = "jikwonDto")
public class JikwonDto {
	private int jikwon_no;
	private String jikwon_name, buser_name, jikwon_jik, jikwon_pay;
}

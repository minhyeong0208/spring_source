package pack.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias(value = "memberDto")  // 객체 별명을 주고 mapper.xml 문서에서 사용할 수 있다.
public class MemberDto {
	private int num;
	private String name, addr;
}

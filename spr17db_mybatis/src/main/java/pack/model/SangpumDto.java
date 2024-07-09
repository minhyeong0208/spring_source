package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
//@Data  // 여러 어노테이션을 통합
@NoArgsConstructor  // 파라미터가 없는 생성자를 생성하는 어노테이션
@AllArgsConstructor // 파라미터가 있는 생성자를 생성하는 어노테이션
@Builder
public class SangpumDto {
	private String code, sang, su, dan;
}

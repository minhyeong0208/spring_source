package pack.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class User {
	private int id;  // 중복 데이터가 들어가지 않도록 하기 위함
	private String userName;
	private String password;
	private String email;
	private String role;  // Authority 정보를 저장할 칼럼. ROLE_XXX
}

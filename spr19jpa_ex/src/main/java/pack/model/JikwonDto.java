package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder  // Builder 어노테이션의 경우 매개변수가 있는 생성자를 선언해야함.
@NoArgsConstructor  // 꼭 있어야 함.
@AllArgsConstructor
@Entity
@Table(name="jikwon")   // DB의 특정 테이블과 연결(매핑)
public class JikwonDto {  // 주의! 카멜 표기법을 사용하는 경우, 자동으로 JPA에서는 다음과 같이 snake 표기법을 따른다. 원본 테이블의 이름을 Mem_Dto로 인식.	
	@Id 
	private int jikwon_no;
	private String jikwon_name, buser_num, jikwon_ibsail;

}

package pack.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity  // JPA 의존성 추가했기 때문에 사용 가능, 테이블명 전달 x
@Table(name = "product1")
public class ProductVo {
	@Id
	@Column(name="code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 증가(auto_increment)
	private int code;
	
	@Column(name="sang", nullable = false, length = 20)
	private String sang;
	
	private int su;
	private int dan;
	
}

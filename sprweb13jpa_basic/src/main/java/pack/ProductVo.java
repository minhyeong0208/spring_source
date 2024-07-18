package pack;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")  // 물리적인 테이블명은 product.
public class ProductVo {  // @Table 어노테이션의 name이 없는 경우, PRODUCT_VO로 생성 
	@Id
	private Integer code;
	private String sang;
	private Integer su;
	private Integer dan;
}
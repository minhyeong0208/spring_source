package pack.model;

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
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="jikwon")
public class JikwonDto {
	@Id
	private String jikwon_no;
	
	private String buser_num;
	private String jikwon_name, jikwon_ibsail;
}

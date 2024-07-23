package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "jikwon")
public class Jikwon {
	@Id
	private int jikwon_no;
	
	private int jikwon_pay;
	
	@Column(name = "buser_num")
	private String buser;
	private String jikwon_name, jikwon_jik;
	
	@Column(name = "jikwon_rating")
	private String rating;
}

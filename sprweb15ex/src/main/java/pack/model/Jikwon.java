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
	
	private String jikwon_name;
	private String jikwon_gen;
	private String jikwon_pay;
	
	@Column(name = "jikwon_jik")
	private String jik;
}

package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jikwon")
public class Jikwon {
	@Id
	private Long jikwon_no;
	private String jikwon_name;
	
	public Long getJikwon_no() {
		return jikwon_no;
	}
	public void setJikwon_no(Long jikwon_no) {
		this.jikwon_no = jikwon_no;
	}
	public String getJikwon_name() {
		return jikwon_name;
	}
	public void setJikwon_name(String jikwon_name) {
		this.jikwon_name = jikwon_name;
	}
}

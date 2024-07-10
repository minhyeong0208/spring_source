package pack;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="jikwon")
public class Jikwon {
	@Id
	@Column(name = "jikwon_no")
	private String jikwonNo;
	
	@Column(name = "jikwon_name")
	private String jikwonName;

	@ManyToOne  // 직원 입장에서 각각의 직원은 하나의 부서르 가질 수 있음.
	@JoinColumn(name = "buser_num", referencedColumnName = "buser_no")
	private Buser buser;  // Buser 클래스를 가리킴, buser 테이블 X
	
	@Column(name = "jikwon_ibsail")
	private Date jikwonIbsail;
}

package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Gogek {
	@Id
	@Column(name = "gogek_no")
	private int gno;
	
	@Column(name = "gogek_name")
	private String gname;
	
	private String gender;
	
	private String age;
	
	@Column(name = "gogek_tel")
	private String tel;
	
//	@Column(name = "gogek_damsano")
//	private int damsano;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "no", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))  // name 속성은 PK여야만 함.
	private Jikwon jikwon;
}

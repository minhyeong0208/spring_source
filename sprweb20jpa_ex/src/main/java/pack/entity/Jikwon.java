package pack.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Jikwon {
	@Id
	@Column(name = "jikwon_no")
	private int jno;
	
	@Column(name = "jikwon_name")
	private String jname;
	
	@Column(name = "jikwon_jik")
	private String jik;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "buser_num", referencedColumnName = "buser_no")
	private Buser buser;
	
	@OneToMany(mappedBy = "jikwon", fetch = FetchType.EAGER)
	private List<Gogek> gogeks;
	
}

package pack.model;

import java.util.ArrayList;
import java.util.Date;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jikwon { // 일대다
	@Id
	@Column(name = "jikwon_no")
	private int no;
	
	@Column(name = "jikwon_name")
	private String name;
	@Column(name = "jikwon_jik")
	private String jik;
	
	@OneToMany(mappedBy = "jikwon", fetch = FetchType.EAGER)
	@Builder.Default  // Emp 엔티티가 생성될 때, list를 초기화함.
	private List<Gogek> list = new ArrayList<Gogek>();
	
	//@Column(name = "buser_num")
	//private int bno;
	
	@ManyToOne(fetch = FetchType.EAGER)  // 다대일
	@JoinColumn(name = "bno", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private Buser buser;
}

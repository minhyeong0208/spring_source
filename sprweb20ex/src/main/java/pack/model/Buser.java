package pack.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Buser {  // 일대다
	
	@Id
	@Column(name = "buser_no")
	private int bno;
	
	@Column(name = "buser_name")
	private String bname;
	
	@OneToMany(mappedBy = "buser", fetch = FetchType.EAGER)
	@Builder.Default  // Emp 엔티티가 생성될 때, list를 초기화함.
	private List<Jikwon> list = new ArrayList<Jikwon>();
}
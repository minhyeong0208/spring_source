package pack.entity;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
public class Dept { // 1:N 하나의 Dept에는 여러 개의 emp가 들어올 수 있다.
	@Id
	private int deptno; // deptno를 PK로
	
	private String dname;
	private String loc;
	
	// 01. FetchType.LAZY : Dept 사용 중 Emp는 필요할 때 지연 로딩
	// 세션이 열려있는 동안 세션관리가 필요하며, LazyInitializationException 조치 필요
	
	// 02. FetchType.EAGER : Dept 사용 중 Emp는 필요할 때 즉시 로딩. 메모리 낭비가 심하다.
	@OneToMany(mappedBy = "dept", fetch = FetchType.EAGER) // 별도의 관리를 안해도 됨.
	@Builder.Default // Emp 엔티티가 생성될 때 list를 초기화함.
	private List<Emp> list = new ArrayList<Emp>();
	
	
}

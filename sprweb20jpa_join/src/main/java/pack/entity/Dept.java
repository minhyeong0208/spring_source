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
@Builder  // 다양한 생성자 오버로딩을 위해 사용. -> 이를 사용하기 위해 @AllArgsConstructor, @NoArgsConstructor을 꼭 작성해줘야 함!
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dept {  // DEPT 입장에서 EMP는 1대다 관계
	@Id
	private int deptno;  // PK
	private String dname;
	private String loc;
	
	// FetchType.LAZY : Dept 사용 중 Emp는 필요할 때 지연 로딩.
	// 세션이 열려 있는 동안 세션관리가 필요하며 LazyInitializationException 조치가 필요하다.

	// FetchType.EAGER : Dept 사용 중 Emp는 필요할 때 즉시 로딩.
	@OneToMany(mappedBy = "dept", fetch = FetchType.EAGER)  // mappedBy 옵션 : 
	@Builder.Default  // Emp 엔티티가 생성될 때, list를 초기화함.
	private List<Emp> list = new ArrayList<Emp>(); // 하나의 부서에는 여러명이 직원이 존재.
}
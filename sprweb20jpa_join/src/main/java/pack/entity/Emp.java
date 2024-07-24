package pack.entity;

import java.util.Date;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Emp { // EMP 입장에서 DEPT는 다대일 관계
	@Id
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;    // 관리자 직원번호
	
	@Temporal(TemporalType.DATE)  // 날짜 타입 매핑 시 사용
	private Date hiredate;
	private Double sal;
	private Double comm;
	//private Integer deptno;  // FK
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "deptno", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))  // name 속성은 PK여야만 함.
	private Dept dept;
}

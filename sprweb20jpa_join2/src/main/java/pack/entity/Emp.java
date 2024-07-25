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
public class Emp { // N:1
	@Id
	private int empno; // empno를 PK로
	
	private String ename;
	private String job;
	private String mgr;	   // 관리자 직원 번호
	
	@Temporal(TemporalType.DATE) // 날짜 타입 매핑. JPA에서 사용
	private Date hiredate; // 입사일
	private Double sal;	   // 월급
	private Double comm;
	//private Integer deptno;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "deptno", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)) // 비활성화..	
	private Dept dept; // emp는 dept를 참조
	
}

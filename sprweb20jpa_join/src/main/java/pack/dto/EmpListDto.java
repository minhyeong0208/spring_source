package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Emp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpListDto {
	private Integer empno;
	private String ename;
	private Integer deptno;
	private String dname;
	private String job;

	// Entity를 DTO로 변환하기
	public static EmpListDto toDto(Emp emp) {
		
		return EmpListDto.builder()
				.empno(emp.getEmpno())
				.ename(emp.getEname())
				.deptno(emp.getDept().getDeptno())
				.dname(emp.getDept().getDname())
				.job(emp.getJob())
				.build();
	}
}

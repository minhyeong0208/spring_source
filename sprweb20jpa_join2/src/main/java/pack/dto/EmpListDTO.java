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
@AllArgsConstructor
@NoArgsConstructor
public class EmpListDTO {
	private Integer empno;
	private String ename;
	private Integer deptno;
	private String dname;
	private String job;
	
	public static EmpListDTO toDto(Emp emp) {
		return EmpListDTO.builder()
				.empno(emp.getEmpno())
				.ename(emp.getEname())
				.deptno(emp.getDept().getDeptno())
				.dname(emp.getDept().getDname())
				.job(emp.getJob())
				.build();
	}
}

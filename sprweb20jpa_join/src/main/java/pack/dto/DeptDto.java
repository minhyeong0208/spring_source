package pack.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Dept;
import pack.entity.Emp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptDto {
	private int deptno;
	private String dname;
	private String loc;
	
	private int count;  // 근무 인원수 저장
	private List<String> names;  // 근무 직원의 이름 리스트
	
	// Entity를 DTO로 변환하기
	public static DeptDto toDto(Dept dept) {
		// 직원명 저장 리스트
		List<String> names = new ArrayList<String>();
		
		for(Emp temp: dept.getList()) {
			names.add(temp.getEname());
		}
		
		// Lombok builder로 생성자 주입 값을 선택적으로 입력 가능.
		// 생성자를 통해 값을 주입. 메소드 체이닝을 통해 원하는 값만 삽입할 수 있다.
		return DeptDto.builder()
				.deptno(dept.getDeptno())
				.dname(dept.getDname())
				.loc(dept.getLoc())
				.count(dept.getList().size())
				.names(names)
				.build();
	}
}

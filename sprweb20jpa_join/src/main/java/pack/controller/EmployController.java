package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import pack.dto.DeptDto;
import pack.dto.EmpListDto;
import pack.entity.Dept;
import pack.entity.Emp;
import pack.repository.DeptRepository;
import pack.repository.EmpRepository;

@Controller
public class EmployController {
	@Autowired
	private EntityManagerFactory factory;

	@Autowired
	private EmpRepository empRepo;

	@Autowired
	private DeptRepository deptRepo;

	@GetMapping("/employ/list")
	public String emplist(Model model) {
		// 모든 직원 정보 출력
		// List<Emp> list = empRepo.findAll(); // 기본 메소드
		// List<Emp> list = empRepo.findAllByOrderByEmpnoAsc(); // 오름차순
		// List<Emp> list = empRepo.findAllByOrderByEmpnoDesc(); // 내림차순

		List<Emp> list = empRepo.getListAll(); // JPQL : findAll()과 동일한 결과
		// List<Emp> list = empRepo.getList(1500); // 1500을 초과하는 직원만 출력

		model.addAttribute("list", list);
		return "employ/elist";
	}

	@GetMapping("/employ/dept") // 부서 정보 출력
	public String emplist(@RequestParam("deptno") int deptno, Model model) {
		Dept d = deptRepo.findById(deptno).get();
		DeptDto dto = DeptDto.toDto(d);

		model.addAttribute("dto", dto);
		return "employ/dept";
	}

	// JPQL 연습장 관련
	@GetMapping("/jpql")
	public String jpql() {
		return "jpql";
	}

	@ResponseBody // 넘어온 내용을 찍음
	@PostMapping("/jpql/test")
	public List<EmpListDto> test(@RequestParam("query") String query) {
		// System.out.println(query); // select e from Emp as e
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<EmpListDto> list = null;
		try {
			// 전달받은 query(JPQL)문을 실행
			TypedQuery<Emp> tQuery = em.createQuery(query, Emp.class);
			
			list = tQuery.getResultStream().map(EmpListDto::toDto).toList();
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		
		} finally {
			em.close();
		}
		
		return list;
	}

}

package pack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import pack.entity.Dept;
import pack.entity.Emp;
import pack.repository.DeptRepository;
import pack.repository.EmpRepository;

@SpringBootApplication
public class Sprweb20jpaJoinApplication {
	// 01. 어플리케이션에서 SQL 처리용 JPA 메소드 연습
	// 02. @MVC로 회원자료 처리
	// 03. @MVC로 회원자료 처리(Join)
	// 04. JPQL 연습용 화면 작성 : AJAX
	// H2 DB

	@Autowired
	private EntityManagerFactory emf;

	@Autowired
	private DeptRepository deptRepository;

	@Autowired
	private EmpRepository empRepository;

	// 생성자 이후 자동 실행
	@PostConstruct
	public void initMembers() {
		// Hibernate 객체 사용 : dept, emp, 샘플 데잍터를 JPQL을 이용해 저장하기(자료 집어넣기)
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			List<String> queries = new ArrayList<String>();
			// DEPT 테이블
			queries.add("INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');");
			queries.add("INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');");
			queries.add("INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');");
			queries.add("INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');");

			// EMP 테이블
			queries.add(
					"INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7369,'SMITH','CLERK',7902,parsedatetime('17-12-1980','dd-MM-yyyy'),800,NULL,20);");
			queries.add(
					"INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7499,'ALLEN','SALESMAN',7698,parsedatetime('20-02-1981','dd-MM-yyyy'),1600,300,30);");
			queries.add(
					"INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7521,'WARD','SALESMAN',7698,parsedatetime('22-02-1981','dd-MM-yyyy'),1250,500,30);");
			queries.add(
					"INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7566,'JONES','MANAGER',7839,parsedatetime('02-04-1981','dd-MM-yyyy'),2975,NULL,20);");
			queries.add(
					"INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7654,'MARTIN','SALESMAN',7698,parsedatetime('28-09-1981','dd-MM-yyyy'),1250,1400,30);");
			queries.add(
					"INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7698,'BLAKE','MANAGER',7839,parsedatetime('01-05-1981','dd-MM-yyyy'),2850,NULL,30);");
			queries.add(
					"INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7782,'CLARK','MANAGER',7839,parsedatetime('09-06-1981','dd-MM-yyyy'),2450,NULL,10);");
			queries.add(
					"INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7788,'SCOTT','ANALYST',7566,parsedatetime('13-07-1987','dd-MM-yyyy'),3000,NULL,20);");
			queries.add(
					"INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7839,'KING','PRESIDENT',NULL,parsedatetime('17-11-1981','dd-MM-yyyy'),5000,NULL,10);");
			queries.add(
					"INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7844,'TURNER','SALESMAN',7698,parsedatetime('08-09-1981','dd-MM-yyyy'),1500,0,30);");
			queries.add(
					"INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7876,'ADAMS','CLERK',7788,parsedatetime('13-07-1987','dd-MM-yyyy'),1100,NULL,20);");
			queries.add(
					"INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7900,'JAMES','CLERK',7698,parsedatetime('03-12-1981','dd-MM-yyyy'),950,NULL,30);");

			// 반복 처리로 쿼리를 실행
			for (String que : queries) {
				em.createNativeQuery(que).executeUpdate(); // 테이블이 만들어진다.

			}
			tx.commit();
		} catch (Exception e) {
			System.out.println("ERROR" + e);
			tx.rollback();
		} finally {
			em.close();

		}

		// 사원 번호 읽기
		Emp e1 = empRepository.findById(7788).get();
		System.out.println(e1.getEname() + "사원의 부서명은 " + e1.getDept().getDname());

		/*
		 * // 직원 추가 : 40번 부서 Olive Dept dnum =deptRepository.findById(40).get();
		 * System.out.println(dnum.getDname() + " " + dnum.getDeptno());
		 * 
		 * // 40번 부서의 다른 정보를 이용해 직원정보를 저장할 것이 아니면 find 없이 부서번호만 Dept 객체에 넣는다. // 롬복의
		 * builder()를 사용하여 Dept 객체를 빌더 패턴으로 생성 Dept d =
		 * Dept.builder().deptno(40).build(); System.out.println(d.getDeptno());
		 * 
		 * Emp my = Emp.builder().empno(8000).ename("Olive").dept(d).build();
		 * empRepository.save(my);
		 */

		// 부서 정보 읽기 : 10번
		Dept detp10 = deptRepository.findById(10).get();
		System.out.println("부서명 : " + detp10.getDname());
		System.out.println("부서 위치 : " + detp10.getLoc());
		System.out.println("근무 인원 수 : " + detp10.getList().size());

		// 10번 부서 근무 직원 리스트 뽑기~
		for (Emp imsi : detp10.getList()) {
			System.out.println("직원명 : " + imsi.getEname());
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Sprweb20jpaJoinApplication.class, args);
	}

}

package pack;


import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Main {
	// Join
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		
		try {
			// JPQL 사용하여 JOIN
			System.out.println("JPQL 사용");
			String jpql = "SELECT j.jikwonNo, j.jikwonName, b.buserName, j.jikwonIbsail FROM Jikwon j JOIN j.buser b";  //j.buser는 Jikwon 클래스에 선언되어 있는 포함관계의 Buser 클래스 객체
			// JPQL이 안되는 경우에는 Native를 사용할 수 있다.
			
			TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
			List<Object[]> results = query.getResultList();
			
			for(Object[] result: results) {
				int year = getYear((Date)result[3]);
				System.out.println(result[0] + " " + result[1] + " " + result[2]+ " " + year);
			}
			
			// Native SQL 사용
			System.out.println("\nNative SQL 사용");
			String sql = "select jikwon_no,jikwon_name,buser_name,year(jikwon_ibsail) from jikwon inner join buser on jikwon.buser_num=buser.buser_no";
			Query query2 = em.createNativeQuery(sql);
			List<Object[]> results2 = query2.getResultList();
			
			for(Object[] result: results2) {
				System.out.println(result[0] + " " + result[1] + " " + result[2]+ " " + result[3]);
			}
		} catch (Exception e) {
			System.out.println("main err : " + e);
		} finally {
			em.close();
			emf.close();
		}
		
	}

	private static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}
}

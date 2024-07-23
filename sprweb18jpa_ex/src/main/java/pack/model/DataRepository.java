package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Jikwon, Integer>{
   
    List<Jikwon> findByNum(int buserNum);
 
    List<Jikwon> findByNumAndRating(int buserNum, String rating);
}

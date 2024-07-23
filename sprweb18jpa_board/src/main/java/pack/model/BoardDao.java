package pack.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.controller.BoardBean;

@Repository
public class BoardDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataRepository dataRepository;
	
	// 전체 자료 읽기
	public List<Board> list() {
		List<Board> list = dataRepository.findAll();  // 이 과정은 영속성 컨텍스트 내에서 이뤄짐.
		logger.info("list size : " + list.size());
		
		return list;
	}
	
	// 검색 자료 읽기
	public List<Board> search(BoardBean bean) {
		List<Board> slist = null;
		
		if(bean.getSearchName().equals("author")) {
			slist = dataRepository.searchLike(bean.getSearchValue());
		} else {
			slist = dataRepository.searchLike2(bean.getSearchValue());
		}
		
		return slist;
	}
	
	// 자료 추가
	@Transactional  // 프록시 객체는 해당 메소드가 처리될 때 Commit이나 Rollback을 수행한다.
	// CheckedException 또는 예외가 없는 경우, Commit을 수행한다.
	// UncheckedException이 발생한 경우, Rollback을 수행한다.
	public String insertData(BoardBean bean) {
		try {
			// 새 글 입력 시, 가장 큰 번호를 얻어 +1
			int max = dataRepository.maxNum();
			
			Board dto = new Board();
			dto.setNum(max + 1);
			dto.setAuthor(bean.getAuthor());
			dto.setTitle(bean.getTitle());
			dto.setContent(bean.getContent());
			dto.setBwrite(Timestamp.valueOf(LocalDateTime.now()));
			dto.setReadcnt(0);
			
			dataRepository.save(dto);
			
			return "success";
		} catch (Exception e) {
			return "입력 오류 : " + e.getMessage();
		}
	}
	
	@Transactional
	public Board detail(int num) {
		// 조회수 증가
		dataRepository.updateReadcnt(num);
		
		// Optional<T> 클래스를 사용해 NPE를 방지할 수 있도록 도와준다.
		// Repository에서 findById()의 반환값은 Optional 타입이다.
		Optional<Board> board = dataRepository.findById(num);  // Null이 넘어올 수 있다. 검사가 복잡. -> Optional 클래스 사용. 널포인터 예외 방지.
		logger.info("board :: {}", board.get());  // 두 번째 인자가 {} 내로 삽입된다.
		
		if(board.isPresent()) {
			return board.get();  // board는 Optional 타입. get()메소드로 값을 추출해야함. board 객체를 리턴한다.
		} else {
			return new Board();
		}
	}
	
	@Transactional
	public String updateData(BoardBean bean) {
		try {
			// 조회수도 수정에 참여시키기 위한 선행 작업
			Optional<Board> board = dataRepository.findById(bean.getNum());  
			Board imsi = board.get();  // 수정된 자료 읽기
			/*
			Board dto = new Board();
			dto.setNum(bean.getNum());  // 이미 등록된 번호(num)이므로 수정.
			dto.setAuthor(bean.getAuthor());
			dto.setTitle(bean.getTitle());
			dto.setContent(bean.getContent());
			dto.setReadcnt(imsi.getReadcnt());
			
			dataRepository.save(dto);  // 수정
			*/
			
			// 방법 2: save 사용 x, 수정할 내용만 추가하면 된다.
			imsi.setAuthor(bean.getAuthor());
			imsi.setTitle(bean.getTitle());
			imsi.setContent(bean.getContent());
			imsi.setReadcnt(imsi.getReadcnt());
			
			return "success";
		} catch (Exception e) {
			return "수정 오류 : " + e.getMessage();
		}
	}
	
	@Transactional
	public String deleteData(int num) {
		try {
			dataRepository.deleteById(num);
			
			return "success";
		} catch (Exception e) {
			return "삭제 오류 : " + e.getMessage();
		}
	}
}

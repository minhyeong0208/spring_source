package pack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.transaction.Transactional;
import pack.dto.MemberDTO;
import pack.entity.Member;
import pack.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository memRepository;
	
	@Override
	// Model은 Spring이 제공하는 모델을 사용해서 따로 반환하지 않아도 된다. (Spring에서 관리됨)
	public void getList(Model model) { 
		/*// 방법 01. Member 전체 자료 반환 : 기본 메소드 사용
		// Member 엔티티를 MemberDTO 객체로 전달
		List<Member> entityList = memRepository.findAll();
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		for(Member temp:entityList) {
			MemberDTO dto = new MemberDTO();
			dto.setNum(temp.getNum());
			dto.setName(temp.getName());
			dto.setAddr(temp.getAddr());
			list.add(dto);
		}
		// 컨트롤러에 MemberDTO가 담긴 list를 전달한다.
		*/
		
		// 방법 02. List<Member>를 Stream으로 연결해서 map()을 사용 List<Member>로 변경하기
		List<MemberDTO> list = memRepository
				.findAllByOrderByNumDesc()
				.stream()
				.map(item -> MemberDTO
						.toDto(item)).toList();
		
		/*// 방법 03. 람다 표현식을 메소드 참조 표현식으로 기술 클래스명 메소드명
		List<MemberDTO> list2 = memRepository
				.findAllByOrderByNumDesc()
				.stream()
				.map(MemberDTO::toDto)
				.toList();
		*/
		
		model.addAttribute("list", list);
	}
	
	@Override // ⭐⭐⭐ insert는 save가 중요 ⭐⭐⭐
	public void insert(MemberDTO dto) {
		// JPA 작업 영역 내로 들어갈 때 일반 자료 전달용 (DTO, FormBean) 객체를 대응 엔티티로 변환
		memRepository.save(Member.toEntity(dto));
	}
	
	// 수정 자료 읽기
	@Override
	public void getData(Long num, Model model) {
		Member m = memRepository.findById(num).get();
		model.addAttribute("dto", MemberDTO.toDto(m)); // Entity를 DTO로 변환해서 컨트롤러에게 넘긴다.
	}
	
	// 회원 수정
	@Override
	public void update(MemberDTO dto) {
		memRepository.save(Member.toEntity(dto));
	}
	
	@Transactional
	@Override
	public void update2(MemberDTO dto) {
		// 수정할 회원의 번호를 이용해서 회원 정보 entity 객체 얻어내기
	    Member m1 = memRepository.findById(dto.getNum()).get();
	    Member m2 = memRepository.findById(dto.getNum()).get();
	    
	    // 동일성 검사
	    boolean isEqual = m1 == m2;
	    System.out.println("m1과 m2가 같냐?" + isEqual);
	    
	    // setter 메소드를 이용해서 이름과 주소 수정하기
	    m1.setName(dto.getName());
	    m1.setAddr(dto.getAddr());
	}
	
	
	@Override
	public void delete(Long num) {
		memRepository.deleteById(num);
	}
}

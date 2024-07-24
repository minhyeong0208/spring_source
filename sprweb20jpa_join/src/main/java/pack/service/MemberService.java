package pack.service;

import org.springframework.ui.Model;

import pack.dto.MemberDto;

public interface MemberService {
	// 전체 회원자료 읽기
	public void getList(Model model);
	
	// 데이터 삽입
	public void insert(MemberDto dto);
	
	// 하나의 자료 읽기
	public void getData(Long num, Model model);
	
	// 데이터 수정
	public void update(MemberDto dto);
	public void update2(MemberDto dto);
	
	// 데이터 삭제
	public void delete(Long num);
}

// controller가 service를 호출.

package pack.service;

import org.springframework.ui.Model;

import pack.dto.MemberDTO;

public interface MemberService {
	public void getList(Model model);
	public void insert(MemberDTO dto);
	public void getData(Long num, Model model);
	public void update(MemberDTO dto);
	public void update2(MemberDTO dto);
	public void delete(Long num);
}

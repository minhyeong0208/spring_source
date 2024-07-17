package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemberDao;
import pack.model.MemberDto;

@Controller
public class UpdateController {

	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("update")
	public String updateData(@RequestParam("id")String id, Model model) {
		MemberDto dto = memberDao.getMember(id);
		
		model.addAttribute("member", dto);
		
		return "updateform";
	}
	
	@PostMapping("update")
	public String submit(MemberBean bean) {
		memberDao.updateData(bean);
		
		
		// 추가 후 목록 보기
		return "redirect:/detail?id=" + bean.getId();  // forward하면 추가된 내용을 읽을 수 없다. redirect 해야 한다.
	}
}

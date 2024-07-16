package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.MemberDao;

@Controller
public class InsertController {

	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("insert")
	public String insertData() {
		
		return "insertform";
	}
	
	@PostMapping("insert")
	public String submit(MemberBean bean) {
		memberDao.insertData(bean);
		
		// 추가 후 목록 보기
		return "redirect:/list";  // forward하면 추가된 내용을 읽을 수 없다. redirect 해야 한다.
		// listController를 다시 만나야 함.
	}
}

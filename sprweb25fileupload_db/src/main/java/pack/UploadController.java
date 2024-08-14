package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/insert")
public class UploadController {
	
	@Autowired
	private FriendService friendService;
	
	@GetMapping
	public String showInsertForm() {
		return "insert";
	}
	
	@PostMapping("/upload")
	public String handledFileUpload(@RequestParam("bunho")int bunho
								,@RequestParam("irum")String irum
								,@RequestParam("junhwa")String junhwa
								,@RequestParam("jikup")String jikup
								,@RequestParam("file")MultipartFile file
								,RedirectAttributes redirectAttributes) { // 메시지를 달고 리다이렉트를 하기 위해 RedirectAttributes 사용
		if(!file.isEmpty() && file.getSize() > 2097152) { // 파일 크기를 2MB로 제한 
			// Flash 속성 추가 메소드, 일회성. 주로 리다이렉트 후 사용자에게 메세지 전달에 사용
			redirectAttributes.addFlashAttribute("message", "파일 크기가 너무 큼.");  // error가 발생하면 insert.html의 div 태그에 뿌리도록하기 위함
			return "redirect:/insert";
		}
		
		// image mime type 예) image/jpeg, ...
		if(!file.getContentType().startsWith("image/")) {  // 이미지 파일인지 확인
			redirectAttributes.addFlashAttribute("message", "이미지 파일만 업로드 가능!"); 
			return "redirect:/insert";
		}
		
		// insert 처리
		try {
			Friend friend = new Friend();
			friend.setBunho(bunho);
			friend.setIrum(irum);
			friend.setJunhwa(junhwa);
			friend.setJikup(jikup);
			friend.setSajin(file.getBytes()); // 이진 데이터 처리를 위해 
			friend.setImagetype(file.getContentType());
			
			friendService.saveFriend(friend);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "이미지 파일 저장 중, 오류 발생: " + e); 
			return "redirect:/insert";
		}
		
		return "redirect:/list";
	}
}

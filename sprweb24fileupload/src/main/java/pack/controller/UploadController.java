package pack.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;  // 에러를 자동으로 잡아준다.
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@GetMapping("/upload")
	public String abc(UploadFile uploadFile) {
		return "uploadform";
	}
	
	@PostMapping("/upload")
	public String submit(UploadFile uploadFile, Model model, BindingResult result) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		// 업로드된 파일 검사
		MultipartFile file = uploadFile.getFile();
		String fileName = file.getOriginalFilename();
		
		if(result.hasErrors()) {  // 에러(파일을 선택하지 않은 경우)가 있는 경우
			return "err";
		}
		
		try {
			inputStream = file.getInputStream();
			File newFile = new File("C:\\spring\\sprsou\\sprweb24fileupload\\src\\main\\resources\\static\\upload\\" + fileName);
			
			if(!newFile.exists()) {  // 파일이 없으면 파일을 생성
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			
			int read = 0;
			byte[] bytes = new byte[1024];
			while((read = inputStream.read(bytes)) != -1) {  // 자료가 있는동안 읽기
				outputStream.write(bytes, 0, read);
			}
			
		} catch (Exception e) {
			System.out.println("file submit err : " + e);
			return "err";
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (Exception e2) { }
		}
		
		model.addAttribute("filename", fileName);
		return "uploadfile";
	}
}

package pack.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DownloadController {
	@PostMapping("download")
	@ResponseBody
	public byte[] downProcess(HttpServletResponse response, @RequestParam("filename")String filename) throws Exception {
		System.out.println("filename : " + filename);
		
		File file = new File("C:\\spring\\sprsou\\sprweb24fileupload\\src\\main\\resources\\static\\upload\\" + filename);
		
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		String fn = new String(file.getName().getBytes(), "iso_8859_1");
		
		// 브라우저에게 다운로드를 지시
		response.setHeader("Content-Disposition", "attachment;filename= \"" + fn + "\"");
		response.setContentLength(bytes.length);  // 파일의 총 크기만큼 다운로드
		
		return bytes;
	}
}

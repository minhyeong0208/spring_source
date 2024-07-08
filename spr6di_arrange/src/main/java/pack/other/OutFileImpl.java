package pack.other;

import java.io.FileWriter;

public class OutFileImpl implements OutFileInter {
	private String filePath;  // 출력 파일의 경로 기억
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public void outFile(String msg) {
		// MessageImpl 클래스의 변수 msg 결과를 파일로 출력
		try {
			FileWriter writer = new FileWriter(filePath);
			writer.write(msg);  // 출력할 메시지 msg를 인수로 전달
			writer.close();
			System.out.println("파일 저장 완료!");
		} catch (Exception e) {
			System.out.println("outFile : " + e);
		}
		
	}
}

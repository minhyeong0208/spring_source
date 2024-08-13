package pack;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Friend {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY); // bunho 칼럼이 Auto-Increment일 때, 사용
	private int bunho;
	private String irum;
	private String junhwa;
	private String jikup;
	
	@Lob // BLOB 또는 CLOB으로 처리됨.
	private byte[] sajin;
	private String imagetype;
	
	@Transient  // DB와 관련없는 임시 데이터 저장
	private String base64Image;  // base64로 인코딩된 이미지 타입
}

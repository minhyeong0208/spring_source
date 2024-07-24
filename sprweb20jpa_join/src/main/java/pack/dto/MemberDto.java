package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Member;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
	private Long num;
	private String name;
	private String addr;

	// Entity를 DTO로 변환
	public static MemberDto todto(Member entity) {

		return MemberDto.builder()
				.num(entity.getNum())
				.name(entity.getName())
				.addr(entity.getAddr())
				.build();
	}
}

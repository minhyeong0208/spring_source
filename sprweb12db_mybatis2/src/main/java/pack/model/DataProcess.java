// 20240718 장마
package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.MemberBean;

@Repository
public class DataProcess {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MapperInter mapperInter; // hikari pool이 자동 지원됨.

	// 전체 자료 읽기
	public List<MemberDto> getDataAll() {
		List<MemberDto> list = mapperInter.selectAll();
		logger.info("전체 자료 크기 : " + list.size());
		return list;
	}

	// 부분 자료 읽기
	public MemberDto getData(String num) {
		MemberDto dto = mapperInter.selectPart(num);
		return dto;
	}

	// 회원 추가
	public boolean insert(MemberBean bean) {
		// 번호 중복 방지 또는 번호 자동 증가 작업이 필요하나 생략..
		int re = mapperInter.insertData(bean);

		if (re > 0)
			return true;
		else
			return false;
	}

	// 회원 수정
	public boolean update(MemberBean bean) {
		int re = mapperInter.updateData(bean);

		if (re > 0)
			return true;
		else
			return false;
	}

	// 회원 삭제
	public boolean delete(String num) {
		int re = mapperInter.deleteData(num);

		if (re > 0)
			return true;
		else
			return false;
	}
}
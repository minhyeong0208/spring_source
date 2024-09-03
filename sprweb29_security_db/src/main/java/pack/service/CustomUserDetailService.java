package pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pack.model.Jikwon;
import pack.repository.JikwonRepository;

@Service
public class CustomUserDetailService implements UserDetailsService { // 사용자 인증 시, 사용자 정보를 로드하는 역할

	@Autowired
	private JikwonRepository jikwonRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String sabun) throws UsernameNotFoundException {
		// 사원번호로 사용자 정보를 조회하고, 그 결과로 UserDetails 객체를 생성 후, 반환
		Long jikwonNo = Long.parseLong(sabun); // sabun을 Long 타입으로 변환
		
		Jikwon jikwon = jikwonRepository.findById(jikwonNo)
				.orElseThrow(() -> new UsernameNotFoundException("사원번호 없음 : " + sabun));
		
		return User.builder()
				.username(String.valueOf(jikwon.getJikwon_no()))  // 사원번호를 username으로 사용
				.password(passwordEncoder.encode(jikwon.getJikwon_name()))  // 사원이름을 password로 사용, 암호화
				.roles("USER")
				.build();
	}
}

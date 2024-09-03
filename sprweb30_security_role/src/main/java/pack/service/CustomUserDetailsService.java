package pack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pack.entity.User;

// 원래 아이디와 비밀번호는 DB와 연동해서 처리. 
// 편의상 미리 선언한 특정한 아이디와 비밀번호를 사용. 

// User의 정보를 가져오는 클래스
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username : " + username);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  // 비밀번호를 암호화할 때 사용
		
		String role = "";
		if(username.equals("guest"))
			role = "ROLE_USER";  // 실제 DB에는 ROLE_XXX 형식으로 저장되어 있어야 한다.
		else if(username.equals("batman"))
			role = "ROLE_STAFF";
		else if(username.equals("superman"))
			role = "ROLE_ADMIN";
		
		// DB에서 username을 이용해 사용자 정보(이름, 비밀번호, 이메일, 권한, ...)를 얻어 온다.
		
		User user = User.builder()
						.id(1)
						.userName(username)
						.password(encoder.encode("1234"))
						.email("@")
						.role(role)
						.build();
		
		// 원래 권한 정보도 따로 테이블을 만들어 관리해 하나의 계정이 다양한 권한을 가질 수 있도록 해야한다.
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
		// 여기서 반환된 userDetails 객체를 이용해 시큐리티가 계정과 비밀번호 유효성 검증을 하고 권한도 검증한다.
		return userDetails;
	}
}
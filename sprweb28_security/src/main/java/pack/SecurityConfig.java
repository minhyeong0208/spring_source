package pack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity  // 웹 보안과 관련된 클래스를 설정
public class SecurityConfig {  // 기본적인 웹 보안 구성을 설정
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// HttpSecurity 객체를 사용하여 보안설정을 정의
		http.authorizeHttpRequests(authorizeRequest ->   // http 요청에 대한 보안 권한 설정
			authorizeRequest.requestMatchers("/login").permitAll()  //requestMatchers와 antMatchers는 동일  // login 경로는 인증 없이 누구든 접근 허용
							.anyRequest().authenticated()  // 그 외의 나머지 요청의 경우, 인증된 경우에만 접근 허용
		)
		.formLogin(formLogin -> 
			formLogin.loginPage("/login")  // 로그인 페이지 경로 지정
					 .defaultSuccessUrl("/", true)  // 로그인 성공 시, 이동할 경로(현재 루트)
					 .permitAll()  // 로그인 페이지는 인증없이 누구든 접근 허용
		)
		.logout(logout -> 
			logout.logoutUrl("/logout")  // 로그아웃 경로(기본값 logout)
				  .logoutSuccessUrl("/login?logout")  // 로그아웃 성공 시, /login 경로로 이동
				  .permitAll()   // 로그아웃 페이지 역시 인증없이 누구든 접근 허용
		)
		.sessionManagement(sessionManagement -> 
			sessionManagement.maximumSessions(1)  // 최대 동시 세션 수를 제한
							 .expiredUrl("/login?expired")  // 세션 만료 시, 로그인으로 이동
		);
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.builder()
							   .username("minhy")  // 아이디 설정
							   .password(passwordEncoder().encode("123"))  // 비밀번호 설정
							   .roles("USER")  // default user 역할
							   .build();  // 사용자명, 비밀번호 역할 설정
		
		return new InMemoryUserDetailsManager(user);
		// 사용자 정보를 메모리에 저장하고 관리하는 클래스가 InMemoryUserDetailsManager이다.
		// 주로 애플리케이션, 테스트 환경에서 사용한다. 
		// 영구 저장소 X, 애플리케이션을 재시작하면 사라진다.
	}
	
	@Bean
	// 비밀번호 암호화를 위해 작성
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();  // 비밀번호 암호화를 위해 BCrypt 알고리즘을 사용
		// 단방향 해시함수를 이용하여 암호화를 수행한다.
	}
}
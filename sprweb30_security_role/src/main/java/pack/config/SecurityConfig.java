package pack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity  // 시큐리티 객체를 이 곳에서 만들어 주면 된다.
public class SecurityConfig {
	// 클라이언트 요청 -> 필터 + 필터 ... + Dispatcher Servlet
	// 클라이언트 요청이 들어오면 여러 필터를 거쳐 디스패처 서블릿으로 이동한다.
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		// 인증없이 접근 가능 요청(URL)
		String[] whiteList = {
			"/", "/notice", "/user/loginform", "/user/login_fail", "/user/expired", "/shop"
		};
		
		httpSecurity
			.csrf(csrf -> csrf.disable())  // CSRF 사용 X
			.authorizeHttpRequests(config ->   // 사용자 인증 설정
				config.requestMatchers(whiteList).permitAll()  // whiteList에 포함되는 경로는 모두 접근 가능
				.requestMatchers("/admin/**").hasRole("ADMIN") // /admin 하위 경로는 ADMIN 만 접근 가능, ROLE이 하나이므로 hasRole() 사용
				.requestMatchers("/staff/**").hasAnyRole("ADMIN", "STAFF") // staff 하위 경로는 ADMIN, STAFF 접근 가능, ROLE이 여러 개이므로 hasAnyRole() 사용
				.anyRequest().authenticated()
				)
			.formLogin(config ->
				config.loginPage("/user/required_loginform")
				.loginProcessingUrl("/user/login")  // Spring Security가 자동으로 로그인 처리를 해줄 요청 경로 설정
				.usernameParameter("userName")  // /user/login으로부터 넘어온 값(userName), 이 때 username과 password를 알려야 함.
				.passwordParameter("password")
				.successHandler(new AuthSuccessHandler())  // 로그인 성공 이후에 뭔가를 처리할 것이 있다면 핸들러를 등록해서 처리한다.
				.failureForwardUrl("/user/login_fail")  // 로그인 실패 시, 이동할 경로(/user/login_fail)를 설정
				.permitAll()
				)
			.logout(config -> 
				config.logoutUrl("/user/logout")  // 로그아웃 시, 이동할 경로(Spring Security가 자동 처리)
				.logoutSuccessUrl("/")  // 로그아웃 이후에 리다이렉트 경로 설정
				.permitAll()
				)
			.exceptionHandling(config ->  // 인증 처리 중 예외가 발생했을 때 설정. 권한 확인 과정에서 예외가 발생한 경우.
				config.accessDeniedPage("/user/denied")  // Spring Security는 인증에 실패하는 경우, 403 Forbidden을 발생시킨다. 이 때, 이동할 경로를 설정한다.
				)
			.sessionManagement(config -> 
				config.maximumSessions(1)  // 최대 허용 세션 수
				.expiredUrl("/user/expired")  // 허용 세션 개수가 넘어서 로그인이 해제된 경우, 리다이렉트할 경로 지정
				);
		
		return httpSecurity.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity httpSecurity, 
			UserDetailsService userDetailsService,
			BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
		AuthenticationManagerBuilder authManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
		
		authManagerBuilder.userDetailsService(userDetailsService)
						  .passwordEncoder(bCryptPasswordEncoder);
		
		return authManagerBuilder.build();
	}
}
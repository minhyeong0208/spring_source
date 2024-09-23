package pack.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	// CORS 설정을 관리하기 위해 사용되는 인터페이스
	// 글로벌 CORS 설정은 모든 HTTP 엔드포인트에 대해 적용된다.
	// 필요에 따라 특정 경로에 대해서만 CORS를 설정할 수도 있다.
	// 이러한 설정을 통해 다른 도메인에서의 WebSocket 연결문제를 해결할 수 있다.
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") 
		.allowedOrigins("*")  // 모든 도메인 허용
		.allowedMethods("GET","POST","PUT","DELETE")  // 허용할 HTTP 메소드
		.allowedHeaders("*");  // 모든 헤더 허용
	}
}

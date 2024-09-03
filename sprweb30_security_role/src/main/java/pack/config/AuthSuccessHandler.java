package pack.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//  1) 요청 캐쉬 객체를 직접 생성해서
//	클라이언트가 요청 시 요청과정에서 발생하는 여러 정보들을 세션에 담아 두고 필요시 꺼내어 쓰기 위한 기능이다.
//	유념할 점은 이 요청 캐시를 스프링 시큐리티가 언제, 어떤 이유로 사용 하느냐를 이해하는 것이 중요하다.
//	스프링 시큐리티에서는 SavedRequest 에 캐시용 데이터들을 담아 두고 이 객체를 세션에 저장하게 되는데 이 시점은 정확하게 인증에 실패할 때가 아닌 인증의 과정을 아예 거치지 않은 상태에서 인증 사용자에게만 허용되는 자원에 접근했다가 FilterSecurityInterceptor 필터에 의해서 접근이 거부되어 예외가 발생하게 되고 그 예외를 ExceptionTranslationFilter가 받아서 처리하는 과정 중에 requestCache.saveRequest(request, response) 처리가 이루어 진다는 점이다. 그리고 이후에 사용자가 인증에 성공하게 되면 인증필터가 ExceptionTranslationFilter 에서 처리한 RequestCache와 SavedRequest 객체를 참조해서 클라이언트가 원래 접근하고자 했던 자원의 정보를 얻어서 SuccessHandler 에서 리다이렉트 할 뿐 이러한 원리를 어떤 시점과 위치에서 활용하느냐는 개발자의 몫이다.
//	그래서 /login으로 바로 접근해서 인증에 성공하게 되면 RequestCache와 SavedRequest의 처리가 전혀 이루어지지 않기 때문에 당연히 savedRequest는 null일 수 밖에 없다. 즉 인증에 성공한 상태에서 자원에 접근할 경우 FilterSecurityInterceptor 가 접근을 거부하지 않을 것이고 그러면 예외가 발생하지 않으므로 ExceptionTranslationFilter를 호출할 일이 없기 때문에 savedRequest 객체는 생성되지 않는다. 
//	savedRequest는 FilterSecurityInterceptor 와 ExceptionTranslationFilter의 과정에서 생성되는 객체임을 기억하면 된다. 그렇다면 SuccesHandler에서 savedRequest가 null 인치 체크하는 구문이 필요하고, 상황에 따른 분기 로직이 구현되어야 할 것이다.

	private RequestCache requestCache = new HttpSessionRequestCache();

	// 2) 생성자에서 부모 객체에 전달
	public AuthSuccessHandler() {
		super.setRequestCache(requestCache);
	}

	// 로그인 성공 이후 자동으로 호출되는 메소드
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// 추가로직 구현, 로깅 처리 .., 세션 처리 .. , 예외 처리 .. 등
		// 세션 유지 시간 설정
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60 * 20); // 초 단위로 설정

		// 3) 로그인 성공 이후 미리 저장된 요청이 있었는지 읽어와서
		SavedRequest cashed = requestCache.getRequest(request, response);

		// 4) 만일 미리 저장된 요청이 없다면 (로그인하지 않은 상태로 인증이 필요한 경로를 요청하지 않았다면)
		if (cashed == null) {
			// 5) 로그인 환영 페이지로 forward 이동
			RequestDispatcher rd = request.getRequestDispatcher("/user/login_success");
			rd.forward(request, response);
		} else {
			// 6) 원래 가려던 목적지 경로로 리다이렉트 시킨다 (GET 방식 요청 파라미터도 자동으로 같이 가지고 간다) SecurityConfig
			// 클래스에서 http.formLogin().successHandler(new CustomAuthenticationHandler())로
			// 설정한다.
			super.onAuthenticationSuccess(request, response, authentication);
		}

	}

}
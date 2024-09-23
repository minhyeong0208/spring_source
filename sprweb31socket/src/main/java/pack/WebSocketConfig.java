package pack;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker  // STOMP 웹 소켓 메시징을 활성화함
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/topic");  // "/topic"으로 시작하는 메세지는 메세지 브로커로 라우팅이 된다.
		registry.setApplicationDestinationPrefixes("/app");  // "/app"으로 시작하는 메세지를 현재 서버로 보낸다는 의미이다.
	}
	
	@Override  // STOMP 엔드포인트를 등록
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws")
		.setAllowedOriginPatterns("*")  // 모든 도메인을 허용하면서 allowCredentiails(자격 증명)을 사용할 수 있음.
		.withSockJS();
		// "/ws" 엔드포인트는 SockJS 옵션을 통해 웹소켓을 사용할 수 있도록 설정
		// .allowedOriginPatterns("http://localhost:3000", "https://korea.com") // 허용할 도메인 명시
	}
}

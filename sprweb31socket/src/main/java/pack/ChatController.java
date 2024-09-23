package pack;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
	// Spring WebSocket 애플리케이션에서 클라이언트가 특정 목적지로 전송하는 메시지를 처리하는 메서드를 정의하는 데 사용된다.
	@MessageMapping("/message")  // /app/message로 수신된 메세지를 처리. 라우팅할 때, /app은 생략.
	// 처리된 메세지는 "/topic/messages"로 브로드캐스팅한다.
	@SendTo("/topic/messages")
	public String sendMessage(String message) {
		return message; // 클라이언트로부터 받은 메시지를 그대로 반환한다.  
		// 자동으로 /topic/messages 경로를 구독(subscribe)하고 있는 모든 클라이언트에 전송한다.
	}
}
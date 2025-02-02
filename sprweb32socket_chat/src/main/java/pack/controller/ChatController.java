package pack.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import pack.model.ChatMessage;

@Controller
public class ChatController {

	// 새로운 접속자가 채팅에 참여할 때, 처리용
	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public") // 여기서 송신 후, chat.html에서 수신한다.
	public ChatMessage addUser(ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		// 웹 소켓 세션에 채팅명 저장. 세션은 클라이언트와 서버 사이의 연결을 추적한다.

		return chatMessage; // 새로운 접속자의 참여를 모든 클라이언트에 전송(BroadCast)
	}

	// 접속한 클라이언트가 전송한 메세지 처리용
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public") // 여기서 송신 후, chat.html에서 수신한다.
	public ChatMessage sendMessage(ChatMessage chatMessage) {
		return chatMessage; // 반환할 메세지는 '/topic/public' 주제로 모든 클라이언트에 전송(BroadCast)
	}
}

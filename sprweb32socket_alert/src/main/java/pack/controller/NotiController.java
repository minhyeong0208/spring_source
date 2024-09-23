package pack.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import pack.model.MyNotification;

@Controller
public class NotiController {
	
	@MessageMapping("/friend-request")
	@SendTo("/topic/notifications")
	public MyNotification friendRequest(String fromUser) {
		if(fromUser == null || fromUser.trim().isEmpty()) {
			fromUser = "알 수 없는 사용자";
		}
		return new MyNotification("친구 요청", fromUser + "님이 친구 요청을 보냈습니다.");
	}
	
	@MessageMapping("/comment")
	@SendTo("/topic/notifications")
	public MyNotification comment(String fromUser) {
		if(fromUser == null || fromUser.trim().isEmpty()) {
			fromUser = "아무개";
		}
		return new MyNotification("댓글", fromUser + "님이 게시판에 댓글을 작성했습니다.");
	}
	
	@MessageMapping("/like")
	@SendTo("/topic/notifications")
	public MyNotification like(String fromUser) {
		if(fromUser == null || fromUser.trim().isEmpty()) {
			fromUser = "익명 사용자";
		}
		return new MyNotification("좋아요", fromUser + "님이 게시물을 좋아해요.");
	}
}

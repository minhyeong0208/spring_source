package pack.model;

public class MyNotification {
	private String type;  // 알림 유형 : 친구 요청, 댓글, 좋아요
	private String message;  // 알림 내용
	
	public MyNotification() {
		// TODO Auto-generated constructor stub
	}
	
	public MyNotification(String type, String message) {
		this.type = type;
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
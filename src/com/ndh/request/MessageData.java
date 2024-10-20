package com.ndh.request;

public class MessageData {
	private String sender;
	private String recipient;
	private String content;

	public MessageData(String sender, String recipient, String content) {
		this.sender = sender;
		this.recipient = recipient;
		this.content = content;
	}

	// Getter và Setter (nếu cần)
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
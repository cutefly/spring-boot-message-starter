package kr.co.kpcard.message;

import lombok.Builder;

@Builder
public class MessageDT {

	private String templateId;
	private String receiver;
	private String subject;
	private String text;
}

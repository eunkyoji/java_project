package co.yedam.board.vo;

import java.io.Serializable;

public class Reply implements Serializable {
	private int replyNo;
	private int brdNo;
	private String reply;
	private String replyer;

	public Reply() {
	}

	public Reply(int brdNo, String reply, String replyer) {
		super();
		this.brdNo = brdNo;
		this.reply = reply;
		this.replyer = replyer;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}

	@Override
	public String toString() {
		return "  [" + replyNo + "]    " + reply + "     " + replyer;
	}

}

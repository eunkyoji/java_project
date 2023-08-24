package co.yedam.board.service;

import java.util.List;

import co.yedam.board.vo.Reply;

public interface ReplyService {
	public boolean addReply(Reply reply);
	public List<Reply> replyList(int brdNo);
	public boolean delReply(int replyNo);
	public void save();
}

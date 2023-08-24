package co.yedam.board.service;

import java.util.List;

import co.yedam.board.vo.Reply;

public interface ReplyService {
	// 등록(추가)
	public boolean add(Reply reply);
	
	// 수정 : 글 내용 수정.
	public boolean modify(Reply reply);
	
	// 삭제
	public boolean remove(int replyNo, int brdNo);
	
	public List<Reply> list(int page, int brdNo);
	
	// 종료.
	public void save();
	
	// 글번호 입력 시 작성자 반환.
	public String getResponseUser(int replyNo, int brdNo);

	public int getTotal();
	
}

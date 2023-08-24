package co.yedam.board.service;

import java.util.List;

import co.yedam.board.vo.Board;

// 파일저장, DB저장.
public interface BoardService {
	// 등록(추가)
	public boolean add(Board board);
	// 목록
	public List<Board> list(int page);
	public int getTotal();
	// 수정: 글내용 수정.
	public boolean modify(Board board);
	// 삭제
	public boolean remove(int brdNo);
	// 상세조회
	public Board search(int brdNo);
	// 종료.
	public void save();
	// 글번호 - 작성자 반환.
	public String getResponseUser(int brdNo);
	
}

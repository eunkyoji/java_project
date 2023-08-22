package co.yedam.board;

import java.util.List;

// 파일저장, DB저장
public interface BoardService {
	// 등록(추가)
	public boolean add(Board board);
	
	// 목록
	public List<Board> list(int page);
	
	// 전체 건수
	public int getTotal();
	
	// 수정 : 글 내용 수정.
	public boolean modify(Board board);
	
	// 삭제
	public boolean remove(int brdNo);
	
	// 상세조회
	public Board search(int brdNo);
	
	// 종료.
	public void save();
}

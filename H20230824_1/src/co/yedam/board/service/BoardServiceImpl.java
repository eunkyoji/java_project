package co.yedam.board.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.yedam.board.vo.Board;

public class BoardServiceImpl implements BoardService {

	List<Board> boardList = new ArrayList<>();

	public BoardServiceImpl() {
		init();
	}

	private void init() {
		try {
			FileInputStream fis = //
					new FileInputStream("c:/temp/board.dat");
			ObjectInputStream ois = //
					new ObjectInputStream(fis);
			boardList = (List<Board>) ois.readObject();

			ois.close();
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int getMaxNo() {
		int brdNo = 0;
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() > brdNo) {
				brdNo = boardList.get(i).getBrdNo();
			}
		}
		return brdNo + 1;
	}

	@Override
	public boolean add(Board board) {
		board.setBrdNo(getMaxNo());
		board.setWriteDate(new Date());
		board.setUpdateDate(new Date());
		return boardList.add(board);
	}

	@Override
	public List<Board> list(int page) {
		int start = (page - 1) * 5;
		int end = page * 5;
		List<Board> pageList = new ArrayList<>();
		for (int i = 0; i < boardList.size(); i++) {
			if (i >= start && i < end) {
				pageList.add(boardList.get(i));
			}
		}
		return pageList;
	}

	@Override
	public boolean modify(Board board) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() //
					== board.getBrdNo()) {
				boardList.get(i).setBrdContent(board.getBrdContent());
				boardList.get(i).setUpdateDate(new Date());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean remove(int brdNo) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() == brdNo) {
				boardList.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public Board search(int brdNo) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() == brdNo) {
				return boardList.get(i);
			}
		}
		return null;
	}

	@Override
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/board.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(boardList);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getTotal() {
		return boardList.size();
	}

	@Override
	public String getResponseUser(int brdNo) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() == brdNo) {
				return boardList.get(i).getBrdWriter();
			}
		}
		return null;
	}
}

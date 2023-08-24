package co.yedam.board.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.vo.Reply;

public class ReplyServiceImpl implements ReplyService {

	List<Reply> replyList = new ArrayList<>();

	public ReplyServiceImpl() {
		init();
	}

	private void init() {
		try {
			FileInputStream fis = //
					new FileInputStream("c:/temp/reply.dat");
			ObjectInputStream ois = //
					new ObjectInputStream(fis);
			replyList = (List<Reply>) ois.readObject();

			ois.close();
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int getMaxNo() {
		int replyNo = 0;
		for (int i = 0; i < replyList.size(); i++) {
			if (replyList.get(i).getReplyNo() > replyNo) {
				replyNo = replyList.get(i).getReplyNo();
			}
		}
		return replyNo + 1;
	}

	@Override
	public boolean addReply(Reply reply) {
		reply.setReplyNo(getMaxNo());
		return replyList.add(reply);
	}

	@Override
	public List<Reply> replyList(int brdNo) {
		List<Reply> rlist = new ArrayList<>();
		for (int i = 0; i < replyList.size(); i++) {
			if (replyList.get(i).getBrdNo() == brdNo) {
				rlist.add(replyList.get(i));
			}
		}
		return rlist;
	}

	@Override
	public boolean delReply(int replyNo) {
		for (int i = 0; i < replyList.size(); i++) {
			if (replyList.get(i).getReplyNo() == replyNo) {
				replyList.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/reply.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(replyList);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

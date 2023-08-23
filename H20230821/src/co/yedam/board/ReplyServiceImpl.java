package co.yedam.board;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReplyServiceImpl implements ReplyService{

	List<Reply> replyList = new ArrayList<>();
	
	public ReplyServiceImpl() {
		init();
	}
	
	private void init() {
		try {
			FileInputStream fis = new FileInputStream("C:/Temp/reply.dat");
			
			ObjectInputStream ois = new ObjectInputStream(fis);
			replyList = (List<Reply>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private int getMaxNo(int brdNo) {
		int replyNo = 0;
		for( int i = 0; i < replyList.size(); i++ ) {
			if( replyList.get(i).getBrdNo() == brdNo ) {
				if( replyList.get(i).getReplyNo() > replyNo ) {
					replyNo = replyList.get(i).getReplyNo();
				}
			}
		}
		return replyNo + 1;
	}
	
	@Override
	public boolean add(Reply reply) {
		reply.setReplyNo(getMaxNo(reply.getBrdNo()));
		return replyList.add(reply);
	}

	@Override
	public boolean modify(Reply reply) {
		for( int i = 0; i < replyList.size(); i++ ) {
			if( replyList.get(i).getBrdNo() == reply.getBrdNo() && replyList.get(i).getReplyNo() == reply.getReplyNo() ) {
				replyList.get(i).setReplyContent(reply.getReplyContent());
				return true;
			}
		}
		return false;
	}
	
	@Override
	public List<Reply> list(int page, int brdNo) {
		int start	= (page - 1) * 5;
		int end		= page * 5;
		
		List<Reply> pageList = new ArrayList();
		for( int i = 0; i < replyList.size(); i++ ) {
			if( replyList.get(i).getBrdNo() == brdNo && (i >= start && i < end) ) {
				pageList.add(replyList.get(i));
			}
		}
		return pageList;
	}

	@Override
	public boolean remove(int replyNo, int brdNo) {
		for( int i = 0; i < replyList.size(); i++ ) {
			if( replyList.get(i).getBrdNo() == brdNo && replyList.get(i).getReplyNo() == replyNo ) {
				replyList.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/reply.dat");
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

	@Override
	public int getTotal() {
		return replyList.size();
	}
	
	@Override
	public String getResponseUser(int replyNo, int brdNo) {
		for( int i = 0; i < replyList.size(); i++ ) {
			if( replyList.get(i).getBrdNo() == brdNo && replyList.get(i).getReplyNo() == replyNo ) {
				return replyList.get(i).getReplyWriter();
			}
		}
		return null;
	}
}

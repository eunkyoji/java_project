package co.yedam.board;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Board implements Serializable{
	private int		brdNo;		// brd_no 글번호
	private String	brdTitle;	// brd_title 제목
	private String	brdContent;	// brd_content 내용
	private String	brdWriter;	// brd_writer 작성자
	private Date	writeDate;	// write_date 작성일
	private Date	updateDate;	// update_date 수정일
	
	// constructor
	public Board() {
		
	}
	
	public Board(String brdTitle, String brdContent, String brdWriter) {
		super();
		this.brdTitle = brdTitle;
		this.brdContent = brdContent;
		this.brdWriter = brdWriter;
	}

	// getter/setter
	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public String getBrdTitle() {
		return brdTitle;
	}

	public void setBrdTitle(String brdTitle) {
		this.brdTitle = brdTitle;
	}

	public String getBrdContent() {
		return brdContent;
	}

	public void setBrdContent(String brdContent) {
		this.brdContent = brdContent;
	}

	public String getBrdWriter() {
		return brdWriter;
	}

	public void setBrdWriter(String brdWriter) {
		this.brdWriter = brdWriter;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Board [brdNo=" + brdNo + ", brdTitle=" + brdTitle + ", brdContent=" + brdContent + ", brdWriter="
				+ brdWriter + ", writeDate=" + writeDate + ", updateDate=" + updateDate + "]";
	}

	public String listInfo() {
		return brdNo + "\t" + brdTitle + "\t\t\t" + brdWriter; 
	}
	
	public String showInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = null;
		if( updateDate == null ) {
			date = "";
		} else {
			date = sdf.format(updateDate);
		}
		
		String str = null;
		
		str = "글번호 : " + brdNo + "\t 작성자 : " + brdWriter + "\t 작성일 : " + sdf.format(writeDate) + "\n" + " 제목 : " + brdTitle + "\n" + " 내용 : " + brdContent;
		
		return str;
	}
}

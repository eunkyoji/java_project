package co.yedam.classes.board;

public class Board {
	private int		no;
	private String	title;
	private String	content;
	private String	name;
	private String	date;
	
	public Board(int no, String title, String content, String name, String date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.name = name;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", name=" + name + ", date=" + date + "]"
				+ "\n content \n" + content;
	}
}

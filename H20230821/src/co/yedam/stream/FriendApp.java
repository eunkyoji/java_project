package co.yedam.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import co.yedam.friend.Friend;

public class FriendApp {
	Scanner scn = new Scanner(System.in);
	List<Friend> friends = new ArrayList<>();
	
	public FriendApp() {
		loadFile();
	}
	
	public void start() {
		boolean run = true;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.종료");
			System.out.println("선택 >> ");
			
			int menu = scn.nextInt();
			scn.nextLine();
			
			if( menu == 1 ) {
				add();
			} else if( menu == 2 ) {
				list();
			} else if( menu == 3 ) {
				System.out.println("종료합니다.");
				saveFile();
				run = false;
			}
		} // end of while
	}// end of start
	
	SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd");
	private void add() {
		String name		= printString("이름 입력");
		String phon		= printString("연락처 입력");
		String birth 	= printString("생일 입력(ex:95-06-15)");
		
		try {
			Friend fnd = new Friend(name, phon, sdf.parse(birth));
			friends.add(fnd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private void list() {
		for( Friend fnd : friends ) {
			System.out.println(fnd.toString());
		}
	}
	
	private void saveFile() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		//friends 컬랙션에 값 => 텍스트 저장.
		File file = new File("C:/Temp/friendList.txt");
		try {
			//FileWriter fw = new FileWriter("C:/Temp/friendList.txt");
			FileWriter fw = new FileWriter(file);
			for(Friend fnd : friends ) {
				String line = fnd.getName() + " " + fnd.getPhone() + " " + sdf.format(fnd.getBirth());
				fw.write(line + "\n");
			}
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadFile() {
		
		File file = new File("C:/Temp/friendList.txt");
		Scanner scn = null;
		try {
			scn = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String[] name = null;
		while(true) {
			String line = null;
			try {
				line = scn.nextLine();
			} catch (NoSuchElementException e) {
				break;
			}
			
			String[] data = line.split(" ");	//공란을 기준으로 배열 만듬
			
			try {
				friends.add(new Friend(data[0], data[1], sdf.parse(data[2])));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	private String printString(String msg) {
		System.out.println(msg + " >> ");
		return scn.nextLine();
	}
}

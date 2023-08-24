package co.yedam.board.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.vo.User;

public class UserServiceImpl implements UserService {
// users.txt 에서 정보를 읽고 
	// User정보를 List컬랙션에 저장.
// User 클래스 생성.
	List<User> userList = new ArrayList<>();

	public UserServiceImpl() {
		loadFile();
	}

	@Override
	public User checkLogin(User user) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserId().equals(user.getUserId())) {
				if (userList.get(i).getUserPw().equals(user.getUserPw())) {
					return userList.get(i);
				}
			}
		}
		return null;
	}
	
	void loadFile() {
		try {
			FileReader fr = new FileReader("c:/temp/users.txt");
			BufferedReader br = new BufferedReader(fr);
			while (true) {
				String str = br.readLine();
				if (str == null) {
					break;
				}
				String[] data = str.split(" ");
				userList.add(new User(data[0], data[1], data[2]));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public User checkId(User user) {
		for( int i = 0; i < userList.size(); i++ ) {
			if( userList.get(i).getUserId().equals(user.getUserId()) ) {
				return userList.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean setPassword(User user) {
			String line = null;
			for( int i = 0; i < userList.size(); i++ ) {
				if( userList.get(i).getUserId() == user.getUserId() ) {
					userList.get(i).setUserPw(user.getUserPw());
					return true;
				}
			}

		return false;
	}

	@Override
	public boolean userSave() {
		String line = null;
		for( int i = 0; i < userList.size(); i++ ) {
			if( i == 0 ) {
				line = userList.get(i).getUserId() + " " +
						   userList.get(i).getUserPw() + " " +
						   userList.get(i).getUserNm();
			} else {
				line += "\n" + userList.get(i).getUserId() + " " +
					   userList.get(i).getUserPw() + " " +
					   userList.get(i).getUserNm();
			}
		}
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("C:/Temp/users.txt");
			Writer oos = new OutputStreamWriter(fos);
			oos.write(line);
			
			oos.flush();
			oos.close();
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	


}

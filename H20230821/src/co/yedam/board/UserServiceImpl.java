package co.yedam.board;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{
	// users.txt 에서 정보를 읽고 User 정보를 List 컬랙션에 저장.
	// User 클래스 생성.
	
	List<User> userList = new ArrayList<>();

	public UserServiceImpl() {
		loadFile();
	}
	
	void loadFile() {
		try {
			FileReader fr = new FileReader("C:/Temp/users.txt");
			BufferedReader br = new BufferedReader(fr);
			 
			while(true) {
				String str = br.readLine();
				if(str == null) {
					break;
				}
				
				String[] userInfo = str.split(" ");
				userList.add(new User(userInfo[0], userInfo[1], userInfo[2]));
			}
			
			fr.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public User checkLogin(User user) {
		
		for( int i = 0; i < userList.size(); i++ ) {
			if( userList.get(i).getId().equals(user.getId())) {
				if( userList.get(i).getPw().equals(user.getPw())) {
					return userList.get(i);
				}
				
			}
		}
		return null;
	}
}

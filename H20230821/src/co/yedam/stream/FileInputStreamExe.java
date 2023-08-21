package co.yedam.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class FileInputStreamExe {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:/Temp/out.data");
			while(true) {
				int val = fis.read();
				if( val == -1 ) {
					break;
				}
				System.out.println(val);
			}
			
			fis.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

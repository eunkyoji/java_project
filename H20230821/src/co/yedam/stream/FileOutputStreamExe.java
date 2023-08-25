package co.yedam.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileOutputStreamExe {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/out.data");
			fos.write(100);
			fos.write(110);
			fos.write(255);//2 4 8 16 32 64 128 256
			// 0 ~ 255
			fos.flush();	// 버퍼의 캐시값을 비움
			fos.close();	// 리소스 환원
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("end");
	}
}

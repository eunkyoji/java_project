package co.yedam.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExe {
	public static void main(String[] args) {
		try {
			File file = new File("src/co/yedam/stream/FileCopy.java");
			FileReader fr = new FileReader(file);
			
			char[] buf = new char[100];
			
			while(true) {
				int val = fr.read(buf);
				if( val == -1 ) {
					break;
				}
				
				for( int i = 0; i < val; i++ ) {
					System.out.print(buf[i]);
				}
				
			}
			
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

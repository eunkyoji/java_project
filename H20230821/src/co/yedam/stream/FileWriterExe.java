package co.yedam.stream;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterExe {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("c:/Temp/names.txt");
			Scanner scn = new Scanner(System.in);
			
			System.out.println("start");
			while(true) {
				String line = scn.nextLine();
				if( line.equals("quit") ) {
					break;
				}
				fw.write(line + "\n");
			}
			fw.flush();
			fw.close();
			scn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("end");
	}
}

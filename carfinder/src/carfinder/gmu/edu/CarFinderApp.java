package carfinder.gmu.edu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CarFinderApp {
	public static void main(String [] args){
		
		cacheUsers();
		login(usersAr);
		menu(usersAr);
		
	}

	private static void cacheUsers() {
		BufferedReader br = null;
		String line="";
		String[] outData = new String[5];
		int counter=0;
 		try{
			br = new BufferedReader(new FileReader(path)); 
			while( (line = br.readLine()) !=null ){
				System.out.println("[Reading from file ...]");
				//System.out.println(line);
				//store this information inside another file
				outData[counter++] = line;
			}
			String newPath = "src/FilesIO/copy.txt";
			write(outData,newPath);
			
			File f = new File("src/FilesIO/copy.txt");
			System.out.println(f.isDirectory());
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

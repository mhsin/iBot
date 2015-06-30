package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Watch {
	
	public static ArrayList<String> partNumber = new ArrayList<String>();
	public static ArrayList<String> deliveryMessage = new ArrayList<String>();
	
	public static void loadPartNum(){
		FileReader fileReader;
		try {
			fileReader = new FileReader("watchPartNum.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			try {
				while ((line = bufferedReader.readLine()) != null) {
					partNumber.add(line);
				}
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}

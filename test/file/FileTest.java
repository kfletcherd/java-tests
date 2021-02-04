package test.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

class FileTest {

	public static void main(String args[]){
		load(args[0]);
	}

	public static void load(String userInput){
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("test.ini"));

			p.setProperty("exists", "true");
			p.setProperty("User Input", userInput);
			p.store(new FileOutputStream("test.ini"), "Settings");

			p.list(System.out);

		} catch (Exception e) {
			System.out.println("Failed"+e.toString());
		}
	}
}


package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class commonUtils {

	public static String generateEmailwithNanoTime() {
		return "user" + System.currentTimeMillis() + System.nanoTime() + "@gmail.com";
	}
	
	
	public static Properties loadPropertiesFile() {
		Properties prop=new Properties();
		FileReader fr=null;
		try {
			fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\ProjectConfig.properties");
			prop.load(fr);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return prop;
		
	}
}

package Utilities_Class;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class My_Util {

		public static FileInputStream Properties_Setup() throws Throwable {
			Properties prop=new Properties();
			File file=new File("C:\\Users\\lenovo\\git\\repository\\Hybrid_FrameWork\\src\\test\\java\\utilities\\data.properties");
			FileInputStream fr=new FileInputStream(file);
			prop.load(fr);
			System.out.println(prop.getProperty("browser"));
			return fr;
		}
		
	
}

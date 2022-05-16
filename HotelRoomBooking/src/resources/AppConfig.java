package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//import org.apache.log4j.Logger;

public class AppConfig {
	public static final Properties PROPERTIES;
	public static InputStream inputStream = null;
	static {
		try {
			inputStream = new FileInputStream("src/resources/configuration.properties");
		}
		catch (FileNotFoundException e) {
//			Logger logger = Logger.getLogger(AppConfig.class);
//			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		PROPERTIES = new Properties();
		try {
			PROPERTIES.load(inputStream);
		}
		catch (IOException e) {
			e.printStackTrace();
//			Logger logger = Logger.getLogger(AppConfig.class);
//			logger.error(e.getMessage(), e);
		}
	}
}

package configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * handy class allowing me to easily get properties saved in a .properties file
 * @author amine
 *
 */
public class AppProperties {
	private static volatile AppProperties instance;
	private Properties properties;
	private static String fileName;
	private File file;
	private FileInputStream confFile;
	private AppProperties(){
		fileName = getClass().getClassLoader().getResource("app.properties").getFile();
		properties = new Properties();
		file = new File(fileName);
		try {
			confFile = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		readProperties();
	}
	public static AppProperties getInstance(){
		if(instance == null){
			instance = new AppProperties();
		}
		return instance;
	}

	private void readProperties(){
		try {
			properties.load(confFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Properties getPropreties(){
		return properties;
	}
	public String getProperty(String key){
		return properties.getProperty(key);
	}
}

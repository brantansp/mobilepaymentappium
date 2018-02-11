package mBankingUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


// TODO: Auto-generated Javadoc
/**
 * The Class PropertyFileReader.
 */
public class PropertyFileReader {
	
	private String propFileName;

	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	private Properties properties;

	public PropertyFileReader(final String propertyFile) {
		propFileName = propertyFile;
		log.info("file : "+propFileName);
		loadProperty();
	}

	public static void main(String[] args) {
        String path = System.getProperty("user.dir")+"\\property\\driver.properties";
        log.info("path : "+path);
		PropertyFileReader handler = new PropertyFileReader(path);
		log.info(handler.getProperty("orientation"));
	}

	public String getProperty(String key) {
		
		String value = properties.getProperty(key);
		return value;
	}
	
	private final void loadProperty() {
		InputStream is = null;
		try {
			is = new FileInputStream(propFileName);
			properties = new Properties();
			properties.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}

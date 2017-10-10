package catalog.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import catalog.view.MainController;

 // Connection Factory, which reads the configuration data from a XML file.
 
public class ConnectionFactory {

	private static SqlSessionFactory sqlSessionFactory;
	
	private ConnectionFactory() {
		throw new IllegalStateException("Utility class");
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			try {
	
				String resource = "SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
	
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
	
			catch (FileNotFoundException fileNotFoundException) {
				MainController.LOGGER.log(Level.ALL, "context", fileNotFoundException);
			}
			catch (IOException iOException) {
				MainController.LOGGER.log(Level.ALL, "context", iOException);
			}
		}
		
		return sqlSessionFactory;
	}

}

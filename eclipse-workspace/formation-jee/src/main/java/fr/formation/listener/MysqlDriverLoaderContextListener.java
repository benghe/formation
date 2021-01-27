package fr.formation.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MysqlDriverLoaderContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	

}

/**
 * Configuration Holder - Application Scoped
 */
package pl.studioit.puzzlecrm.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author K.O.
 * k.olszewski@o2.pl
 */
public class Config implements ServletContextListener {
	private String hello= "Hello";
	
	// Do stuff during webapp's startup.
	public void contextInitialized(ServletContextEvent event) {
		 event.getServletContext().setAttribute("config", this);

	}

	// Do stuff during webapp's shutdown.
	public void contextDestroyed(ServletContextEvent event) {

	}

	/**
	 * @param hello the hello to set
	 */
	public void setHello(String hello) {
		this.hello = hello;
	}

	/**
	 * @return the hello
	 */
	public String getHello() {
		return hello;
	}

}

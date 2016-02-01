package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import cron.Mailer;

/**
 * 
 * @author amine
 *	starts a Mailer CRON job
 */
@WebListener
public class Listener implements ServletContextListener {
	public void contextInitialized(ServletContext context) {
		Mailer.main(null);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
	}
}

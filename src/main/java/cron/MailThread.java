package cron;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import configuration.AppProperties;
import entities.ManagerRH;
import listeners.LocalEntityManagerFactory;

/*
 * this thread will be responsible of sending emails to the users
 */
public class MailThread implements Runnable {

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		Properties props = AppProperties.getInstance().getPropreties();
		String username = props.getProperty("email.username");
		String password = props.getProperty("email.password");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		Query query = em.createNamedQuery("ManagerRH.findAll", ManagerRH.class);
		List<ManagerRH> managers = query.getResultList();
		for (Iterator<ManagerRH> rhIter = managers.iterator(); rhIter.hasNext();) {
			ManagerRH manager = rhIter.next();
			sendEmail(props,session,manager);
		}
	}

	private void sendEmail(Properties props,Session session,ManagerRH manager) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(props.getProperty("email.username")));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(manager.getEmail()));
			message.setSubject("It's A New Month, A new BAP, A new Life :p");
			message.setText("Dear " + manager.getPrenom() + ","+
							"Please create a new BAP for each and every one of your coleagues");
			Transport.send(message);
			System.out.println("sent email to "+manager.getPrenom());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

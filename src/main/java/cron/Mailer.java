package cron;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Mailer {
	private Runnable mailThread;
	public static void main(String[] args){
		new Mailer();
	}
	public Mailer(){
		this.mailThread = new MailThread();
		this.startCronThread();
	}
	private void startCronThread(){
	    ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
	    ses.scheduleAtFixedRate(mailThread, 0, 31, TimeUnit.DAYS);  // every month (or so :p)
	}
}

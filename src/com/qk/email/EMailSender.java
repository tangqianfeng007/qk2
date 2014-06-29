package com.qk.email;

import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


/**
 * EMail发送对象
 */
public class EMailSender {

    /**
     * 邮件发送队列
     */
    private LinkedBlockingQueue<EMailTask> queue;

    private Email email;

    public EMailSender(String username, String password) throws Exception {
        this.queue = new LinkedBlockingQueue<EMailTask>();
        this.email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthentication(username, password);
        email.setSSLOnConnect(true);
        email.setFrom(username);

        //启动处理线程
        new Thread(new EMailWorker()).start();
    }

    public void addTask(String address, String subject, String message) {
        this.queue.add(new EMailTask(address, subject, message));
    }

    /**
     * 用来发送邮件的进程
     */
    private class EMailWorker implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    EMailTask task = queue.take();
                    try {
                        email.addTo(task.address);
                        email.setSubject(task.subject);
                        email.setMsg(task.message);
                        email.setCharset("UTF-8");
                        email.send();
                    } catch (EmailException e) {

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

    }

    private class EMailTask {

        private String address;

        private String subject;

        private String message;

        public EMailTask(String address, String subject, String message) {
            this.address = address;
            this.subject = subject;
            this.message = message;
        }
    }
}

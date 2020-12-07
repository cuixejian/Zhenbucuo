package com.webtest.demo;
/**
 * author:cuixuejian
 
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailUtil2 {
	public static String getPropertyValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("conf/config.properties");
		prop.load(fis);
		fis.close();
		return prop.getProperty(key);

	}

	public MailUtil2() throws IOException, AddressException, MessagingException {

		String to = getPropertyValue("tomail");
		String[] strArray = null;
		strArray = to.split(",");
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}
		String sender = "cuixuejian2020@126.com";
		// 授权码
//		String auth_code = "VZWDRLIBCRCPABRM";
		String auth_code = "LZKQWUIBCNFPLVKM";
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.126.com");
		props.put("mail.smtp.auth", true);

		// 1、构造Session对象（邮件会话对象），设置服务器，授权码，需要Properties对象
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(sender, auth_code);
			}

		});
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(sender));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(strArray[0]));
//		设置标题
		message.setSubject("作为页面发送");
//		message.setText(aString);
		
//		一个Multipart对象包含一个或多个bodypart对象，组成邮件正文
		MimeMultipart mimeMultipart =new MimeMultipart();
		//读取本地测试报告文件,将文件添加到"节点"
		MimeBodyPart file=new MimeBodyPart();
//		SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");
		DataHandler dataHandler1 = new DataHandler(new FileDataSource("C:\\zhenbucuo\\project\\崔雪健\\TPshopcxj\\test-output\\s1\\t2.html"));
        file.setDataHandler(dataHandler1);
        
        mimeMultipart.addBodyPart(file);
        message.setContent(mimeMultipart);
				

		// 发送邮件
		Transport.send(message);

		
		

	}

}


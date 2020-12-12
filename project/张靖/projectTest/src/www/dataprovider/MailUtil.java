package www.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
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

import www.util.ReadProperties;

import java.util.Properties;

public class MailUtil extends ReadProperties{
	
	public static void send(String string) throws IOException, AddressException, MessagingException {

		String to = getPropertyValue("tomail");
		String[] strArray = null;
		strArray = to.split(",");
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}
		String sender = "ZJ793558181@126.com";
		// 授权码
		String auth_code = "XFWKGXTZPLKIXBRC";
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
		try {
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(strArray[0]));
//			设置标题
			message.setSubject("作为html发送");
//			message.setText(aString);
			
//			一个Multipart对象包含一个或多个bodypart对象，组成邮件正文
			MimeMultipart mimeMultipart =new MimeMultipart();
			//读取本地测试报告文件,将文件添加到"节点"
			MimeBodyPart file=new MimeBodyPart();
//			SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");
			DataHandler dataHandler1 = new DataHandler(new FileDataSource("F:/woow/ant/test/projectTest/reports/s1.html"));
	        file.setDataHandler(dataHandler1);
	        
	        mimeMultipart.addBodyPart(file);
	        message.setContent(mimeMultipart);
			// 发送邮件
			Transport.send(message);
			System.out.println("发送完毕");
		} catch (MessagingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

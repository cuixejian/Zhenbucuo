package aa;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {

	public static void sendMail(String title, String msg) throws IOException {

		Properties properties = new Properties();
		// 加载配置文件
		FileInputStream in = new FileInputStream("config/config.properties");
		// 使用properties对象加载输入流
		properties.load(in);
		// 获取key对应的value值
		in.close();
		String sender = properties.getProperty("frommail");
		// 授权码
		String auth_code = properties.getProperty("auth_code");
		String[] tos = properties.getProperty("tomail").split(",");

		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.163.com");
		props.put("mail.smtp.auth", true);

		// 1、构造Session对象（邮件会话对象），设置服务器，授权码，需要Properties对象
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(sender, auth_code);
			}

		});

		// 2、创建邮件，创建Message对象，子类 MimeMessage
		// 设置发件人、收件人、主题、正文
		Message message = new MimeMessage(session);
		try {

			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(tos[0]));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(tos[1]));
			message.setSubject(title);
			message.setText(msg);
			// 3、发送邮件
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
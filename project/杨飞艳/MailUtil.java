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
		// ���������ļ�
		FileInputStream in = new FileInputStream("config/config.properties");
		// ʹ��properties�������������
		properties.load(in);
		// ��ȡkey��Ӧ��valueֵ
		in.close();
		String sender = properties.getProperty("frommail");
		// ��Ȩ��
		String auth_code = properties.getProperty("auth_code");
		String[] tos = properties.getProperty("tomail").split(",");

		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.163.com");
		props.put("mail.smtp.auth", true);

		// 1������Session�����ʼ��Ự���󣩣����÷���������Ȩ�룬��ҪProperties����
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(sender, auth_code);
			}

		});

		// 2�������ʼ�������Message�������� MimeMessage
		// ���÷����ˡ��ռ��ˡ����⡢����
		Message message = new MimeMessage(session);
		try {

			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(tos[0]));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(tos[1]));
			message.setSubject(title);
			message.setText(msg);
			// 3�������ʼ�
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
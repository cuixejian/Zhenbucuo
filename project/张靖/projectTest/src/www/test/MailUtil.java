package www.test;

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
	
	public MailUtil() throws IOException, AddressException, MessagingException {

		String to = getPropertyValue("tomail");
		String[] strArray = null;
		strArray = to.split(",");
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}
		String sender = "ZJ793558181@126.com";
		// ��Ȩ��
		String auth_code = "XFWKGXTZPLKIXBRC";
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.126.com");
		props.put("mail.smtp.auth", true);

		// 1������Session�����ʼ��Ự���󣩣����÷���������Ȩ�룬��ҪProperties����
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
//		���ñ���
		message.setSubject("��Ϊҳ�淢��");
//		message.setText(aString);
		
//		һ��Multipart�������һ������bodypart��������ʼ�����
		MimeMultipart mimeMultipart =new MimeMultipart();
		//��ȡ���ز��Ա����ļ�,���ļ���ӵ�"�ڵ�"
		MimeBodyPart file=new MimeBodyPart();
//		SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");
		DataHandler dataHandler1 = new DataHandler(new FileDataSource("F:/woow/ant/test/projectTest/reports/index.html"));
        file.setDataHandler(dataHandler1);
        
        mimeMultipart.addBodyPart(file);
        message.setContent(mimeMultipart);
		// �����ʼ�
		Transport.send(message);
	}
}

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
		// ��Ȩ��
//		String auth_code = "VZWDRLIBCRCPABRM";
		String auth_code = "LZKQWUIBCNFPLVKM";
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
		DataHandler dataHandler1 = new DataHandler(new FileDataSource("C:\\zhenbucuo\\project\\��ѩ��\\TPshopcxj\\test-output\\s1\\t2.html"));
        file.setDataHandler(dataHandler1);
        
        mimeMultipart.addBodyPart(file);
        message.setContent(mimeMultipart);
				

		// �����ʼ�
		Transport.send(message);

		
		

	}

}


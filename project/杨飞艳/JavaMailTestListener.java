package aa;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class JavaMailTestListener extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult tr) {
		
		String title = tr.getInstanceName() + "£∫ ≤‚ ‘ ß∞‹";
		String msg = tr.getInstanceName()+"¿‡_"+tr.getName()+"∑Ω∑®£¨≤‚ ‘ ß∞‹";
		
		try {
			MailUtil.sendMail(title, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
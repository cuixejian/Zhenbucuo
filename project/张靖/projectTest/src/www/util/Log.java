package www.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	// ��ʼ��Log4j��־
	static Logger logger = LogManager.getLogger(Log.class.getName());
	// ��ӡ����������ͷ����־
	public static void startTestCase(String sTestCaseName) {
		logger.info("------------------ " + sTestCaseName + "  " +"��ʼִ�� ------------------");
	}
	
	//��ӡ����������������־
	public static void endTestCase(String sTestCaseName) {
		logger.info("------------------ " + sTestCaseName + "  " +"����ִ�н��� ---------------");

	}

	public static void fatal(String msg) {
		logger.fatal(msg);
	}

	public static void error(String msg) {
		logger.error(msg);
	}

	public static void warn(String msg) {
		logger.warn(msg);
	}

	public static void info(String msg) {
		logger.info(msg);
	}

	public static void debug(String msg) {
		logger.debug(msg);
	}
}

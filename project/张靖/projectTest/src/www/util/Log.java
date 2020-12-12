package www.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	// 初始化Log4j日志
	static Logger logger = LogManager.getLogger(Log.class.getName());
	// 打印测试用例开头的日志
	public static void startTestCase(String sTestCaseName) {
		logger.info("------------------ " + sTestCaseName + "  " +"开始执行 ------------------");
	}
	
	//打印测试用例结束的日志
	public static void endTestCase(String sTestCaseName) {
		logger.info("------------------ " + sTestCaseName + "  " +"测试执行结束 ---------------");

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

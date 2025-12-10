package Utilities;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerFactory {

   private LoggerFactory()
   {
       super();
   }

    /*
    * Normal way
    * public static Logger logger =LogManager.getLogger(LoggerFactory.class);
    *
    * which need to be applied to each class manually if we need to apply a logger for another class
    * */

    // instead we use a method to use the current thread, and return the class name that called the method
    /*
    * for additional info
    * getStackTrace()[1]  --> current thread
    * getStackTrace()[2]  --> logger itself
    * getStackTrace()[3]  --> the method that called the logger
    ** */

    public static Logger logger()
    {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }

    public static void logInfo(String... displayedMessage)
    {
        logger().info(String.join("",displayedMessage));
    }
    public static void debugLog(String... displayedMessage)
    {
        logger().debug(String.join("",displayedMessage));
    }
    public static void logWarn(String... displayedMessage)
    {
        logger().warn(String.join("",displayedMessage));
    }
    public static void logError(String... displayedMessage)
    {
        logger().error(String.join("",displayedMessage));
    }
}

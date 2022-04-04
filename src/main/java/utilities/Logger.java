package utilities;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import utilities.ReportsUtility.ExtentReport;

public class Logger {

    @Step("{message}")
    public static void logStep(String message) {
        System.out.println("<" + Helper.getCurrentTime("dd-MM-yyyy HH:mm:ss.SSS a") + "> " + message);
        ExtentReport.info(message);
    }

    public static void logMessage(String message) {
        System.out.println("<" + Helper.getCurrentTime("dd-MM-yyyy HH:mm:ss.SSS a") + "> " + message);
       ExtentReport.info(message);
    }

    @Attachment(value = "API Request - {type}", type = "text/json")
    public static byte[] attachApiRequestToAllureReport(String type, byte[] b) {
        return attachTextJson(b);
    }

    @Attachment(value = "API Response", type = "text/json")
    public static byte[] attachApiResponseToAllureReport(byte[] b) {
        return attachTextJson(b);
    }

    @Attachment(value = "API Response", type = "text/json")
    public static String attachApiResponseToAllureReport(String b) {
        return attachTextJson(b);
    }


    public static byte[] attachTextJson(byte[] b) {
        try {
            return b;
        } catch (Exception e) {
            return null;
        }
    }

    public static String attachTextJson(String b) {
        try {
            return b;
        } catch (Exception e) {
            return null;
        }
    }
}

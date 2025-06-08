package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtendReportUtility {
	public static final ExtentReports extentReports = new ExtentReports(); 
	  
 	public synchronized static ExtentReports createExtentReports() { 
 		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); 
 		reporter.config().setReportName("7r_mart_supermarket"); 
 		extentReports.attachReporter(reporter); 
 		extentReports.setSystemInfo("Organization", "Obsqura"); 
 		extentReports.setSystemInfo("Name", "Jyothi"); 
 		return extentReports; 
 	}
}

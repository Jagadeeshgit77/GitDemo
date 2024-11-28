import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportsDemo {
    ExtentReports extentReports;
    @BeforeTest
    public void config(){
        //ExtentReports, ExtentSpark Reporter
        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter report = new ExtentSparkReporter(path);

        report.config().setReportName("WebAutomationResults");
        report.config().setDocumentTitle("Test Results");

        extentReports = new ExtentReports();
        extentReports.attachReporter(report);
        extentReports.setSystemInfo("Tester", "Jagadeesh");
        System.out.println("Hi! I'm Y. I made some changes");
    }
    @Test
    public void initialDemo(){
        ExtentTest test=extentReports.createTest("InitialDemo");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        test.fail("Result not matched");

        extentReports.flush();


    }

}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.ie.driver", "D:\\Git\\selenium-auto-testing-repo\\selenium\\iedriver\\IEDriverServer.exe");

        // Instantiate a IEDriver class.
        WebDriver driver = new InternetExplorerDriver();
        driver.navigate().to("http://www.google.com");
    }
}

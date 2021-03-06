package jeus.blog.auto;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SampleTest {
    private WebDriver webDriver;

    @BeforeEach
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", "selenium/chromedriver/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @AfterEach
    public void quitDriver() {
        webDriver.close();
    }

    @Test
    public void showPage() {
        //指定したURLに遷移する
        webDriver.get("http://localhost:8080/app/v1/");

        // 最大5秒間、ページが完全に読み込まれるまで待つ
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

//        webDriver.findElement("");

        // 検証
//        assertThat(webDriver.getTitle(), is("さいけの技術ブログ"));
    }

    @Test
    public void testIE() {
        System.setProperty("webdriver.ie.driver", "D:/Git/selenium-auto-testing-repo/selenium/iedriver/IEDriverServer.exe");

        // Instantiate a IEDriver class.
        WebDriver driver = new InternetExplorerDriver();
        driver.get("http://www.google.com");

//        driver.manage().window().maximize();

        //Deleting all the cookies
//        driver.manage().deleteAllCookies();

        //launching the specified URL
//        driver.get("https://www.google.com/");

        //Locating the elements using name locator for the text box
        driver.findElement(By.name("q")).sendKeys("BrowserStack");

        //name locator for google search button
        WebElement searchIcon = driver.findElement(By.name("btnK"));
        searchIcon.click();

    }

    @Test
    public void showPage2() {
        //指定したURLに遷移する
        webDriver.get("https://saikeblog.com");

        // 最大5秒間、ページが完全に読み込まれるまで待つ
        webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        // タブの「技術」要素を取得し、クリックする
        WebElement webElement = webDriver.findElement(By.id("menu-item-37"));
        webElement.click();

        // 検証
//        assertThat(webDriver.getTitle(), is("技術 – さいけの技術ブログ"));
//        assertThat(webDriver.getCurrentUrl(), is("https://saikeblog.com/category/%e6%8a%80%e8%a1%93/"));
    }
}

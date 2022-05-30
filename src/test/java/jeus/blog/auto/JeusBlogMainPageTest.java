package jeus.blog.auto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class JeusBlogMainPageTest {

    private WebDriver webDriver;

    @BeforeEach
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", "selenium/chromedriver/chromedriver.exe");
        webDriver = new ChromeDriver();
        // Transition to the specified URL
        webDriver.get("http://localhost:8080/app/v1/");
    }

    @AfterEach
    public void quitDriver() {
        webDriver.close();
    }

    @Test
    public void showMainPage() throws InterruptedException {
        // Wait up to 5 seconds for the page to fully load
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        // Check title
        assertEquals("Jeu's Diary", webDriver.getTitle());
        assertEquals("His story making history", webDriver.findElements(By.name("mainBannerTitle")).stream()
                .findFirst()
                .get()
                .getText());
    }

    @Test
    public void showITBoardPage() throws InterruptedException {
        // Wait up to 5 seconds for the page to fully load
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        // Move to the IT Board page.
        webDriver.findElement(By.name("menu_it")).click();

        // Wait up to 5 seconds for the page to fully load
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        TimeUnit.SECONDS.sleep(5);

        // Check title

    }
}

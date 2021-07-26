import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class mainTest {




    WebDriver driver;
    WebDriverWait wait;
    @BeforeAll
    public void initDriver(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1420,108");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterAll
    public void closeDriver() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }


    @Test
    public  void googleSearchTest() {
        Logger logger = Logger.getLogger(this.getClass().getName());
        logger.warning("This is a warning!");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.get("https://google.com/ncr");
            driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
            WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3")));
            String s=firstResult.getAttribute("textContent");

            System.out.println(firstResult.getAttribute("textContent"));

            assert (s.equals("Cheese - Wikipedia"));

        } finally {
            //driver.quit();
        }


    }

}
package baseConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

import static ge.tbcitacademy.data.Constants.WAIT_LONG_SECONDS;
import static ge.tbcitacademy.data.Constants.WAIT_SHORT_MILSECONDS;

public class BaseClass {
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected Actions action;
    protected WebDriverWait waitLong;
    protected WebDriverWait shortWait;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
        waitLong = new WebDriverWait(driver, Duration.ofSeconds(WAIT_LONG_SECONDS));
        shortWait = new WebDriverWait(driver, Duration.ofMillis(WAIT_SHORT_MILSECONDS));
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
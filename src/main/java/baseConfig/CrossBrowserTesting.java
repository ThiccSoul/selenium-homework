package baseConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.time.Duration;
import static ge.tbcitacademy.data.Constants.WAIT_LONG_SECONDS;
import static ge.tbcitacademy.data.Constants.WAIT_SHORT_MILSECONDS;

public class CrossBrowserTesting {

    protected WebDriver driver;
    protected WebDriverWait waitLong;
    protected WebDriverWait waitShort;
    protected Actions action;
    protected JavascriptExecutor js;

    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        if (browser == null || browser.isEmpty()) {
            browser = "chrome"; // ბრაუზერი იქნება ქრომი თუ არ გადაეცემა პარამეტრი
        }
        driver = initializeDriver(browser);
        driver.manage().window().maximize();
        waitLong = new WebDriverWait(driver, Duration.ofSeconds(WAIT_LONG_SECONDS));
        waitShort = new WebDriverWait(driver, Duration.ofMillis(WAIT_SHORT_MILSECONDS));
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;

        System.out.println(browser + " browser is launched successfully.");
    }

    private WebDriver initializeDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(new ChromeOptions());
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver(new EdgeOptions());
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(new FirefoxOptions());
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser + ". Please specify 'chrome', 'edge', or 'firefox'.");
        }
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

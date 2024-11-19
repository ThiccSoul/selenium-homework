import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import static ge.tbcitacademy.data.Constants.*;
public class WaitsTest {

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void waitForDisappearance(){
        driver.get(DYNAMIC_CONTROLS_PAGE);
        WebElement enableButton = driver.findElement(By.xpath(ENABLE_BUTTON_XPATH));
        WebElement inputField = driver.findElement(By.xpath(INPUT_FIELD_XPATH));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

        enableButton.click();
        WebElement progressBar = driver.findElement(By.xpath(PROGRESS_BAR_XPATH));

        wait.until(ExpectedConditions.invisibilityOf(progressBar));
        Assert.assertEquals(enableButton.getText(), "Disable");

        inputField.sendKeys("ACCESS GRANTED");
    }

    @Test
    public void waitForText(){
        driver.get(TOOLS_QA_PAGE);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement startAndStopBtn = driver.findElement(By.id("startStopButton"));
        WebElement progressBar = driver.findElement(By.id("progressBar"));
        startAndStopBtn.click();
        wait.until(ExpectedConditions.textToBePresentInElement(progressBar, "100%"));
        System.out.println(progressBar.getText());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

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

public class NavigationTest {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ULTIMATE_QA_PAGE);
    }

    @Test
    public void test03() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement link1 = driver.findElement(By.xpath("//*[text()='Services']"));
        link1.click();
        wait.until(ExpectedConditions.urlToBe(ULTIMATE_QA_CONSULTING_PAGE));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, ULTIMATE_QA_CONSULTING_PAGE);
        driver.navigate().back();
        String currentUrl2 = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl2, ULTIMATE_QA_PAGE);
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }

}

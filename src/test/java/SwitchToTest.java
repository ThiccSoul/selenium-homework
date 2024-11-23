import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import static ge.tbcitacademy.data.Constants.ALERT_BTN_ID;
import static ge.tbcitacademy.data.Constants.DEMOQA_ALERTS_PAGE;

public class SwitchToTest {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // I think this would work but website demanded to upgrade plan :'(

//    @Test(priority = 1)
//    public void iFrameTest() {
////        driver.get("http://the-internet.herokuapp.com/iframe");
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////
////        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
////        driver.switchTo().frame(iframe);
////
////        WebElement iframeP = wait.until(
////                ExpectedConditions.presenceOfElementLocated(By.xpath(".//body[@id='tinymce']/p"))
////        );
////        iframeP.clear();
////        iframeP.sendKeys("Here Goes");
//
////        driver.switchTo().parentFrame();
////        WebElement alignCenterButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[@title='Align center']")));
////        alignCenterButton.click();
//
//    }
    @Test
    public void demoQATest() {
        driver.get(DEMOQA_ALERTS_PAGE);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement alertButton = driver.findElement(By.id(ALERT_BTN_ID));
        alertButton.click();

        // in case there will be delay in appearing alert popup
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}

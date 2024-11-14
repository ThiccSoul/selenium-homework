import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static ge.tbcitacademy.data.Constants.ultimateQaConsultingPage;
import static ge.tbcitacademy.data.Constants.ultimateQaPage;

public class NavigationTest {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ultimateQaPage);
    }

    @Test
    public void test03() throws InterruptedException {
        WebElement link1 = driver.findElement(By.xpath("(//*[@id='menu-item-218392'])[1]"));
        link1.click();
        // without sleep sometimes url won't be grabbed
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, ultimateQaConsultingPage, "wrong url is displayed");
        driver.navigate().back();
        Thread.sleep(2000);
        String currentUrl2 = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl2, ultimateQaPage, "wrong url is displayed for sure");
    }

    @AfterClass
    public void tearDown () throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

}

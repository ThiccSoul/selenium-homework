import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static ge.tbcitacademy.data.Constants.*;

public class WebElementTest {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(dragAndDropPage);
    }

    @Test
    public void test02() {
        WebElement columnA = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
        int locationOfColumnA = columnA.getLocation().getY();
        WebElement columnB = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
        int locationOfColumnB = columnB.getLocation().getY();
        Assert.assertEquals(locationOfColumnA, locationOfColumnB, "these bad boys doesn't match");

        String draggableValueA = columnA.getAttribute(draggableAttribute);
        String draggableValueB = columnB.getAttribute(draggableAttribute);

        Assert.assertEquals(draggableValueA, "true", "this element is not draggable");
        Assert.assertEquals(draggableValueB, "true", "this element is not draggable");

        WebElement link1 = driver.findElement(By.linkText("Elemental Selenium"));
        String hrefValue = link1.getAttribute("href");

        Assert.assertEquals(hrefValue, elementalSeleniumPage, "Link is not correct");
    }

    @AfterClass
    public void tearDown () throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}

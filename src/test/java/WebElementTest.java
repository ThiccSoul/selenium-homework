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
        driver.get(DRAG_AND_DROP_PAGE);
    }

    @Test
    public void test02() {
        WebElement columnA = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
        int locationOfColumnA = columnA.getLocation().getY();
        WebElement columnB = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
        int locationOfColumnB = columnB.getLocation().getY();
        Assert.assertEquals(locationOfColumnA, locationOfColumnB, "these bad boys doesn't match");

        String draggableValueA = columnA.getAttribute(DRAGGABLE_ATTRIBUTE);
        String draggableValueB = columnB.getAttribute(DRAGGABLE_ATTRIBUTE);

        Assert.assertEquals(draggableValueA, "true");
        Assert.assertEquals(draggableValueB, "true");

        WebElement link1 = driver.findElement(By.linkText("Elemental Selenium"));
        String hrefValue = link1.getAttribute("href");

        Assert.assertEquals(hrefValue, ELEMENTAL_SELENIUM_PAGE);
    }

    @AfterClass
    public void tearDown (){
        driver.quit();
    }
}

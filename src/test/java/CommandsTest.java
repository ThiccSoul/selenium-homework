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

public class CommandsTest {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(dynamicControlsPage);
    }

    @Test
    public void test01() {
        WebElement textField = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        Assert.assertFalse(textField.isEnabled());
        WebElement button = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        String buttonTextEnable = button.getText();
        Assert.assertEquals(buttonTextEnable, buttonEnableText);
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(textField.isEnabled());
        String message = successMessage.getText();

        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertEquals(message, enableMessage);

        String buttonTextDisable = button.getText();
        Assert.assertEquals(buttonTextDisable, buttonDisabledText);

        textField.sendKeys(inputTextExample);
        textField.clear();
        Assert.assertTrue(textField.getText().isEmpty());

        WebElement headingElement = driver.findElement(By.tagName("h4"));
        String headingElementText = headingElement.getText();
        Assert.assertEquals(headingElementText,mainHeadingTitle );

        WebElement headingDescription = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/p"));
        String headingDescriptionActualText = headingDescription.getText();
        Assert.assertEquals(headingDescriptionActualText, mainHeadingDescription);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

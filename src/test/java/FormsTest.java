import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import static ge.tbcitacademy.data.Constants.*;
import static util.HelperFunctions.universalSelector;

public class FormsTest {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void customDropDownTest() {
        driver.get(CUSTOM_DROPDOWN_PAGE);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement demo2Btn = driver.findElement(By.xpath(DEMO_BTN_XPATH));
        demo2Btn.click();

        WebElement signInWithDropDown = driver.findElement(By.id("dd"));
        WebElement ulList = signInWithDropDown.findElement(By.xpath(UL_LIST_RELATIVE_XPATH));

        Assert.assertFalse(ulList.isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(signInWithDropDown));
        signInWithDropDown.click();

        wait.until(ExpectedConditions.visibilityOf(ulList));
        Assert.assertTrue(ulList.isDisplayed());

        universalSelector(ulList, "Github");
    }

    @Test
    public void nativeDropDownTest(){
        driver.get(REGISTER_FORM_PAGE);
        WebElement maleRadioButton = driver.findElement(By.xpath(MALE_RADIO_BUTTON_XPATH));
        Select modelDropdown = new Select(driver.findElement(By.cssSelector(MODEL_DROPDOWN_XPATH)));
        WebElement inputAddress1 = driver.findElement(By.xpath(inputAddress1_XPATH));
        WebElement inputAddress2 = driver.findElement(By.xpath(INPUTADDRESS2_XPATH));
        WebElement inputCity = driver.findElement(By.xpath(INPUTCITY_XPATH));
        WebElement inputContact1 = driver.findElement(By.xpath(INPUT_CONTACT1_XPATH));
        WebElement inputContact2 = driver.findElement(By.xpath(INPUT_CONTACT2_XPATH));
        WebElement checkBox = driver.findElement(By.xpath(DELIVERY_XPATH));
        WebElement submit = driver.findElement(By.xpath(SUBMIT_XPATH));

        maleRadioButton.click();
        universalSelector(modelDropdown, "Mega 123 Medium screen");
        inputAddress1.sendKeys("Someone's Street");
        inputAddress2.sendKeys("apt 3, floor 2");
        inputCity.sendKeys("Tbilisi");
        inputContact1.sendKeys("zura jeshtianshiki");
        inputContact2.sendKeys("gocha xadaviki");
        if(!checkBox.isSelected()) checkBox.click();
        submit.click();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        driver.quit();

    }
}

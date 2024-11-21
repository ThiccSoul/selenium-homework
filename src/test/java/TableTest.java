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
import static util.HelperFunctions.getElementFromTable;

public class TableTest {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void techListicTableTest1() {
        driver.get(TECHLISTIC_PAGE);
        WebElement table1Element = getElementFromTable(driver.findElement(By.id(TECHLISTIC_TABLE_ID)), TECHLISTIC_ROW1 ,TECHLISTIC_COLUMN_HEADER1);
        System.out.println(table1Element.getText());
        Assert.assertEquals(table1Element.getText(), EXPECTED_TECHLISTIC_ELEMENT1);
    }
    @Test
    public void techListicTableTest2() {
        driver.get(TECHLISTIC_PAGE);
        WebElement table2Element = getElementFromTable(driver.findElement(By.cssSelector(TECHLISTIC_TABLE_CSSSELECTOR)), TECHLISTIC_ROW2, TECHLISTIC_COLUMN_HEADER2 );
        System.out.println(table2Element.getText());
        Assert.assertEquals(table2Element.getText(), EXPECTED_TECHLISTIC_ELEMENT2);
    }
    @Test
    public void techCanvasTableTest() {
        driver.get(TECH_CANVAS_PAGE);
        WebElement table3Element = getElementFromTable(driver.findElement(By.id(TECH_CANVAS_TABLE_ID)), TECH_CANVAS_ROW, 	TECH_CANVAS_COLUMN_HEADER);
        System.out.println(table3Element.getText());
        Assert.assertEquals(table3Element.getText(), EXPECTED_TECH_CANVAS_ELEMENT);
    }
    @Test
    public void hardDomTableTest() {
        driver.get(CHALLENGING_DOM_PAGE);
        WebElement table4Element = getElementFromTable(driver.findElement(By.tagName(HARDDOM_TABLE_TAGNAME)),HARDDOM_ROW , HARDDOM_COLUMN_NAME );
        System.out.println(table4Element.getText());
        Assert.assertEquals(table4Element.getText(), EPECTED_HARDDOM_ELEMENT);
    }
    @Test
    public void expandTestinPageTableTest(){
        driver.get(EXPAND_TESTING_PAGE);
        WebElement table5Element = getElementFromTable(driver.findElement(By.id(EXPAND_TESTING_TABLE_ID)), EXPAND_TESTING_ROW, EXPAND_TESTING_COLUMN_HEADER);
        System.out.println(table5Element.getText());
        Assert.assertEquals(table5Element.getText(), EXPECTED_EXPAND_TESTING_ELEMENT);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

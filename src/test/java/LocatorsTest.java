import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

import static ge.tbcitacademy.data.Constants.*;

public class LocatorsTest{
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void unorderedListTest() {
        driver.get(JQUERY_UI_PAGE);
        List<WebElement> ulElements = driver.findElements(By.xpath(UL_ELEMENTS_XPATH));
        List<WebElement> listFilteredWithLetterO = ulElements.stream().filter(li -> li.getText().toLowerCase().contains(FILTER_LETTER)).toList();

        listFilteredWithLetterO.parallelStream().forEach(li -> {
            WebElement href = li.findElement(By.tagName(ANCHOR_TAG));
            String hrefValue = href.getAttribute(ATTRIBUTE_HREF);

            assert hrefValue != null;
            if (!hrefValue.contains(FILTER_WORD)) {
                System.out.println(hrefValue);
            }
        });
    }

    @Test
    public void buttonsTest() {
        driver.get(ADD_REMOVE_ELEMENT_PAGE);
        WebElement addElementButton = driver.findElement(By.xpath(ADD_ELEMENT_BUTTON_XPATH));
        for(int i = 0; i < 3; i++ ){
            addElementButton.click();
        }
        WebElement lastAddedButton = driver.findElement(By.xpath(LAST_ADDED_BUTTON_XPATH));
        Assert.assertEquals(lastAddedButton.getAttribute(ATTRIBUTE_CLASS), ATTRIBUTE_CLASS_VALUE);

        List<WebElement> deleteButtons = driver.findElements(By.cssSelector(DELETE_BUTTONS_LIST_CSSSELECTOR));
        WebElement lastDeleteButton = deleteButtons.getLast();

        Assert.assertEquals(lastDeleteButton.getAttribute(ATTRIBUTE_ONCLICK), ATTRIBUTE_ONCLICK_VALUE);
    }


    @Test
    public void challengingDomTest(){
        driver.get(CHALLENGING_DOM_PAGE);

        //the hard way
        List<WebElement> tableRows = driver.findElements(By.xpath(TABLE_ROWS_XPATH));

        int rowIndex = -1;
        int cellIndex = -1;

        for (int i = 0; i < tableRows.size(); i++) {
            List<WebElement> cells = tableRows.get(i).findElements(By.xpath(CELLS_RELATIVE_XPATH));
            for (int j = 0; j < cells.size(); j++) {
                if (cells.get(j).getText().equals(CELL_TEXT)) {
                    rowIndex = i + 1;
                    cellIndex = j + 1;
                    break;
                }
            }
        }
        String targetCellPath = String.format(TARGET_CELL_PATH, rowIndex, cellIndex);
        WebElement dynamicIpsumValue = driver.findElement(By.xpath(targetCellPath));
        WebElement loremValueOfIpsum = dynamicIpsumValue.findElement(By.xpath(LOREM_VALUE_OF_IPSUM_XPATH));
        String loremValueOfIpsumFinal = loremValueOfIpsum.getText();

        System.out.println(loremValueOfIpsumFinal);

        //the easy way
        WebElement ipsumValue = driver.findElement(By.xpath(IPSUM_VALUE_XPATH));
        WebElement siblingLorem = ipsumValue.findElement(By.xpath(LOREM_VALUE_OF_IPSUM_XPATH2));

        String targetValue = siblingLorem.getText();

        System.out.println(targetValue);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

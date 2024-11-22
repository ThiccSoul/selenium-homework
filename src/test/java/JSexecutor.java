import baseConfig.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ge.tbcitacademy.data.Constants.*;

public class JSexecutor extends BaseClass {

    @Test
    public void deleteTest() {
        driver.get(TO_DO_PAGE);
        WebElement deletePracticeMagic = driver.findElement(By.xpath(PRACTICE_MAGIC_DEL_BUTTON_XPATH));
        WebElement practiceMagic = driver.findElement(By.xpath(PRACTICE_MAGIC_BUTTON));
        action.moveToElement(practiceMagic).build().perform();
        js.executeScript(CLICKING_THE_ELEMENT, deletePracticeMagic);
        waitLong.until(ExpectedConditions.stalenessOf(practiceMagic));
        try {
            practiceMagic.isDisplayed();
            Assert.fail(UNEXPECTED_ELEMENT_MSG);
        } catch (StaleElementReferenceException e) {
            System.out.println(ELEMENT_SUCCESSFULLY_DELETED_MSG);
        }
    }

    @Test
    public void scrollTest() {
        driver.get(TECHLISTIC_TABLES_PAGE);
        List<WebElement> headingExamples = driver.findElements(By.xpath(CODE_EXAMPLE + "//preceding::h3[not(@class='title')]/span//parent::h3"));
        List<WebElement> codeExamples = driver.findElements(By.xpath(CODE_EXAMPLE));
        HashMap<String, String> codePairs = new HashMap<>();

        for (int i = 0; i < headingExamples.size() && i < codeExamples.size(); i++) {
            codePairs.put(headingExamples.get(i).getText(), codeExamples.get(i).getText());
            js.executeScript(SCROLL_INTO_VIEW, codeExamples.get(i));
        }
        Assert.assertEquals(codePairs.size(), 8);

//          codePairs ელემენტების დაპრინტვა
//        for (Map.Entry<String, String> entry : codePairs.entrySet()) {
//            System.out.println("Heading: " + entry.getKey());
//            System.out.println("Code Example: " + entry.getValue());
//            System.out.println("---------------");
//        }

        WebElement popularTutorialTitles = driver.findElement(By.xpath(POPULAR_TUTORIAL_TITLES_XPATH));
        List<WebElement> popularTutorialLinks = driver.findElements(By.xpath(POPULAR_TUTORIAL_LINKS_XPATH));

        js.executeScript(SCROLL_INTO_VIEW, popularTutorialTitles);
        HashMap<String, String> popTutPairsMap = new HashMap<>();
        for (WebElement popularTutPair : popularTutorialLinks) {
            String anchorText = popularTutPair.getText();
            String anchorHref = popularTutPair.getAttribute("href");
            popTutPairsMap.put(anchorText, anchorHref);
        }
        js.executeScript(SCROLL_TO_LOWEST);

//          popTutPairsMap-ის ელემენტების დაპრინტვა
//        for (Map.Entry<String, String> entry : popTutPairsMap.entrySet()) {
//            System.out.println("Anchor Text: " + entry.getKey() + " | URL: " + entry.getValue());
//        }

    }

    @Test
    public void anotherScrollTest() {
        driver.get(WEBDRIVER_UNI_PAGE);

        WebElement entriesElement = driver.findElement(By.id("zone2"));
        js.executeScript(SCROLL_INTO_VIEW, entriesElement);

        String entriesDisplayText = (String) js.executeScript(GET_TEXT, entriesElement);
        Assert.assertEquals(entriesDisplayText.trim(), "0 Entries");
    }
}

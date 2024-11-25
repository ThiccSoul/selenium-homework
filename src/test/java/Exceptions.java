import baseConfig.BaseClass;
import baseConfig.CrossBrowserTesting;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static ge.tbcitacademy.data.Constants.*;

public class Exceptions extends CrossBrowserTesting {
    @Test(priority = 4)
    public void InvalidSelectorException() {
        driver.get(QA_TOUCH_PAGE);
        try {
            // გადავცემთ არასწორ სელექტორს რათა აღიძვრეს InvalidSelectorException
            WebElement SoftwareTestingLink = driver.findElement(By.cssSelector(SOFTWARE_TESTING_LINK_XPATH));
        } catch (InvalidSelectorException e) {
            System.out.println(e.getClass().getName());
        }
    }

    @Test(priority = 5)
    public void NoSuchWindowException() {
        driver.get(WEBDRIVER_UNI_PAGE);
        try {
            // ვცდილობთ გადავიდეთ ისეთ ფანჯარაზე რომელიც არ არსებობს რათა აღიძრას NoSuchWindowException
            driver.switchTo().window(NON_EXISTENT_WINDOW_MSG);
        } catch (NoSuchWindowException e) {
            System.out.println(e.getClass().getName());
        }
    }

    @Test(priority = 6)
    public void StaleElementReferenceException() {
        driver.get(MYHOME_PAGE);
        WebElement help = waitLong.until(ExpectedConditions.presenceOfElementLocated(By.xpath(HELP_BTN_XPATH)));
        WebElement fromDevelopers = driver.findElement(By.xpath(FROM_DEVELOPERS_BTN_XPATH));
        try {
//           დახმარების გვერდზე გადავდივარ სადაც ღილაკი "ბინები დეველოპერებისგან" აღარ არსებობს, შესაბამიოსად გამოაქვს StaleElementReferenceException
            help.click();
            fromDevelopers.click();
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getClass().getName());
        }
    }

    @Test(priority = 7)
    public void TimeoutException() {
        driver.get(SELENIUM_PAGE);
        WebElement adderButton = driver.findElement(By.id("adder"));
        adderButton.click();
        try {
 //           until ქონდიშენი სანამ შესრულდება shortWait იქამდე გადის, შესაბამისად გამოდის TimeoutException
            WebElement redBox = waitShort.until(ExpectedConditions.presenceOfElementLocated(By.xpath(RED_BOX_XPATH)));
        } catch (TimeoutException e) {
            System.out.println(e.getClass().getName());
        }
    }

    @Test(priority = 8)
    public void NoSuchElementException() {
        driver.get(HEROKUAPP_DROPDOWN_PAGE);
        try {
//             ჩვენ ვცდილობთ დავიჭიროთ ელემენტი რომელიც არ არსებობს, შესაბამისად გამოგვაქ NoSuchElementException
            WebElement dropDown = driver.findElement(By.id("dropdowns"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getClass().getName());
        }
    }

    @Test(priority = 9)
    public void NoSuchFrameException() {
        driver.get(SELENIUM_FRAME_PAGE);
        WebElement iframe = driver.findElement(By.id("ifr"));
        try {
 //           ვცდილობ დავსვიჩოთ არარსებულ ფრეიმზე
            driver.switchTo().frame(1);
        } catch (NoSuchFrameException e) {
            System.out.println(e.getClass().getName());
        }
    }

    @Test(priority = 10)
    public void MoveTargetOutOfBoundsException() {
        driver.get(FORUM_PAGE);
        try {
//            როცა ვცდილობ ჩამოვსქროლოთ უფრო დიდზე ვიდრე საიტის ზომაა გამოდის შემდეგი ექსეფშენი MoveTargetOutOfBoundsException
            action.moveByOffset(0, 1000).click().build().perform();
        } catch (MoveTargetOutOfBoundsException e) {
            System.out.println(e.getClass().getName());
        }
    }

    @Test(priority = 11)
    public void NoSuchSessionException() {
        driver.get(BLIZZARD_PAGE);
        WebElement mobileButton = driver.findElement(By.xpath(MOBILE_BTN_XPATH));
        try {
//          იქამდე ვაკეთებთ quit-ს სანამ ბათონზე დავაკლიკებთ შესაბამისად გამოგვაქ NoSuchSessionException
            driver.quit();
            mobileButton.click();
        } catch (NoSuchSessionException e) {
            System.out.println(e.getClass().getName());
        }
    }
}


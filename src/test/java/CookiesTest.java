import baseConfig.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Optional;
import java.util.Set;

import static ge.tbcitacademy.data.Constants.*;

public class CookiesTest extends BaseClass {
    @Test
    public void filterCookies() {
        driver.get(TECHLISTIC_PAGE);
        Set<Cookie> cookies = driver.manage().getCookies();
        Optional<Cookie> activeTemplateCookie = cookies.stream()
                .filter(cookie -> cookie.getName().contains(CONTAINING_WORDS_NAME))
                .findFirst();
        String cookieValue = activeTemplateCookie.get().getValue();
        Assert.assertTrue(cookieValue.contains(CONTAINING_WORDS_VALUE));
    }

    @Test
    public void injectCookie() {
        driver.get(TECHLISTIC_PAGE);
        waitLong.until(ExpectedConditions.jsReturnsValue(COMPLETE_READY_STATE));

        int cookiesSizeBefore = driver.manage().getCookies().size();

        for (int i = 0; i < COOKIE_NAMES.length; i++) {
            driver.manage().addCookie(new Cookie(COOKIE_NAMES[i], COOKIE_VALUES[i]));
        }

        for (String cookieName : COOKIE_NAMES) {
            Cookie ourCookie = driver.manage().getCookieNamed(cookieName);
            assert ourCookie != null;
            System.out.println(ourCookie.getName() + " " + ourCookie.getValue());
        }

        for (String cookieName : COOKIE_NAMES) {
            Cookie toBeDeletedCookie = driver.manage().getCookieNamed(cookieName);
            assert toBeDeletedCookie != null;
            driver.manage().deleteCookie(toBeDeletedCookie);
        }

        int cookiesSizeAfter = driver.manage().getCookies().size();
        Assert.assertEquals(cookiesSizeAfter, cookiesSizeBefore);
    }

    @Test
    public void autoCompleteTest() {
        driver.get(AUTOCOMPLETE_PAGE);
        WebElement hiddenStatus = driver.findElement(By.xpath(HIDDENSTATUS_XPATH));
        WebElement searchField = driver.findElement(By.id(SEARCHFIELD_ID));

        String oldText = hiddenStatus.getText();
        searchField.sendKeys("Ango");

        waitLong.until(driver -> !driver.findElement(By.xpath(HIDDENSTATUS_XPATH)).getText().equals(oldText));
        if (hiddenStatus.getText().equalsIgnoreCase("No search results.")) throw new IllegalArgumentException("Enter existing country");

        action.sendKeys(searchField, Keys.ARROW_DOWN, Keys.ENTER).perform();
        waitLong.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SELECTED_ITEM_XPATH)));

        System.out.println("making some conflict");
    }
}
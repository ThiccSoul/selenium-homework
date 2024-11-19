package util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperFunctions {
    public static void universalSelector(Object element, String visibleText) {
        System.out.println("I AM A CHANGE MEANWHILE");
        if(element instanceof Select) {
            ((Select) element).selectByVisibleText(visibleText);
        } else if (element instanceof WebElement) {
            String xPath = String.format("//*[text()='%s']", visibleText);
            WebElement anchorElement = ((WebElement) element).findElement(By.xpath(xPath));
            anchorElement.click();
        } else {
            throw new IllegalArgumentException("unsupported element entered");
        }
    }
}

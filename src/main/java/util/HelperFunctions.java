package util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;

public class HelperFunctions {
    public static void universalSelector(Object element, String visibleText) {
        System.out.println("I AM A FIX");
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

    public static WebElement getElementFromTable(WebElement table, String tableRow, String tableColumnHeader) {
        int indexHeader = -1;
        int indexRow = -1;
        List<WebElement> tableRowElements;
        List<WebElement> tableHeaders;
        List<WebElement> tableFooterElements = table.findElements(By.tagName("tfoot"));
        tableRowElements = table.findElements(By.xpath(".//tbody//tr"));

        if (table.findElements(By.tagName("thead")).isEmpty()) {
            tableHeaders = table.findElements(By.tagName("th"));
        } else {
            tableHeaders = table.findElements(By.xpath(".//thead//th"));
        }
        if (!tableFooterElements.isEmpty()) {
            tableRowElements.addAll(tableFooterElements);
        }
        for (int i = 0; i < tableHeaders.size(); i++) {
            if (tableHeaders.get(i).getText().equals(tableColumnHeader.trim())) {
                indexHeader = i;
                break;
            }
        }
        for (int j = 0; j < tableRowElements.size(); j++) {
            if (tableRowElements.get(j).getText().contains(tableRow.trim())) {
                indexRow = j;
                break;
            }
        }
        if (indexHeader == -1 && tableColumnHeader.trim().isEmpty()) {
            return tableRowElements.get(indexRow).findElement(By.tagName("td"));
        } else if (indexHeader != -1 && indexRow != -1) {
            return tableRowElements.get(indexRow).findElement(By.xpath("*[position()=" + (indexHeader + 1) + "]"));
        } else if (indexRow == -1) {
            throw new NoSuchElementException("Table row not found: " + tableRow);
        } else {
            throw new NoSuchElementException("Table column header not found: " + tableColumnHeader);
        }
    }
}

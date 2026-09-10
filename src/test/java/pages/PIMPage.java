package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage extends BasePage {

    private By employeeNameInput = By.cssSelector("input[placeholder='Type for hints...']");
    private By searchButton = By.cssSelector("button[type='submit']");
    private By resultRows = By.cssSelector(".oxd-table-body .oxd-table-card");
    private By noRecordsMessage = By.xpath("//*[normalize-space()='No Records Found']");
    private By header = By.cssSelector("h6.oxd-text--h6");

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    public void searchEmployeeByName(String employeeName) {
        type(employeeNameInput, employeeName);
        click(searchButton);
    }

    public boolean hasResults() {
        return isElementVisible(resultRows);
    }

    public boolean isNoRecordsDisplayed() {
        return isElementVisible(noRecordsMessage);
    }

    public boolean isOnPIMPage() {
        return isElementVisible(header)
                && getText(header).equals("PIM");
    }
}
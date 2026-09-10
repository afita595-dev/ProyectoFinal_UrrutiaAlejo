package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private By pimMenu = By.xpath("//span[normalize-space()='PIM']");
    private By userDropdown = By.cssSelector(".oxd-userdropdown-tab");
    private By logoutOption = By.xpath("//a[normalize-space()='Logout']");
    private By header = By.cssSelector("h6.oxd-text--h6");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void goToPIM() {
        click(pimMenu);
    }

    public void logout() {
        click(userDropdown);
        click(logoutOption);
    }

    public boolean isOnDashboard() {
        return isElementVisible(header)
                && getHeaderText().equals("Dashboard");
    }

    public String getHeaderText() {
        return getText(header);
    }
}
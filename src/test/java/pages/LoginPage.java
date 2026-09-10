package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By errorMessage = By.cssSelector(".oxd-alert-content-text");

    private String loginUrl = "https://opensource-demo.orangehrmlive.com/";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.get(loginUrl);
    }

    public void enterUserName(String username) {
        type(usernameInput, username);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void loginAs(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        click(loginButton);
    }

    public boolean isOnLoginPage() {
        return isElementVisible(usernameInput);
    }

    public boolean isErrorDisplayed() {
        return isElementVisible(errorMessage);
    }
}
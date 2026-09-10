package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class PruebaLogin {

    @Test
    public void loginExitoso() {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.goTo();
            loginPage.loginAs("Admin", "admin123");

            new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.urlContains("/dashboard"));

            Assert.assertTrue(
                    driver.getCurrentUrl().contains("/dashboard"),
                    "No se llegó al Dashboard después del login."
            );
        } finally {
            driver.quit();
        }
    }
    @Test
    public void loginFallido() {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.goTo();
            loginPage.loginAs("Admin", "claveIncorrecta");

            Assert.assertTrue(
                    loginPage.isErrorDisplayed(),
                    "No apareció el mensaje de error para credenciales inválidas."
            );
        } finally {
            driver.quit();
        }
    }
}

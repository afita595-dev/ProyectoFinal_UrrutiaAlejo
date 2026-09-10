package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hooks {

    private static WebDriver driver;

    @Before
    public void configurarNavegador() {
        Logger cdpLogger = Logger.getLogger(
                "org.openqa.selenium.devtools.CdpVersionFinder"
        );
        cdpLogger.setLevel(Level.OFF);
        cdpLogger.setUseParentHandlers(false);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void cerrarNavegador() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

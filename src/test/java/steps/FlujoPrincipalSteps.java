package steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;

import java.time.Duration;

public class FlujoPrincipalSteps {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PIMPage pimPage;

    @Dado("que el usuario se encuentra en la pantalla de login")
    public void abrirPantallaDeLogin() {
        loginPage = new LoginPage(Hooks.getDriver());
        loginPage.goTo();
    }

    @Cuando("inicia sesión con usuario {string} y contraseña {string}")
    public void iniciarSesion(String usuario, String contrasena) {
        loginPage.loginAs(usuario, contrasena);
    }

    @Entonces("debería visualizar el dashboard")
    public void validarDashboard() {
        WebDriver driver = Hooks.getDriver();

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.urlContains("/dashboard"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/dashboard"),
                "No se llegó al Dashboard después del login."
        );
    }

    @Cuando("navega al módulo PIM")
    public void navegarAlModuloPIM() {
        dashboardPage = new DashboardPage(Hooks.getDriver());
        dashboardPage.goToPIM();

        pimPage = new PIMPage(Hooks.getDriver());

        Assert.assertTrue(
                pimPage.isOnPIMPage(),
                "No se navegó correctamente al módulo PIM."
        );
    }

    @Cuando("busca el empleado {string}")
    public void buscarEmpleado(String empleado) {
        pimPage.searchEmployeeByName(empleado);
    }

    @Entonces("debería visualizar resultados de la búsqueda")
    public void validarResultadosDeBusqueda() {
        Assert.assertTrue(
                pimPage.hasResults(),
                "No se encontraron resultados para el empleado buscado."
        );
    }

    @Cuando("cierra sesión")
    public void cerrarSesion() {
        dashboardPage = new DashboardPage(Hooks.getDriver());
        dashboardPage.logout();
    }

    @Entonces("debería visualizar la pantalla de login")
    public void validarPantallaDeLogin() {
        loginPage = new LoginPage(Hooks.getDriver());

        Assert.assertTrue(
                loginPage.isOnLoginPage(),
                "No se volvió a la pantalla de login después del logout."
        );
    }
}
/*package pe.tuempresa.reniec.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ReniecSteps {

    private String originalWindow;

    // ==== LOCATORS (AJUSTA SI RENIEC CAMBIA EL HTML) ====
    private final By menuPeruanosExtranjero = By.xpath("//*[contains(.,'Peruanos en el Extranjero')]");
    private final By opcionConsuladosEnElMundo = By.xpath("//*[contains(.,'Consulados en el mundo')]");
    private final By opcionListaConsulados = By.xpath("//*[contains(.,'Lista de Consulados en el mundo')]");

    // En la nueva pestaña (según tu captura: input buscar)
    private final By inputBusqueda = By.cssSelector("input[type='text'], input[type='search']");
    private final By resultadoCuenca = By.xpath("//*[contains(.,'Cuenca')]");

    @Given("el usuario ingresa a la web de RENIEC mas servicios en linea")
    public void ingresaAlaWeb() {
        WebDriver driver = BrowseTheWeb.as(theActorInTheSpotlight()).getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.reniec.gob.pe/portal/masServiciosLinea.htm");
        originalWindow = driver.getWindowHandle();
    }

    @When("navega a Peruanos en el Extranjero y abre Lista de Consulados en el mundo")
    public void navegaYAbreLista() {
        WebDriver driver = BrowseTheWeb.as(theActorInTheSpotlight()).getDriver();

        // Click "Peruanos en el Extranjero"
        driver.findElement(menuPeruanosExtranjero).click();

        // Click "Consulados en el mundo" (si es desplegable)
        driver.findElement(opcionConsuladosEnElMundo).click();

        // Click "Lista de Consulados en el mundo" (esto abre nueva pestaña)
        driver.findElement(opcionListaConsulados).click();
    }

    @When("en la nueva pestaña busca la palabra {string}")
    public void buscaEnNuevaPestana(String palabra) {
        WebDriver driver = BrowseTheWeb.as(theActorInTheSpotlight()).getDriver();

        // Espera a que aparezca nueva pestaña
        esperarNuevaPestana(driver);

        // Cambia a la nueva pestaña
        cambiarANuevaPestana(driver);

        // Busca (si el campo requiere Enter)
        driver.findElement(inputBusqueda).clear();
        driver.findElement(inputBusqueda).sendKeys(palabra);
        driver.findElement(inputBusqueda).sendKeys(org.openqa.selenium.Keys.ENTER);

        // Mini pausa para que cargue resultado
        dormir(1000);
    }

    @Then("debe visualizar el resultado relacionado a {string}")
    public void validaResultado(String palabra) {
        WebDriver driver = BrowseTheWeb.as(theActorInTheSpotlight()).getDriver();
        // Validación simple: texto “Cuenca”
        driver.findElement(By.xpath("//*[contains(.,'" + palabra + "')]"));
    }

    @Then("regresa a la pestaña original")
    public void regresaOriginal() {
        WebDriver driver = BrowseTheWeb.as(theActorInTheSpotlight()).getDriver();
        driver.close(); // cierra pestaña nueva
        driver.switchTo().window(originalWindow);
    }

    // ===== helpers =====

    private void esperarNuevaPestana(WebDriver driver) {
        long start = System.currentTimeMillis();
        while (driver.getWindowHandles().size() < 2) {
            dormir(200);
            if (System.currentTimeMillis() - start > 8000) {
                throw new RuntimeException("No se abrió la nueva pestaña en el tiempo esperado.");
            }
        }
    }

    private void cambiarANuevaPestana(WebDriver driver) {
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        for (String h : handles) {
            if (!h.equals(originalWindow)) {
                driver.switchTo().window(h);
                return;
            }
        }
        throw new RuntimeException("No encontré la pestaña nueva para cambiar.");
    }

    private void dormir(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
*/
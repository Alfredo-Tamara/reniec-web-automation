package pe.tuempresa.reniec.stepdefinitions.demoqa;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import pe.tuempresa.reniec.interactions.CloseCurrentTabAndBackToMain;
import pe.tuempresa.reniec.interactions.SwitchToNewTab;
import pe.tuempresa.reniec.questions.PageBodyContainsText;
import pe.tuempresa.reniec.tasks.OpenDemoQABrowserWindows;
import pe.tuempresa.reniec.ui.DemoQAWindowsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class DemoQASteps {

    private String mainWindow;

    @Given("el usuario abre la web de DemoQA Browser Windows")
    public void abreDemoQA() {
        Actor fito = OnStage.theActorInTheSpotlight();
        fito.attemptsTo(OpenDemoQABrowserWindows.page());

        WebDriver driver = BrowseTheWeb.as(fito).getDriver();
        driver.manage().window().maximize();
        mainWindow = driver.getWindowHandle();
    }

    @When("hace click en el boton New Tab")
    public void clickNewTab() {
        theActorCalled("Fito").attemptsTo(
                Click.on(DemoQAWindowsPage.BTN_NEW_TAB)
        );
    }

    @Then("cambia a la nueva pestaña y valida que existe el texto {string}")
    public void validaTexto(String texto) {
        Actor fito = theActorCalled("Fito");

        fito.attemptsTo(SwitchToNewTab.from(mainWindow));

        fito.attemptsTo(
                Ensure.that(PageBodyContainsText.of(texto)).isTrue()
        );
    }

    @Then("regresa a la pestaña original")
    public void vuelveOriginal() {
        Actor fito = theActorCalled("Fito");

        fito.attemptsTo(CloseCurrentTabAndBackToMain.to(mainWindow));

        WebDriver driver = BrowseTheWeb.as(fito).getDriver();
        fito.attemptsTo(
                Ensure.that(driver.getCurrentUrl()).contains("demoqa.com/browser-windows")
        );
    }
}

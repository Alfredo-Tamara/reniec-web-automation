package pe.tuempresa.reniec.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class CloseCurrentTabAndBackToMain implements Interaction {

    private final String mainHandle;

    public CloseCurrentTabAndBackToMain(String mainHandle) {
        this.mainHandle = mainHandle;
    }

    public static CloseCurrentTabAndBackToMain to(String mainHandle) {
        return new CloseCurrentTabAndBackToMain(mainHandle);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        if (!driver.getWindowHandle().equals(mainHandle)) {
            driver.close();
        }
        driver.switchTo().window(mainHandle);
    }
}

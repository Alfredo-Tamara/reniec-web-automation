package pe.tuempresa.reniec.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        OnStage.theActorCalled("Fito").can(BrowseTheWeb.with(driver));
    }

    @After
    public void tearDown() {
        try {
            OnStage.drawTheCurtain();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}




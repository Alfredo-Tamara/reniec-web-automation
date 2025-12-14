package pe.tuempresa.reniec.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Set;

public class SwitchToNewTab implements Interaction {

    private final String mainHandle;

    public SwitchToNewTab(String mainHandle) {
        this.mainHandle = mainHandle;
    }

    public static SwitchToNewTab from(String mainHandle) {
        return new SwitchToNewTab(mainHandle);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        long end = System.currentTimeMillis() + Duration.ofSeconds(10).toMillis();
        while (driver.getWindowHandles().size() < 2 && System.currentTimeMillis() < end) {
            try { Thread.sleep(150); } catch (InterruptedException ignored) {}
        }

        Set<String> handles = driver.getWindowHandles();
        String newHandle = handles.stream()
                .filter(h -> !h.equals(mainHandle))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No apareció la nueva pestaña"));

        driver.switchTo().window(newHandle);
    }
}


package pe.tuempresa.reniec.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DemoQAWindowsPage {

    public static final Target BTN_NEW_TAB =
            Target.the("botón New Tab")
                    .located(By.id("tabButton"));

    public static final Target BODY =
            Target.the("body de la página")
                    .located(By.tagName("body"));
}


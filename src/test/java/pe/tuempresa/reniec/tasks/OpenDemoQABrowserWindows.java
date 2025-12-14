package pe.tuempresa.reniec.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenDemoQABrowserWindows {

    public static Task page() {
        return Task.where("{0} abre DemoQA Browser Windows",
                Open.url("https://demoqa.com/browser-windows")
        );
    }
}


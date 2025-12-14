package pe.tuempresa.reniec.runners;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/demoqa",
        glue = {"pe.tuempresa.reniec.hooks","pe.tuempresa.reniec.stepdefinitions.demoqa"},
        plugin = {"pretty"},
        monochrome = true
)
public class DemoQARunner { }








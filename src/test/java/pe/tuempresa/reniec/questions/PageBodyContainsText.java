package pe.tuempresa.reniec.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import pe.tuempresa.reniec.ui.DemoQAWindowsPage;

public class PageBodyContainsText implements Question<Boolean> {

    private final String expected;

    public PageBodyContainsText(String expected) {
        this.expected = expected;
    }

    public static PageBodyContainsText of(String expected) {
        return new PageBodyContainsText(expected);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String body = Text.of(DemoQAWindowsPage.BODY).answeredBy(actor);
        return body != null && body.contains(expected);
    }
}


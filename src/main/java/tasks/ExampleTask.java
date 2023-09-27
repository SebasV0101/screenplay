package tasks;

import models.DataTableExample;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import userinterfaces.ExampleInterface;

public class ExampleTask implements Task {
    DataTableExample dataTableExample;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(dataTableExample.getUserName())
                        .into(ExampleInterface.EXAMPLE),
                Scroll.to(ExampleInterface.EXAMPLE),
                Click.on(ExampleInterface.EXAMPLE.of(dataTableExample.getRadioItems())),
                Click.on(ExampleInterface.EXAMPLE)
        );
    }

    public static ExampleTask exampleTask(DataTableExample dataTableExample) {
        return Tasks.instrumented(ExampleTask.class, dataTableExample);
    }
}

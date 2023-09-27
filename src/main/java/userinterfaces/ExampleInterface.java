package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ExampleInterface {
    public static final Target EXAMPLE = Target.the("ExampleTarjet")
            .locatedBy("//input[@name='username']");
}

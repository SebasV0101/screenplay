package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.ExampleInterface;

public class ExampleQuestion implements Question {
    @Override
    public Object answeredBy(Actor actor){
        return Text.of(ExampleInterface.EXAMPLE).viewedBy(actor).asString();
    }

    public static ValidationForm compare(){
        return new ValidationForm();
    }

}

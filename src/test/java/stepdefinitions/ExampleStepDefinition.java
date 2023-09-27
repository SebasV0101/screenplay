package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.DataTableExample;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import questions.ExampleQuestion;
import tasks.ExampleTask;

import javax.xml.crypto.Data;
import java.util.List;

public class ExampleStepDefinition {

    @Managed
    WebDriver ExampleBrowser;

    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("ExampleUser");
        OnStage.theActorInTheSpotlight()
                .can(BrowseTheWeb.with(ExampleBrowser));
    }

    @Given("^User gets into webpage and goes to form page$")
    public void user_gets_into_webpage_and_goes_to_form_page() {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                Open.url("http://example.com")
        );
        Actor.named("ExampleUser").attemptsTo();
    }


    @When("^User submit the information$")
    public void user_submit_the_information(List<DataTableExample> dataTableExampleList) {
        DataTableExample dataTableExample;
        dataTableExample = dataTableExampleList.get(0);

        OnStage.theActorInTheSpotlight().attemptsTo(
                ExampleTask.exampleTask(dataTableExample);
        );
    }

    @Then("^The information is displayed$")
    public void the_information_is_displayed() {
        OnStage.theActorInTheSpotlight()
                .should(GivenWhenThen.seeThat(ExampleQuestion.compare(),
                        //Matchers.equalTo(students.getFirstName() + " " + students.getLastName())));
                        Matchers.equalTo("Example comparation")));
    }

}

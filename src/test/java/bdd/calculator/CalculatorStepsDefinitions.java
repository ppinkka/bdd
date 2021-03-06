package bdd.calculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CalculatorStepsDefinitions {

    // Calculator - klasa - czyli przepis jak powinien wyglądać obiekt
    // calculator - pole - PUSTE pole stworzone wg przepisu z klasy Calculator
    Calculator calculator;
    Integer result;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        // new Calculator - tworzy nowy obiekt Calculator
        calculator = new Calculator();
    }
    @When("I add {int} and {int}")
    public void i_add_and(Integer int1, Integer int2) {
        result = calculator.addTwoNumbers(int1, int2);
    }
    @When("subtract {int} from {int}")
    public void subtract_from(Integer int1, Integer int2) {
        result = calculator.subtract(int1, int2);
    }
    @When("I multiply {int} and {int}")
    public void i_multiply_and(Integer int1, Integer int2) {
        result = calculator.multiplyTwo(int1, int2);
    }
    @When("I divide {int} by {int}")
    public void i_divide_by(Integer int1, Integer int2) {
        result = calculator.divide(int1, int2);
    }
    @Then("I should get {int}")
    public void i_should_get(Integer int1) {
        Assert.assertEquals(result, int1);
    }
}

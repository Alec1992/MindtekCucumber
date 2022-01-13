package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.TestSheepAppPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class TestSheepAppSteps {

    WebDriver driver= Driver.getDriver();
    TestSheepAppPage testSheepAppPage=new TestSheepAppPage();


    @Given("user navigates to TestSheep application")
    public void user_navigates_to_TestSheep_application() {
        driver.get(ConfigReader.getProperty("TestSheepAppURL"));

    }

    @When("user enters {string} as first Number")
    public void user_enters_as_first_Number(String number1) {
        testSheepAppPage.number1.sendKeys(number1);

    }

    @And("user enters {string} as second number")
    public void user_enters_as_second_number(String number2) {
        testSheepAppPage.number2.sendKeys(number2);

    }

    @And("user selects {string} operator")
    public void userSelectsOperator(String operation) {
        BrowserUtils.selectByText(testSheepAppPage.operation,operation);
    }

    @When("clicks on Calculate button")
    public void clicks_on_Calculate_button() {
        testSheepAppPage.calculateButton.click();

    }

    @Then("user validates that output is {int}")
    public void user_validates_that_output_is(Integer result) {
        String result2=testSheepAppPage.result.getAttribute("value");
        Assert.assertEquals(result.toString(),result2);

    }


    @Then("user validates {string} error message")
    public void userValidatesErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage=testSheepAppPage.errorMessage.getText();
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }
}

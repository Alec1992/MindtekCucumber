package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.PizzaAppPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;
import java.util.Map;

public class PizzaAppSteps {

    WebDriver driver= Driver.getDriver();
    Map<String, Object> data;
    PizzaAppPage pizzaAppPage=new PizzaAppPage();
    String pizzaCost;


    @Given("user navigates to pizza application")
    public void user_navigates_to_pizza_application() {
        driver.get(ConfigReader.getProperty("PizzaAppURL"));

    }

    @When("user creates pizza order with data")
    public void user_creates_pizza_order_with_data(DataTable dataTable) {
        data=dataTable.asMap(String.class,Object.class);
        BrowserUtils.selectByValue(pizzaAppPage.pizza1Box, data.get("Pizza").toString());
        BrowserUtils.selectByValue(pizzaAppPage.toppings1Box,data.get("Toppings 1").toString());
        BrowserUtils.selectByValue(pizzaAppPage.toppings2Box, data.get("Toppings 2").toString());
        pizzaAppPage.pizza1QtyBox.sendKeys(data.get("Quantity").toString());
        pizzaAppPage.nameBox.sendKeys(data.get("Name").toString());
        pizzaAppPage.emailBox.sendKeys(data.get("email").toString());
        pizzaAppPage.phoneBox.sendKeys(data.get("phone").toString());
        if(data.get("Payment type").toString().equals("cash on pickup")){
            pizzaAppPage.cashpaymentRadioButton.click();
        }else if(data.get("Payment type").toString().equals("Credit Card")){
            pizzaAppPage.ccpaymentRadioButton.click();
        }

        pizzaCost=pizzaAppPage.pizza1CostBox.getAttribute("value");
        pizzaAppPage.placeOrderButton.click();





    }


    @Then("user validates that order is created with success message {string} {string}")
    public void userValidatesThatOrderIsCreatedWithSuccessMessage(String success, String pizza) {
        String expectedMessage=success+pizzaCost+" "+pizza;
        String actualMessage=pizzaAppPage.dialogWindow.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }
}

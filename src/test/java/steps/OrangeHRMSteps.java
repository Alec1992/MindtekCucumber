package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.OrangeHRMPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OrangeHRMSteps {
    WebDriver driver= Driver.getDriver();
    OrangeHRMPage orangeHRMPage=new OrangeHRMPage();
    int timesheetTotal;
    int totalHoursOfTheRow1 =0;
    int updatedTimesheetTotal;


    @Given("user navigates to OrangeHRM app and provides {string} for username and {string} for password and click login button")
    public void userNavigatesToOrangeHRMAppAndProvidesForUsernameAndForPasswordAndClickLoginButton(String username, String password) {
        driver.get(ConfigReader.getProperty("OrangeHRMURL"));
        orangeHRMPage.username.sendKeys(username);
        orangeHRMPage.password.sendKeys(password);
        orangeHRMPage.loginButton.click();
    }




    @When("user clicks on TIME button and clicks on view for Paul Collings")
    public void user_clicks_on_TIME_button_and_clicks_on_view_for_Paul_Collings() {
        orangeHRMPage.timeModule.click();
        orangeHRMPage.paulCollingsTimeSheet.click();

    }

    @When("user clicks on Add timesheet button and selects date Jan 3rd on calendar and clicks on OK button")
    public void user_clicks_on_Add_timesheet_button_and_selects_date_Jan_3rd_on_calendar_and_clicks_on_OK_button() {
        orangeHRMPage.addTimeSheetBtn.click();
        orangeHRMPage.calendar.click();
        orangeHRMPage.jan03rd.click();
        orangeHRMPage.okButton.click();

    }

    @Then("user verifies {string} message is displayed")
    public void user_verifies_message_is_displayed(String expectedMessage) {
        String actualMessage=orangeHRMPage.actualMessage.getText();
        Assert.assertEquals(actualMessage,expectedMessage);

    }

       @When("user saves total hours and clicks on Edit button")
    public void user_saves_total_hours_and_clicks_on_Edit_button() {
        String timesheetTotal1=orangeHRMPage.timesheetTotal.getText().replace(":","");
        timesheetTotal=Integer.parseInt(timesheetTotal1);
        orangeHRMPage.editButton.click();

    }

    @Then("user selects the first row and saves total hours for that row and clicks remove row button and clicks on save button")
    public void user_selects_the_first_row_and_saves_total_hours_for_that_row_and_clicks_remove_row_button_and_clicks_on_save_button() {

        orangeHRMPage.firstRow.click();
        String[] totalHoursOfTheRow= new String[7];
        String[] hoursPerDays=new String[7];

            hoursPerDays[0]="initialRows_0_0";
            hoursPerDays[1]="initialRows_0_1";
            hoursPerDays[2]="initialRows_0_2";
            hoursPerDays[3]="initialRows_0_3";
            hoursPerDays[4]="initialRows_0_4";
            hoursPerDays[5]="initialRows_0_5";
            hoursPerDays[6]="initialRows_0_6";

        for (int i=0; i<hoursPerDays.length; i++) {
            totalHoursOfTheRow[i] = driver.findElement(By.id(hoursPerDays[i])).getAttribute("value").replace(":","");
            if(totalHoursOfTheRow[i].equals("")){
                continue;
            }
               totalHoursOfTheRow1 += Integer.parseInt(totalHoursOfTheRow[i]);
        }

        orangeHRMPage.removeButton.click();
        orangeHRMPage.saveButton.click();

    }

    @Then("user validates that total hours on timesheet are updated accordingly")
    public void user_validates_that_total_hours_on_timesheet_are_updated_accordingly() {

        String updatedTimeSheetTotal=orangeHRMPage.updatedTimeSheetTotal.getText().replace(":","");
        updatedTimesheetTotal=Integer.parseInt(updatedTimeSheetTotal);

        Assert.assertEquals(timesheetTotal - totalHoursOfTheRow1, updatedTimesheetTotal);



    }

    @Then("user clicks on edit button and clicks on add Row button and provides all inputs")
    public void userClicksOnEditButtonAndClicksOnAddRowButtonAndProvidesAllInputs() {
        orangeHRMPage.editButton.click();

        //orangeHRMPage.addRowButton.click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.getElementsByName('initialRows[0][projectId]')[0]");
        driver.findElement(By.name("initialRows[0][projectName]")).clear();
        driver.findElement(By.name("initialRows[0][projectName]")).sendKeys("Internal - Recruitment");
        BrowserUtils.hoverOver(orangeHRMPage.elementForHoverOver);
        orangeHRMPage.elementForHoverOver.click();


       BrowserUtils.hoverOver(driver.findElement(By.name("initialRows[0][projectActivityName]")));

        driver.findElement(By.name("initialRows[0][projectActivityName]")).click();

        driver.findElement(By.xpath("//select/option[@value='70']")).click();

        String[] timeBoxes = {"1", "2", "3", "4", "5", "6"};

        for (String timeBox : timeBoxes) {
            driver.findElement(By.name("initialRows[0]"+"["+ timeBox + "]")).clear();
            driver.findElement(By.name("initialRows[0]"+"["+ timeBox + "]")).sendKeys("3:00");
        }
    }

    @Then("user clicks on save button and validates that total hours are updated accordingly")
    public void user_clicks_on_save_button_and_validates_that_total_hours_are_updated_accordingly() {

        orangeHRMPage.saveButton.click();
        String updatedTimeSheetTotal2 = orangeHRMPage.updatedTimeSheetTotal.getText().replace(":", "");
        int updatedTimesheetTotal1 = Integer.parseInt(updatedTimeSheetTotal2);

        Assert.assertEquals(updatedTimesheetTotal+1800, updatedTimesheetTotal1);
    }





}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class OrangeHRMPage {

    public OrangeHRMPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);

    }

    @FindBy(id="txtUsername")
    public WebElement username;

    @FindBy(id="txtPassword")
    public WebElement password;

    @FindBy(id="btnLogin")
    public WebElement loginButton;

    @FindBy(id="menu_time_viewTimeModule")
    public WebElement timeModule;

    @FindBy(xpath = "(//a[@id='viewSubmitted'])[1]")
    public WebElement paulCollingsTimeSheet;

    @FindBy(xpath = "(//td[@class='right total'])[last()]")
    public WebElement timesheetTotal;

    @FindBy(id="btnAddTimesheet")
    public WebElement addTimeSheetBtn;

    @FindBy(id="time_date")
    public WebElement calendar;

    @FindBy(xpath = "(//a[@class='ui-state-default'])[3]")
    public WebElement jan03rd;

    @FindBy(id="addTimesheetBtn")
    public WebElement okButton;

    @FindBy(id="msgDiv")
    public WebElement actualMessage;

    @FindBy(id="btnEdit")
    public WebElement editButton;

    @FindBy(id="initialRows_0_toDelete")
    public WebElement firstRow;

    @FindBy(id="submitRemoveRows")
    public WebElement removeButton;

    @FindBy(id="submitSave")
    public WebElement saveButton;

    @FindBy(xpath = "(//td[@class='right total'])[last()]")
    public WebElement updatedTimeSheetTotal;

    @FindBy(id="btnAddRow")
    public WebElement addRowButton;

    @FindBy(xpath = "input[@class='project inputFormatHint']")
    public WebElement newRowProjectName;

    @FindBy(xpath = "(//select[@class='projectActivity'])[last()]")
    public WebElement newRowProjectActivity;

    @FindBy(xpath = "//li[@class='ac_even ac_over']")
    public WebElement elementForHoverOver;


























}

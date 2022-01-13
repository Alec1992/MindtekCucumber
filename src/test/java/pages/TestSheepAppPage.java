package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestSheepAppPage {
    public TestSheepAppPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
            }



    @FindBy(id="number1Field")
    public WebElement number1;

    @FindBy(id="number2Field")
    public WebElement number2;

    @FindBy(id="selectOperationDropdown")
    public WebElement operation;

    @FindBy(id="calculateButton")
    public WebElement calculateButton;

    @FindBy(id="numberAnswerField")
    public WebElement result;

    @FindBy(id="errorMsgField")
    public WebElement errorMessage;


}

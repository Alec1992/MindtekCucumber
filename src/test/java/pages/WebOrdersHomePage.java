package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class WebOrdersHomePage {

    public  WebOrdersHomePage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='Process.aspx']")
    public WebElement orderModule;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr")
    public List<WebElement> numberOfRows;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td[2]")
    public WebElement firstNameInTable;

    @FindBy(xpath = "//a[@href='Default.aspx']")
    public WebElement viewAllOrdersModule;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td[6]")
    public WebElement streetInRow;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td[7]")
    public WebElement cityInRow;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td[8]")
    public WebElement stateInRow;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td[9]")
    public WebElement zipInRow;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td[10]")
    public WebElement cardTypeInRow;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td[11]")
    public WebElement cardNumberInRow;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td[12]")
    public WebElement expireDateInRow;




}

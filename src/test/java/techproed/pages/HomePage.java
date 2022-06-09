package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Login")
    public WebElement homeLoginButton;

    @FindBy(xpath = "//select[@name='car']")
    public WebElement selectCarsDropdown;

    @FindBy(xpath = "//input[@name='pickUpLocation']")
    public WebElement pickUpplace;

    @FindBy(xpath = "//input[@name='dropOfLocation']")
    public WebElement dropOffplace;

    @FindBy(xpath = "//input[@name='pickUpDate']")
    public WebElement pickupDate;

    @FindBy(xpath = "//input[@name='pickUpTime']")
    public WebElement pickupTime;

    @FindBy(xpath = "//input[@name='dropOffDate']")
    public WebElement dropOffeDate;

    @FindBy(xpath = "//input[@name='dropOffTime']")
    public WebElement dropOffTime;

    @FindBy(xpath = "//*[text()=' CONTINUE RESERVATION']")
    public WebElement continueReservation;

    @FindBy(xpath = "//*[text()='Please first login']")
    public WebElement pleaseFirstLoginWarning;


















}
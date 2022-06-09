package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;
//AFTER LOGGED İN
public class DefaultPage {
    public DefaultPage() {
        PageFactory.initElements(Driver.getDriver(), this);}

        @FindBy (xpath = "//button[@id='dropdown-basic-button']")
        public WebElement userID;

}

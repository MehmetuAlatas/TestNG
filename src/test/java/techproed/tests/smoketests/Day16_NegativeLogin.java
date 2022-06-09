package techproed.tests.smoketests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.DefaultPage;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.time.Duration;

public class Day16_NegativeLogin {

    HomePage homePage;
    LoginPage loginPage;
    Faker faker;

    @Test
    public void negativeLogin() {
        /**USER STORY 3
         Name: Login screen error messages
         Description:
         User should see error message when user tries to login with incorrect credentials
         Acceptance Criteria:
         As admin or customer, I should be able to see error message, when I do not provide a correct email address or password in a pop up window
         Error Message: invalid credentials         */
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage=new HomePage();
        loginPage=new LoginPage();

        faker=new Faker();
        homePage.homeLoginButton.click();;
        loginPage.username.sendKeys(faker.internet().emailAddress());
        loginPage.password.sendKeys(faker.internet().password());
        loginPage.loginButton.click();

//        WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By));
        ReusableMethods.waitForVisibility(loginPage.invalidCredentialsErrorMessage,5);
        Assert.assertTrue(loginPage.invalidCredentialsErrorMessage.isDisplayed());

    }
}

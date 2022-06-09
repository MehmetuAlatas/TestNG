package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;


public class HomeWorkUserStory {

    HomePage homePage;
    LoginPage loginPage;
    Faker faker;

    @Test
    public void userStory4() throws InterruptedException {
        /**Name:
         Login screen error messages
         Description:
         User should see error message when a valid email domain is not entered
         Acceptance Criteria:
         As admin or customer, I should be able to see error message, when I do not provide a complete email address in email address box
         Error Message: email must be a valid email
         WhenI enter a valid email domain, then I should not see the error message
         *
         */
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage = new HomePage();
        loginPage = new LoginPage();
        homePage.homeLoginButton.click();
        loginPage.username.sendKeys("akmkmkmaa");
        String expectederrorMessage = "email must be a valid email";
        Assert.assertEquals(loginPage.emailErrorMessage.getText(), expectederrorMessage);
        Driver.getDriver().navigate().refresh();
        loginPage.username.sendKeys("uuuuu@gmail.com");
        Assert.assertFalse(loginPage.emailErrorMessage2.isDisplayed());
        Driver.closeDriver();
    }

    /**
     * Name:
     * Require user to login for reservation
     * Description:
     * User should see a message when user tries to book a car while not logged in
     * Acceptance Criteria:
     * As customer, I should be able to see error message, when I try to book a car while not logged in
     * Message: Please first login
     * Given user is on the login page
     * And tries to book a car
     * And click continue reservation
     * Then user see the warning message: Please first login
     */
    @Test
    public void userStory5() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage = new HomePage();
        faker = new Faker();
        Select select = new Select(homePage.selectCarsDropdown);
        select.selectByIndex(2);
        homePage.pickUpplace.sendKeys(faker.country().capital());
        homePage.dropOffplace.sendKeys(faker.country().capital());
        homePage.pickupDate.sendKeys(faker.date().toString());
        homePage.pickupTime.sendKeys("13:13");
        homePage.dropOffeDate.sendKeys(faker.date().toString());
        homePage.dropOffTime.sendKeys("13:53");
        homePage.continueReservation.click();
        ReusableMethods.waitForVisibility(homePage.pleaseFirstLoginWarning, 5);
        Assert.assertTrue(homePage.pleaseFirstLoginWarning.isDisplayed());
        Driver.closeDriver();
    }
}

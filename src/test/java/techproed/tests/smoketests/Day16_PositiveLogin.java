package techproed.tests.smoketests;

import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day16_PositiveLogin {
    /**
     * USER STORY 1
     *     •Name:
     *     Admin Login
     *
     * 	•Description:
     * 	User should be able login as admin
     *
     * 	•Acceptance Criteria:
     * 	•As admin, I should be able to log in the application
     *
     * 	https://www.bluerentalcars.com/
     *     Admin email: admin@bluerentalcars.com
     * 	Admin password: 12345
     */
    /*
    SMOKE TEST
--------------------------------------
*** What is is ?
 To see the application is UP and RUNNING
 Testing critical functionalities
    Ex: Login
        Checkin
        Check out
        Add to cart
        Payment ...
*** How often do we do smoke testing?
     It should be done every early morning => 08.00 am
*** How long does smoke test run ?
     15 - 20 mins
*** How can we do our smoke test ?
    We have a smoke test suite in our framework
    We run it every morning
*** How many test cases do you have in your smoke test suite ?
    About 20 test cases
*** Do all of your smoke tests automated?
    Smoke test cases are crucial and we must automate
*** Who decides smoke testing ?
    Test Lead / Team Work

    REGRESSION TEST
-------------------------------
*** What ? Testing ALL major functionalities
**This is a comprehensive test
    Smoke
    Creating new users
    Making payment with different payment method ...
*** How often is regression test  done ?
    Before every major release and after fixing major bugs
    Every 6 months (depends on your project)
    When new features added
*** How long does regression test take to execute ?
    It takes 4-5 hours.
*** How do you run your regression test?
    We have a regression suit in our framework
*** How many test cases do you have in your regression suite?
    Depends on the project, 500
*** Are all of your regression test cases automated?
    More than %90 of test cases can be automated.
    There can be some test cases that they need manual intervention.
*** Which stories can not be automated?
    Captcha Codes
    We might have some stories that need high level security
    Tech/Team lead have access to these pages.
    They might need manual intervention
*** Who decides regression tests?
    Test/Team lead
     */

    HomePage homePage;
    LoginPage loginPage;
    @Test
    public void adminLogin (){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage=new HomePage();
        loginPage=new LoginPage();
        homePage.homeLoginButton.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("admin_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("admin_password"));
        loginPage.loginButton.click();





    }
}

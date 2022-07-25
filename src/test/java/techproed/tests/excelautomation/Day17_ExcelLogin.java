package techproed.tests.excelautomation;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.DefaultPage;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtil;
import techproed.utilities.ReusableMethods;
import java.io.IOException;
import java.util.List;
import java.util.Map;
public class Day17_ExcelLogin {
    HomePage homePage;
    LoginPage loginPage;
    DefaultPage defaultPage;
    ExcelUtil excelUtil;
    //    we will store excel data in this list
    List<Map<String, String>> testData;
    public void login(){
//          Go to the url
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        initialize objects
        homePage = new HomePage();
        loginPage = new LoginPage();
        defaultPage = new DefaultPage();
        try {
//            clicking to home login button
//            We should surround this part with try catch block, to be able to catch the exception after first login
//            If I add a try catch block, I will not get NoSuchElementException
            homePage.homeLoginButton.click();
        } catch (Exception e){
//            e.printStackTrace();
        }
        try {
//            After 1st login, I need to log out
//            But for the first login I do not need to log out
//            If I add a try catch block, I will not get NoSuchElementException
            defaultPage.userID.click();
            defaultPage.logOut.click();
            defaultPage.OK.click();
            homePage.homeLoginButton.click();
        } catch (Exception e){
        }
    }
    @Test
    public void customerLogin() throws IOException {
//       path of Excel file
        String path = ".\\src\\test\\java\\resources\\mysmoketestdata.xlsx";
//        customer data sheet from mysmoketest excel file
        String customerSheet = "customer_info";
//        use  excelUtil
        excelUtil = new ExcelUtil(path,customerSheet);
//        get and store the data from Excel sheet
        testData = excelUtil.getDataList();
//        System.out.println(testData);
        for(Map<String,String> eachData : testData){
//            System.out.println(eachData);
            login();
            ReusableMethods.waitFor(2);
            loginPage.username.sendKeys(eachData.get("username"));
            ReusableMethods.waitFor(2);
            loginPage.password.sendKeys(eachData.get("password").substring(0,5));
            ReusableMethods.waitFor(2);
            loginPage.loginButton.click();
            ReusableMethods.waitFor(2);
//            Assertion
            Assert.assertTrue(defaultPage.userID.isDisplayed());
//            Screenshot
            ReusableMethods.getScreenshot("LoginTest");
        }
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}

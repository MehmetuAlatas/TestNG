package techproed.tests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;
public class Day17_JSUtilsTest {
    @Test
    public void jsUtilsTest(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        Scroll down until I can see 'Contact'
        JSUtils.scrollIntoViewJS(Driver.getDriver().findElement(By.xpath("//a[.='Contact']")));
        ReusableMethods.waitFor(2);
//        Scroll all the way up
        JSUtils.scrollAllUpByJS();
//        flash
        JSUtils.flash(Driver.getDriver().findElement(By.linkText("Login")));

        Driver.closeDriver();
    }
}
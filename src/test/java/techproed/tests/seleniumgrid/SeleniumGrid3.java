package techproed.tests.seleniumgrid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
public class SeleniumGrid3 {
    WebDriver driver;
    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
        driver.get("https://www.bluerentalcars.com/");
        Thread.sleep(3000);
        String customerService = driver.findElement(By.xpath("(//div[@class='section-title']//h2)[1]")).getText();
        System.out.println(customerService);
        Thread.sleep(3000);
        System.out.println("Current Thread: " + Thread.currentThread());
        System.out.println(driver.getTitle());
        driver.quit();
    }

}
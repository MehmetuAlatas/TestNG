package techproed.tests.dataprovider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Day18_DataProvider1 {

    /*
    DATA PROVIDER: It is a TestNG annotation. It is used to get the list of data
    1. Create a method
    2. Use @DataProvider
    3. Add the data

    We can add alternative name to DataProvider using (name = "alternative name")

    How to pass data from a method to test method with data provider?
    Add (dataProvider = "name") near the @Test annotation
     */
    @DataProvider (name = "customer-login-data" )
    public Object [][] dataProviderMethod(){
        Object [][] customerCredential = {
                {"customer@bluerentalcars.com","12345"},
                {"customer1@bluerentalcars.com","12346"},
                {"customer2@bluerentalcars.com","12347"},
                {"customer3@bluerentalcars.com","12348"}
        };
        return customerCredential;
    }
    @Test (dataProvider = "customer-login-data" )
    public void customerLoginInfo(String username, String password){
        System.out.println("Username: " + username + " || password: " + password);
    }
}
/**Marks a method as supplying data for a test method.
 * The annotated method must return an Object[][] where each Object[] can be assigned
 * the parameter list of the test method. The @Test method that wants to receive data from
 * this DataProvider needs to use a dataProvider name equals to the name of this annotation.
 name: The name of this data provider. If it's not supplied, the name of this data provider will
 automatically be set to the name of the method
 *
 *
 */
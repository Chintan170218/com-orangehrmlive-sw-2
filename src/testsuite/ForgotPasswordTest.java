package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {


    //Declaring URL
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    //Setting up the browser before each individual test
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){

        //Click on the ‘Forgot your password’ link
        WebElement clickForgotPassword = driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
        clickForgotPassword.click();

        //Verify the ‘Forgot Your Password?’ text is display
        //Declaring the text from the requirements
        String expectedMessage = "Forgot Your Password?";

        //Verifying the text from the requirements and getting the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);

        //Validating actual vs expected message
        Assert.assertEquals("The text does not match the expected text",expectedMessage, actualMessage);

    }

    //Closing the browser after each individual test
    @After
    public void teardown(){
        closeBrowser();
    }
}

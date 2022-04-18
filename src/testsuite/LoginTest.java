package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {


    //Declaring URL
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    //Setting up the browser before each individual test
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter “Admin” username
        WebElement enterUsername = driver.findElement(By.id("txtUsername"));
        enterUsername.sendKeys("Admin");

        //Enter “admin123” password
        WebElement enterPassword = driver.findElement(By.id("txtPassword"));
        enterPassword.sendKeys("admin123");

        //Click on ‘LOGIN’ button
        WebElement clickLoginBtn = driver.findElement(By.id("btnLogin"));
        clickLoginBtn.click();

        //Verify the ‘Welcome’ text is display
        //Declaring the text from the requirements
        String expectedMessage = "Welcome";

        //Verifying the text from the requirements and getting the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//*[@id='welcome']"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);

        if(actualMessageElement.isDisplayed()){
            System.out.println("'Welcome' is displayed");
        }else {
            System.out.println("'Welcome' is not displayed");
        }

        //Get first 7 letters of the text 'Welcome'
        String requiredActualText =actualMessage.substring(0,7);
        System.out.println(requiredActualText);

        //Validating actual vs expected message
        Assert.assertEquals("The text does not match the expected text",expectedMessage, requiredActualText);

    }

    //Closing the browser after each individual test
    @After
    public void teardown(){
        closeBrowser();
    }
}

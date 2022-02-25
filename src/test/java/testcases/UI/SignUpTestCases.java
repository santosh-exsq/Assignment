package testcases.UI;

import base.TestBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CreateAccountPage;
import pageObjects.HomePage;

public class SignUpTestCases extends TestBase {

    HomePage homePage;
    CreateAccountPage createAccountPage;

    @BeforeMethod
    public void caseBeforeTest(){
        homePage = new HomePage(driver);
        homePage.hoverToProfileMenu();
        createAccountPage = homePage.clickOnCreateAccountButton();
    }

    @Test(description = "Create account from amazon")
    public void createAccount(){
        String randomEmailId= RandomStringUtils.randomAlphabetic(8)+"@gmail.com";
        System.out.println(randomEmailId);
        createAccountPage.yourNameField.sendKeys(configFile.getPropertyValue("USERNAME"));
        createAccountPage.mobileNumberField.sendKeys(configFile.getPropertyValue("MOBILE_NUMBER"));
                createAccountPage.emailAddressField.sendKeys(randomEmailId);
        createAccountPage.passwordField.sendKeys(configFile.getPropertyValue("SIGN_UP_PASSWORD"));
        createAccountPage.continueButton.click();
    }
}

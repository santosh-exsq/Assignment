package testcases.UI;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class SignInTestCases extends TestBase {

    HomePage homePage;
    SignInPage signInPage;

    @BeforeMethod
    public void caseBeforeTest() {
        homePage = new HomePage(driver);
        homePage.hoverToProfileMenu();
        signInPage = homePage.clickOnSignInButton();
    }

    @Test (description = "Verify elements available on signIn page")
    public void validateElementsAvailabilityOnSignInPage() {
        Assert.assertTrue(signInPage.emailIdField.isDisplayed(), "Email Field is not displayed");
        Assert.assertTrue(signInPage.continueButton.isDisplayed(), "Continue button is not displayed");
    }

    @Test(description = "Verify Error message for blank email Address")
    public void validateErrorMessageForEmailId() {
        signInPage.continueButton.click();
        Assert.assertEquals(signInPage.emailErrorMessage.getText(), configFile.getPropertyValue("EMAIL_VALIDATION"));
    }

    @Test(description = "Login with valid details")
    public void loginWithValidDetails() {
        signInPage.emailIdField.sendKeys(configFile.getPropertyValue("VALID_MOBILE_NO"));
        signInPage.continueButton.click();
        signInPage.passwordField.sendKeys(configFile.getPropertyValue("PASSWORD"));
        signInPage.signInSubmitButton.click();
        Assert.assertTrue(homePage.profileAfterLoggedIn.isDisplayed(),"Logged in Profile Menu is not showing");
    }

    @Test(description = "Verify error message with invalid email Id")
    public void loginWithInvalidDetails() {
        signInPage.emailIdField.sendKeys(configFile.getPropertyValue("INVALID_EMAIL_ID"));
        signInPage.continueButton.click();
        Assert.assertTrue(signInPage.wrongEmailErrorMessage.getText().contains(configFile.getPropertyValue("WRONG_EMAIL_VALIDATION")));
    }
}

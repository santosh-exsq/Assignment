package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    WebDriver driver;
    public SignInPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(id = "ap_email")
    public WebElement emailIdField;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(xpath = "//div[@id='auth-email-missing-alert']//div[@class='a-alert-content']")
    public WebElement emailErrorMessage;

    @FindBy(id = "ap_password")
    public WebElement passwordField;

    @FindBy(id = "signInSubmit")
    public WebElement signInSubmitButton;

    @FindBy(xpath = "//span[@class='a-list-item']")
    public WebElement wrongEmailErrorMessage;

}

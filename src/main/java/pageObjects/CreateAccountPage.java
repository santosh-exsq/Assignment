package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    public CreateAccountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "ap_customer_name")
    public WebElement yourNameField;

    @FindBy(id = "ap_phone_number")
    public WebElement mobileNumberField;

    @FindBy(id = "ap_email")
    public WebElement emailAddressField;

    @FindBy(id = "ap_password")
    public WebElement passwordField;

    @FindBy(id = "ap_password_check")
    public WebElement againPasswordField;

    @FindBy(id = "continue")
    public WebElement continueButton;
}

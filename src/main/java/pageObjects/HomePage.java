package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[text()='Hello, Sign in']")
    public WebElement signInMenu;

    @FindBy(xpath = "//div[@id='nav-flyout-ya-signin']//span[text()='Sign in']")
    public WebElement signInOption;

    @FindBy(xpath = "//div[@id='nav-flyout-ya-newCust']//a[text()='Start here.']")
    public WebElement startHereOption;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement profileAfterLoggedIn;

    public void hoverToProfileMenu(){
        Actions actions = new Actions(driver);
        actions.moveToElement(signInMenu).build().perform();
    }

    public SignInPage clickOnSignInButton(){
        signInOption.click();
        return new SignInPage(driver);
    }

    public CreateAccountPage clickOnCreateAccountButton(){
        startHereOption.click();
        return new CreateAccountPage(driver);
    }


}

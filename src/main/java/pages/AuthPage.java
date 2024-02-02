package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Helper;

public class AuthPage {

    @FindBy(id = "loginEmail")
    private WebElement emailInput;

    @FindBy(id = "loginPassword")
    private WebElement passwordInput;

    @FindBy(id = "authButton")
    private WebElement loginButton;

    @FindBy(id = "authAlertsHolder")
    private WebElement errorAuth;

    public AuthPage() {
        PageFactory.initElements(Helper.getDriver(), this);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getTextOfErrorAuth() {
        return errorAuth.getText();
    }
}
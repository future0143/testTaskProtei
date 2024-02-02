package steps;

import config.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AuthPage;
import utils.Helper;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AuthSteps {

    private final AuthPage authPage;

    public AuthSteps(AuthPage authPage) {
        this.authPage = authPage;
    }

    @Given("Находимся на странице авторизации")
    public void openAuthPage() {
        Helper.openPage(Constants.AUTH_PAGE.getData());
    }

    @When("Вводим {string} в форму ввода")
    public void inputEmail(String email) {
        if (email.equals("(зарегистрированный email)")) {
            inputEmail(Constants.EMAIL.getData());
        } else {
            authPage.enterEmail(email);
        }
    }

    @And("вводим {string} в форму ввода")
    public void inputPassword(String password) {
        authPage.enterPassword(password);
    }

    @And("нажимаем на кнопку \"Вход\"")
    public void clickButton() {
        authPage.clickLoginButton();
    }

    @Given("Пользователь авторизован")
    public void userAuthorised() {
        openAuthPage();
        inputEmail(Constants.EMAIL.getData());
        inputPassword(Constants.PASSWORD.getData());
        clickButton();
    }

    @When("Вводим email в форму ввода")
    public void enterEmailOfRegisteredUser() {
        inputEmail(Constants.EMAIL.getData());
    }

    @And("вводим пароль в форму ввода")
    public void enterPassOfRegisteredUser() {
        inputPassword(Constants.PASSWORD.getData());
    }

    @Then("Появляется {string}")
    public void checkErrorText(String error) {
        assertEquals(error, authPage.getTextOfErrorAuth());
    }
}
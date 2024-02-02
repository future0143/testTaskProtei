package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.InputsPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputsPageSteps {

    private final InputsPage inputsPage;

    public InputsPageSteps() {
        this.inputsPage = new InputsPage();
    }

    @Then("Происходит успешная авторизация: открывается анкета")
    @And("находимся на странице с анкетой")
    public void successAuth() {
        inputsPage.checkInputsFormIsVisible();
    }

    @When("вводим {string} в поле Email")
    public void inputEmail(String email) {
        inputsPage.inputEmail(email);
    }

    @When("вводим {string} в поле Имя")
    public void inputName(String name) {
        inputsPage.inputName(name);
    }

    @When("выбираем {string}")
    public void chooseGenderInDropDown(String gender) {
        inputsPage.chooseGender(gender);
    }

    @When("устанавливаем {string} в разделе с чекбоксами")
    public void setCheckbox(String checkbox) {
        if (checkbox.contains("1.1")) {
            inputsPage.chooseFirstCheckbox();
        } else {
            inputsPage.chooseSecondCheckbox();
        }
    }

    @When("выбираем {string} из списка радиокнопок")
    public void chooseRadioButton(String radioBtn) {
        switch (radioBtn) {
            case "2.1" -> inputsPage.chooseFirstRadioBtn();
            case "2.2" -> inputsPage.chooseSecondRadioBtn();
            case "2.3" -> inputsPage.chooseThirdRadioBtn();
        }
    }

    @When("нажимаем на кнопку Добавить")
    public void clickButtonAdd() {
        inputsPage.clickBtnAdd();
    }

    @And("в таблице с данными отображаются все данные заполненной анкеты - {string}, {string}, {string}, {string}, {string}")
    public void checkDataInTable(String email, String name, String gender, String choiceFirst, String choiceSecond) {
        List<WebElement> cells = checkFieldsFromTable(email, name, gender, choiceSecond);
        assertEquals(cells.get(3).getText(), choiceFirst);
    }

    private List<WebElement> checkFieldsFromTable(String email, String name, String gender, String choiceSecond) {
        List<WebElement> rows = inputsPage.getListOfRecordsFromTable();
        List<WebElement> cells = rows.get(0).findElements(By.tagName("td"));
        assertEquals(cells.get(0).getText(), email);
        assertEquals(cells.get(1).getText(), name);
        assertEquals(cells.get(2).getText(), gender);
        assertEquals(cells.get(4).getText(), choiceSecond);

        return cells;
    }

    @Then("в поле Пол отображается выбранный {string}")
    public void checkGender(String gender) {
        assertEquals(inputsPage.getTextFromFieldGender(), gender);
    }

    @Then("в поле с чекбоксами выбран {string}")
    public void checkChosenCheckbox(String checkbox) {
        if (checkbox.equals("1.1")) {
            assertTrue(inputsPage.getCheckboxFirst().isSelected());
        } else {
            assertTrue(inputsPage.getCheckboxSecond().isSelected());
        }
    }

    @Then("в поле с радиокнопками выбран {string}")
    public void checkRadioButton(String radioButton) {
        switch (radioButton) {
            case "2.1" -> assertTrue(inputsPage.getRadioBtnFirst().isSelected());
            case "2.2" -> assertTrue(inputsPage.getRadioBtnSecond().isSelected());
            case "2.3" -> assertTrue(inputsPage.getRadioBtnThird().isSelected());
        }
    }

    @Then("появляется уведомление об успешном добавлении данных")
    public void checkTextFromAlert() {
        String expectedText = "Данные добавлены.";
        assertEquals(inputsPage.getTextFromModalContent(), expectedText);
        inputsPage.clickButtonOk();
    }

    @When("выбираем первый вариант в разделе с чекбоксами")
    public void chooseFirstCheckbox() {
        inputsPage.chooseFirstCheckbox();
    }

    @And("выбираем второй вариант в разделе с чекбоксами")
    public void chooseSecondCheckbox() {
        inputsPage.chooseSecondCheckbox();
    }

    @Then("в поле с чекбоксами выбраны оба варианта")
    public void checkAllCheckboxAreChosen() {
        assertTrue(inputsPage.getCheckboxFirst().isSelected());
        assertTrue(inputsPage.getCheckboxSecond().isSelected());
    }

    @And("в таблице с данными отображаются все данные заполненной анкеты - {string}, {string}, {string}, {string}, {string}, {string}")
    public void checkDataInTableWithTwoCheckbox(String email, String name, String gender, String firstCheckbox, String secondCheckbox, String choiceSecond) {
        List<WebElement> cells = checkFieldsFromTable(email, name, gender, choiceSecond);
        assertEquals(cells.get(3).getText(), firstCheckbox + ", " + secondCheckbox);
    }

    @Then("Добавление анкеты не происходит. Таблица с анкетами пуста")
    @And("данные заполненной анкеты отсутствуют в таблице")
    public void checkTableIsEmpty() {
        List<WebElement> rows = inputsPage.getListOfRecordsFromTable();
        assertTrue(rows.isEmpty());
    }

    @Then("появляется {string}")
    public void появляется(String textError) {
        assertEquals(textError, inputsPage.getTextOfError());
    }
}
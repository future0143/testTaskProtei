package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Helper;

import java.util.List;

public class InputsPage {

    @FindBy(id = "dataEmail")
    private WebElement dataEmail;

    @FindBy(id = "dataName")
    private WebElement dataName;

    @FindBy(id = "inputsPage")
    private WebElement inputsForm;

    @FindBy(id = "dataGender")
    private WebElement gender;

    @FindBy(id = "dataCheck11")
    private WebElement checkboxFirst;

    @FindBy(id = "dataCheck12")
    private WebElement checkboxSecond;

    @FindBy(id = "dataSelect21")
    private WebElement radioBtnFirst;

    @FindBy(id = "dataSelect22")
    private WebElement radioBtnSecond;

    @FindBy(id = "dataSelect23")
    private WebElement radioBtnThird;

    @FindBy(id = "dataSend")
    private WebElement buttonAdd;

    @FindBy(id = "dataTable")
    private WebElement dataTable;

    @FindBy(className = "uk-modal-content")
    private WebElement modalContent;

    @FindBy(xpath = "//button[contains(@class, 'uk-modal-close')]")
    private WebElement buttonOk;

    @FindBy(id = "dataAlertsHolder")
    private WebElement errorAlert;

    private Select select;

    public InputsPage() {
        PageFactory.initElements(Helper.getDriver(), this);
    }

    public void checkInputsFormIsVisible() {
        inputsForm.isDisplayed();
    }

    public void inputName(String name) {
        dataName.sendKeys(name);
    }

    public void inputEmail(String email) {
        dataEmail.sendKeys(email);
    }

    public void chooseGender(String genderName) {
        select = new Select(gender);
        select.selectByVisibleText(genderName);
    }

    public void chooseFirstCheckbox() {
        checkboxFirst.click();
    }

    public void chooseSecondCheckbox() {
        checkboxSecond.click();
    }

    public void chooseFirstRadioBtn() {
        radioBtnFirst.click();
    }

    public void chooseSecondRadioBtn() {
        radioBtnSecond.click();
    }

    public void chooseThirdRadioBtn() {
        radioBtnThird.click();
    }

    public void clickBtnAdd() {
        buttonAdd.click();
    }

    public List<WebElement> getListOfRecordsFromTable() {
        return dataTable.findElements(By.xpath(".//tbody/tr"));
    }

    public String getTextFromModalContent() {
        return modalContent.getText();
    }

    public String getTextFromFieldGender() {
        return select.getFirstSelectedOption().getText();
    }

    public void clickButtonOk() {
        buttonOk.click();
    }

    public WebElement getCheckboxFirst() {
        return checkboxFirst;
    }

    public WebElement getCheckboxSecond() {
        return checkboxSecond;
    }

    public WebElement getRadioBtnFirst() {
        return radioBtnFirst;
    }

    public WebElement getRadioBtnSecond() {
        return radioBtnSecond;
    }

    public WebElement getRadioBtnThird() {
        return radioBtnThird;
    }

    public String getTextOfError() {
        return errorAlert.getText();
    }
}
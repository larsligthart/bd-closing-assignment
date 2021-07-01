package io.testsmith.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VisaApplicationPage extends AbstractPageBase {

    @FindBy(name = "first_name")
    private WebElement textfieldFirstName;

    @FindBy(name = "last_name")
    private WebElement textfieldLastName;

    @FindBy(name = "email")
    private WebElement textfieldEmail;

    @FindBy(name = "confirmemail")
    private WebElement textfieldEmailConfirm;

    @FindBy(name = "phone")
    private WebElement textfieldPhone;

    @FindBy(name = "date")
    private WebElement textfieldDate;

    @FindBy(css = "label.switch input")
    private WebElement checkboxNotes;

    @FindBy(name = "notes")
    private WebElement textfieldNotes;

    @FindBy(id = "sub")
    private WebElement submitButton;


    public VisaApplicationPage(WebDriver driver) {
        super(driver);
    }

    public VisaApplicationPage setFirstName(String firstName) {
        textfieldFirstName.sendKeys(firstName);
        return this;
    }

    public VisaApplicationPage setLastName(String lastName) {
        textfieldLastName.sendKeys(lastName);
        return this;
    }

    public VisaApplicationPage setEmail(String email) {
        textfieldEmail.sendKeys(email);
        return this;
    }

    public VisaApplicationPage setEmailConfirm(String email) {
        textfieldEmailConfirm.sendKeys(email);
        return this;
    }

    public VisaApplicationPage setPhoneNumber(String phoneNumber) {
        textfieldPhone.sendKeys(phoneNumber);
        return this;
    }

    public VisaApplicationPage setDate(String date) {
        textfieldDate.sendKeys(date);
        return this;
    }

    public VisaApplicationPage clickNotesButton() {
        checkboxNotes.click();
        return this;
    }

    public VisaApplicationPage setNotes(String notes) {
        textfieldNotes.sendKeys(notes);
        return this;
    }

    public VisaApplicationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public VisaApplicationPage fillRequiredFieldsVisaFormAndSubmit(String firstName, String lastName, String email, String phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setEmailConfirm(email);
        setPhoneNumber(phoneNumber);
        clickSubmitButton();
        return this;
    }
}
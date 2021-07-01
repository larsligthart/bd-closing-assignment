package io.testsmith.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VisaConfirmationPage extends AbstractPageBase {

    @FindBy(className = "checkmark")
    private WebElement checkMark;

    public VisaConfirmationPage(WebDriver driver) {super(driver);}

    public boolean isCheckMarkVisibility() {
        return checkMark.isDisplayed();
    }
}


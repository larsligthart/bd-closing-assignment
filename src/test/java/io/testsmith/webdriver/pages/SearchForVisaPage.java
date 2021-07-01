package io.testsmith.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SearchForVisaPage extends AbstractPageBase {

    @FindBy(css = "select[name='nationality_country'] + div")
    private WebElement dropdownFromCountry;

    @FindBy(css = "select[name='nationality_country'] + div input")
    private WebElement textfieldFromCountry;

    @FindBy(css = "select[name='destination_country'] + div")
    private WebElement dropdownToCountry;

    @FindBy(css = "select[name='destination_country'] + div input")
    private WebElement textfieldToCountry;

    @FindBy(name = "date")
    private WebElement textfieldDate;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement buttonSubmit;

    public SearchForVisaPage(WebDriver driver) {
        super(driver);
    }

//    public SearchForVisaPage setCountryOfOriginTo(String countryOfOrigin) {
//        dropdownFromCountry.click();
//        textfieldFromCountry.sendKeys(countryOfOrigin);
//        driver.findElement(By.xpath(String.format("//li/em[text()='%s']", countryOfOrigin))).click();
//        return this;
//    }
//
//    public SearchForVisaPage setCountryOfDestinationTo(String countryOfDestination) {
//        dropdownToCountry.click();
//        textfieldToCountry.sendKeys(countryOfDestination);
//        driver.findElement(By.xpath(String.format("//li/em[text()='%s']", countryOfDestination))).click();
//        return this;
//    }

    public SearchForVisaPage setCountryTo(String country, String selector) {
        if (selector == "Destination") {
            dropdownToCountry.click();
            textfieldToCountry.sendKeys(country);
        } else if (selector == "Origin") {
            dropdownFromCountry.click();
            textfieldFromCountry.sendKeys(country);
        }
        driver.findElement(By.xpath(String.format("//li/em[text()='%s']", country))).click();
        return this;
    }

    public SearchForVisaPage setDateTo(LocalDateTime date) {
        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
        if (date.isBefore(tomorrow)) {
               return this;
        }
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String formatedDate = date.format(dateFormatter);
        textfieldDate.sendKeys(formatedDate);

        return this;
    }

    public SearchForVisaPage clickSubmitButton() {
        buttonSubmit.click();
        return this;
    }

    public SearchForVisaPage fillVisumFormAndSubmit(String originCountry, String destination, LocalDateTime date) {
        this.setCountryTo(originCountry, "Origin")
                .setCountryTo(destination, "Destination")
                .setDateTo(date)
                .clickSubmitButton();

        return this;
    }
}
package io.testsmith.webdriver;

import io.testsmith.webdriver.pages.HomePage;
import io.testsmith.webdriver.pages.SearchForVisaPage;
import io.testsmith.webdriver.pages.VisaApplicationPage;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class Exercises extends TestBase {

    @Test
    public void applyForVisa() {

        new HomePage(getDriver())
                .acceptCookies()
                .selectMenuItem("Visa");

        LocalDateTime travelDay = LocalDateTime.now().plusWeeks(3);

        boolean checkmark = new SearchForVisaPage((getDriver()))
                .fillVisumFormAndSubmit(
                        "American Samoa",
                        "Belgium",
                        travelDay
                )
                .fillRequiredFieldsVisaFormAndSubmit(
                        "Jan",
                        "Test",
                        "jantest@test.nl",
                        "0612345678"
                ).isCheckMarkVisibility();

        Assert.assertTrue(checkmark);
    }

}

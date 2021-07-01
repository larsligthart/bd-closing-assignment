package io.testsmith.webdriver;

import io.testsmith.webdriver.pages.HomePage;
import io.testsmith.webdriver.pages.SearchForVisaPage;
import io.testsmith.webdriver.pages.VisaApplicationPage;
import org.testng.annotations.Test;

public class Exercises extends TestBase {

    @Test
    public void applyForVisa() throws InterruptedException {

        new HomePage(getDriver())
                .acceptCookies()
                .selectMenuItem("Visa");

        LocalDateTime travelDay = LocalDateTime.now().plusWeeks(3);

        new SearchForVisaPage((getDriver()))
                .fillVisumFormAndSubmit(
                        "American Samoa",
                        "Belgium",
                        travelDay
                );


        Thread.sleep(5000);

        new VisaApplicationPage(getDriver());
    }

}

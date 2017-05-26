package ui.pages;

import core.driver.DriverProvider;
import core.pom.elements.IElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import core.pom.BasePage;

/**
 * Created by Юрий on 13.05.2017.
 */
public class LoginPage extends BasePage {

    @FindBy(how =How.CSS, using = ".w-authforms__quicksign-button_fb")
    private IElement facebookBtn;

    public FacebookLoginPage openFacebookLoginPage() {
        facebookBtn.waitForElementClickable().click();
        DriverProvider.getDriver().switchToNewWindow();
        return new FacebookLoginPage();
    }
}

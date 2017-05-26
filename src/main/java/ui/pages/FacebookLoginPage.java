package ui.pages;

import core.driver.DriverProvider;
import core.pom.elements.IElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import core.pom.BasePage;

/**
 * Created by Юрий on 13.05.2017.
 */
public class FacebookLoginPage extends BasePage {

    @FindBy(how = How.ID, using = "email")
    private IElement emailFld;

    @FindBy(how = How.ID, using = "pass")
    private IElement passwordFld;

    @FindBy(how = How.ID, using = "loginbutton")
    private IElement loginBtn;

    public GamePage login(String email, String password) {
        emailFld.waitForElementVisible().sendKeys(email);
        passwordFld.waitForElementVisible().sendKeys(password);
        loginBtn.waitForElementClickable().click();
        DriverProvider.getDriver().switchToPreviousWindow();
        return new GamePage();
    }

}

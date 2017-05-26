package ui.pages;

import core.driver.DriverProvider;
import core.pom.elements.IElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import core.pom.BasePage;

/**
 * Created by Юрий on 13.05.2017.
 */
public class MainPage extends BasePage {

    @FindBy(how = How.CSS, using = ".w-authmenu__button_log-in")
    IElement loginBtn;

    public MainPage goTo() {
        DriverProvider.getDriver().get("https://plarium.com/ru/igri-strategii/vikings-war-of-clans/");
        return new MainPage();
    }

    public LoginPage openLoginPage() {
        loginBtn.waitForElementVisible().click();
        return new LoginPage();
    }
}

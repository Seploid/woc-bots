package core.driver;


import org.openqa.selenium.WebDriver;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

/**
 * Created by Юрий on 13.05.2017.
 */
public interface IDriver extends WebDriver {

    WebDriver getWebDriver();
    Screen getScreen();
    void switchToNewWindow();
    void switchToPreviousWindow();

}

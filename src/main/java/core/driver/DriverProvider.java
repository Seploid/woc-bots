package core.driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.sikuli.script.Screen;

import java.io.IOException;

/**
 * Created by Юрий on 13.05.2017.
 */
public class DriverProvider {

    private static IDriver driver;

    public static IDriver getDriver() {
        if (driver == null) {
            driver = new Driver(new ChromeDriver(), new Screen());
//            driver.manage().window().setSize(new Dimension(10,10));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}

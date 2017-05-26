package core.driver;

import core.driver.IDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import java.awt.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Юрий on 14.05.2017.
 */
public class Driver implements IDriver {

    private WebDriver webDriver;
    private String winHandle;
    private Screen screen;

    public Driver(WebDriver webDriver, Screen screen) {
        this.webDriver = webDriver;
        this.screen = screen;
    }

    public void get(String s) {
        webDriver.get(s);
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return webDriver.findElements(by);
    }

    public WebElement findElement(By by) {
        return webDriver.findElement(by);
    }

    public String getPageSource() {
        return webDriver.getPageSource();
    }

    public void close() {
        webDriver.close();
    }

    public void quit() {
        webDriver.quit();
    }

    public Set<String> getWindowHandles() {
        return webDriver.getWindowHandles();
    }

    public String getWindowHandle() {
        return webDriver.getWindowHandle();
    }

    public TargetLocator switchTo() {
        return webDriver.switchTo();
    }

    public Navigation navigate() {
        return webDriver.navigate();
    }

    public Options manage() {
        return webDriver.manage();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public Screen getScreen() {
        return screen;
    }


    public void switchToNewWindow() {
        winHandle = getWindowHandle();
        Set<String> winHandles = getWindowHandles();
        winHandles.remove(winHandle);
        for (String newWinHandle: winHandles) {
            switchTo().window(newWinHandle);
        }
    }

    public void switchToPreviousWindow() {
        switchTo().window(winHandle);
    }
}

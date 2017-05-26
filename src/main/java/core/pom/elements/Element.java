package core.pom.elements;

import core.pom.FindByHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Юрий on 13.05.2017.
 */
public class Element implements IElement {

    private final long DEFAULT_TIMEOUT = 5;

    private By locator;
    private WebDriver driver;

    public Element(WebDriver driver, How how, String using) {
        this.driver = driver;
        this.locator = FindByHelper.getLocator(how, using);
    }

    public void click() {
        driver.findElement(locator).click();
    }

    public void submit() {
        driver.findElement(locator).submit();
    }

    public void sendKeys(CharSequence... charSequences) {
        driver.findElement(locator).sendKeys(charSequences);
    }

    public void clear() {
        driver.findElement(locator).clear();
    }

    public String getTagName() {
        return driver.findElement(locator).getTagName();
    }

    public String getAttribute(String s) {
        return driver.findElement(locator).getAttribute(s);
    }

    public boolean isSelected() {
        return driver.findElement(locator).isSelected();
    }

    public boolean isEnabled() {
        return driver.findElement(locator).isEnabled();
    }

    public String getText() {
        return driver.findElement(locator).getText();
    }

    public List<WebElement> findElements(By by) {
        return driver.findElement(locator).findElements(by);
    }

    public WebElement findElement(By by) {
        return driver.findElement(locator).findElement(by);
    }

    public boolean isDisplayed() {
        return driver.findElement(locator).isDisplayed();
    }

    public Point getLocation() {
        return driver.findElement(locator).getLocation();
    }

    public Dimension getSize() {
        return driver.findElement(locator).getSize();
    }

    public Rectangle getRect() {
        return driver.findElement(locator).getRect();
    }

    public String getCssValue(String s) {
        return driver.findElement(locator).getCssValue(s);
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return driver.findElement(locator).getScreenshotAs(outputType);
    }

    public IElement waitForElementVisible() {
        return waitForElementVisible(DEFAULT_TIMEOUT);
    }

    public IElement waitForElementVisible(long timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }

    public IElement waitForElementClickable() {
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator));
        return this;
    }

    public IElement waitForElementInvisible() {
        return waitForElementInvisible(DEFAULT_TIMEOUT);
    }

    public IElement waitForElementInvisible(long timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOfElementLocated(locator));
        return this;
    }

    public IElement waitForTextToBePresentInElement(String text, long timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        return this;
    }
}

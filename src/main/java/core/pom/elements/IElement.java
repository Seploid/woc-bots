package core.pom.elements;

import org.openqa.selenium.WebElement;

/**
 * Created by Юрий on 13.05.2017.
 */
public interface IElement extends WebElement {

    IElement waitForElementVisible();
    IElement waitForElementVisible(long timeout);
    IElement waitForElementClickable();
    IElement waitForElementInvisible();
    IElement waitForElementInvisible(long timeout);
    IElement waitForTextToBePresentInElement(String text, long timeout);

}

package core.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.support.How;

/**
 * Created by Юрий on 13.05.2017.
 */
public class FindByHelper {


    public static By getLocator(How how, String using) {
        switch (how){
            case CLASS_NAME:
                return By.className(using);
            case CSS:
                return By.cssSelector(using);
            case ID:
                return By.id(using);
            case NAME:
                return By.name(using);
            case XPATH:
                return By.xpath(using);
            case LINK_TEXT:
                return By.linkText(using);
            default:
                throw new IllegalArgumentException("Unsupported How enum value.");
        }
    }
}

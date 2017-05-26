package core.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Created by Юрий on 14.05.2017.
 */
public class WaitConditions {

    public static ExpectedCondition<Boolean> htmlToFinishLoading() {

        return new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                String script = "return document.readyState";
                return (Boolean) ((JavascriptExecutor) driver).executeScript(script).equals("complete");
            }

            @Override
            public String toString() {
                return String.format("Wait for html to finish loading");
            }
        };
    }
}

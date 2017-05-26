package core.pom;

import core.driver.DriverProvider;
import core.pom.factory.PageFactory;

/**
 * Created by Юрий on 13.05.2017.
 */
public class BasePage implements IPage {

    public BasePage() {
        PageFactory.initElements(DriverProvider.getDriver(), this);
    }
}

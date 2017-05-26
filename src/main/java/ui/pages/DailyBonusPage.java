package ui.pages;

import core.pom.BasePage;
import core.pom.annotations.FindByImage;
import core.pom.elements.IImageElement;

/**
 * Created by Юрий on 14.05.2017.
 */
public class DailyBonusPage extends BasePage {

    @FindByImage(url = "Common/pickup.PNG", similarity = 0.9f, x = 537, y = 338, w = 647, h = 432)
    private IImageElement pickup;

    public GamePage pickup() {
        pickup.clickIfExists(5);
        return new GamePage();
    }
}

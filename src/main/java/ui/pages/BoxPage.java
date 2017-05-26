package ui.pages;

import core.pom.BasePage;
import core.pom.annotations.FindByImage;
import core.pom.elements.IImageElement;

/**
 * Created by Юрий on 16.05.2017.
 */
public class BoxPage extends BasePage {

    @FindByImage(url = "Common/pickup.PNG", similarity = 0.9f, x = 537, y = 338, w = 647, h = 432)
    private IImageElement pickup;

    @FindByImage(url = "Common/close.PNG", similarity = 0.9f, x = 537, y = 338, w = 647, h = 432)
    private IImageElement close;

    public GamePage pickup() {
        pickup.clickIfExists(0);
        close.clickIfExists(0);
        return new GamePage();
    }
}

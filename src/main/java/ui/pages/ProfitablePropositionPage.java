package ui.pages;

import core.pom.annotations.FindByImage;
import core.pom.elements.IImageElement;
import org.sikuli.script.Screen;

/**
 * Created by Юрий on 14.05.2017.
 */
public class ProfitablePropositionPage extends GamePage {

    @FindByImage(url = "ProfitablePropositionPage/Profitable_proposition.PNG", similarity = 0.5f)
    private IImageElement pageTitle;

    @FindByImage(url = "Common/close_window.PNG", similarity = 0.75f)
    private IImageElement closeWindow;

    @Override
    public void waitForPageLoadedCompletely() {
        pageTitle.wait(60d);
    }

    public void closeWindows() {
        closeWindow.click();
    }
}

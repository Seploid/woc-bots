package ui.pages;

import core.driver.DriverProvider;
import core.pom.WaitConditions;
import core.pom.annotations.FindByImage;
import core.pom.elements.IElement;
import core.pom.elements.IImageElement;
import core.pom.BasePage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Юрий on 14.05.2017.
 */
public class GamePage extends BasePage {

    @FindBy(how = How.CSS, using = ".preloaderText")
    private IElement progressText;

    @FindBy(how = How.CSS, using = ".c-button")
    private IElement cookieOk;

    @FindByImage(url = "GamePage/daily_bonus.PNG", similarity = 0.75f, x = 490, y = 720, w = 700, h = 210)
    private IImageElement dailyBonus;

    @FindByImage(url = "GamePage/box.PNG", similarity = 0.75f, x = 0, y = 250, w = 120, h = 360)
    private IImageElement lockyBox;

    @FindByImage(url = "GamePage/menu.PNG", x = 490, y = 840, w = 700, h = 210)
    private IImageElement menu;

    public boolean isCorrectPageOpened() {
        return "https://plarium.com/ru/igri-strategii/vikings-war-of-clans/igra/".equals(DriverProvider.getDriver().getCurrentUrl());
    }

    public void waitForPageLoadedCompletely() {
        new WebDriverWait(DriverProvider.getDriver().getWebDriver(), 240).until(WaitConditions.htmlToFinishLoading());
//        progressText.waitForTextToBePresentInElement("50%", 240);
        try {
            Thread.sleep(180000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isDailyBonusExists() {
        return dailyBonus.exists(0);
    }

    public DailyBonusPage openDailyBonus() {
        dailyBonus.click();
        return new DailyBonusPage();
    }

    public BoxPage openLockyBoxBonus() {
        lockyBox.click();
        return new BoxPage();
    }

    public MenuPage openMenu() {
        menu.click();
        return new MenuPage();
    }

    public GamePage okWithCookiePolicy() {
        cookieOk.waitForElementClickable();
        cookieOk.click();
        return new GamePage();
    }
}

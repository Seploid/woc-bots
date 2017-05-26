package ui.pages;

import core.pom.BasePage;
import core.pom.annotations.FindByImage;
import core.pom.elements.IImageElement;

/**
 * Created by Юрий on 16.05.2017.
 */
public class MenuPage extends BasePage {

    @FindByImage(url = "MenuPage/tasks.PNG", x = 567, y = 313, w = 560, h = 515)
    private IImageElement tasks;

    @FindByImage(url = "MenuPage/close.PNG", similarity = 0.9f, x = 567, y = 313, w = 560, h = 515)
    private IImageElement close;

    public TasksPage openTasks() {
        tasks.click();
        return new TasksPage();
    }

    public GamePage closeWindow() {
        close.click();
        return new GamePage();
    }

}

package ui.pages;

import core.pom.BasePage;
import core.pom.annotations.FindByImage;
import core.pom.elements.IImageElement;

/**
 * Created by Юрий on 16.05.2017.
 */
public class TasksPage extends BasePage {

    @FindByImage(url = "TasksPage/clan_tasks_tab.PNG", similarity = 0.9f, x = 512, y = 222, w = 652, h = 707)
    private IImageElement clanTasksTab;

    @FindByImage(url = "TasksPage/vip_tasks_tab.PNG", similarity = 0.9f, x = 512, y = 222, w = 652, h = 707)
    private IImageElement vipTasksTab;

    @FindByImage(url = "TasksPage/speed_up.PNG", similarity = 0.9f, x = 512, y = 222, w = 652, h = 707)
    private IImageElement speedUpButton;

    @FindByImage(url = "TasksPage/start.PNG", similarity = 0.9f, x = 512, y = 222, w = 652, h = 707)
    private IImageElement startButton;

    @FindByImage(url = "TasksPage/pick_up.PNG", similarity = 0.9f, x = 512, y = 222, w = 652, h = 707)
    private IImageElement pickUpButton;

    @FindByImage(url = "TasksPage/close.PNG", similarity = 0.75f, x = 512, y = 222, w = 652, h = 707)
    private IImageElement close;

    public TasksPage actionsOnTasksTab() {
        if ((pickUpButton.exists(1) || startButton.exists(1)) && !speedUpButton.exists(1)) {
            startButton.clickIfExists(1);
            pickUpButton.clickIfExists(1);
        }
        return this;
    }

    public TasksPage openClanTasksTab() {
        clanTasksTab.click();
        return this;
    }

    public TasksPage openVipTasksTab() {
        vipTasksTab.click();
        return this;
    }

    public MenuPage closeWindow() {
        close.click();
        return new MenuPage();
    }
}

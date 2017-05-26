package scripts;

import org.testng.annotations.Test;
import ui.Pages;

public class CommonActions extends BaseScript{
    /**
     * pick up daily bonus if exists
     */
    @Test
    public void dailyBonus() {
        if (Pages.GamePage().isDailyBonusExists()) {
            Pages.GamePage().openDailyBonus().pickup();
        }
    }

    /**
     * open box
     */
    @Test
    public void boxOfLocky() {
        Pages.GamePage().openLockyBoxBonus().pickup();
    }

    @Test
    public void tasks() {
        Pages.GamePage().openMenu().openTasks();
        //MainTab opened by default
        Pages.TasksPage().actionsOnTasksTab();
        Pages.TasksPage().openClanTasksTab().actionsOnTasksTab();
        Pages.TasksPage().openVipTasksTab().actionsOnTasksTab();
        Pages.TasksPage().closeWindow().closeWindow();
    }

}

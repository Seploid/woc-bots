package ui;

import ui.pages.GamePage;
import ui.pages.MainPage;
import ui.pages.ProfitablePropositionPage;
import ui.pages.TasksPage;

/**
 * Created by Юрий on 13.05.2017.
 */
public class Pages {

    public static MainPage MainPage() {
        return new MainPage();
    }

    public static GamePage GamePage() {
        return new GamePage();
    }

    public static ProfitablePropositionPage ProfitablePropositionPage() {
        return new ProfitablePropositionPage();
    }

    public static TasksPage TasksPage() {
        return new TasksPage();
    }
}

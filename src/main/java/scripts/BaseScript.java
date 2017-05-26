package scripts;

import core.driver.DriverProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import ui.Pages;
import ui.bo.ResourceType;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseScript {

    private static final String PATH_TO_SCREENSHOTS_FOLDER = "target/";
    private static final String SCREENSHOTS_FOLDER = "screenshots/";
    private static final String DATE_FORMAT = "dd_MMM_yyyy__hh_mm_ssaa_SSS";

    @Parameters({"login", "password", "resource"})
    @BeforeTest(alwaysRun = true)
    public static void setUp(String login, String password, ResourceType resource) {
        Pages.MainPage().goTo();
        Pages.MainPage()
                .openLoginPage()
                .openFacebookLoginPage()
                .login(login, password)
                .waitForPageLoadedCompletely();
        Pages.GamePage().okWithCookiePolicy();
        Pages.ProfitablePropositionPage().closeWindows();

    }

    @AfterTest(alwaysRun = true)
    public static void tearDown() {
        DriverProvider.closeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public static void takescreenshot() {
        if (!Reporter.getCurrentTestResult().isSuccess()) {
            try {
                byte[] srcFile = ((TakesScreenshot) DriverProvider.getDriver().getWebDriver()).getScreenshotAs(OutputType.BYTES);

                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

                File directory = new File(PATH_TO_SCREENSHOTS_FOLDER + SCREENSHOTS_FOLDER);
                System.out.println("DIRECTORY > " + directory);
                directory.mkdirs();

                String filename = "screenshot_" + dateFormat.format(date) + ".png";
                File f = new File(directory, filename);
                if (!f.exists()) f.createNewFile();

                FileUtils.writeByteArrayToFile(f, srcFile);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

}

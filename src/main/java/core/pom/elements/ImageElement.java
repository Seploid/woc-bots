package core.pom.elements;


import core.exceptions.ScriptException;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

/**
 * Created by Юрий on 13.05.2017.
 */
public class ImageElement implements IImageElement{

    private Screen screen;
    private String url;
    private Float similarity;
    private int x;
    private int y;
    private int w;
    private int h;

    public ImageElement(Screen screen, String url, Float similarity, Integer x, Integer y, Integer w, Integer h) {
        this.screen = screen;
        this.url = url;
        this.similarity = similarity;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public String getUrl() {
        return url;
    }

    public float getSimilarity() {
        return similarity;
    }


    public void click() {
        try {
            new Region(x,y,w,h).click(createImage(), 0);
            Thread.sleep(2000);
        } catch (FindFailed findFailed) {
            throw new ScriptException(findFailed);
        } catch (InterruptedException ignore) {
            ignore.printStackTrace();
        }
    }

    public void wait(double timeout) {

        try {
            screen.wait(createImage(), timeout);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }

    public boolean exists(double timeout) {
        try {
            new Region(x,y,w,h).wait(createImage(), timeout);
            return true;
        } catch (FindFailed ignored) {
            return false;
        }
    }

    public void clickIfExists(double timeout) {
        if (exists(timeout)) {
            click();
        }
    }

    private Pattern createImage() {
        return new Pattern(url).similar(similarity);
    }

}

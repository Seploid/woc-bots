package core.pom.elements;

/**
 * Created by Юрий on 13.05.2017.
 */
public interface IImageElement {

    void click();
    void wait(double timeout);
    boolean exists(double timeout);
    void clickIfExists(double timeout);
}

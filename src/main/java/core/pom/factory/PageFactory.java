package core.pom.factory;

import core.driver.IDriver;
import core.pom.IPage;
import core.pom.annotations.FindByImage;
import core.pom.elements.Element;
import core.pom.elements.IElement;
import core.pom.elements.IImageElement;
import core.pom.elements.ImageElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.sikuli.script.Screen;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Юрий on 13.05.2017.
 */
public class PageFactory {

    public static void initElements(IDriver driver, IPage page) {
        try {
            initImageElements(driver, page);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void initImageElements(IDriver driver, IPage page) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> pageClass = page.getClass();

        for (Field field : pageClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(FindByImage.class) || field.isAnnotationPresent(FindBy.class)) {
                initImageField(driver, page, field);
            }
        }
    }

    private static void initImageField(IDriver driver, IPage pageContainer, Field field) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> fieldClass = field.getType();
        field.setAccessible(true);
        if (IImageElement.class.isAssignableFrom(fieldClass) && field.isAnnotationPresent(FindByImage.class)) {
            final FindByImage elementAnnotation = field.getAnnotation(FindByImage.class);
            Constructor<?> fieldConstructor = ImageElement.class.getConstructor(Screen.class, String.class, Float.class, Integer.class, Integer.class, Integer.class, Integer.class);
            field.set(pageContainer, fieldConstructor.newInstance(
                    driver.getScreen(),
                    ClassLoader.getSystemResource(elementAnnotation.url()).getPath(),
                    elementAnnotation.similarity(),
                    elementAnnotation.x(),
                    elementAnnotation.y(),
                    elementAnnotation.w(),
                    elementAnnotation.h()
            ));
        } else if (IElement.class.isAssignableFrom(fieldClass) && field.isAnnotationPresent(FindBy.class)) {
            final FindBy elementAnnotation = field.getAnnotation(FindBy.class);
            Constructor<?> fieldConstructor = Element.class.getConstructor(WebDriver.class, How.class, String.class);
            field.set(pageContainer, fieldConstructor.newInstance(driver, elementAnnotation.how(), elementAnnotation.using()));
        } else {
            throw new IllegalArgumentException("Incorrect pair of Annotation and Interface for field of page object");
        }
    }
}

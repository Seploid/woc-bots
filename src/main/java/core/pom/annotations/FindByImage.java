package core.pom.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Юрий on 13.05.2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ java.lang.annotation.ElementType.FIELD })
public @interface FindByImage {

    public abstract String url() default "";

    public abstract float  similarity() default 1f;

    public abstract int x() default 0;

    public abstract int y() default 0;

    public abstract int w() default 1680;

    public abstract int h() default 1050;
}

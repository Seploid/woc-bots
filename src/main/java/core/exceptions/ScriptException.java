package core.exceptions;

/**
 * Created by Юрий on 16.05.2017.
 */
public class ScriptException extends RuntimeException {

    public ScriptException(Exception e) {
        super(e);
    }
}

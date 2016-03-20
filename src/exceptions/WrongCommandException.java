package exceptions;

/**
 * Created by Evgeny on 19.03.2016.
 */
public class WrongCommandException extends DeviceStoreException {

    public WrongCommandException() {
        exceptionString = "Entered wrong command or wrong parameters.";
    }

}

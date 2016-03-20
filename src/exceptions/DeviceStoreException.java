package exceptions;

/**
 * Created by Evgeny on 20.03.2016.
 */
public class DeviceStoreException extends Exception {
    protected String exceptionString = "";

    @Override
    public String toString() {
        return exceptionString+"\nPlease enter \"help\" for more information";
    }
}

package exceptions;

/**
 * Created by Evgeny on 20.03.2016.
 */
public class WrongSortTypeException extends DeviceStoreException {

    public WrongSortTypeException() {
        exceptionString = "Entered wrong sort parameter. Sorted by ID";
    }
    public WrongSortTypeException(String str) {
        exceptionString = "Entered wrong sort parameter \""+str+"\" Sorted by ID";
    }

    @Override
    public String toString() {
        return exceptionString;
    }
}

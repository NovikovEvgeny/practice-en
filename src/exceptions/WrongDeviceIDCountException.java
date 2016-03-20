package exceptions;

/**
 * Created by Evgeny on 20.03.2016.
 */
public class WrongDeviceIDCountException extends DeviceStoreException {

    public WrongDeviceIDCountException() {
        exceptionString = "Entered wrong deviceID or count of devices. Try again";
    }

    public WrongDeviceIDCountException(int deviceID, int count) {
        exceptionString = "Entered nonexisting deviceID \""+deviceID+
                "\" or count of devices \""+count+"\". Try again";
    }

    @Override
    public String toString () {
        return exceptionString;
    }
}

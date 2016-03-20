package exceptions;

/**
 * Created by Evgeny on 20.03.2016.
 */
public class WrongClientIDCountException extends DeviceStoreException {

    public WrongClientIDCountException() {
        exceptionString = "Entered wrong clientID or count of positions in order";
    }

    public WrongClientIDCountException(int clientID, int count) {
        exceptionString = "Entered nonexisting clientID \""+clientID+"\" or wrong count of positions \""+
                count+"\" in order";
    }

}

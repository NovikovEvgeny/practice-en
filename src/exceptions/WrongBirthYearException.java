package exceptions;

/**
 * Created by Evgeny on 19.03.2016.
 */
public class WrongBirthYearException extends DeviceStoreException {

    public WrongBirthYearException() {
        exceptionString = "Entered wrong year of birth.";
    }

    public WrongBirthYearException(String str) {
        exceptionString = "Entered wrong year of birth \""+str+"\"";
    }

    public WrongBirthYearException(int year, int since, int until) {
        exceptionString = "Entered wrong year of birth \""+year+"\". Year of birth must be between "+since+" and "+
                        until;
    }
}

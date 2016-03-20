package exceptions;

import controllers.Controller;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Evgeny on 20.03.2016.
 */
public class WrongDateException extends DeviceStoreException {

    public WrongDateException() {
        exceptionString = "Entered wrong date.";
    }

    public WrongDateException(String str) {
        exceptionString = "Entered wrong date \""+str+"\". Enter date if format "+Controller.dateFormat.toPattern();
    }

    public WrongDateException(Date date, Calendar before) {
        exceptionString = "Entered wrong date \""+Controller.dateFormat.format(date)+
                "\". Enter date if format "+Controller.dateFormat.toPattern()+
                " date must be before"+Controller.dateFormat.format(before);
    }

}

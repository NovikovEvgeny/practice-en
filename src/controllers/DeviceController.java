package controllers;

import entities.DeviceStorage;
import enums.DeviceSortParams;
import exceptions.WrongDateException;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Evgeny on 19.03.2016.
 */
public class DeviceController extends Controller {

    public static boolean addDevice (DeviceStorage devices, String [] commandSplit) throws WrongDateException {
        Date dt;
        Calendar cal = Calendar.getInstance();
        try {
            dt = Controller.dateFormat.parse(commandSplit[5]);
        } catch (ParseException e) {
            throw new WrongDateException(commandSplit[5]);
        }
        cal.setTime(dt);
        if (cal.after(Calendar.getInstance())) {
            throw new WrongDateException(dt,Calendar.getInstance());
        }
        devices.addDevice(commandSplit[2], commandSplit[3], commandSplit[4], dt);
        View.displayDevices(devices);
        return true;
    }

    public boolean searchDevice(DeviceStorage devices, String[] commandSplit) {
        fillParamsForSearch(commandSplit);
        //TODO check params, now they just ignoring, if param is not model, type, etc
        DeviceStorage devstor = devices.search(searchParams);
        devstor.sort(DeviceSortParams.deviceSortMap.get(sortType));
        View.displayDevices(devstor);
        return true;
    }
}

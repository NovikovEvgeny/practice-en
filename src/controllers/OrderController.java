package controllers;

import entities.ClientStorage;
import entities.DeviceStorage;
import entities.Order;
import entities.OrderStorage;
import enums.OrderSortParams;
import exceptions.WrongClientIDCountException;
import exceptions.WrongDateException;
import exceptions.WrongDeviceIDCountException;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Evgeny on 19.03.2016.
 */
public class OrderController extends Controller {

    public static boolean addOrder(OrderStorage orders, String[] commandSplit, ClientStorage clients, DeviceStorage devices)
            throws WrongDateException, WrongClientIDCountException, WrongDeviceIDCountException {
        int clientID = 0, countOfPositions = 0;
        try {
            clientID = Integer.parseInt(commandSplit[2]);
            countOfPositions = Integer.parseInt(commandSplit[4]);
        } catch (NumberFormatException e) {
            throw new WrongClientIDCountException();
        }
        if (!clients.containsID(clientID) || (countOfPositions < 1)) {
            throw new WrongClientIDCountException(clientID, countOfPositions);
        }

        Date dtOrder;
        Calendar calOrder = Calendar.getInstance();
        try {
            dtOrder = Controller.dateFormat.parse(commandSplit[3]);
        } catch (ParseException e) {
            throw new WrongDateException(commandSplit[3]);
        }
        calOrder.setTime(dtOrder);
        if (calOrder.after(Calendar.getInstance())) {
            throw new WrongDateException(dtOrder, Calendar.getInstance());
        }

        String[] devcount;
        Order tmpOrder = new Order(orders.getCurrentOrderID(), clients.getByID(Integer.parseInt(commandSplit[2])), dtOrder);
        int deviceID = 0, count = 0;
        boolean wrongParams = true;

        for (int i = 0; i < countOfPositions; i++) {
            View.println("Enter deviceID and count of devices");
            do {
                devcount = (new Scanner(System.in)).nextLine().split(" ");
                try {
                    try {
                        deviceID = Integer.parseInt(devcount[0]);
                        count = Integer.parseInt(devcount[1]);
                    } catch (NumberFormatException e) {
                        throw new WrongDeviceIDCountException();
                    }
                    if ((!devices.containsID(deviceID)) || (count < 1)) {
                        throw new WrongDeviceIDCountException(deviceID, count);
                    } else {
                        wrongParams = false;
                    }
                } catch (WrongDeviceIDCountException e) {
                    View.displayWarning(e);
                }
            } while (wrongParams);
            tmpOrder.addPositionInOrder(devices.getByID(deviceID), count);
        }
        orders.addOrder(tmpOrder);
        View.displayOrders(orders);
        return true;
    }

    public boolean searchOrder(OrderStorage orders, String[] commandSplit) {
        fillParamsForSearch(commandSplit);
        //TODO check params now they just ignoring, if param is not clientid, date etc
        OrderStorage ord = orders.search(searchParams);
        ord.sort(OrderSortParams.orderSortMap.get(sortType));
        View.displayOrders(ord);
        return true;
    }
}

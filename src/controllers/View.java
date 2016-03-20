package controllers;

import entities.ClientStorage;
import entities.DeviceStorage;
import entities.OrderStorage;

/**
 * Created by Evgeny on 19.03.2016.
 */
public class View {
    private StringBuilder str;

    public static void displayWarning(Exception e) {
        System.out.println(e.toString());
    }

    public static void displayClients(ClientStorage clients) {
        System.out.println("Total notes: " + clients.getSize()+"\n"+
                        clients.toString());
    }

    public static void displayDevices(DeviceStorage devices) {
        System.out.println("Total notes: " + devices.getSize()+"\n"+
                    devices.toString());
    }

    public static void displayOrders(OrderStorage orders) {
        System.out.println("Total notes: " + orders.getSize()+"\n"+
                            orders.toString());
    }

    public static void println(String s) {
        System.out.println(s);
    }

    public void print(String s) {
        System.out.print(s);
    }

    public void printHelp(String s) {
        switch (s) {
            case "main":
                System.out.println("For information enter help");
                break;

            default:
                System.out.println("Enter command. For information about commands enter help");
                break;
        }
    }
}

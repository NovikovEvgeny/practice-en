package controllers;

import entities.ClientStorage;
import entities.DeviceStorage;
import entities.OrderStorage;
import enums.ClientSortParams;
import enums.DeviceSortParams;
import enums.OrderSortParams;
import exceptions.DeviceStoreException;
import exceptions.WrongCommandException;

import java.util.Date;
import java.util.Scanner;

/**
 * class MainController
 *
 * Created by Evgeny on 14.03.2016.
 */
public class MainController {
    DeviceStorage devices = new DeviceStorage();
    DeviceController deviceController = new DeviceController();
    ClientStorage clients = new ClientStorage();
    ClientController clientController = new ClientController();
    OrderStorage checks = new OrderStorage();
    OrderController orderController = new OrderController();
    //Helper helper = new Helper();
    // TODO change scanner to BufferedReader
    Scanner sc = new Scanner (System.in);
    String command; //entered instruction
    String[] commandSplit;

    public MainController (){
        ClientSortParams.init();
        DeviceSortParams.init();
        OrderSortParams.init();
        //View.init();
    }

    public void run()  {
        //for example & text
        clients.addClient("Evgeny", "Novikov", "Pavlovich", 1994);
        clients.addClient("Alena", "Yakovleva", "Andreevna", 1995);
        clients.addClient("Evgeny", "Yakovlev", "Pavlovich", 1993);
        clients.addClient("Alena", "Novikova", "Pavlovna", 1994);

        devices.addDevice("IPhone-5", "smartphone", "white", new Date());
        devices.addDevice("IPhone-6", "smartphone", "black", new Date());
        devices.addDevice("Lenovo", "notebook", "white", new Date());
        devices.addDevice("Asus", "notebook", "black", new Date());

        int indexOrd = checks.addOrder(clients.getByIndex(0), new Date());
        checks.addPositionInOrder(indexOrd, devices.getByID(0), 5);
        checks.addPositionInOrder(indexOrd, devices.getByID(2), 3);

        indexOrd = checks.addOrder(clients.getByIndex(1), new Date());
        checks.addPositionInOrder(indexOrd, devices.getByID(1), 5);
        checks.addPositionInOrder(indexOrd, devices.getByID(2), 7);

        indexOrd = checks.addOrder(clients.getByIndex(2), new Date());
        checks.addPositionInOrder(indexOrd, devices.getByID(3), 2);
        checks.addPositionInOrder(indexOrd, devices.getByID(1), 1);

        indexOrd = checks.addOrder(clients.getByIndex(0), new Date());
        checks.addPositionInOrder(indexOrd, devices.getByID(0), 3);
        checks.addPositionInOrder(indexOrd, devices.getByID(3), 10);
        //end test

        View.println("WELCOME");
        boolean notExit = true;
        do {
            try {
                command = sc.nextLine();
                commandSplit = command.split(" ");
                switch (commandSplit[0].toLowerCase()) {
                    case "help": //help
                        //display.println(helper.getHelp(command));
                        View.println("help will be here");
                        break;

                    case "add":
                        if (commandSplit.length < 3) {
                            throw new WrongCommandException();
                        }
                        switch (commandSplit[1].toLowerCase()) {
                            case "client":
                                if (commandSplit.length < 6) {
                                    throw new WrongCommandException();
                                }
                                clientController.addClient(clients, commandSplit);
                                break;

                            case "device":
                                if (commandSplit.length < 6) {
                                    throw new WrongCommandException();
                                }
                                deviceController.addDevice(devices, commandSplit);
                                break;

                            case "order":
                                if (commandSplit.length < 5) {
                                    throw new WrongCommandException();
                                }
                                orderController.addOrder(checks, commandSplit, clients, devices);
                                break;

                            default:
                                throw new WrongCommandException();
                        }// end case "add"
                        break;

                    case "search":
                        if (commandSplit.length < 4 || commandSplit.length % 2 == 1) {
                            throw new WrongCommandException();
                        }
                        switch (commandSplit[1].toLowerCase()) {
                            case "client":
                                clientController.searchClient(clients, commandSplit);
                                break;

                            case "device":
                                deviceController.searchDevice(devices, commandSplit);
                                break;

                            case "order":
                                orderController.searchOrder(checks, commandSplit);
                                break;

                            default:
                                throw new WrongCommandException();
                        }//end case "search"
                        break;

                    case "exit":
                        notExit = false;
                        break;

                    default:
                        throw new WrongCommandException();

                }
            } catch (DeviceStoreException e){
                View.displayWarning(e);
            }  catch (NumberFormatException e) {
                View.displayWarning(e);
            }
        } while (notExit);

        sc.close();
		/* Examples of commands:
		 * add client Evgeniy Novikov Pavlovich 1994
		 * add device model type color date(int?)
		 * add check clientID(int) date(==can be"today"?) positions(int)
		 * after add check
		 * diveceID(int) count(int)
		 *
		 * search client firstname Evgeny lastname Novikov middlename Pavlovich year 1994 id 0 sort firstname
		 * search device model asdf type asdf color adsf date 1995 id 0 sort type
		 * search check clientid 0 firstname Evgeny lastname Novikov middlename pavlovich year 1994 date 1994
		 * sort clientid date
		 */
    }
}

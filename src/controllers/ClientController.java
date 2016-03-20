package controllers;

import entities.ClientStorage;
import enums.ClientSortParams;
import exceptions.WrongBirthYearException;

import java.util.Calendar;

/**
 * Created by Evgeny on 19.03.2016.
 */
public class ClientController extends Controller {

    public boolean addClient(ClientStorage clients, String [] commandSplit) throws WrongBirthYearException {
        int year = 0;
        try {
            year = Integer.valueOf(commandSplit[5]);
        } catch (NumberFormatException e) {
            throw new WrongBirthYearException(commandSplit[5]);
        }
        //TODO which limits on birthyear?
        int until = Calendar.getInstance().get(Calendar.YEAR);
        if (year < 1850 || year > until) {
            throw new WrongBirthYearException(year, 1850, until);
        }
        clients.addClient(commandSplit[2], commandSplit[3], commandSplit[4], year);
        View.displayClients(clients);
        return true;
    }

    public boolean searchClient(ClientStorage clients, String[] commandSplit) {
        fillParamsForSearch(commandSplit);
        //TODO check params now they just ignoring, if param is not firstname, lastname etc
        ClientStorage cls = clients.search(searchParams);
        cls.sort(ClientSortParams.clientSortMap.get(sortType));
        View.displayClients(cls);
        return true;
    }
}

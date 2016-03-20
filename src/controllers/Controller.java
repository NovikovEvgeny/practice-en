package controllers;

import enums.ClientSortParams;
import exceptions.WrongSortTypeException;

import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * Created by Evgeny on 19.03.2016.
 */
public class Controller {
    String sortType = "id";
    HashMap<String, String> searchParams = new HashMap<>();

    public static String strDateFormat = "dd.MM.yyyy";
    public static SimpleDateFormat dateFormat = new SimpleDateFormat(strDateFormat);


    public void fillParamsForSearch(String[] commandSplit) {
        searchParams.clear();
        for (int i = 2; i < commandSplit.length; i += 2) {
            if (commandSplit[i].equalsIgnoreCase("sort")) {
                if (ClientSortParams.clientSortMap.containsKey(commandSplit[i + 1].toLowerCase())) {
                    View.displayWarning(new WrongSortTypeException(commandSplit[i + 1]));
                    sortType = commandSplit[i + 1].toLowerCase();
                    break;
                }
            }
            searchParams.put(commandSplit[i], commandSplit[i + 1]);
        }
    }
}

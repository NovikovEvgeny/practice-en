package enums;

import entities.Client;

import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by Evgeny on 19.03.2016.
 */
public class ClientSortParams {

    public static HashMap<String, ClientComparator> clientSortMap =
            new HashMap<String, ClientComparator>();

    public static void init() {
        clientSortMap.put("id", ClientComparator.ID_SORT);
        clientSortMap.put("firstname", ClientComparator.FIRSTNAME_SORT );
        clientSortMap.put("middlename", ClientComparator.MIDDLENAME_SORT);
        clientSortMap.put("lastname", ClientComparator.LASTNAME_SORT);
        clientSortMap.put("birthyear", ClientComparator.BIRTHYEAR_SORT);
    }

    public enum ClientComparator implements Comparator<Client> {
        ID_SORT {
            public int compare(Client c1, Client c2) {
                return Integer.valueOf(c1.getID()).compareTo(c2.getID());
            }
        },
        FIRSTNAME_SORT {
            public int compare(Client c1, Client c2) {
                return c1.getfirstName().compareToIgnoreCase(c2.getfirstName());
            }
        },
        MIDDLENAME_SORT {
            public int compare(Client c1, Client c2) {
                return c1.getmiddleName().compareToIgnoreCase(c2.getmiddleName());
            }
        },
        LASTNAME_SORT {
            public int compare(Client c1, Client c2) {
                return c1.getlastName().compareToIgnoreCase(c2.getlastName());
            }
        },
        BIRTHYEAR_SORT {
            public int compare(Client c1, Client c2) {
                return Integer.valueOf(c1.getYear()).compareTo(c2.getYear());
            }
        };

        public static Comparator<Client> getComparator(final Comparator<Client> comp) {
            return new Comparator<Client>() {
                public int compare(Client o1, Client o2) {
                    return  comp.compare(o1, o2);
                }
            };
        }
    }
}

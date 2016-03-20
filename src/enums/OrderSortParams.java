package enums;

import entities.Order;

import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by Evgeny on 19.03.2016.
 */
public class OrderSortParams {
    public static HashMap<String, OrderComparator> orderSortMap =
            new HashMap<String, OrderComparator>();

    public static void init() {
        orderSortMap.put("id", OrderComparator.ID_SORT);
        orderSortMap.put("date", OrderComparator.DATE_SORT);
        orderSortMap.put("clientid", OrderComparator.CLIENTID_SORT);
    }

    public enum OrderComparator implements Comparator<Order> {
        ID_SORT {
            public int compare(Order c1, Order c2) {
                return Integer.valueOf(c1.getID()).compareTo(c2.getID());
            }
        },
        DATE_SORT {
            public int compare(Order c1, Order c2) {
                return c1.getDate().compareTo(c2.getDate());
            }
        },
        CLIENTID_SORT {
            public int compare(Order c1, Order c2) {
                return Integer.valueOf(c1.getClientID()).compareTo(c2.getClientID());
            }
        };

        public static Comparator<Order> getComparator(final Comparator<Order> comp) {
            return new Comparator<Order>() {
                public int compare(Order o1, Order o2) {
                    return comp.compare(o1, o2);
                }
            };
        }
    }
}

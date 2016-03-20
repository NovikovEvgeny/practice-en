package entities;

import enums.OrderSortParams;

import java.util.*;

/**
 * Created by Evgeny on 14.03.2016.
 */
public class OrderStorage {
    private List<Order> orders = new ArrayList<Order>();
    private int currentOrderID = 0;

    public int addOrder(Client client, Date date) {
        orders.add(new Order(currentOrderID++, client, date));
        return currentOrderID-1;
    }

    /**
     * use only for search
     * @param order
     */
    public int addOrder(Order order) {
        Order ord = new Order(order.getID(), order.getClient(), order.getDate());
        for (int i=0; i<order.getSize(); i++) {
            ord.addPositionInOrder(order.getPosition(i).getDevice(), order.getPosition(i).getCount());
        }
        orders.add(ord);
        currentOrderID++;
        return currentOrderID-1;
    }

    public void addPositionInOrder(int ind, Device device, int count) {
        orders.get(ind).addPositionInOrder(device, count);
    }

    public void sort(OrderSortParams.OrderComparator comp) {
        Collections.sort(orders, OrderSortParams.OrderComparator.getComparator(comp));
    }

    public OrderStorage search(HashMap<String, String> params) {
        OrderStorage findedOrders = clone();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            findedOrders = search(findedOrders, entry.getKey(), entry.getValue());
        }
        return findedOrders;
    }

    public OrderStorage search(OrderStorage ls, String param, String value) {
        OrderStorage findedOrders = new OrderStorage();
        switch (param) {
            case "clientid":
                for (int i=0; i<ls.getSize(); i++) {
                    if (value.equalsIgnoreCase(String.valueOf(ls.getByIndex(i).getClientID()))) {
                        findedOrders.addOrder(ls.getByIndex(i));
                    }
                }
                break;

            case "date":
                for (int i=0; i<ls.getSize(); i++) {
                    if (value.equalsIgnoreCase(String.valueOf(ls.getByIndex(i).getDate()))) {
                        findedOrders.addOrder(ls.getByIndex(i));
                    }
                }
                break;

            case "id":
                for (int i=0; i<ls.getSize(); i++) {
                    if (value.equalsIgnoreCase(String.valueOf(ls.getByIndex(i).getID()))) {
                        findedOrders.addOrder(ls.getByIndex(i));
                    }
                }
                break;

            default:
                findedOrders = ls;
        }
        return findedOrders;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Order order : orders) {
            str.append(order.toString());
        }
        return str.toString();
    }

    @Override
    public OrderStorage clone() {
        OrderStorage ord = new OrderStorage();
        for (Order order : orders) {
            ord.addOrder(order.clone());
        }
        return ord;
    }

    public int getSize() {
        return orders.size();
    }

    public Order getByIndex(int ind) {
        return orders.get(ind).clone();
    }

    public Order getByID(int id) {
        for (Order order : orders) {
            if (order.getID() == id) {
                return order.clone();
            }
        }
        return null;
    }

    public boolean containsID(int id) {
        for (Order order : orders) {
            if (order.getID() == id) {
                return true;
            }
        }
        return false;
    }

    public int getCurrentOrderID() {
        return currentOrderID;
    }

}

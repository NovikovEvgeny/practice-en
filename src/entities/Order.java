package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Evgeny on 14.03.2016.
 */
public class Order {
    private int id;
    private Client client;
    private Date date;
    private List<Position> positions = new ArrayList<Position>();

    public Order(int id, Client client, Date date) {
        this.id = id;
        this.client = client;
        this.date = date;
    }

    public void addPositionInOrder(Device device, int count) {
        positions.add(new Position(device, count));
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Order #" + id + "\n  PurchaserID: " + client.getID() +
                ", FullName: " + client.getFullName() + ", Date: " + date.toString() + "\n");
        for (Position pos : positions) {
            str.append("      " + pos.toString()).append("\n");
        }
        return str.toString();
    }

    @Override
    public Order clone() {
        //TODO encapsulation for date?
        Order ord = new Order(id, getClient(), date);
        for (Position pos : positions) {
            ord.addPositionInOrder(pos.getDevice(), pos.getCount());
        }
        return ord;
    }

    public Position getPosition(int ind) {
        return positions.get(ind).clone();
    }

    public int getSize() {
        return positions.size();
    }

    public int getID() {
        return id;
    }

    public int getClientID() {
        return client.getID();
    }

    public Client getClient() {
        return client.clone();
    }

    public Date getDate() {
        //TODO encapsulation?
        return date;
    }
}

/** The class {@code Position}
 * for describe one of multiplicity notes in {@code Order}
 *
 *  @author Evgeny Novikov
 */
class Position {
    private Device device;
    private int count;

    public Position(Device device, int count) {
        this.device = device;
        this.count = count;
    }

    public Device getDevice() {
        return device.clone();
    }

    public int getCount() {
        return count;
    }

    @Override
    public Position clone() {
        return (new Position(device.clone(), count));
    }

    @Override
    public String toString() {
        return (device.toString() + " Count: " + count);
    }


}


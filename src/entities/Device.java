package entities;

import java.util.Date;

/**
 * The class {@code Device} for describe devices
 *
 * Created by Evgeny on 14.03.2016.
 */
public class Device {
    private int id;
    private String model;
    private String type;
    private String color;
    private Date date;

    public Device(int id, String model, String type, String color, Date date) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.color = color;
        this.date = date;
    }

    public int getID() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }

    public String getType() {
        return this.type;
    }

    public String getColor() {
        return this.color;
    }

    //TODO encapsulation?
    public Date getDate() {
        return date;
    }

    @Override
    public Device clone() {
        return (new Device(id, model, type, color, date));
    }

    @Override
    public String toString() {
        return ("DeviceID: " + id + ", Model: " + model + ", Type: " + type + ", Color: " + color);
    }

    /*
    modify params in future?
    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    */
}

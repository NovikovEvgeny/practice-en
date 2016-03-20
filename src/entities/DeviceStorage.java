package entities;

import enums.DeviceSortParams;

import java.util.*;

/**
 * The class {@code DeviceStorage}
 * for storing a multiplicity of devices ({@code Devices} class)
 *
 * Created by Evgeny on 14.03.2016.
 */
public class DeviceStorage {
    private List<Device> devices = new ArrayList<Device>();
    private int currentDeviceID = 0;

    public void addDevice(String model, String type, String color, Date date) {
        devices.add(new Device (currentDeviceID++, model, type, color, date));
    }

    /**
     * use only for search
     * @param d
     */
    public void addDevice(Device d) {
        devices.add(new Device (d.getID(), d.getModel(), d.getType(), d.getColor(), d.getDate()));
        currentDeviceID++;
    }

    public void sort(DeviceSortParams.DeviceComparator comp) {
        Collections.sort(devices, DeviceSortParams.DeviceComparator.getComparator(comp));
    }

    public DeviceStorage search(HashMap<String, String> params) {
        DeviceStorage findedDevices = clone();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            findedDevices = search(findedDevices, entry.getKey(), entry.getValue());
        }
        return findedDevices;
    }

    public DeviceStorage search(DeviceStorage ls, String param, String value) {
        DeviceStorage findedDevices = new DeviceStorage();
        switch (param) {
            case "model":
                for (int i=0; i<ls.getSize(); i++) {
                    if (value.equalsIgnoreCase(ls.getByIndex(i).getModel())) {
                        findedDevices.addDevice(ls.getByIndex(i));
                    }
                }
                break;

            case "type":
                for (int i=0; i<ls.getSize(); i++) {
                    if (value.equalsIgnoreCase(ls.getByIndex(i).getType())) {
                        findedDevices.addDevice(ls.getByIndex(i));
                    }
                }
                break;

            case "color":
                for (int i=0; i<ls.getSize(); i++) {
                    if (value.equalsIgnoreCase(ls.getByIndex(i).getColor())) {
                        findedDevices.addDevice(ls.getByIndex(i));
                    }
                }
                break;

            case "date":
                for (int i=0; i<ls.getSize(); i++) {
                    if (value.equalsIgnoreCase(String.valueOf(ls.getByIndex(i).getDate()))) {
                        findedDevices.addDevice(ls.getByIndex(i));
                    }
                }
                break;

            case "id":
                for (int i=0; i<ls.getSize(); i++) {
                    if (value.equalsIgnoreCase(String.valueOf(ls.getByIndex(i).getID()))) {
                        findedDevices.addDevice(ls.getByIndex(i));
                    }
                }
                break;

            default:
                findedDevices = ls;
        }
        return findedDevices;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Device device : devices) {
            str.append(device.toString()).append("\n");
        }
        return str.toString();
    }

    @Override
    public DeviceStorage clone() {
        DeviceStorage devstr = new DeviceStorage();
        for (Device device : devices) {
            devstr.addDevice(device.clone());
        }
        return devstr;
    }

    public int getSize() {
        return devices.size();
    }

    public Device getByIndex(int ind) {
        return devices.get(ind).clone();
    }

    public Device getByID(int id) {
        for (Device dev : devices) {
            if (dev.getID() == id) {
                return dev.clone();
            }
        }
        return null;
    }

    public boolean containsID(int id) {
        for (Device dev : devices) {
            if (dev.getID() == id) {
                return true;
            }
        }
        return false;
    }
}

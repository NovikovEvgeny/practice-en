import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class ListDevices {
	
	static Comparator <Device> modelOrder = new Comparator <Device>() {
		public int compare (Device d1, Device d2) {
			return d1.getModel().compareToIgnoreCase(d2.getModel());
		}
	};
	
	static Comparator <Device> typeOrder = new Comparator <Device>() {
		public int compare (Device d1, Device d2) {
			return d1.getType().compareToIgnoreCase(d2.getType());
		}
	};
	
	static Comparator <Device> colorOrder = new Comparator <Device>() {
		public int compare (Device d1, Device d2) {
			return d1.getColor().compareToIgnoreCase(d2.getColor());
		}
	};
	
	static Comparator <Device> idOrder = new Comparator <Device>() {
		public int compare (Device d1, Device d2) {
			int abs = d1.getID() - d2.getID();
			if (abs > 0) {
				return 1;
			} else if (abs < 0) {
                return -1;
			} else {
				return 0;
			}
		}
	};
	
	static Comparator <Device> dateOrder = new Comparator <Device>() {
		public int compare (Device d1, Device d2) {
			int abs = d1.getDate().getYear() - d2.getDate().getYear();
			if (abs > 0) {
				return 1;
			} else if (abs < 0) {
                return -1;
			} else {
				return 0;
			}
		}
	};
	
	private ArrayList<Device> devices;
	
	public ListDevices() {
		devices = new ArrayList<Device>();
	}
	
	public void addDevice(String model, String type, String color, Date date) {
		Device dev = new Device (devices.size(), model, type, color, date);
		devices.add(dev);
	}
	
	public StringBuilder getDevices(String typesort) {
		this.sort(typesort);
		return this.getDevices();
	}
	
	public StringBuilder getDevices() {
		StringBuilder str = new StringBuilder();
		for (Device device : devices) {
			str.append("ID: " + device.getID() + ", Model: " + device.getModel() + 
					", Type: " + device.getType() + ", Color: " + device.getColor() + "\n");
		}
		return str;
	}
	
	public int getSize() {
		return devices.size();
	}
	
	public Device get(int i) { 
		return devices.get(i);
	}
	
	public Device getByID(int id) {
		for (Device dev : devices) {
			if (dev.getID() == id) {
				return dev;
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
	
	public void sort(String typesort) {
		switch (typesort) {
		case "modelOrder": 
			Collections.sort(devices, modelOrder); 
			break;
			
		case "typeOrder": 
			Collections.sort(devices, typeOrder); 
			break;
			
		case "colorOrder": 
			Collections.sort(devices, colorOrder); 
			break;
			
		case "dateOrder": 
			Collections.sort(devices, dateOrder); 
			break;
			
		default: 
			Collections.sort(devices, idOrder); 
			break;
		}
	}
}

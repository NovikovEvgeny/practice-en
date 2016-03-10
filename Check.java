import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Check {
	
	static Comparator <PositionInCheck> deviceIDOrder = 
				new Comparator <PositionInCheck>() {
		public int compare (PositionInCheck c1, PositionInCheck c2) {
			int abs = c1.getDeviceID() - c2.getDeviceID();
			if (abs > 0) {
				return 1;
			} else if(abs < 0) {
                return -1;
			} else {
				return 0;
			}
		}
	};
	
	static Comparator <PositionInCheck> countOrder = 
			new Comparator <PositionInCheck>() {
		public int compare (PositionInCheck c1, PositionInCheck c2) {
			int abs = c1.getCount() - c2.getCount();
			if (abs > 0) {
				return 1;
			} else if (abs < 0) {
                return -1;
			} else {
				return 0;
			}
		}
	};
	
	private int id; 
	private int clientID;
	private Date date;	
	private ArrayList<PositionInCheck> positions;
	
	public Check(int id, int clientID, Date date) {
		positions = new ArrayList<PositionInCheck>();
		this.id = id;
		this.clientID = clientID;
		this.date = date;
	}
	
	public void addPositionInCheck(int deviceID, int count) {
		PositionInCheck pos = new PositionInCheck(deviceID, count);
		positions.add(pos);
	}	
	
	public String getPositions(ListDevices devices, String typesort) {
		this.sort(typesort);
		return this.getPositions(devices);
	}
	
	public String getPositions(ListDevices devices) {
		int id;
		Device dev;
		StringBuilder str = new StringBuilder();
		for (PositionInCheck pos : positions) {
			id = pos.getDeviceID();
			dev = devices.getByID(id);
			str.append("     DeviceID: " + id + ", Model: " + dev.getModel() + ", Type: " + 
					dev.getType() + ", Color: " + dev.getColor() + ", Count: " + pos.getCount() + "\n");
		}
		return str.toString();
	}
	
	public int getSize() {
		return positions.size();
	}
	
	public int getID() {
		return id;
	}
	
	public int getClientID() {
		return clientID;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void sort(String typesortPositions) {
		switch (typesortPositions) {
		case "countOrder": 
			Collections.sort(positions, countOrder); 
			break;
			
		default: 
			Collections.sort(positions, deviceIDOrder); 
			break;
		}
	}
}

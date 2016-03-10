import java.util.ArrayList;
import java.util.Date;
import java.util.Comparator;
import java.util.Collections;

public class ListChecks {
	
	static Comparator <Check> idOrder = new Comparator <Check>() {
		public int compare (Check c1, Check c2) {
			int abs = c1.getID() - c2.getID();
			if (abs > 0) {
				return 1;
			} else if (abs < 0) {
                return -1;
			} else {
				return 0;
			}
		}
	};
	
	static Comparator <Check> clientIDOrder = new Comparator <Check>() {
		public int compare (Check c1, Check c2) {
			int abs = c1.getClientID() - c2.getClientID();
			if (abs > 0) {
				return 1;
			} else if (abs < 0) {
                return -1;
			} else {
				return 0;
			}
		}
	};
	
	static Comparator <Check> dateOrder = new Comparator <Check>() {
		public int compare (Check c1, Check c2) {
			//TODO solve problem with date
			int abs = c1.getDate().getYear() - c2.getDate().getYear();
			if (abs > 0) {
				return 1;
			} else if (abs < 0) {
                return -1;
			} else {
				return 0;
			}
		}
	};
	
	private ArrayList<Check> checks;
	
	public ListChecks() {
		checks = new ArrayList<Check>();
	}
	
	public int addCheck(int clientID, Date date) {
		Check chk = new Check (checks.size(), clientID, date);
		checks.add(chk);
		return checks.get(checks.size() - 1).getID();
	}
	
	public void addPositionInCheck(int checkID, int deviceID, int count) {
		checks.get(checkID).addPositionInCheck(deviceID, count);
	}
	
	public StringBuilder getChecks(ListDevices devices, ListClients clients, 
									String typesortChecks, String typesortPos) {
		this.sort(typesortChecks, typesortPos);
		return getChecks(devices, clients);
	}
	
	public StringBuilder getChecks(ListDevices devices, ListClients clients) {
		StringBuilder str = new StringBuilder();
		for (Check check : checks) {
			str.append("Check #" + check.getID() + "\n  PurchaserID: " + check.getClientID() + 
					", FullName: " + clients.getByID(check.getClientID()).getFullName() + 
				", Date: " + check.getDate() + "\n");
			str.append(check.getPositions(devices));
		}
		return str;
	}
	
	public int getSize() {
		return checks.size();
	}
	
	public void sort(String typesortChecks, String typesortPositions) {
		switch (typesortChecks) {
		case "clientIDOrder": 
			Collections.sort(checks, clientIDOrder); 
			break;
			
		case "dateOrder": 
			Collections.sort(checks, dateOrder); 
			break;
			
		default: 
			Collections.sort(checks, idOrder); 
			break;
		}
		for (Check ch : checks) {
			ch.sort(typesortPositions);
		}
	}
}
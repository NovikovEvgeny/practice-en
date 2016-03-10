import java.util.Collections;

public class View {
	
	private String typesort;
	private String typesortPos;
	private StringBuilder str;
	
	public void setTypesort(String object, String typesort) {
		if (object.compareTo("Client") == 0) {
			switch (typesort) {
			case "firstNameOrder": 
				this.typesort = "first name order"; 
				break;
				
			case "lastNameOrder": 
				this.typesort = "last name order"; 
				break;
				
			case "middleNameOrder": 
				this.typesort = "middle name order"; 
				break;
				
			case "fullNameOrder": 
				this.typesort = "full name order"; 
				break;
				
			case "birthYearOrder": 
				this.typesort = "birthyear order"; 
				break;
				
			default: 
				this.typesort = "ID order"; 
				break;
			}
			return;
		}
		if (object.compareTo("Device") == 0) {
			switch (typesort) {
			case "modelOrder": 
				this.typesort = "model order"; 
				break;
				
			case "typeOrder": 
				this.typesort = "type order"; 
				break;
				
			case "colorOrder": 
				this.typesort = "color order"; 
				break;
				
			case "dateOrder": 
				this.typesort = "date order"; 
				break;
				
			default: 
				this.typesort = "ID order"; 
				break;
			}
			return;
		}
	}
	
	public void setTypesort(String object, String tsCh, String tsPos) {
		if (object.compareTo("Check") == 0) {
			switch (tsCh) {
			case "clientIDOrder": 
				this.typesort = "clientID order"; 
				break;
				
			case "dateOrder": 
				this.typesort = "date order"; 
				break;
				
			default: 
				this.typesort = "ID order"; 
				break;
			}
			switch (tsPos) {
			case "countOrder": 
				this.typesortPos = "count order"; 
				break;
				
			default: 
				this.typesortPos = "deviceID order"; 
				break;
			}
			return;
		}
	}
	
	public void displayClients(ListClients clients, String typesort) {
		this.setTypesort("Client", typesort);
		str = clients.getClients(typesort);
		System.out.println("Total notes: " + clients.getSize() + ". Sort: " + this.typesort + ".");
		System.out.println(str);
	}
	
	public void displayClients(ListClients clients) {
		this.displayClients(clients, "none");
	}
	
	public void displayDevices(ListDevices devices, String typesort) {
		this.setTypesort("Device", typesort);
		str = devices.getDevices(typesort);
		System.out.println("Total notes: " + devices.getSize() + ". Sort: " + this.typesort + ".");
		System.out.println(str);
	}
	
	public void displayDevices(ListDevices devices) {
		this.displayDevices(devices, "none");
	}
	
	public void displayChecks(ListChecks checks, ListDevices devices, ListClients clients, 
			String typesortCh, String typesortPos) {
		this.setTypesort("Check", typesortCh, typesortPos);
		str = checks.getChecks(devices, clients, typesortCh, typesortPos);
		System.out.println("Total notes: " + checks.getSize() + ". Sort checks: " + this.typesort + 
							", sort positions in checks: " + this.typesortPos);
		System.out.println(str);
	}
	
	public void displayChecks(ListChecks checks, ListDevices devices, ListClients clients) {
		this.displayChecks(checks, devices, clients, "none", "none");
	}
	
	public void println(String s) {
		System.out.println(s);
	}
	
	public void print(String s) {
		System.out.print(s);
	}
	
	public void printHelp(String s) {
		switch (s) {
		case "main":
			System.out.println("For information enter help");
			break;
			
		default: 
			System.out.println("Enter command. For information about commands enter help");
			break;
		}
		
	}
}

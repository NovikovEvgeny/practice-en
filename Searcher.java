

public class Searcher {
	public ListClients searchClients(ListClients ls, String [] params, String [] values) {
		ListClients findedClients = ls;
		for (int i=0; i<params.length && i<values.length && params[i] != null; i++) {
			findedClients = searchClients(findedClients, params[i].toLowerCase(), values[i]);
		}		
		return findedClients;
	}
	
	public ListClients searchClients(ListClients ls, String param, String value) {
		ListClients findedClients = new ListClients();
		switch (param) {
		case "firstname":
			for (int i=0; i<ls.getSize(); i++) {
				if (value.equalsIgnoreCase(ls.get(i).getFN())) {
					findedClients.addClient(ls.get(i));
				}
			}
			break;
			
		case "lastname":
			for (int i=0; i<ls.getSize(); i++) {
				if (value.equalsIgnoreCase(ls.get(i).getLN())) {
					findedClients.addClient(ls.get(i));
				}
			}
			break;
			
		case "middlename":
			for (int i=0; i<ls.getSize(); i++) {
				if (value.equalsIgnoreCase(ls.get(i).getMN())) {
					findedClients.addClient(ls.get(i));
				}
			}
			break;
			
		case "year":
			for (int i=0; i<ls.getSize(); i++) {
				if (value.equalsIgnoreCase(String.valueOf(ls.get(i).getYear()))) {
					findedClients.addClient(ls.get(i));
				}
			}
			break;
			
		case "id":
			for (int i=0; i<ls.getSize(); i++) {
				if (value.equalsIgnoreCase(String.valueOf(ls.get(i).getID()))) {
					findedClients.addClient(ls.get(i));
				}
			}
			break;
		}	
		return findedClients;
		}
		
	public ListDevices searchDevices(ListDevices ls, String [] params, String [] values) {
		ListDevices findedDevices = ls;
		for (int i=0; i<params.length && i<values.length && params[i] != null; i++) {
			findedDevices = searchDevices(findedDevices, params[i].toLowerCase(), values[i]);
		}		
		return findedDevices;
	}
		
	public ListDevices searchDevices(ListDevices ls, String param, String value) {
		ListDevices findedDevices = new ListDevices();
		switch (param) {
		case "model":
			for (int i=0; i<ls.getSize(); i++) {
				if (value.equalsIgnoreCase(ls.get(i).getModel())) {
					findedDevices.addDevice(ls.get(i));
				}
			}
			break;
			
		case "type":
			for (int i=0; i<ls.getSize(); i++) {
				if (value.equalsIgnoreCase(ls.get(i).getType())) {
					findedDevices.addDevice(ls.get(i));
				}
			}
			break;
			
		case "color":
			for (int i=0; i<ls.getSize(); i++) {
				if (value.equalsIgnoreCase(ls.get(i).getColor())) {
					findedDevices.addDevice(ls.get(i));
				}
			}
			break;
			
		case "year":
			for (int i=0; i<ls.getSize(); i++) {
				if (value.equalsIgnoreCase(String.valueOf(ls.get(i).getDate().toString()))) {
					findedDevices.addDevice(ls.get(i));
				}
			}
			break;
			
		case "id":
			for (int i=0; i<ls.getSize(); i++) {
				if (value.equalsIgnoreCase(String.valueOf(ls.get(i).getID()))) {
					findedDevices.addDevice(ls.get(i));
				}
			}
			break;
			
			
		}
		return findedDevices;
	}
}

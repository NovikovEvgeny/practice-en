import java.util.ArrayList;
/** The class {@code Searcher} 
 * has a lot of methods for search necessary Clients/Devices/Checks 
 * in Lists
 *  
 *  @author Evgeny Novikov
 */
public class Searcher {
	public ListClients searchClients(ListClients ls, ArrayList<String> params, ArrayList<String> values) {
		ListClients findedClients = ls;
		for (int i=0; i<params.size(); i++) {
			findedClients = searchClients(findedClients, params.get(i).toLowerCase(), values.get(i));
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
		
	public ListDevices searchDevices(ListDevices ls, ArrayList<String> params, ArrayList<String> values) {
		ListDevices findedDevices = ls;
		for (int i=0; i<params.size(); i++) {
			findedDevices = searchDevices(findedDevices, params.get(i).toLowerCase(), values.get(i));
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
	
	public ListChecks searchChecks(ListChecks lc, ListClients ls, ListDevices ld, 
			ArrayList<String> params, ArrayList<String> values) {
		ListChecks findedChecks = lc;
		for (int i=0; i<params.size(); i++) {
			findedChecks = searchChecks(findedChecks, ls, ld, params.get(i).toLowerCase(), values.get(i));
		}		
		return findedChecks;
	}
		
	public ListChecks searchChecks(ListChecks lchk, ListClients lclients, ListDevices ld, 
			String param, String value) {
		ListChecks findedChecks = new ListChecks();
		switch (param) {
		case "clientid":
			for (int i=0; i<lchk.getSize(); i++) {
				if (value.equalsIgnoreCase(String.valueOf(lchk.get(i).getClientID()))) {
					findedChecks.addCheck(lchk.get(i));
				}
			}
			break;
			
		case "date":
			for (int i=0; i<lchk.getSize(); i++) {
				if (value.equalsIgnoreCase(lchk.get(i).getDate().toString())) {
					findedChecks.addCheck(lchk.get(i));
				}
			}
			break;
			
		case "firstname":
			for (int i=0; i<lclients.getSize(); i++) {
				if (value.equalsIgnoreCase(lclients.get(i).getFN())) {
					int id = lclients.get(i).getID();
					for (int j=0; j<lchk.getSize(); j++) {
						if (id == lchk.get(j).getClientID()) {
							findedChecks.addCheck(lchk.get(j));
						}
					}
				}
			}
			break;
			
		case "lastname":
			for (int i=0; i<lclients.getSize(); i++) {
				if (value.equalsIgnoreCase(lclients.get(i).getLN())) {
					int id = lclients.get(i).getID();
					for (int j=0; j<lchk.getSize(); j++) {
						if (id == lchk.get(j).getClientID()) {
							findedChecks.addCheck(lchk.get(j));
						}
					}
				}
			}
			break;
			
		case "middlename":
			for (int i=0; i<lclients.getSize(); i++) {
				if (value.equalsIgnoreCase(lclients.get(i).getMN())) {
					int id = lclients.get(i).getID();
					for (int j=0; j<lchk.getSize(); j++) {
						if (id == lchk.get(j).getClientID()) {
							findedChecks.addCheck(lchk.get(j));
						}
					}
				}
			}
			break;
			
		case "year":
			for (int i=0; i<lclients.getSize(); i++) {
				if (value.equalsIgnoreCase(String.valueOf(lclients.get(i).getYear()))) {
					int id = lclients.get(i).getID();
					for (int j=0; j<lchk.getSize(); j++) {
						if (id == lchk.get(j).getClientID()) {
							findedChecks.addCheck(lchk.get(j));
						}
					}
				}
			}
			break;
			
			
		}
		return findedChecks;
	}
}

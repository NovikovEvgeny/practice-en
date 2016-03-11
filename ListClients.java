import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListClients {
	
	static Comparator <Client> firstNameOrder = new Comparator <Client>() {
		public int compare (Client c1, Client c2) {
			return c1.getFN().compareToIgnoreCase(c2.getFN());
		}
	};
	
	static Comparator <Client> lastNameOrder = new Comparator <Client>() {
		public int compare (Client c1, Client c2) {
			return c1.getLN().compareToIgnoreCase(c2.getLN());
		}
	};
	
	static Comparator <Client> middleNameOrder = new Comparator <Client>() {
		public int compare (Client c1, Client c2) {
			return c1.getMN().compareToIgnoreCase(c2.getMN());
		}
	};
	
	static Comparator <Client> fullNameOrder = new Comparator <Client>() {
		public int compare (Client c1, Client c2) {
			return c1.getFullName().compareToIgnoreCase(c2.getFullName());
		}
	};
	
	static Comparator <Client> birthYearOrder = new Comparator <Client>() {
		public int compare (Client c1, Client c2) {
			int abs = c1.getYear() - c2.getYear();
			if (abs > 0) {
				return 1;
			} else if (abs < 0) {
                return -1;
			} else {
				return 0;
			}
		}
	};
	
	static Comparator <Client> idOrder = new Comparator <Client>() {
		public int compare (Client c1, Client c2) {
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
	
	private ArrayList<Client> clients;
	
	public ListClients() {
		clients = new ArrayList<Client>();
	}
	
	public void addClient(String FN, String LN, String MN, int year) {
		Client cl = new Client (clients.size(), FN, LN, MN, year);
		clients.add(cl);	
	}
	
	public void addClient(Client c) {
		Client c1 = new Client (clients.size(), c.getFN(), c.getLN(), c.getMN(), c.getYear());
		clients.add(c1);
	}

	public StringBuilder getClients(String typesort) {
		this.sort(typesort);
		return this.getClients();
	}
	
	public StringBuilder getClients() {
		StringBuilder str = new StringBuilder();
		for (Client client : clients) {
			str.append("ID: " + client.getID() + ", Name: " + client.getFullName() + 
					", Year of birth: " + client.getYear() + "\n");
		}
		return str;
	}
	
	public int getSize() {
		return clients.size();
	}
	
	public Client get(int i) {
		return clients.get(i);
	}
	
	public Client getByID(int id) {
		for (Client client : clients) {
			if (client.getID() == id) {
				return client;
			}
		}
		return null;
	}
	
	public boolean containsID(int id) {
		for (Client client : clients) {
			if (client.getID() == id) {
				return true;
			}
		}
		return false;
	}
	
	public void sort(String typesort) {
		switch (typesort) {
		case "firstNameOrder": 
			Collections.sort(clients, firstNameOrder); 
			break;
			
		case "lastNameOrder": 
			Collections.sort(clients, lastNameOrder); 
			break;
			
		case "middleNameOrder": 
			Collections.sort(clients, middleNameOrder); 
			break;
			
		case "fullNameOrder": 
			Collections.sort(clients, fullNameOrder); 
			break;
			
		case "birthYearOrder": 
			Collections.sort(clients, birthYearOrder); 
			break;
			
		default: 
			Collections.sort(clients, lastNameOrder); 
			break;
		}
	}
}

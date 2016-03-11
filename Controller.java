import java.util.Scanner;
import java.util.Date;

public class Controller {
	/* A class implementation */
	ListDevices devices = new ListDevices();
	ListClients clients = new ListClients();
	ListChecks checks = new ListChecks();
	View display = new View();
	Helper helper = new Helper();
	Searcher searcher = new Searcher();
	
	String [] params; // for search
	String [] values; // for search
	
	public void exec() {
		// TODO change scanner to BufferedReader
		Scanner sc = new Scanner (System.in);
		String command; //entered instruction 
		String[] commandSplit;
		
		clients.addClient("Evgeny", "Novikov", "Pavlovich", 1994);
		clients.addClient("Alena", "Yakovleva", "Andreevna", 1995);
		clients.addClient("Evgeny", "Yakovlev", "Pavlovich", 1993);
		clients.addClient("Alena", "Novikova", "Pavlovna", 1994);
		
		devices.addDevice("IPhone-5", "smartphone", "white", new Date());
		devices.addDevice("IPhone-6", "smartphone", "black", new Date());
		devices.addDevice("Lenovo", "notebook", "white", new Date());
		devices.addDevice("Asus", "notebook", "black", new Date());
		
		int idChk = checks.addCheck(0, new Date());
		checks.addPositionInCheck(idChk, 0, 5);
		checks.addPositionInCheck(idChk, 2, 3);
		
		idChk = checks.addCheck(1, new Date());
		checks.addPositionInCheck(idChk, 1, 5);
		checks.addPositionInCheck(idChk, 2, 7);
		
		idChk = checks.addCheck(2, new Date());
		checks.addPositionInCheck(idChk, 3, 2);
		checks.addPositionInCheck(idChk, 1, 1);
		
		idChk = checks.addCheck(3, new Date());
		checks.addPositionInCheck(idChk, 0, 3);
		checks.addPositionInCheck(idChk, 3, 10);
		
		display.println("WELCOME");
		display.printHelp("main");
		boolean notExit = true;
		do {
			command = sc.nextLine();
			commandSplit = command.split(" ");
			switch (checkNewCommand(commandSplit)) {
			/* Possible returns of checkNewCommand:
			 * 0 - exit
			 * -2 - wrong clientID in add check
			 * -1 - wrong command
			 * 1 - help
			 * 2 - add client
			 * 3 - add device
			 * 4 - add check
			 * 5 - search client
			 * 6 - search device
			 * 7 - search check
			 */
			case -1:
				display.println("Wrong command. Enter help for information");
				break;
				
			case -2:
				display.println("Nonexistent clientID");
				break;
				
			case 0:
				notExit = false;
				break;
				
			case 1:
				display.println(helper.getHelp(command));
				break;
				
			case 2:
				display.println("added client");
				//TODO change 1994 to normal date
				clients.addClient(commandSplit[2], commandSplit[3], commandSplit[4], 1994);
				display.displayClients(clients);
				break;
				
			case 3:
				display.println("added device");
				Date dt = new Date();
				//TODO normal date
				dt.setYear(1994);
				devices.addDevice(commandSplit[2], commandSplit[3], commandSplit[4], dt);
				display.displayDevices(devices);
				break;
				
			case 4:
				display.println("added check");
				Date dt2 = new Date(5);
				String[] devcount;
				//TODO normal date
				
				int tmpChk = checks.addCheck(Integer.parseInt(commandSplit[2]), dt2);
				for (int i=0; i<Integer.parseInt(commandSplit[4]); i++) {	
					display.println("Enter deviceID and count of devices");
					devcount = sc.nextLine().split(" ");
					while ( (!devices.containsID(Integer.parseInt(devcount[0]))) || 
							(Integer.parseInt(devcount[1]) < 1) ) {
						display.println("Enter correct clientID or count of devices");
						devcount = sc.nextLine().split(" ");
					}
					
					checks.addPositionInCheck(tmpChk, Integer.parseInt(devcount[0]), Integer.parseInt(devcount[1]));
				}
				display.displayChecks(checks, devices, clients);
				break;
				
			case 5:
				display.println("search client");
				int j=0;
				if (commandSplit[commandSplit.length-2].equalsIgnoreCase("sort"))
				{
					params = new String[commandSplit.length/2-2];
					values = new String[commandSplit.length/2-2];
					for (int i=2; i<commandSplit.length-2; i+=2) {
						params[j] = commandSplit[i];
						values[j] = commandSplit[i+1];
						j++;
					}
				} else {
					params = new String[commandSplit.length/2-1];
					values = new String[commandSplit.length/2-1];
					for (int i=2; i<commandSplit.length; i+=2) {
						params[j] = commandSplit[i];
						values[j] = commandSplit[i+1];
						j++;
					}
				}
					
				display.displayClients(searcher.searchClients(clients, params, values), 
						commandSplit[commandSplit.length-1]);
				break;
				
			case 6:
				display.println("search device");
				int k = 0;
				if (commandSplit[commandSplit.length-2].equalsIgnoreCase("sort"))
				{
					params = new String[commandSplit.length/2-2];
					values = new String[commandSplit.length/2-2];
					for (int i=2; i<commandSplit.length-2; i+=2) {
						params[k] = commandSplit[i];
						values[k] = commandSplit[i+1];
						k++;
					}
				} else {
					params = new String[commandSplit.length/2-1];
					values = new String[commandSplit.length/2-1];
					for (int i=2; i<commandSplit.length; i+=2) {
						params[k] = commandSplit[i];
						values[k] = commandSplit[i+1];
						k++;
					}
				}
				
				display.displayDevices(searcher.searchDevices(devices, params, values), 
						commandSplit[commandSplit.length-1]);
				break;
				
				
			case 7:
				display.println("search check");
				int p = 0;
				if (commandSplit[commandSplit.length-2].equalsIgnoreCase("sort"))
				{
					params = new String[commandSplit.length/2-2];
					values = new String[commandSplit.length/2-2];
					for (int i=2; i<commandSplit.length-2; i+=2) {
						params[p] = commandSplit[i];
						values[p] = commandSplit[i+1];
						p++;
					}
				} else {
					params = new String[commandSplit.length/2-1];
					values = new String[commandSplit.length/2-1];
					for (int i=2; i<commandSplit.length; i+=2) {
						params[p] = commandSplit[i];
						values[p] = commandSplit[i+1];
						p++;
					}
				}
				
				display.displayChecks(searcher.searchChecks(checks, clients, devices, params, values),
						devices, clients,
						"clientIDOrder","countOrder" );
				break;
				
			default:
				display.println("Wrong command. Enter help for information");
				
			}
		} while (notExit);
			
			
		/* Examples of commands:
		 * add client Evgeniy Novikov Pavlovich 1994
		 * add device model type color date(int?)
		 * add check clientID(int) date(==can be"today"?) positions(int)
		 * after add check
		 * diveceID(int) count(int)
		 *
		 * search client firstname Evgeny lastname Novikov middlename Pavlovich year 1994 id 0 sort firstname
		 * search device model asdf type asdf color adsf date 1995 id 0 sort type
		 * search check clientid 0 firstname Evgeny lastname Novikov middlename pavlovich year 1994 date 1994 
		 * sort clientid date sortpos deviceid count
		 */
	}
	
	public int checkNewCommand(String[] s) {
		/*
		 * checks new command and return code of command
		 * -2 - worng clientID in addcheck
		 * -1 - wrong command
		 * 0 - exit
		 * 1 - help
		 * 2 - add client
		 * 3 - add device
		 * 4 - add check
		 * 5 - search client
		 * 6 - search device
		 * 7 - search check
		 */
		switch (s[0].toLowerCase()) {
		case "help":
			return 1;
			
		case "add":
			if (s.length < 3) {
				return -1;
			}
			switch (s[1].toLowerCase()) {
			case "client":
				if (s.length < 6) {
					return -1;
				}
				return 2;
				
			case "device":
				if (s.length < 6) {
					return -1;
				}
				return 3;
				
			case "check":
				if (s.length < 5) {
					return -1;
				}
				if (!clients.containsID(Integer.parseInt(s[2]))) {
					return -2;
				}
				return 4;
				
			default:
				return -1;
			}// end case "add"
			
		case "search":
			if (s.length < 4 || s.length%2 == 1) {
				return -1;
			}
			switch (s[1].toLowerCase()) {
			/*search client firstname Evgeny lastname Novikov middlename Pavlovich year 1994 id 0 sort firstname
			*search device model asdf type asdf color adsf date 1995 id 0 sort type
			*search check clientid 0 firstname Evgeny lastname Novikov middlename pavlovich year 1994 date 1994 
			*sort clientid date sortpos deviceid count
			*/
			case "client":		
				return 5;
				
			case "device":
				return 6;
				
			case "check":
				return 7;
				
			default: 
				return -1;
			}//end case "search"
			
		case "exit":
			return 0;
			
		default:
			return -1;
		}
		
	}
	
}

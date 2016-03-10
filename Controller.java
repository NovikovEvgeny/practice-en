import java.util.Scanner;
import java.util.Date;

public class Controller {
	/* A class implementation */
	public static void main(String[] args) {
		ListDevices devices = new ListDevices();
		ListClients clients = new ListClients();
		ListChecks checks = new ListChecks();
		View display = new View();
		Helper helper = new Helper();
		// TODO change scanner to BufferedReader
		Scanner sc = new Scanner (System.in);
		String command; //entered instruction 
		String[] commandSplit;
		
		display.println("WELCOME");
		display.printHelp("main");
		boolean notExit = true;
		do {
			command = sc.nextLine();
			commandSplit = command.split(" ");
			switch (checkNewCommand(clients, devices, checks, commandSplit)) {
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
				break;
				
			case 6:
				display.println("search device");
				break;
				
			case 7:
				display.println("search check");
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
	
	public static int checkNewCommand(ListClients cl, ListDevices dv, ListChecks ch, String[] s) {
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
				if (!cl.containsID(Integer.parseInt(s[2]))) {
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
			}//end case "search"
			
		case "exit":
			return 0;
			
		default:
			return -1;
		}
		
	}
	
}

/** The class {@code Helper} for form documentations for users
 *  
 *  @author Evgeny Novikov
 */
public class Helper {
	public String getHelp(String s) {
		switch (s.toLowerCase()) {
		//case "help":
		//	return "For more informatoin for add client/device/sale, enter help add\n"+
		//		"For more information for search clients/devices/sales, enter help search";
			
		case "help add":
			return "To add new client enter add client FirstName SecondName MiddleName BirthYear\n"+
				"To add new device enter add device Model Type Color Year\n"+
				"To add new check enter add check clientID Date CountOfPositions";
			
		case "help search":
			return "help search info";
			
		default:
			return "For more informatoin for add client/device/sale, enter help add\n"+
				"For more information for search clients/devices/sales, enter help search";
		}
		
	}
}

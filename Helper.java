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
			return "To add new client enter \"add client FirstName SecondName MiddleName BirthYear\"\n"+
				"To add new device enter \"add device Model Type Color Year\"\n"+
				"To add new check enter \"add check clientID Date CountOfPositions\"";
			
		case "help search":
			return "To search clients enter \"search client \" and then pairs parameter - value, \n"+
				"possible parameters: firstname lastname middlename birthyear, \n"+
				"for example: \"search client firstname Ivan secondname Ivanov\n"+
				"parameters for \"search device\": model type color year\n"+
				"for expample: \"search device model IPhone type smartphone color white year 2015\n"+
				"parameters for check: clientid date\n"+
				"for sort results add parameter \"sort\" in end of command\n"+
				"for example: search client firstname ivan lastname ivanov sort birthyear\n"+
				"for checks exists additional parameter sortpos - sort in posotions in check\n"+
				"for example: search check clientid 0 sort date sortpos count\n"+
				"ATTENTION! parameter \"sort\" MUST BE in the end of command, parameter "+
				"\"sortpos\" must be after parameter \"sort\"";
			
		default:
			return "For more informatoin for add client/device/sale, enter help add\n"+
				"For more information for search clients/devices/sales, enter help search";
		}
		
	}
}

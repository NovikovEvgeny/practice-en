/** The class {@code Client} for describe clients
 *  
 *  @author Evgeny Novikov
 */
public class Client {
	
	private int id; //clientID
	private int birthyear; //clients year of birth
	private String fn; // FirstName
	private String ln; //LastName
	private String mn; //MiddleName
	
	public Client(int id) {
		this.id = id;
		this.fn = this.ln = this.mn = " ";
		this.birthyear = 0;
	}
	
	public Client(int id, String firstName, String lastName, String middleName, int year) {
		this.id = id;
		this.setFIO(firstName, lastName, middleName);
		this.birthyear = year;
	}
	
	public Client(int id, String fullName, int year) {
		this.id = id;
		this.setFIO(fullName);
		this.birthyear = year;
	}
	
	public void setFIO(String firstName, String lastName, String middleName) {
		this.fn = firstName;
		this.ln = lastName;
		this.mn = middleName;
	}
	
	public void setFIO(String fullName) {
		String [] names = fullName.split(" ");
		this.setFIO(names[0], names[1], names[2]);
	}
	
	public int getID() {
		return this.id;
	}
	
	public int getYear() {
		return this.birthyear;
	}
	
	public String getFullName() {
		return fn + " " + ln + " " + mn;
	}
	
	public String getFN() {
		return fn;
	}
	
	public String getLN() {
		return ln;
	}
	
	public String getMN() {
		return mn;
	}
};
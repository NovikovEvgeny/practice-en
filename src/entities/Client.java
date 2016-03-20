package entities;

/** The class {@code Client} for describe client
 *
 *  @author Evgeny Novikov
 */
public class Client {
    private int id;
    private int birthyear;
    private String firstName;
    private String lastName;
    private String middleName;

    public Client(int id, String firstName, String lastName, String middleName, int year) {
        this.id = id;
        setName(firstName, lastName, middleName);
        birthyear = year;
    }

    public void setName(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    @Override
    public Client clone() {
        return (new Client(id, firstName, lastName, middleName, birthyear));
    }

    @Override
    public String toString () {
        return ("ClientID: "+id+", Name: "+getFullName()+", Year of birth: "+birthyear);
    }


    public int getID() {
        return this.id;
    }

    public int getYear() {
        return this.birthyear;
    }

    public String getFullName() {
        return firstName + " " + lastName + " " + middleName;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public String getmiddleName() {
        return middleName;
    }

    /*
    public Client(int id, String fullName, int year) {
        this.id = id;
        setName(fullName);
        birthyear = year;
    }
    public void setName(String fullName) {
        //TODO add exception if names.length < 3
        String [] names = fullName.split(" ");
        this.setName(names[0], names[1], names[2]);
    }
    */
}

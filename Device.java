import java.util.Date;
/** The class {@code Device} for describe devices
 *  
 *  @author Evgeny Novikov
 */
public class Device {
	
	private int id;
	private String model;
	private String type;
	private String color;
	private Date date;
	
	public Device(int id) {
		this.id = id;
		model = type = color = " ";
		date.setTime(0);
	}
	
	public Device(int id, String model, String type, String color, Date date) {
		this.id = id;
		setModel(model);
		setType(type);
		setColor(color);
		setDate(date);
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public Date getDate() {
		return date;
	}
}

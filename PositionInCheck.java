/** The class {@code PositionInCheck} 
 * for describe one of multiplicity notes in {@code Check}
 *  
 *  @author Evgeny Novikov
 */
public class PositionInCheck {
	
	private int deviceID;
	private int count;
	
	public PositionInCheck(int deviceID, int count) {
		this.deviceID = deviceID;
		this.count = count;
	}
	
	public int getDeviceID() {
		return deviceID;
	}
	
	public int getCount() {
		return count;
	}
}

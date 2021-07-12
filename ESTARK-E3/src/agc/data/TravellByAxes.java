package agc.data;

public class TravellByAxes {
	private Distance x_Axis;
	private Distance y_Axis;
	private Distance z_Axis;
	
	public Distance getX_Axis() {
		return x_Axis;
	}
	public Distance getY_Axis() {
		return y_Axis;
	}
	public Distance getZ_Axis() {
		return z_Axis;
	}

	public TravellByAxes ()
	{
		this.x_Axis = new Distance();
		this.y_Axis = new Distance();
		this.z_Axis = new Distance();
	}
	
	public TravellByAxes (double xValue, double yValue, double zValue){
		
		this.x_Axis=new Distance(xValue);
		this.y_Axis=new Distance(yValue);
		this.z_Axis=new Distance(zValue);
		
	}
	
	@Override
	public String toString() {
		return "{\n"
				+ "\t\"X_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Distance\": "+ x_Axis.getDistance() + "\n"
				+ "\t},\n"
				+ "\t\"Y_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Distance\": "+ y_Axis.getDistance() + "\n"
				+ "\t},\n"
				+ "\t\"Z_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Distance\": "+ z_Axis.getDistance() + "\n"
				+ "\t}\n"
				+ "}";
	}
	
}

package agc.data;

public class SpeedDeviationByAxes {
	private Speed x_speed;
	private Speed y_speed;
	private Speed z_speed;
	
	private Deviation x_dev;
	private Deviation y_dev;
	private Deviation z_dev;
	
	//Get methods
	public Speed getX_speed() {
		return x_speed;
	}
	public Speed getY_speed() {
		return y_speed;
	}
	public Speed getZ_speed() {
		return z_speed;
	}
	
	public Deviation getX_dev() {
		return x_dev;
	}
	public Deviation getY_dev() {
		return y_dev;
	}
	public Deviation getZ_dev() {
		return z_dev;
	}
	
	//Constructors
	public SpeedDeviationByAxes(){
		this.x_dev = new Deviation();
		this.y_dev = new Deviation();
		this.z_dev = new Deviation();
		this.x_speed = new Speed();
		this.y_speed = new Speed();
		this.z_speed = new Speed();
	}
	
	public SpeedDeviationByAxes (double xspe, double yspe, double zspe, double xdev, double ydev, double zdev){
		
		this.x_dev=new Deviation (xdev);
		this.y_dev=new Deviation (ydev);
		this.z_dev=new Deviation (zdev);
		
		this.x_speed=new Speed (xspe);
		this.y_speed=new Speed (yspe);
		this.z_speed=new Speed (zspe);
		
	}
	
	@Override
	// Effort spent: 9 minutes
	public String toString() {
		return "{\n"
				+ "\t\"X_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Average Speed\": "+ x_speed.getSpeed() + ",\n"
				+ "\t\t\"Standard Deviation\": "+ x_dev.getDeviation() + "\n"
				+ "\t},\n"
				+ "\t\"Y_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Average Speed\": "+ y_speed.getSpeed() + ",\n"
				+ "\t\t\"Standard Deviation\": "+ y_dev.getDeviation() + "\n"
				+ "\t},\n"
				+ "\t\"Z_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Average Speed\": "+ z_speed.getSpeed() + ",\n"
				+ "\t\t\"Standard Deviation\": "+ z_dev.getDeviation() + "\n"
				+ "\t}\n"
				+ "}";
	}
	
}

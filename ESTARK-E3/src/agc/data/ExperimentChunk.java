package agc.data;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.json.JsonObject;

public class ExperimentChunk {

	private Date time;
	private double lat;
	private double lon;
	private double accel_x;
	private double accel_y;
	private double accel_z;

	public ExperimentChunk(Date time, double accel_x, double accel_y, double accel_z, double lat, double lon) {
		this.time = time;
		this.lat = lat;
		this.lon = lon;
		this.accel_x = accel_x;
		this.accel_y = accel_y;
		this.accel_z = accel_z;
	}
	
	public Date getTime() {
		return time;
	}

	public double getLongitude() {
		return lon;
	}

	public double getLatitude() {
		return lat;
	}

	public double getAccel_x() {
		return accel_x;
	}

	public double getAccel_y() {
		return accel_y;
	}

	public double getAccel_z() {
		return accel_z;
	}


	@Override
	public String toString() {
		String result = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
		result += "Time: " + formatter.format(time) + "\n";
		result += "ACCEL_X: " + accel_x + "\n";
		result += "ACCEL_Y: " + accel_y + "\n";
		result += "ACCEL_Z: " + accel_z + "\n";
		result += "LATITUDE: " + lat + "\n"; 
		result += "LONGITUDE: " + lon;
		return result;
	}

}

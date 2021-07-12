package agc.data;

public class MinMaxAcceleration {
	double minAcceleration;
	double maxAcceleration;
		
	public double getMinAcceleration() {
		return minAcceleration;
	}
	
	public double getMaxAcceleration() {
		return maxAcceleration;
	}

	public MinMaxAcceleration ()
	{
		this.minAcceleration = 0.0d;
		this.maxAcceleration = 0.0d;
	}
	
	public MinMaxAcceleration (double minValue, double maxValue)
	{
		this.minAcceleration = minValue;
		this.maxAcceleration = maxValue;
	}
	
}

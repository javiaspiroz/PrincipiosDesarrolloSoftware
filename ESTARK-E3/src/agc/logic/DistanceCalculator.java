package agc.logic;

import agc.data.Experiment;
import agc.data.ExperimentChunk;
import agc.exceptions.AGCException;
import agc.data.TravellByAxes;

public class DistanceCalculator implements Calculator {

	@SuppressWarnings("deprecation")
	@Override
	public Object Calculate(Object obj) throws AGCException {
		
		Experiment myExperiment= (Experiment) obj;
		// We do not consider the initial sample, as it is the initial position from the gyroscope
		ExperimentChunk prevChunk = myExperiment.getItem(myExperiment.getSubExperimentInitialItem());
		//Set initial variables to return
		double accx, accy, accz, lat, lon, disx=0.0d, disy=0.0d, disz=0.0d;
		accx= prevChunk.getAccel_x();
		accy= prevChunk.getAccel_y();
		accz= prevChunk.getAccel_z();
		lat=prevChunk.getLatitude();
		lon=prevChunk.getLongitude();
		double time=prevChunk.getTime().getSeconds(), timeaux, v0x=accx*time, v0y=accy*time, v0z=accz*time;
		
		// Skip to next element to process the remaining values
		for (int i=myExperiment.getSubExperimentInitialItem(); i<myExperiment.getSubExperimentFinalItem()+1; i++){
			ExperimentChunk currentChunk = myExperiment.getItem(i);
			//We calculate the distance for the different axes: latitude=x and longitude=y
			timeaux=(currentChunk.getTime().getSeconds()-time);
			v0x+=accx*timeaux;
			v0y+=accy*timeaux;
			v0z+=accz*timeaux;
			disx=v0x*(timeaux)+0.5*accx*Math.pow((timeaux), 2);
			disy=v0y*(timeaux)+0.5*accy*Math.pow((timeaux), 2);
			disz=v0z*(timeaux)+0.5*accz*Math.pow((timeaux), 2);
		}
		disx=lat+disx;
		disy=lon+disy;
		disz=Math.sqrt(Math.pow(disx,2)+Math.pow(disy,2));
		TravellByAxes result = new TravellByAxes(disx, disy, disz);
		return result;
	}

}

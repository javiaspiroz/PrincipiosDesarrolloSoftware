package agc.logic;

import agc.data.Experiment;
import agc.data.ExperimentChunk;
import agc.data.SpeedDeviationByAxes;
import agc.exceptions.AGCException;

public class SpeedDeviationCalculator implements Calculator{

	@SuppressWarnings("deprecation")
	@Override
	public Object Calculate(Object obj) throws AGCException {
		
		Experiment myExperiment= (Experiment) obj;
		// We do not consider the initial sample, as it is the initial position from the gyroscope
		ExperimentChunk prevChunk = myExperiment.getItem(myExperiment.getSubExperimentInitialItem());
		//Set initial variables to return
		double accx, accy, accz, ite=0,vx=0,vy=0,vz=0,dx=0,dy=0,dz=0,vx2=0,vy2=0,vz2=0,auxx=0,auxy=0,auxz=0;
		accx= prevChunk.getAccel_x();
		accy= prevChunk.getAccel_y();
		accz= prevChunk.getAccel_z();
		double time=prevChunk.getTime().getSeconds(), timeaux=0, v0x=accx*time, v0y=accy*time, v0z=accz*time;
			
		// Skip to next element to process the remaining values
		for (int i=myExperiment.getSubExperimentInitialItem(); i<myExperiment.getSubExperimentFinalItem()+1; i++){
			ExperimentChunk currentChunk = myExperiment.getItem(i);
			timeaux=(currentChunk.getTime().getSeconds()-time);
			vx=v0x+accx*timeaux;
			vy=v0y+accy*timeaux;
			vz=v0z+accz*timeaux;
			ite++;
		}
		//Calculate speed for each axes
		double finaltime=timeaux-time;
		vx=vx/finaltime;
		vz=vz/finaltime;
		vy=vy/finaltime;
		//Calculate deviation for each axes
		for(int i=0; i<ite; i++){
			vx2=v0x+accx*timeaux;
			vy2=v0y+accy*timeaux;
			vz2=v0z+accz*timeaux;
			auxx+=Math.pow((vx2-vx), 2);
			auxy+=Math.pow((vy2-vx), 2);
			auxz+=Math.pow((vz2-vx), 2);
		}
		
		dx=Math.sqrt((1/ite)*(auxx));
		dy=Math.sqrt((1/ite)*(auxy));
		dz=Math.sqrt((1/ite)*(auxz));
		SpeedDeviationByAxes result = new SpeedDeviationByAxes(vx,vy,vz,dx,dy,dz);
		return result;
	}

}

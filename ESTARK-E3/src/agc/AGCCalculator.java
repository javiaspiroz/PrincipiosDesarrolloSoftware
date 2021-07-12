package agc;

import agc.data.AccelerationByAxes;
import agc.data.FullTurnByAxes;
import agc.data.SpeedDeviationByAxes;
import agc.data.TravellByAxes;
import agc.exceptions.AGCException;
import agc.data.Experiment;
import agc.logic.Calculator;
import agc.logic.DistanceCalculator;
import agc.logic.FullTurnCalculator;
import agc.logic.MinMaxAccelerationCalculator;
import agc.logic.SpeedDeviationCalculator;
import agc.io.ExperimentDataFileManager;

public class AGCCalculator implements AgcCalculatorInterface {

	@Override
	public AccelerationByAxes CalculateMinMaxAcceleration(String InputFile, int InitialInstant, int FinalInstant)
			throws AGCException {
		ExperimentDataFileManager myDataManager = new ExperimentDataFileManager();
		Experiment myExperiment = myDataManager.Parse(InputFile);		
		myExperiment.identifySubExperiment(InitialInstant, FinalInstant);
		
		Calculator myCalculator = new MinMaxAccelerationCalculator ();
		AccelerationByAxes result = (AccelerationByAxes) myCalculator.Calculate(myExperiment);
		return result;
	}

	@Override
	public FullTurnByAxes CalculateFullTurn(String InputFile, int InitialInstant, int FinalInstant)
			throws AGCException {
		ExperimentDataFileManager myDataManager = new ExperimentDataFileManager();
		Experiment myExperiment = myDataManager.Parse(InputFile);		
		myExperiment.identifySubExperiment(InitialInstant, FinalInstant);
		
		Calculator myCalculator = new FullTurnCalculator ();
		FullTurnByAxes result = (FullTurnByAxes) myCalculator.Calculate(myExperiment);
		return result;
	}
	
	@Override
	public TravellByAxes CalculateTravelledDistance(String InputFile, int InitialInstant, int FinalInstant)
			throws AGCException {
		ExperimentDataFileManager myDataManager = new ExperimentDataFileManager();
		Experiment myExperiment = myDataManager.Parse(InputFile);		
		myExperiment.identifySubExperiment(InitialInstant, FinalInstant);
		
		Calculator myCalculator = /*check if cast is necessary*/ (Calculator) new DistanceCalculator ();
		TravellByAxes result = (TravellByAxes) myCalculator.Calculate(myExperiment);
		return result;
	}
	
	@Override
	public SpeedDeviationByAxes CalculateSpeedDeviationByAxis(String InputFile, int InitialInstant, int FinalInstant)
			throws AGCException {
		ExperimentDataFileManager myDataManager = new ExperimentDataFileManager();
		Experiment myExperiment = myDataManager.Parse(InputFile);		
		myExperiment.identifySubExperiment(InitialInstant, FinalInstant);
		
		Calculator myCalculator = /*check if cast is necessary*/ (Calculator) new SpeedDeviationCalculator ();
		SpeedDeviationByAxes result = (SpeedDeviationByAxes) myCalculator.Calculate(myExperiment);
		return result;
	}

}

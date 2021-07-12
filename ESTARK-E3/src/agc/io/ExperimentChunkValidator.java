package agc.io;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.json.JsonObject;

import agc.data.ExperimentChunk;
import agc.exceptions.AGCException;

public class ExperimentChunkValidator {
	public ExperimentChunk Validate (JsonObject element) throws AGCException {

		double lon, lat, accelx, accely, accelz;
		Date parsedDate;
		// Check if keys for the given chunk are valid
		if (hasValidKeys(element)) {
			parsedDate = validateTime(element);
			lon = validateLongitude(element, "LONGITUDE");
			lat = validateLatitude(element, "LATITUDE");
			accelx = validateAccelValue(element, "ACCEL_X");
			accely = validateAccelValue(element, "ACCEL_Y");
			accelz = validateAccelValue(element, "ACCEL_Z");
		} else {
			throw new AGCException("Error: Invalid key value in input JSON.");
		}
		ExperimentChunk experimentChunk = new ExperimentChunk(parsedDate, accelx, accely,
				accelz, lat, lon);
		return experimentChunk;
	}

	// This method checks a JSON Object checking if all the keys that contains are valid
	private static boolean hasValidKeys(JsonObject element) {
		boolean result = true;
		for (String key : element.keySet()) {
			if (key.equals("Time") || key.equals("LONGITUDE") || key.equals("LATITUDE") 
					|| key.equals("ACCEL_X") || key.equals("ACCEL_Y") || key.equals("ACCEL_Z")) {
				// result = true;
			} else {
				result = false;
			}
		}
		return result;
	}
	
	private Date validateTime(JsonObject element) throws AGCException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
		Date parsedDate;
		try {
			if (element.getString("Time").length() > 23) {
				throw new AGCException("Error: invalid input for Time in JSON.");	
			}
			parsedDate = formatter.parse(element.getString("Time"));
		} catch (Exception e) {
			throw new AGCException("Error: invalid input for Time in JSON.");
		}
		return parsedDate;
	}

	private double validateLongitude(JsonObject element, String label) throws AGCException {
		double lon = 0.0d;
		try {
			lon = processNumberForLabel(label, element);
			if ((lon <= -180.0d) || (lon >= 180.0d)) {
				throw new AGCException("Error: longitude value for" + label + " cannot be less than -180 or greater than 180.");
			}
		} catch (AGCException e) {
			throw e;
		}
		return lon;
	}
	
	private double validateLatitude(JsonObject element, String label) throws AGCException {
		double lat = 0.0d;
		try {
			lat = processNumberForLabel(label, element);
			if ((lat <= -90.0d) || (lat >= 90.0d)) {
				throw new AGCException("Error: latitude value for" + label + " cannot be less than -90 or greater than 90.");
			}
		} catch (AGCException e) {
			throw e;
		}
		return lat;
	}
	
	private double validateAccelValue(JsonObject element, String label) throws AGCException {
		double accelx = 0.0d;
		try {
			accelx = processNumberForLabel(label, element);
		} catch (AGCException e) {
			throw e;
		}
		return accelx;
	}
	
	// This method does all the error processing for a number based on the corresponding label
	private  double processNumberForLabel(String label, JsonObject element) throws AGCException {
		double value;
		try {
			if (hasAtLeastSevenDecimals(element.getJsonNumber(label).toString())) {
				value = element.getJsonNumber(label).doubleValue();
			} else {
				throw new AGCException("Error: less than 7 decimals for " + label + " in JSON input data.");
			}
		} catch (Exception e) {
			if (e.getClass() == AGCException.class) {
				throw e;
			} else {
				throw new AGCException("Error: " + label + " in JSON input data is not a number.");	
			}
		}
		return value;
	}
	
	// This method checks if a number has at least 7 decimals
	private boolean hasAtLeastSevenDecimals(String input) throws AGCException {
		int pos = input.lastIndexOf('.');

		// If not dots found, error, no separator
		if (pos < 0) {
			throw new AGCException("Error: Invalid separator for decimal number.");
		}
		
		// pos = Seven decimals plus plus one for total length (index) -> less than eight instead of less than seven
		if ((input.length() - pos) < 8) {
			return false;
		}
		return true;
	}
}

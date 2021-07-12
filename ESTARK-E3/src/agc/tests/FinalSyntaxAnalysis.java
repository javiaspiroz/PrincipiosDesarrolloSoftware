package agc.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import agc.AGCCalculator;
//We include them because it's part of what we want to test, but as input is the same for all we'll check just one.
import agc.data.SpeedDeviationByAxes;
import agc.data.TravellByAxes;
import agc.exceptions.AGCException;

/**
 * 
 * @author Javier Aspiroz de la Calle & César Tranche Herrero
 * @since May 2018
 * @version 1.0
 *
 */

@SuppressWarnings("unused")
public class FinalSyntaxAnalysis {

	/* Test case: CP-RF01-02
	* Derivation Tree Node: All
	* Type of case: Regular Value
	* Testing technique: Syntax Analysis
	* Expected value: Valid, all inputs are valid and outputs are too.
	*/

	@Test
	public void testCPRF01_02() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			TravellByAxes aba=agcc.CalculateTravelledDistance("CP-RF01-02.json", 0, 40);
			assertEquals(0, aba.getX_Axis().getDistance(), 1.0d);
			assertEquals(0, aba.getY_Axis().getDistance(), 1.0d);
			assertEquals(0, aba.getZ_Axis().getDistance(), 1.0d);
			
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("", message);//Nothing displayed as input file is valid
	}
	
	/* Test case: CP-RF01-03
	* Derivation Tree Node: Nodes 2, 6, 11, 3, 7, 12, 
	* 				4, 8, 13, 14, … (all non-terminal nodes)
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the omission of one of the non-terminal nodes
	*/

	@Test
	public void testCPRF01_03() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateTravelledDistance("CP-RF01-03.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-04
	* Derivation Tree Node: Nodes 2, 6, 11, 3, 7, 12, 
	* 				4, 8, 13, 14, … (all non-terminal nodes)
	* Type of case: Addition
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the addition of one of the non-terminal nodes
	*/

	@Test
	public void testCPRF01_04() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateTravelledDistance("CP-RF01-04.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-05
	* Derivation Tree Node: Nodes 5, 9, 16, 23
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the modification of {} symbols
	*/

	@Test
	public void testCPRF01_05() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateTravelledDistance("CP-RF01-05.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-06
	* Derivation Tree Node: Nodes 10, 15
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the modification of [] symbols
	*/

	@Test
	public void testCPRF01_06() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateTravelledDistance("CP-RF01-06.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-07
	* Derivation Tree Node: Nodes 24, 62, 66, 70, 74, 78, 82
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the modification of , symbols
	*/

	@Test
	public void testCPRF01_07() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateTravelledDistance("CP-RF01-07.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-08
	* Derivation Tree Node: Nodes 51, 64, 68, 72, 76, 80, 89, 91
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the modification of : symbols
	*/

	@Test
	public void testCPRF01_08() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateTravelledDistance("CP-RF01-08.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-09
	* Derivation Tree Node: Nodes 84, 86
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the modification of - symbols
	*/

	@Test
	public void testCPRF01_09() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateTravelledDistance("CP-RF01-09.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-10
	* Derivation Tree Node: Nodes 50, 63, 67, 71, 75, 79
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the modification of label's names
	*/

	@Test
	public void testCPRF01_10() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateTravelledDistance("CP-RF01-10.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-11
	* Derivation Tree Node: Nodes 117, 120, 126, 129, 142
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the modification of . symbols as decimal separator
	*/

	@Test
	public void testCPRF01_11() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateTravelledDistance("CP-RF01-11.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-12
	* Derivation Tree Node: Nodes 131,132,133, 134, 135, 136, 137, 138, 139, 140, 144, 
	* 		145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 164, 165, 166, 167
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the modification of numeric values for invalid ones
	*/

	@Test
	public void testCPRF01_12() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateTravelledDistance("CP-RF01-12.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Values in the input file are wrong as far as semantic is concerned", message);
	}
	
	/* Test case: CP-RF01-13
	* Derivation Tree Node: Nodes 156, 157, 158, 159
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the modification of invalid numeric values in the LATITUDE field
	*/

	@Test
	public void testCPRF01_13() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateTravelledDistance("CP-RF01-13.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Values in the input file are wrong as far as semantic is concerned", message);
	}
	
	/* Test case: CP-RF01-14
	* Derivation Tree Node: Nodes 160, 161, 162, 163
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the modification of invalid numeric values in the LONGITUDE field
	*/

	@Test
	public void testCPRF01_14() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateTravelledDistance("CP-RF01-14.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Values in the input file are wrong as far as semantic is concerned", message);
	}	
	
	
	/* Test case: CP-RF01-15
	* Derivation Tree Node: Node 3
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the omission of the labels in the input file
	*/

	@Test
	public void testCPRF01_15() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateTravelledDistance("CP-RF01-15.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-16
	* Derivation Tree Node: 1
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: Incorrect file path
	*/

	@Test
	public void testCPRF01_16() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateTravelledDistance("", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input data file not found", message);
	}
	
	/* Test case: CP-RF01-17
	* Derivation Tree Node: None
	* Type of case: None
	* Testing technique: Syntax Analysis
	* Expected value: Incorrect starting time
	*/

	@Test
	public void testCPRF01_17() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateTravelledDistance("CP-RF01-02.json", -1, 40);//Valid .json file is used for checking it
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Starting time is incorrect", message);
	}
	
	/* Test case: CP-RF01-18
	* Derivation Tree Node: None
	* Type of case: None
	* Testing technique: Syntax Analysis
	* Expected value: Incorrect interval time
	*/

	@Test
	public void testCPRF01_18() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateTravelledDistance("CP-RF01-02.json", 0, -40);//Valid .json file is used for checking it
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Length of time frame is incorrect", message);
	}

}

package agc.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import agc.AGCCalculator;
import agc.data.FullTurnByAxes;
import agc.exceptions.AGCException;

/**
 * 
 * @author Javier Aspiroz de la Calle & César Tranche Herrero
 * @since April 2018
 * @version 1.0
 *
 */

public class TestsPartTwoSyntaxAnalysis {

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
			FullTurnByAxes aba=agcc.CalculateFullTurn("CP-RF01-02.json", 0, 40);
			assertEquals(0, aba.getFullTurn_X(), 1.0d);
			assertEquals(0, aba.getFullTurn_Y(), 1.0d);
			assertEquals(0, aba.getFullTurn_Z(), 1.0d);
			
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
			agcc.CalculateMinMaxAcceleration("CP-RF01-03.json", 0, 40);
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
			agcc.CalculateMinMaxAcceleration("CP-RF01-04.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-05
	* Derivation Tree Node: Nodes 5, 9, 16, 24
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the modification of {} symbols
	*/

	@Test
	public void testCPRF01_05() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("CP-RF01-05.json", 0, 40);
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
			agcc.CalculateMinMaxAcceleration("CP-RF01-06.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-07
	* Derivation Tree Node: Nodes 25, 67, 71, 75, 79, 83, 87, 91
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the modification of , symbols
	*/

	@Test
	public void testCPRF01_07() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("CP-RF01-07.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-08
	* Derivation Tree Node: Nodes 56, 98, 100, 69, 73, 77, 81, 85, 89
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the modification of : symbols
	*/

	@Test
	public void testCPRF01_08() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("CP-RF01-08.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-09
	* Derivation Tree Node: Nodes 93, 95
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the modification of - symbols
	*/

	@Test
	public void testCPRF01_09() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("CP-RF01-09.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-10
	* Derivation Tree Node: Nodes 55, 68, 72, 76, 80, 84, 88
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the modification of label's names
	*/

	@Test
	public void testCPRF01_10() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("CP-RF01-10.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-11
	* Derivation Tree Node: Nodes 157, 129, 132, 135, 138,  141, 144
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the modification of . symbols as decimal separator
	*/

	@Test
	public void testCPRF01_11() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("CP-RF01-11.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-12
	* Derivation Tree Node: Nodes 157, 129, 132, 135, 138,  141, 144
	* Type of case: Modification
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the modification of numeric values for invalid ones
	*/

	@Test
	public void testCPRF01_12() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("CP-RF01-12.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Values in the input file are wrong as far as semantic is concerned", message);
	}
	
	/* Test case: CP-RF01-13
	* Derivation Tree Node: Nodes 157, 129, 132, 135, 138,  141, 144
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: Invalid, due to the omission of the labels in the input file
	*/

	@Test
	public void testCPRF01_13() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("CP-RF01-13.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	/* Test case: CP-RF01-14
	* Derivation Tree Node: 1
	* Type of case: Omission
	* Testing technique: Syntax Analysis
	* Expected value: Incorrect file path
	*/

	@Test
	public void testCPRF01_14() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Input data file not found", message);
	}
	
	/* Test case: CP-RF01-15
	* Derivation Tree Node: None
	* Type of case: None
	* Testing technique: Syntax Analysis
	* Expected value: Incorrect starting time
	*/

	@Test
	public void testCPRF01_15() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("CP-RF01-02.json", -1, 40);//Valid .json file is used for checking it
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Starting time is incorrect", message);
	}
	
	/* Test case: CP-RF01-16
	* Derivation Tree Node: None
	* Type of case: None
	* Testing technique: Syntax Analysis
	* Expected value: Incorrect interval time
	*/

	@Test
	public void testCPRF01_16() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("CP-RF01-02.json", 0, -40);//Valid .json file is used for checking it
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Length of time frame is incorrect", message);
	}

}

package agc.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import agc.AGCCalculator;
import agc.data.AccelerationByAxes;
import agc.data.FullTurnByAxes;
import agc.exceptions.AGCException;

/**
 * 
 * @author Javier Aspiroz de la Calle & César Tranche Herrero
 * @since April 2018
 * @version 1.0
 *
 */

public class TestsPartOneEquivalenceClassesBoundaryLimits {

	/* Test case: <CT-RF1-01>
	* Equivalence class or boundary value considered: <IEC2>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the input file does not exist> 
	*/
	
	
	@Test
	public void testCTRF101() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";
		try{			
			AccelerationByAxes aba= agcc.CalculateMinMaxAcceleration("CT-RF1-01.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Input data file not found", message);
	}
	
	/* Test case: <CT-RF1-02>
	* Equivalence class or boundary value considered: <VEC1, VEC3, VEC7, VEC8, VEC9, VEC10, VEC12, VEC26, VEC27, VEC28, VEC30, VEC44, 		VEC45, VEC46, VEC48, VEC50, VEC 51, VEC52, VEC54, VEC80, VEC81>
	* Testing technique: <Equivalence Classes Analysis and boundary values> 
	* Expected value: <The output should be a correct one> 
	*/

	@Test
	public void testCTRF102() {
		AGCCalculator agcc= new AGCCalculator();
		String message="";
		
		try{
			AccelerationByAxes aba= agcc.CalculateMinMaxAcceleration("CT-RF1-02.json", 0, 40);
			assertEquals(0, aba.getX_Axis().getMinAcceleration(), 1.0d);
			assertEquals(0, aba.getY_Axis().getMinAcceleration(), 1.0d);
			assertEquals(0, aba.getZ_Axis().getMinAcceleration(), 1.0d);
			assertEquals(3, aba.getX_Axis().getMaxAcceleration(), 1.0d);
			assertEquals(3, aba.getY_Axis().getMaxAcceleration(), 1.0d);
			assertEquals(3, aba.getZ_Axis().getMaxAcceleration(), 1.0d);
		} catch (AGCException ex) {
			message=ex.getMessage();
		}
	}

	
	/* Test case: <CT-RF1-03>
	* Equivalence class or boundary value considered: <IEC4>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <The input json file does not follows the correct syntax> 
	*/
	
	
	@Test
	public void testCTRF103() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			AccelerationByAxes aba= agcc.CalculateMinMaxAcceleration("CT-RF1-03.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	
	/* Test case: <CT-RF1-04>
	* Equivalence class or boundary value considered: <IEC5>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the date and time are not introduced in a valid way> 
	*/
	
	
	@Test
	public void testCTRF104() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			AccelerationByAxes aba= agcc.CalculateMinMaxAcceleration("CT-RF1-04.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Values in the input file are wrong as far as semantic is concerned", message);
	}
	
	
	/* Test case: <CT-RF1-05>
	* Equivalence class or boundary value considered: <IEC7>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the decimal separator used is no "." > 
	*/
	
	
	@Test
	public void testCTRF105() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			AccelerationByAxes aba= agcc.CalculateMinMaxAcceleration("CT-RF1-05.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Values in the input file are wrong as far as semantic is concerned", message);
	}
	
	
	/* Test case: <CT-RF1-06>
	* Equivalence class or boundary value considered: <IEC11>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the value needed is not in the input file > 
	*/
	
	
	@Test
	public void testCTRF106() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			AccelerationByAxes aba= agcc.CalculateMinMaxAcceleration("CT-RF1-06.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Values in the input file are wrong as far as semantic is concerned", message);
	}
	
	/* Test case: <CT-RF1-07>
	* Equivalence class or boundary value considered: <IEC32>
	* Testing technique: <Boundary values analysis> 
	* Expected value: <There should be an error because the input value is not between 0-360 for the GYRO inputs > 
	*/
	
	
	@Test
	public void testCTRF107() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			AccelerationByAxes aba= agcc.CalculateMinMaxAcceleration("CT-RF1-07.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Values in the input file are not in the interval of values from 0 to 360", message);
	}
	
	/* Test case: <CT-RF1-08>
	* Equivalence class or boundary value considered: <IEC33>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the input field is included several times in the input file > 
	*/
	
	
	@Test
	public void testCTRF108() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			AccelerationByAxes aba= agcc.CalculateMinMaxAcceleration("CT-RF1-08.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The same field is included several times", message);
	}
	
	
	/* Test case: <CT-RF1-09>
	* Equivalence class or boundary value considered: <IEC97>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the starting time is incorrect> 
	*/
	
	
	@Test
	public void testCTRF109() {
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			AccelerationByAxes aba= agcc.CalculateMinMaxAcceleration("CT-RF1-09.json", -10, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The initial time is incorrect", message);
	}
	
	/* Test case: <CT-RF1-09>
	* Equivalence class or boundary value considered: <IEC98>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the length of the time frame is incorrect> 
	*/
	
	
	@Test
	public void testCTRF110() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			AccelerationByAxes aba= agcc.CalculateMinMaxAcceleration("CT-RF1-10.json", 0, -20);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The time frame is incorrect", message);
	}


	/* Test case: <CT-RF2-01>
	* Equivalence class or boundary value considered: <IEC2>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the input file does not exist> 
	*/
	
	
	@Test
	public void testCTRF201() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";
		try{			
			FullTurnByAxes aba= agcc.CalculateFullTurn("CT-RF1-01.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Input data file not found", message);
	}




	/* Test case: <CT-RF1-02>
	* Equivalence class or boundary value considered: <VEC1, VEC3, VEC6, VEC8, VEC9, VEC10, VEC12, VEC28, VEC29, VEC30, VEC32, VEC49, VEC50, VEC51, VEC53, VEC70>
	* Testing technique: <Equivalence Classes Analysis and boundary values> 
	* Expected value: <The output should be a correct one> 
	*/

	@Test
	public void testCTRF202() {
		AGCCalculator agcc= new AGCCalculator();
		String message="";
		
		try{
			FullTurnByAxes aba= agcc.CalculateFullTurn("CT-RF1-02.json", 0, 40);
			assertEquals(6, aba.getFullTurn_X(), 1.0d);
			assertEquals(6, aba.getFullTurn_Y(), 1.0d);
			assertEquals(6, aba.getFullTurn_Z(), 1.0d);
		} catch (AGCException ex) {
			message=ex.getMessage();
		}
	}

	/* Test case: <CT-RF2-03>
	* Equivalence class or boundary value considered: <IEC4>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the input file does not exist> 
	*/
	
	
	@Test
	public void testCTRF203() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";
		try{			
			FullTurnByAxes aba= agcc.CalculateFullTurn("CT-RF1-03.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Input data file not found", message);
	}


	/* Test case: <CT-RF2-04>
	* Equivalence class or boundary value considered: <IEC5>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the date and time are not introduced in a valid way> 
	*/
	
	
	@Test
	public void testCTRF204() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			FullTurnByAxes aba= agcc.CalculateFullTurn("CT-RF1-04.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Values in the input file are wrong as far as semantic is concerned", message);
	}
	
	



	/* Test case: <CT-RF2-05>
	* Equivalence class or boundary value considered: <IEC7>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the decimal separator used is no "." > 
	*/
	
	
	@Test
	public void testCTRF205() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			FullTurnByAxes aba= agcc.CalculateFullTurn("CT-RF1-05.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Values in the input file are wrong as far as semantic is concerned", message);
	}



	/* Test case: <CT-RF2-06>
	* Equivalence class or boundary value considered: <IEC11>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the value needed is not in the input file > 
	*/
	
	
	@Test
	public void testCTRF206() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			FullTurnByAxes aba= agcc.CalculateFullTurn("CT-RF1-06.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Values in the input file are wrong as far as semantic is concerned", message);
	}

	
	/* Test case: <CT-RF2-07>
	* Equivalence class or boundary value considered: <IEC31>
	* Testing technique: <Boundary values analysis> 
	* Expected value: <There should be an error because the input value is not between 0-360 for the GYRO inputs > 
	*/
	
	
	@Test
	public void testCTRF207() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			FullTurnByAxes aba= agcc.CalculateFullTurn("CT-RF1-07.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Values in the input file are not in the interval of values from 0 to 360", message);
	}


	/* Test case: <CT-RF2-08>
	* Equivalence class or boundary value considered: <IEC33>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the input field is included several times in the input file > 
	*/
	
	
	@Test
	public void testCTRF208() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			FullTurnByAxes aba= agcc.CalculateFullTurn("CT-RF1-08.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The same field is included several times", message);
	}



	/* Test case: <CT-RF2-09>
	* Equivalence class or boundary value considered: <IEC74>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the starting time is incorrect> 
	*/
	
	
	@Test
	public void testCTRF209() {
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			FullTurnByAxes aba= agcc.CalculateFullTurn("CT-RF1-09.json", -10, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The initial time is incorrect", message);
	}


	/* Test case: <CT-RF2-10>
	* Equivalence class or boundary value considered: <IEC75>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the length of the time frame is incorrect> 
	*/
	
	
	@Test
	public void testCTRF210() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			FullTurnByAxes aba= agcc.CalculateFullTurn("CT-RF1-10.json", 0, -20);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The time frame is incorrect", message);
	}

}

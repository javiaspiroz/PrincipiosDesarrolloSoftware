package agc.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import agc.AGCCalculator;
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
public class FinalEquivBoundAnalysis {

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
			TravellByAxes aba= agcc.CalculateTravelledDistance("CT-RF1-01.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Input data file not found", message);
	}
	
	
	
	/* Test case: <CT-RF1-02>
	* Equivalence class or boundary value considered: <VEC1, VEC3, VEC5, VEC8, VEC9, VEC14, VEC15, VEC20, VEC21, VEC26, VEC27, VEC28, VEC35, VEC36, VEC37, VEC44, VEC45, VEC46, VEC51, VEC52, VEC53, VEC58, VEC59, VEC60, VEC65>
	* Testing technique: <Equivalence Classes Analysis and boundary values> 
	* Expected value: <The output should be a correct one> 
	*/

	@Test
	public void testCTRF102() {
		AGCCalculator agcc= new AGCCalculator();
		String message="";
		
		try{
			TravellByAxes aba= agcc.CalculateTravelledDistance("CT-RF1-02.json", 0, 40);
			assertEquals(0, aba.getX_Axis().getDistance(), 1.0d);
			assertEquals(0, aba.getY_Axis().getDistance(), 1.0d);
			assertEquals(0, aba.getZ_Axis().getDistance(), 1.0d);
			assertEquals(3, aba.getX_Axis().getDistance(), 1.0d);
			assertEquals(3, aba.getY_Axis().getDistance(), 1.0d);
			assertEquals(3, aba.getZ_Axis().getDistance(), 1.0d);
		} catch (AGCException ex) {
			message=ex.getMessage();
		}
	}

	
	
	/* Test case: <CT-RF1-03>
	* Equivalence class or boundary value considered: <IEC4>
	* Testing technique: <Sintax Analysis> 
	* Expected value: <The input json file does not follows the correct syntax> 
	*/
	
	@Test
	public void testCTRF103() {		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			TravellByAxes aba= agcc.CalculateTravelledDistance("CT-RF1-03.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	
	
	/* Test case: <CT-RF1-04>
	* Equivalence class or boundary value considered: <IEC6>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the date is not introduced in a valid way> 
	*/
	
	@Test
	public void testCTRF104() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			TravellByAxes aba= agcc.CalculateTravelledDistance("CT-RF1-04.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Values in the input file are wrong as far as semantic is concerned", message);
	}
	
	
	
	/* Test case: <CT-RF1-05>
	* Equivalence class or boundary value considered: <IEC7>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the time is not introduced in a valid way> 
	*/
	
	@Test
	public void testCTRF105() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			TravellByAxes aba= agcc.CalculateTravelledDistance("CT-RF1-05.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Values in the input file are wrong as far as semantic is concerned", message);
	}
	
	
	
	/* Test case: <CT-RF1-06>
	* Equivalence class or boundary value considered: <IEC10>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the value needed is not in the input file > 
	*/
	
	@Test
	public void testCTRF106() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			TravellByAxes aba= agcc.CalculateTravelledDistance("CT-RF1-06.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Values in the input file are wrong as far as semantic is concerned", message);
	}
	
	
	
	/* Test case: <CT-RF1-07>
	* Equivalence class or boundary value considered: <IEC11>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <The input value does not have three decimal numbers> 
	*/
	
	@Test
	public void testCTRF107() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			TravellByAxes aba= agcc.CalculateTravelledDistance("CT-RF1-07.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The input value does not have three decimal numbers", message);
	}
	
	
	
	/* Test case: <CT-RF1-08>
	* Equivalence class or boundary value considered: <IEC12>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the input field is included several times in the input file > 
	*/
	
	@Test
	public void testCTRF108() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			TravellByAxes aba= agcc.CalculateTravelledDistance("CT-RF1-08.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The same field is included several times", message);
	}
	
	
	
	/* Test case: <CT-RF1-09>
	* Equivalence class or boundary value considered: <IEC97>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the field value is not a number> 
	*/
	
	@Test
	public void testCTRF109() {
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			TravellByAxes aba= agcc.CalculateTravelledDistance("CT-RF1-09.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The input field value is not a number", message);
	}
	
	
	
	/* Test case: <CT-RF1-10>
	* Equivalence class or boundary value considered: <IEC30>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <The input value does not have seven decimal numbers> 
	*/	
	
	@Test
	public void testCTRF110() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			TravellByAxes aba= agcc.CalculateTravelledDistance("CT-RF1-10.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The input value does not have seven decimal numbers", message);
	}
	
	
	
	/* Test case: <CT-RF1-11>
	* Equivalence class or boundary value considered: <IEC33>
	* Testing technique: <Boundary Limit> 
	* Expected value: <The input file has a value higher than 90> 
	*/
	
	@Test
	public void testCTRF111() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			TravellByAxes aba= agcc.CalculateTravelledDistance("CT-RF1-11.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The input file has a value higher than 90", message);
	}
	
	
	
	/* Test case: <CT-RF1-12>
	* Equivalence class or boundary value considered: <IEC34>
	* Testing technique: <Boundary Limit> 
	* Expected value: <The input file has a value lower than -90> 
	*/
	
	@Test
	public void testCTRF112() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			TravellByAxes aba= agcc.CalculateTravelledDistance("CT-RF1-12.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The input file has a value lower than -90", message);
	}
	
	
	
	/* Test case: <CT-RF1-13>
	* Equivalence class or boundary value considered: <IEC42>
	* Testing technique: <Boundary Limit> 
	* Expected value: <The input file has a value higher than 180> 
	*/
	
	@Test
	public void testCTRF113() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			TravellByAxes aba= agcc.CalculateTravelledDistance("CT-RF1-13.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The input file has a value higher than 180", message);
	}
	
	
	
	/* Test case: <CT-RF1-14>
	* Equivalence class or boundary value considered: <IEC43>
	* Testing technique: <Boundary Limit> 
	* Expected value: <The input file has a value lower than -180> 
	*/
	
	@Test
	public void testCTRF114() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			TravellByAxes aba= agcc.CalculateTravelledDistance("CT-RF1-14.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The input file has a value lower than -180", message);
	}
	
	
	
	/* Test case: <CT-RF1-15>
	* Equivalence class or boundary value considered: <IEC66>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <The file could not be opened > 
	*/
	
	@Test
	public void testCTRF115() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			TravellByAxes aba= agcc.CalculateTravelledDistance("CT-RF1-15.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The file could not be opened", message);
	}
	
	
	
	/* Test case: <CT-RF1-16>
	* Equivalence class or boundary value considered: <IEC69>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <Starting time is incorrect> 
	*/
	
	@Test
	public void testCTRF116() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			TravellByAxes aba= agcc.CalculateTravelledDistance("CT-RF1-02.json", -5, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Starting time is incorrect", message);
	}
	
	
	
	/* Test case: <CT-RF1-17>
	* Equivalence class or boundary value considered: <IEC70>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the length of the time frame is incorrect> 
	*/
	
	@Test
	public void testCTRF117() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			TravellByAxes aba= agcc.CalculateTravelledDistance("CT-RF1-02.json", 0, -20);

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
			SpeedDeviationByAxes aba= agcc.CalculateSpeedDeviationByAxis("CT-RF2-01.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Input data file not found", message);
	}
	
	
	
	/* Test case: <CT-RF2-02>
	* Equivalence class or boundary value considered: <VEC1, VEC3, VEC5, VEC8, VEC9, VEC14, VEC15, VEC20, VEC21, VEC26, VEC27, VEC28, VEC35, VEC36, VEC37, VEC44, VEC45, VEC46, VEC51, VEC52, VEC53, VEC58, VEC59, VEC60, VEC65>
	* Testing technique: <Equivalence Classes Analysis and boundary values> 
	* Expected value: <The output should be a correct one> 
	*/

	@Test
	public void testCTRF202() {
		AGCCalculator agcc= new AGCCalculator();
		String message="";
		
		try{
			SpeedDeviationByAxes aba= agcc.CalculateSpeedDeviationByAxis("CT-RF2-02.json", 0, 40);
			assertEquals(0, aba.getX_speed().getSpeed(), 1.0d);
			assertEquals(0, aba.getY_speed().getSpeed(), 1.0d);
			assertEquals(0, aba.getZ_speed().getSpeed(), 1.0d);
			assertEquals(3, aba.getX_dev().getDeviation(), 1.0d);
			assertEquals(3, aba.getY_dev().getDeviation(), 1.0d);
			assertEquals(3, aba.getZ_dev().getDeviation(), 1.0d);
		} catch (AGCException ex) {
			message=ex.getMessage();
		}
	}

	
	
	/* Test case: <CT-RF2-03>
	* Equivalence class or boundary value considered: <IEC4>
	* Testing technique: <Sintax Analysis> 
	* Expected value: <The input json file does not follows the correct syntax> 
	*/
	
	@Test
	public void testCTRF203() {
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			SpeedDeviationByAxes aba= agcc.CalculateSpeedDeviationByAxis("CT-RF2-03.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Input file does not contain the data in the expected format", message);
	}
	
	
	
	/* Test case: <CT-RF2-04>
	* Equivalence class or boundary value considered: <IEC6>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the date is not introduced in a valid way> 
	*/
	
	@Test
	public void testCTRF204() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			SpeedDeviationByAxes aba= agcc.CalculateSpeedDeviationByAxis("CT-RF2-04.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Values in the input file are wrong as far as semantic is concerned", message);
	}
	
	
	
	/* Test case: <CT-RF2-05>
	* Equivalence class or boundary value considered: <IEC7>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the date is not introduced in a valid way> 
	*/
	
	@Test
	public void testCTRF205() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			SpeedDeviationByAxes aba= agcc.CalculateSpeedDeviationByAxis("CT-RF2-05.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Values in the input file are wrong as far as semantic is concerned", message);
	}
	
	
	
	/* Test case: <CT-RF2-06>
	* Equivalence class or boundary value considered: <IEC10>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the value needed is not in the input file > 
	*/
	
	@Test
	public void testCTRF206() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			SpeedDeviationByAxes aba= agcc.CalculateSpeedDeviationByAxis("CT-RF2-06.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Values in the input file are wrong as far as semantic is concerned", message);
	}
	
	
	
	/* Test case: <CT-RF2-07>
	* Equivalence class or boundary value considered: <IEC11>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <The input value does not have three decimal numbers> 
	*/
	
	@Test
	public void testCTRF207() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			SpeedDeviationByAxes aba= agcc.CalculateSpeedDeviationByAxis("CT-RF2-07.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The input value does not have three decimal numbers", message);
	}
	
	
	
	/* Test case: <CT-RF2-08>
	* Equivalence class or boundary value considered: <IEC12>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the input field is included several times in the input file > 
	*/
	
	@Test
	public void testCTRF208() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			SpeedDeviationByAxes aba= agcc.CalculateSpeedDeviationByAxis("CT-RF2-08.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The same field is included several times", message);
	}
	
	
	
	/* Test case: <CT-RF2-09>
	* Equivalence class or boundary value considered: <IEC97>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the field value is not a number> 
	*/
	
	@Test
	public void testCTRF209() {
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			SpeedDeviationByAxes aba= agcc.CalculateSpeedDeviationByAxis("CT-RF2-09.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The input field value is not a number", message);
	}
	
	
	
	/* Test case: <CT-RF2-10>
	* Equivalence class or boundary value considered: <IEC30>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <The input value does not have seven decimal numbers> 
	*/	
	
	@Test
	public void testCTRF210() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			SpeedDeviationByAxes aba= agcc.CalculateSpeedDeviationByAxis("CT-RF2-10.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The input value does not have seven decimal numbers", message);
	}
	
	
	
	/* Test case: <CT-RF2-11>
	* Equivalence class or boundary value considered: <IEC33>
	* Testing technique: <Boundary Limit> 
	* Expected value: <The input file has a value higher than 90> 
	*/
	
	@Test
	public void testCTRF211() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			SpeedDeviationByAxes aba= agcc.CalculateSpeedDeviationByAxis("CT-RF2-11.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The input file has a value higher than 90", message);
	}
	
	
	
	/* Test case: <CT-RF2-12>
	* Equivalence class or boundary value considered: <IEC34>
	* Testing technique: <Boundary Limit> 
	* Expected value: <The input file has a value lower than -90> 
	*/
	
	@Test
	public void testCTRF212() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			SpeedDeviationByAxes aba= agcc.CalculateSpeedDeviationByAxis("CT-RF2-12.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The input file has a value lower than -90", message);
	}
	
	
	
	/* Test case: <CT-RF2-13>
	* Equivalence class or boundary value considered: <IEC42>
	* Testing technique: <Boundary Limit> 
	* Expected value: <The input file has a value higher than 180> 
	*/
	
	@Test
	public void testCTRF213() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			SpeedDeviationByAxes aba= agcc.CalculateSpeedDeviationByAxis("CT-RF2-13.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The input file has a value higher than 180", message);
	}
	
	
	
	/* Test case: <CT-RF2-14>
	* Equivalence class or boundary value considered: <IEC43>
	* Testing technique: <Boundary Limit> 
	* Expected value: <The input file has a value lower than -180> 
	*/
	
	@Test
	public void testCTRF214() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			SpeedDeviationByAxes aba= agcc.CalculateSpeedDeviationByAxis("CT-RF2-14.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The input file has a value lower than -180", message);
	}
	
	
	
	/* Test case: <CT-RF2-15>
	* Equivalence class or boundary value considered: <IEC87>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <The file could not be opened > 
	*/
	
	@Test
	public void testCTRF215() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			SpeedDeviationByAxes aba= agcc.CalculateSpeedDeviationByAxis("CT-RF2-15.json", 0, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The file could not be opened", message);
	}
	
	
	
	/* Test case: <CT-RF2-16>
	* Equivalence class or boundary value considered: <IEC90>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <Starting time is incorrect> 
	*/
	
	@Test
	public void testCTRF216() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			SpeedDeviationByAxes aba= agcc.CalculateSpeedDeviationByAxis("CT-RF2-02.json", -5, 40);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("Starting time is incorrect", message);
	}
	
	
	
	/* Test case: <CT-RF2-17>
	* Equivalence class or boundary value considered: <IEC91>
	* Testing technique: <Equivalence Classes Analysis> 
	* Expected value: <There should be an error because the length of the time frame is incorrect> 
	*/
	
	@Test
	public void testCTRF217() {
		
		AGCCalculator agcc= new AGCCalculator();
		String message="";

		try{			
			SpeedDeviationByAxes aba= agcc.CalculateSpeedDeviationByAxis("CT-RF2-02.json", 0, -20);

		} catch (AGCException ex) {
			message=ex.getMessage();
		}
		assertEquals("The time frame is incorrect", message);
	}


}

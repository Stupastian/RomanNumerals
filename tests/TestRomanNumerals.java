import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestRomanNumerals {

	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	
	
	
	@Test
	public void testRomanNumeralsIXCMRepeatRules(){
		//setup
		RomanNumerals testable = new RomanNumerals();
		
		//Assert
		
		assertEquals("Input IIII should return error code -1", -1, testable.convertToInteger("IIII"));
		assertEquals("Input XXXX should return error code -1", -1, testable.convertToInteger("XXXX"));
		assertEquals("Input CCCC should return error code -1", -1, testable.convertToInteger("CCCC"));
		assertEquals("Input MMMM should return error code -1", -1, testable.convertToInteger("MMMM"));
	}
	
	@Test
	public void testRomanNumeralsVLDRepeatRules(){
		//Setup
		RomanNumerals testable = new RomanNumerals();
		
		//Assert
		assertEquals("Input VV should return error code -2", -2, testable.convertToInteger("VV"));
		assertEquals("Input VV should return error code -2", -2, testable.convertToInteger("LL"));
		assertEquals("Input VV should return error code -2", -2, testable.convertToInteger("DD"));
	}
	
	@Test
	public void testRomanNumeralsIXCSubstractRules(){
		//Setup
		RomanNumerals testable = new RomanNumerals();
		
		//Assert
		assertEquals("Input IL should return error code -3", -3, testable.convertToInteger("IL"));
		assertEquals("Input IC should return error code -3", -3, testable.convertToInteger("IC"));
		assertEquals("Input IC should return error code -3", -3, testable.convertToInteger("ID"));
		assertEquals("Input IC should return error code -3", -3, testable.convertToInteger("IM"));
		assertEquals("Input XD should return error code -3", -3, testable.convertToInteger("XD"));
		assertEquals("Input XM should return error code -3", -3, testable.convertToInteger("XM"));

	}
	
	@Test
	public void testRomanNumeralsOnlyOneSubstraction(){
		//Setup
		RomanNumerals testable = new RomanNumerals();
		
		//Assert
		assertEquals("Input IIV should return error code -4", -4, testable.convertToInteger("IIV"));
		assertEquals("Input IIX should return error code -4", -4, testable.convertToInteger("IIX"));
		assertEquals("Input XXL should return error code -4", -4, testable.convertToInteger("XXL"));
		assertEquals("Input XXC should return error code -4", -4, testable.convertToInteger("XXC"));
		assertEquals("Input CCD should return error code -4", -4, testable.convertToInteger("CCD"));
		assertEquals("Input CCM should return error code -4", -4, testable.convertToInteger("CCM"));
		
	}
	@Test
	public void testRomanNumeralsNotSubtractedVLD(){
		//Setup
		RomanNumerals testable = new RomanNumerals();
		
		//Assert
		assertEquals("Input VX should return error code -5", -5, testable.convertToInteger("VX"));
		assertEquals("Input LC should return error code -5", -5, testable.convertToInteger("LC"));
		assertEquals("Input DM should return error code -5", -5, testable.convertToInteger("DM"));

		
	}
	
	@Test
	public void testRomanNumeralsWithBasicElements() {
		//setup
		RomanNumerals testable = new RomanNumerals();
		
		//Assert
		assertEquals("input I should return 1", 1, testable.convertToInteger("I"));
		assertEquals("input X should return 10", 10, testable.convertToInteger("X"));
		assertEquals("input L should return 50", 50, testable.convertToInteger("L"));
		assertEquals("input C should return 100", 100, testable.convertToInteger("C"));
		assertEquals("input D should return 500", 500, testable.convertToInteger("D"));
		assertEquals("input M should return 1000", 1000, testable.convertToInteger("M"));
		
	}
	
	@Test
	public void testRomanNumeralsAddTogether(){
		//Setup
		RomanNumerals testable = new RomanNumerals();
		
		//Assert
		assertEquals("Input MMMIII should return 3003", 3003, testable.convertToInteger("MMMIII"));
	
	}
	
	@Test
	public void testRomanNumeralsSubstraction(){
		//Setup
		RomanNumerals testable = new RomanNumerals();
		
		//Assert
		assertEquals("Input IV should return 4", 4, testable.convertToInteger("IV"));
		assertEquals("Input IX should return 9", 9, testable.convertToInteger("IX"));
		assertEquals("Input XL should return 40", 40, testable.convertToInteger("XL"));
		assertEquals("Input XC should return 90", 90, testable.convertToInteger("XC"));
		assertEquals("Input CD should return 400", 400, testable.convertToInteger("CD"));
		assertEquals("Input CM should return 900", 900, testable.convertToInteger("CM"));

		
	}
	
	@Test
	public void testRomanNumeralsTotal(){
		//Setup
		RomanNumerals testable = new RomanNumerals();
		
		//Assert
		assertEquals("Input MMMCMXCIX should return 3999", 3999, testable.convertToInteger("MMMCMXCIX"));
		assertEquals("Empty Input should return 0", 0, testable.convertToInteger(""));
	}
	
	@Test
	public void testRomanNumeralsShouldAcceptLowerCase(){
		//Setup
		RomanNumerals testable = new RomanNumerals();
		
		//Assert
		assertEquals("Input mmmcmxcix should return 3999", 3999, testable.convertToInteger("mmmcmxcix"));
	}
	
	@Test
	public void testRomanNumeralsOnlyContainMDCLXVI(){
		//Setup
		RomanNumerals testable = new RomanNumerals();
		
		//Assert
		assertEquals("Input MMFM should return -6", -6, testable.convertToInteger("MMFM"));
		assertEquals("Input MF should return -6", -6, testable.convertToInteger("MF"));
		assertEquals("Input FM should return -6", -6, testable.convertToInteger("FM"));
		
	}

}

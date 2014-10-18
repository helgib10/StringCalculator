package is.ru.stringcalculator;

import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest {

    public static void main(String args[]){
        org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testStringWithOne() {
		assertEquals(1, Calculator.add("1"));
	}
	@Test
	public void testStringWithTwoVariables (){
		assertEquals(3, Calculator.add("1,2"));
	}
	@Test
	public void testStringWithMultipleVariables() {
		assertEquals(6, Calculator.add("1,2,3"));
	}
	@Test
	public void testStringWithNewLineSeporators() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	@Test
	public void testStringsWithCustomSeparoators() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
	@Test
	public void testNegativesNotAllowed() {
		try {
			Calculator.add("-1,2");
			fail("Exception expected.");
		} catch(RuntimeException ex) {
			assertEquals("Negatives not allowed: -1", ex.getMessage());
		}
   	}
	@Test
	public void testNegativesNotAllowedWithTheRightMessage() {
		try {
			Calculator.add("2,-4,3,-5");
			fail("Exception expected.");
		} catch(RuntimeException ex) {
			assertEquals("Negatives not allowed: -4, -5", ex.getMessage());
		}
	}
	@Test
	public void testThatBigIntegersAreLeftOut() {
		assertEquals(2, Calculator.add("1001,2"));
	}
	@Test
	public void testThatDelimitersCanBeOfAnyLength() {
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}
   }

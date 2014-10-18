package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

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
}

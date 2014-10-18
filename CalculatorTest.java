package stringCalculator;

import static org.juni.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
	@Test
	public void shouldReturnZeroOnEmptyString() {
		assertEquals(0, Calculator.add(""));
	}
}

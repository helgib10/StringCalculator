package is.ru.stringcalculator;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import static org.hamcrest.Matchers.*;

public class Calculator {

	public static int add(String text) {
		if (text.equals(""))
			return 0;
		int sum = 0;
		List<Integer> numbers = split(text);
		List<Integer> negatives = filter(lessThan(0), numbers);
		if(negatives.length > 0)
		{
			throw new RuntimeException("Negatives not allowed: " + join(negatives));
		}
		for (int i = 0; i < numbers.length; i++)
		{
			sum = sum + toInt(numbers[i]);
		}
		return sum;
	}

	private static String[] negative (String text){
		if(

	private static String[] split (String text){
		if(text.startsWith("//")){
			Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
			m.matches();
			String customSplitter = m.group(1);
			String numbers = m.group(2);
			return numbers.split(customSplitter);
		}
		else {
			String[] numbers = text.split(",|\n");
			return numbers;
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}
}


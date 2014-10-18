package is.ru.stringcalculator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Calculator {

	public static int add(String text) {
		if (text.equals(""))
			return 0;
		int sum = 0;
		String[] numbers = split(text);
		for (int i = 0; i < numbers.length; i++)
		{
			sum = sum + toInt(numbers[i]);
		}
		return sum;
	}

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


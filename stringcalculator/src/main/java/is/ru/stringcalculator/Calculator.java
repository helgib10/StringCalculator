package is.ru.stringcalculator;

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
		String[] numbers = text.split(",|\n");
		return numbers;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}
}


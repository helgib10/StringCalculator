package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text) {
		if (text.equals(""))
			return 0;
		int sum = 0;
		String[] numbers = text.split(",");
		for (int i = 0; i < numbers.length; i++)
		{
			sum = sum + toInt(numbers[i]);
		}
		return sum;
	}
	
	private static int toInt(String number){
		return Integer.parseInt(number);
	}
}


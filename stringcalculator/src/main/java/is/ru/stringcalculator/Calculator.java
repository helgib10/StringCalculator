package is.ru.stringcalculator;

import ch.lambdaj.fucnction.convert.Converter;
import static ch.lambdaj.Labda.*;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import static org.hamcrest.Matchers.*;

public class Calculator {

	public static int add(String text) {
		if (text.equals(""))
			return 0;
		int sum = 0;
		String[] tokens = split(text);
		List<Integer> numbers = convert(tokens, toInt());
		List<Integer> negatives = filter(lessThan(0), numbers);
		if(negatives.size() > 0)
		{
			throw new RuntimeException("Negatives not allowed: " + join(negatives));
		}
		for (int i = 0; i < tokens.length; i++)
		{
			sum = sum + toInt(tokens[i]);
		}
		return sum;
	}

	private static String[] split (String text){
		if(text.startsWith("//")){
			Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
			m.matches();
			String customSplitter = m.group(1);
			String tokens = m.group(2);
			return tokens.split(customSplitter);
		}
		else {
			String[] tokens = text.split(",|\n");
			return tokens;
		}
	}

	private static Converter<String, Integer> toInt() {
		return new Converter<String, Integer>() {

			public Integer convert(String from) {
				return toInt(from);
			}
		};
	}

	private static int toInt(String tokens)throws NumberFormatException {
		return Integer.parseInt(tokens);
	}
}


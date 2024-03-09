import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {

	public static void main(String [] args) {

		Pattern p = Pattern.compile("[a-z]*([A-Z]*[a-z]*)*");
		Matcher m = p.matcher("lowerCamelCase");
		System.out.println(m.matches());

	}

}
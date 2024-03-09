import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task9 {

	public static void main(String [] args) {

		Pattern p = Pattern.compile("[a-z]*([A-Z]*[a-z]*)*[=](([-]?[1-9][0-9]*)|([a-z]*[A-Z]*)*)[+-/*](([-]?[1-9][0-9]*)|([a-z]*[A-Z]*)*)");
		Matcher m = p.matcher("i=1+98");
		System.out.println(m.matches());

	}

}
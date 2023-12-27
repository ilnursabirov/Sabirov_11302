import java.util.Scanner;

public class Task8 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		int k = 0;

		for(int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '(') {
				k += 1;
			} else if (str.charAt(i) == ')') {
				k -= 1;
			}

			if (k < 0) {
				break;
			}

		}

		if (k == 0) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

	}

}
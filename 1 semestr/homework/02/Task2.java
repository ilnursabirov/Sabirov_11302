public class Task2 {
	public static void main(String[]args){

		int n = 5;
		int m = n * 2 - 1;

		for (int i = 1; i <= n; i++) {
			for (int j = n - i + n; j >= 1; j--) {
				System.out.print(" ");
			}

			for (int k = 2; k <= i; k++) {
				System.out.print("*");
			}

			System.out.print("*");

			for (int k = 2; k <= i; k++) {
				System.out.print("*");
			}

			System.out.println();
		}



		for (int i = 1; i <= n; i++) {
			for (int j = n - i - 1; j >= 0; j--) {
				System.out.print(" ");
			}

			for (int k = 2; k <= i; k++) {
				System.out.print("*");
			}

			System.out.print("*");

			for (int k = 2; k <= i; k++) {
				System.out.print("*");
			}

			for (int l = m - i*2 + 1; l >= 0; l--) {
				System.out.print(" ");
			}

			for (int k = 2; k <= i; k++) {
				System.out.print("*");
			}

			System.out.print("*");

			for (int k = 2; k <= i; k++) {
				System.out.print("*");
			}

			System.out.println();
		}

	}
}
public class Task13{

	public static void main(String []args){

		int n = 10;

		for (int i = n; i >= 1; i--){

			int j;
			for (j = i - 1; j >= 1; j--) {
				System.out.print(" ");
			}

			for (int k = 1; k <= n - i + 1; k++) {
				System.out.print("*");
			}

			System.out.println();
		}

	}

}
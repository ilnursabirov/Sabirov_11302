public class Task3 {

	public static void main(String [] args) {

		long t1 = System.nanoTime();
		double x  = Math.PI / 6;
		double EPS = 1e-6;
	
		double s = 0;
		int fact = 1;
		int k = 1;
		int sign = 1;

		double deg  = x;
		double a  = sign * deg / fact;

		while (Math.abs(a) > EPS) {

			s += a;
			k += 1;
			fact *= (2 * k - 1) * (2 * k - 2);
			deg *= x * x;
			sign = -1 * sign;
			a  = sign * deg / fact;

		}

		long t2 = System.nanoTime();

		System.out.println("Answer = " + s + " Time: " + (t2 - t1));

		long t10 = System.nanoTime();
		double y = Math.sin(x);
		long t20 = System.nanoTime();
		System.out.println("MathAnswer: " + y + " time: " + (t20 - t10));

	}

}
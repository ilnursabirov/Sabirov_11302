public class Task4{

	public static void main(String[] args){
		
		long t1 = System.nanoTime();
		
		double EPS = 1e-6;
		double x = Math.PI / 3;
		double deg = x * x;	
		double s = 1;	
		int fac = 2;
		int sign = -1;
		double a = sign * deg / fac;
		
		for (int i = 2; Math.abs(a) > EPS; i += 2){
			s += a;
			fac *= (i + 1) * (i + 2);
			sign *= -1;
			deg *= x * x;
			a = sign * deg / fac;
		}

		long t2 = System.nanoTime();
		System.out.println("Answer: " + s + " Time:" + (t2 - t1));

		long t10 = System.nanoTime();
		double y = Math.cos(x);
		long t20 = System.nanoTime();
		System.out.println("MathAnswer: " + y + " Time: " + (t20 - t10));
	}
	
}
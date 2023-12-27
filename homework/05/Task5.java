import java.util.Scanner;

public class Task5{

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.print("x = ");
		double x = Double.parseDouble(sc.nextLine());

		long t1 = System.nanoTime();
		
		double deg = x;
		double EPS = 1e-6;
		double s = 0;
		int fac = 1;
		int sign = 1;
		
		double a = sign * deg / fac;
		int i = 1;
		while (Math.abs(a) > EPS){
			i++;
			s += a;
			fac *= i;
			deg *= x;
			sign *= -1;
			a = sign * deg / fac;
		}

		long t2 = System.nanoTime();
		System.out.println("Answer: " + s + " Time: " + Math.abs(t2 - t1));

		long t10 = System.nanoTime();
		double b = Math.log1p(x);
		long t20 = System.nanoTime();
		System.out.println("MathAnswer: " + b + " Time: " + Math.abs(t20 - t10));
	}

}
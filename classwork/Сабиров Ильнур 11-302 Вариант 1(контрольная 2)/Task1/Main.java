public class Main {
	public static void main(String[] args) {
		Round r = new Round(0.0, 0.0, 5.0);
		double p1 = r.ploshad();
		double p2 = r.izmPloshad(50);
		String s = r.toString();
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(s);
	}
}
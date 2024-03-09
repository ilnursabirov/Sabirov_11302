public class Task27{
	
	public static boolean del3(double [] r){
		boolean f = true;
		for (int i = 0; i < r.length && f; i++){
			if (r[i] % 3 != 0){
				f = false;
			}
		}
		return f;
	}
	
	public static boolean hasDel(double [][] m){
		for (int i = 0; i < m.length; i++){
			if (del3(m[i])){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		double[][] m = new double[][] {
			{6, 99},
			{3, 72},
		};
		System.out.println(hasDel(m));
	}
}
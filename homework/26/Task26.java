public class Task26{
	
	public static boolean chet(int x){
		String s = x + "";
		boolean f = false;
		for (int i = 0; i < s.length() && !f; i++){
			char ch = s.charAt(i);
			if (ch == '2' || ch == '4' || ch == '6' || ch == '8' || ch == '0'){
				f = true;
			}
		}
		return f;
	}
	
	public static boolean pol(int [] m){
		boolean f = true;
		for (int i = 0; i < m.length && f; i++){
			if (!chet(m[i])){
				f = false;
			}
		}
		return f;
	}

	public static void main(String[] args) {
		int[] m = new int[] {23, 56, 8, 9, 4};
		System.out.println(pol(m));
	}
}
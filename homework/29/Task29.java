public class Task29{
	
	public static boolean chet(int n){
		
		boolean f = true;
		String s = n + "";
		char ch;
		for (int i = 0; i < s.length(); i++){
			ch = s.charAt(i);
			if (!(ch == '0' || ch == '2' || ch == '4' || ch == '6' || ch == '8')){
				return !f;
			}
		}
		return f;
		
	}
	
	public static boolean vseChet(int [][] m){
		boolean check = false;
		boolean f = true;
		for (int i = 0; i < m.length && f; i++){
			for (int j = 0; j < m[i].length && !check; j++){
				if (chet(m[i][j])){
					check = !check;
				}
			}
			if (!check){
				f = !f;
			}
		}
		return f;
	}

	public static void main(String[] args){
		int[][] m = new int[][] {
			{24, 80},
			{66, 22}
		};
		System.out.println(vseChet(m));
	}

}
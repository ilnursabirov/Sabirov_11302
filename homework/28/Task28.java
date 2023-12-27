public class Task28{
	
	public static boolean glEng(String [][] ar){
		boolean f = true;
		boolean check = false;
		char ch;
		for (int i = 0; i < ar[0].length && f; i++){
			check = false;
			for (int j = 0; j < ar.length && !check; j++){
				ch = ar[j][i].charAt(0);
				if (('a' <= ch && ch <= 'z')||('A' <= ch && ch <= 'Z')){
					check = true;
				}					
			}
			f = check? f: !f;
		}
		return f;
	}

	public static void main(String[] args) {
		String[][] m = new String[][] {
			{"eqw", "yre"},
			{"ola", "yo"}
		};
		System.out.println(glEng(m));
	}
}
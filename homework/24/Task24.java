public class Task24{
	
	public static void main(String[] args){
		int [] m = new int[] {1, 3, 34, -5, -6, 9};
		int c = 0;
		for (int i = 0; i < m.length && c < 2; i++){
			if (m[i] < 0){
				c++;
			}
		}
		System.out.println(c >= 2);
	}	
}
public class Task25{
	
	char [] gl = {'a', 'o', 'i', 'u', 'y', 'e', 'A', 'O', 'I', 'U', 'Y', 'E'};
	
	public static boolean gl(char ch){
		boolean f = false;
		for (int i = 0; i < gl.length && !f; i++){
			if (gl[i] == ch){
				f = true;
			}
		}
		return f;
	}
	
	public static void main(String arg){
		int c = 0;
		char ch;
		boolean flag = true;
		for (int i = 0; i < arg.length() && flag ; i++){
			ch = arg.charAt(i);
			if (('a' <= ch && ch <= 'z')||('A' <= ch && ch <= 'Z')){
				if (gl(ch)){
					 c++
				}
				if (c > 3){
					flag = false;
				}
			}
		}
		return c == 3;
	}	
}
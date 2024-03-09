public class Task1 {
	
	public static void main(String[] args) {

		String [] str = new String [] {"mama", "ma", "lala", "lol", "lololol"};
		int pareCount = 0;
		int l = 0;
		for (String s : str) {
			l++;
		}

		for (int i = 0; i < l - 1; i++) {

			boolean flag = true;

			for (int j = i + 1; j < l; j++) {
				int mn;
				if (str[i].length() < str[j].length()) {
					mn = str[i].length();
				} else {
					mn = str[j].length();
				}
				for (int x = 0; x < mn; x++) {
					if (str[i].charAt(x) != str[j].charAt(x)) {
						flag = false;
						break;
					}
				}
			}
			if (flag == true) {
					pareCount++;
			}
		}


		if (pareCount <= 2) {
			System.out.println("Ne bolee 2 par");
		} else {
			System.out.println("Bolee 2 par");
		}

	}

}
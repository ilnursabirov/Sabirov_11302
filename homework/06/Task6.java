public class Task6 {

	public static void main(String [] args) {

		int[][] a = new int[][] { 
	    	{0,0,0,1,0,1,1,0,0,1,0,0,0,0,0,1,0,0,1,1},
	    	{1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1},
	    	{0,0,0,1,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,1},
	    	{0,0,0,0,1,1,1,0,0,1,0,0,0,0,0,1,0,0,0,1},
	    	{1,1,1,0,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1},
	      	{0,0,0,1,0,0,1,1,1,1,1,0,1,0,0,1,0,1,0,1},
	    	{1,1,1,1,0,1,1,1,1,1,0,1,0,1,0,1,1,0,1,1},
	    	{1,1,1,1,0,1,1,1,1,1,1,0,0,1,1,0,0,1,1,1},
	    	{1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0},
	    	{0,1,1,1,0,1,1,1,0,1,0,0,0,0,1,1,1,0,1,1},
	     	{1,1,1,1,1,1,0,1,1,1,0,1,1,0,1,1,1,0,1,1},
	    	{0,0,1,1,1,1,1,1,0,1,0,0,0,0,0,1,1,0,1,1},
	    	{1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,0,0,0},
	    	{0,1,1,1,0,1,1,1,0,1,1,1,0,0,1,1,1,1,1,0},
	    	{1,0,1,1,1,0,1,1,0,1,1,1,0,1,0,1,1,1,1,1},
	    	{0,1,1,0,1,1,1,1,0,1,1,1,1,0,0,1,0,1,0,1},
	    	{1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,0,0},
	    	{1,1,0,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0},
	    	{1,0,1,1,0,1,1,1,0,0,1,0,0,1,0,1,0,1,1,1},
	    	{0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0},
		};

		int n[] = new int[20];

		for (int i = 0; i < 20; i++){
			int m = 0;
			for (int j = 0; j < 20; j++){
				if (a[i][j] == 1) {
					m += 1;
				}
			n[i] = m;
			}
		}

		double mx = 0.0;
		int p1 = 0;
		int p2 = 0;
		for (int i = 0; i < 19; i++) {

			for (int j = i + 1; j < 20; j++) {

				int l = 0;
				for (int k = 0; k < 20; k++) {

					if ((a[i][k] == 1) && (a[j][k] == 1)) {
						l += 1;
					}else{

					}

				}

				double t = 1.0 * (2 * l)/(n[i] + n[j]);

				if (t > mx) {
					mx = t;
					p1 = i;
					p2 = j;
				}

			}

		}

		System.out.println(p1 + 1);
		System.out.println(p2 + 1);
		System.out.println(mx);

	}

}
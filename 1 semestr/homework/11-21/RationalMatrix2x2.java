public class RationalMatrix2x2{
	
	private RationalFraction [][] t = new RationalFraction[2][2];
	
	public RationalMatrix2x2(){
		this(new RationalFraction());
	}
	
	public RationalMatrix2x2(RationalFraction x){
		this(x,x,x,x);
	}
	
	public RationalMatrix2x2(RationalFraction a, RationalFraction b, RationalFraction c, RationalFraction d) {
		t[0][0] = a;
		t[0][1] = b;
		t[1][0] = c;
		t[1][1] = d;
	}
	
	public RationalFraction getEl(int i, int j) {
		return t[i][j];
	}
	
	public RationalMatrix2x2 add(RationalMatrix2x2 rM){
		RationalMatrix2x2 res = new RationalMatrix2x2();
		for (int i = 0; i < 2; i++){
			for (int j = 0; j < 2; j++){
				res.t[i][j] = getEl(i, j).add(rM.getEl(i, j));
			}
		}
		return res;
	}
	
	public RationalMatrix2x2 mult(RationalMatrix2x2 rM){
		RationalMatrix2x2 res = new RationalMatrix2x2();
		for (int i = 0; i < 2; i++){
			for (int j = 0; j < 2; j++){
				for (int k = 0; k < 2; k++){
					res.t[i][j] = res.t[i][j].add(t[i][k].mult(rM.t[k][j]));
				}
			}
		}
		return res;
	}
	
	public RationalFraction det() {
		return (getEl(0, 0).mult(getEl(1, 1))).sub(getEl(1, 0).mult(getEl(0, 1)));
	}
	
	public RationalVector2D multVector(RationalVector2D v2){
		RationalFraction x1 = (getEl(0, 0).mult(v2.getx())).add((getEl(0, 1).mult(v2.gety())));
		RationalFraction y1 = (getEl(1, 0).mult(v2.getx())).add((getEl(1, 1).mult(v2.gety())));
		return new RationalVector2D(x1, y1);
	}
	
}
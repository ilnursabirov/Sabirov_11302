public class RationalComplexMatrix2x2{
	
	private RationalComplexNumber[][] t = new RationalComplexNumber [2][2]; 
	
	
	public RationalComplexMatrix2x2(){
		this(new RationalComplexNumber());
	}
	
	public RationalComplexMatrix2x2(RationalComplexNumber x){
		this(x, x, x, x);
	}
	
	public RationalComplexMatrix2x2(RationalComplexNumber a, RationalComplexNumber b, RationalComplexNumber c, RationalComplexNumber d){
		t[0][0] = n1;
		t[0][1] = n2;
		t[1][0] = n3;
		t[1][1] = n4;
	}
	
	public RationalComplexNumber getEl(int i, int j){
		return t[i][j];
	}
	
	public void set(RationalComplexNumber n, int i, int j){
		this.t[i][j] = n;
	}
	
	public RationalComplexMatrix2x2 add(RationalComplexMatrix2x2 rCM){
		RationalComplexNumber [][] r = new RationalComplexNumber[2][2];
		for (int i = 0; i < 2; i++){
			for (int j = 0; j < 2; j++){
				r[i][j] = getEl(i,j).add(rCM.getEl(i,j));
			}
		}
		return new RationalComplexMatrix2x2(r[0][0],r[0][1],r[1][0],r[1][1]);
	}
	
	public RationalComplexMatrix2x2 mult(RationalComplexMatrix2x2 rCM){
		RationalComplexMatrix2x2 res = new RationalComplexMatrix2x2();
		for (int i = 0; i < 2; i++){
			for (int j = 0; j < 2; j++){
				for (int k = 0; k < 2; k++){
					r.t[i][j] = r.t[i][j].add(getEl(i, k).mult(rCM.getEl(k, j)));
				}
			}
		}
		return r;
	}
	
	public RationalComplexNumber det(){
		return (getEl(0, 0).mult(getEl(1, 1))).sub(getEl(0, 1).mult(getEl(1, 0)));
	}
	
	public RationalComplexVector2D multVector(RationalComplexVector2D rCV){
		RationalComplexNumber rx = (getEl(0, 0).mult(rCV.getx())).add(getEl(0, 1).mult(rCV.gety()));
		RationalComplexNumber ry = (getEl(1, 0).mult(rCV.getx())).add(getEl(1, 1).mult(rCV.gety()));
		return new RationalComplexVector2D(rx,ry);
	}	
}
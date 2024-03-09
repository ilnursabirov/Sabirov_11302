public class ComplexMatrix2x2{
	
	private ComplexNumber [][] t = new ComplexNumber[2][2];
	
	public ComplexMatrix2x2(){
		this(new ComplexNumber());
	}
	
	public ComplexMatrix2x2(ComplexNumber cn){
		this(cn, cn, cn, cn);	
	}
	
	private ComplexNumber getEl(int i, int j){
		return t[i][j];
	}
	
	public ComplexMatrix2x2(ComplexNumber a, ComplexNumber b, ComplexNumber c, ComplexNumber d){
		t[0][0] = a;
		t[0][1] = b;
		t[1][0] = c;
		t[1][1] = d;
	}
	
	private ComplexNumber helpAdd(ComplexMatrix2x2 cm, int i, int j){
		return getEl(i, j).add(cm.getEl(i, j));
	}
	
	private ComplexNumber helpMult(int i, int j, int i1, int j1){
		return getEl(i, j).mult(getEl(i1, j1));
	}
	
	public ComplexMatrix2x2 mult(ComplexMatrix2x2 cm){
		ComplexMatrix2x2 result = new ComplexMatrix2x2();
		for (int i = 0; i < 2; i++){
			for (int j = 0; j < 2; j++){
				for (int k = 0; k < 2; k++){
					res.t[i][j] = res.t[i][j].add(getEl(i, k).mult(cm.getEl(k, j)));
				}
			}
		}
		return res;
	}
	
	public ComplexNumber det(){
		return helpMult(0, 0, 1, 1).sub(helpMult(0, 1, 1, 0));
	}
	
	public ComplexVector2D multVector(ComplexVector2D cv){
		ComplexNumber x = new ComplexNumber();
		ComplexNumber y = new ComplexNumber();
		int c;
		int n = 0;
		for (int i = 0; i < 2; i++){
			c = 0;
			for (int j = 0; j < 2; j++){
				if (n == 0){
					x = c%2 == 0? x.add(getEl(i,j).mult(cv.getx())): x.add(getEl(i, j).mult(cv.gety()));
				} else {
					y = c%2 == 0? y.add(getEl(i,j).mult(cv.getx())): y.add(getEl(i, j).mult(cv.gety()));
				}
			}
			n++;
		}
		return new ComplexVector2D(x,y);
	}	
	
}
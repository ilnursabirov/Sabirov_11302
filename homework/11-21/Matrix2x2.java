public class Matrix2x2{
	
	double [][] t = new double [2][2];
	
	public Matrix2x2(){
		this(0, 0, 0, 0);
	}
	
	public Matrix2x2(double x){
		this(x, x, x, x);
	}
	
	public Matrix2x2(double[][] array){
		this.t = t;
	}
	
	public Matrix2x2(double a, double b, double c, double d){
		t[0][0] = a;
		t[0][1] = b;
		t[1][0] = c;
		t[1][1] = d;
	}
	
	public double getEl(int i, int j){
		return t[i][j];
	}
	
	public void setMatr(double [][] arr){
		this.t = ar;
	}
	
	public Matrix2x2 add (Matrix2x2 m2){
		double [][] result = new double[t.length][t[0].length];
		for (int i = 0; i < 2; i++){
			for (int j = 0; j < 2; j++){
				result[i][j] = t[i][j] + m2.t[i][j];
			}
		}
		return new Matrix2x2(result);
	}
	
	private double[][] addSub(int i, double a, double b, double c, double d){
		double [][] ar = {{getEl(0,0) + i * a, getEl(0,1) + i * b},{getEl(1,0) + i * c, getEl(1,1) + i * d}};
		return ar;
	}
	
	public void add2 (Matrix2x2 m2){
		setMatr(addSub(1, m2.getEl(0,0),m2.getEl(0,1), m2.getEl(1,0),m2.getEl(1,1)));
	}
	
	public Matrix2x2 sub (Matrix2x2 m2){
		return new Matrix2x2(addSub(-1, m2.getEl(0,0), m2.getEl(0,1), m2.getEl(1,0), m2.getEl(1,1)));
	}
	
	public void sub2(Matrix2x2 m2){
		setMatr(addSub(-1, m2.getEl(0,0), m2.getEl(0,1), m2.getEl(1,0), m2.getEl(1,1)));
	}
	
	private double[][] helpForEnum(double x){
		double chin[][] = {{getEl(0,0) * x, getEl(0,1) * x},{getEl(1,0) * x, getEl(1,1) * x}};
		return chin;
	}
	
	public Matrix2x2 multNumber(double b){
		double [][] arr = new double[t.length][t[0].length];
		for (int i = 0; i < 2; i++){
			for (int j = 0; j < 2; j++){
				ar[i][j] = t[i][j] * b;
			}
		}
		return new Matrix2x2(arr);
	}
	
	public void multNumber2(double x){
		setMatr(helpForEnum(x));
	}
	
	private double [][] helpMult(Matrix2x2 m2){
		double [][] arr = new double [2][2];
		for (int i = 0; i < 2; i++){
			for (int j = 0; j < 2; j++){
				for (int k = 0 ; k < 2; k++){
					ar[i][j] += t[i][k] * t[k][j];
				}
			}
		}
		return arr;
	}
	
	public Matrix2x2 mult(Matrix2x2 m2){
		return new Matrix2x2(helpMult(m2));
	}
	
	public void mult2(Matrix2x2 m2){
		t = helpMult(m2);
	}
	
	public double det(){
		return t[0][0] * t[1][1] - t[0][1] * t[1][0];
	}
	
	public void transpon(){
		double tran [][] = {{t[0][0],t[1][0]},{t[0][1], t[1][1]}};
		setMatr(tran);
	}
	
	public Matrix2x2 inverseMatrix(){
        double[][] arr = new double[2][2];
        if (det() != 0) {
            double det = det();
            ar[0][0] = t[1][1] / det;
            ar[1][1] = t[0][0] / det;
            ar[0][1] = -t[0][1] / det;
            ar[1][0] = -t[1][0] / det;
            return new Matrix2x2(ar);
        } else {
            return null;
        }
	}
	
	public Matrix2x2 equivalentDiagonal(){
		
		double k = (-1) * getEl(1,0) / getEl(0,0);
		double [][] prom = {{getEl(0,0), getEl(0,1)},{getEl(1,0) + k * getEl(0,0), getEl(1,1) + getEl(0,1) * k}};
		double k2 = prom[1][1] > 0.00001? (-1) * prom[0][1] / prom[1][1]: 1;
		prom [0][1] = 0;
		prom [0][0] += prom[1][0] * k;
		return new Matrix2x2(prom);
	}
	
	public Vector2D multVector(Vector2D vec){
		double [] result = {getEl(0,0) * vec.getx() + getEl(0,1) * vec.gety(), getEl(1,0) * vec.getx() + getEl(1,1) * vec.gety()};
		return new Vector2D(result[0], result[1]);
	}

}
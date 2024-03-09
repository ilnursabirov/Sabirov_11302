public class Vector2D{
	
	private double x;
	private double y;
	
	public Vector2D(){
		this(0,0);
	}
	
	public Vector2D(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getx(){
		return x;
	}
	
	public double gety(){
		return y;
	}
	
	public Vector2D add(Vector2D v2){
		Vector2D resultVector = new Vector2D(x + v2.getx(), y + v2.gety());
		return resultVector;
	}
	
	public void add2(Vector2D v2){
		this.x = x + v2.getx();
		this.y = y + v2.gety();
	}
	
	public Vector2D sub(Vector2D v2){
		Vector2D resultVector = new Vector2D(x - v2.getx(), y - v2.gety());
		return resultVector;
	}
	
	public void sub2(Vector2D v2){
		this.x = x - v2.getx();
		this.y = y - v2.gety();
	}
	
	public Vector2D mult(double num){
		Vector2D resultVector = new Vector2D(x * num, y * num);
		return resultVector;
	}
	
	public void mult2(double num){
		this.x = x * num;
		this.y = y * num;
	}
	
	public String toString(){
		return "x: " + x + " y: " + y;
	}
	
	public double length(){
		return Math.sqrt(x*x + y*y);
	}

	public double scalarProduct(Vector2D v2){
		return x * v2.getx() + y * v2.gety();
		
	}
	
	private boolean helpForEq(double x1, double y1, double z1, double w1){
		return x1 - y1 < 0.000001 & z1 - w1 <0.000001;
	}
	
	public boolean equals(Vector2D v2){
		boolean result = helpForEq(x, v2.getx(), y, v2.gety())? true: false;
		return result;
	}
	
	public double cos(Vector2D v2){
		return scalarProduct(v2)/(length() + v2.length());
	}
}
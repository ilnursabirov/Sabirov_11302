public class RationalVector2D{
	
	private RationalFraction x;
	private RationalFraction y;
	
	public RationalVector2D(){
		this(new RationalFraction(), new RationalFraction());
	}
	
	public RationalVector2D(RationalFraction x, RationalFraction y){
		this.x = x;
		this.y = y;
	}
	
	public RationalFraction getx(){
		return x;
	}
	
	public RationalFraction gety(){
		return y;
	}
	
	
	public RationalVector2D add(RationalVector2D v2){
		RationalVector2D res = new RationalVector2D(x.add(v2.getx()), y.add(v2.gety()));		
		return res;
	}
	
	public String toString(){
		return "x: " + x.toString() + " y: " + y.toString();
	}
	
	public double length(){
		return Math.sqrt(x.value() * x.value() + y.value() * y.value()); 
	}
	
	public RationalFraction scalarProduct(RationalVector2D v2){
		RationalFraction r1 = x.mult(v2.getx()); 
		RationalFraction r2 = y.mult(v2.gety());
		return r1.add(r2);
	}
	
	public boolean equals (RationalVector2D v2){
		return x.equals(v2.getx()) && y.equals(v2.equals(v2.gety()));		
	}	
}
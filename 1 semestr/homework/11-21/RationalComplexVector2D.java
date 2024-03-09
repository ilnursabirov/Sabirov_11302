public class Task20{
	
	private RationalComplexNumber x;
	private RationalComplexNumber y;
	
	public RationalComplexVector2D(){
		this(new RationalComplexNumber(), new RationalComplexNumber());
	}
	
	public RationalComplexVector2D(RationalComplexNumber x, RationalComplexNumber y){
		this.x = x;
		this.y = y;
	}
	
	public RationalComplexNumber getx(){
		return x;
	}
	
	public RationalComplexNumber gety(){
		return y;
	}	
	
	public RationalComplexVector2D add(RationalComplexVector2D raComVec){
		RationalComplexNumber resX = getx().add(raComVec.getx());
		RationalComplexNumber resY = gety().add(raComVec.gety());
		return new RationalComplexVector2D(resX, resY);
	}
	
	public String toString(){
		return "x: " + getx().toString() + ";  y: " + gety().toString();
	}
	
	public RationalComplexNumber scalarProduct(RationalComplexVector2D raComVec){
		return (getx().mult(raComVec.getx())).add(gety().mult(raComVec.gety()));
	}	
}
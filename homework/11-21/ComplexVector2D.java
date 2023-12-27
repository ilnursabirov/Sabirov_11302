public class ComplexVector2D{
	private ComplexNumber x;
	private ComplexNumber y;
	
	public ComplexVector2D(){
		this(new ComplexNumber(), new ComplexNumber());		
	}
	
	public ComplexVector2D(ComplexNumber x, ComplexNumber y){
		this.x = x;
		this.y = y;
	}
	
	public ComplexNumber getx(){
		return x;
	}
	
	public ComplexNumber gety(){
		return y;
	}
	
	public ComplexVector2D add(ComplexVector2D cv2){
		return new ComplexVector2D(x.add(cv2.getx()), y.add(cv2.gety()));		
	}
	
	public String toString(){
		return "x: " + x.toString() + " y: " + y.toString();
	}
	
	public ComplexNumber scalarProduct(ComplexVector2D cv2){
		return (x.mult(cv2.getx())).mult(y.mult(cv2.gety()));
	}
	
	public boolean equals(ComplexVector2D cv2){
		return x.equals(cv2.getx()) && y.equals(cv2.gety());
	}	
}
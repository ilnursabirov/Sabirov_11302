public class RationalComplexNumber{
	
	private RationalFraction r;
	private RationalFraction i;
	
	public RationalComplexNumber(){
		this(new RationalFraction(), new RationalFraction());
	}
	
	public RationalComplexNumber(RationalFraction x, RationalFraction y){
		this.r = x;
		this.i = y;
	}
	
	public RationalFraction getr(){
		return r;
	}
	
	public RationalFraction geti(){
		return i;
	}		
	
	public RationalComplexNumber add(RationalComplexNumber rCN){
		return new RationalComplexNumber(getr().add(rCN.getr()), geti().add(rCN.geti()));
	}
	
	public RationalComplexNumber sub(RationalComplexNumber rCN){
		return new RationalComplexNumber(getr().sub(rCN.getr()), geti().sub(rCN.geti()));
	}
	
	public RationalComplexNumber mult(RationalComplexNumber rCN){
		RationalFraction real = (getr().mult(rCN.getr())).sub(geti().mult(rCN.geti()));
		real.reduce();
		RationalFraction imag = (getr().mult(rCN.geti())).add(geti().mult(rCN.getr()));
		imag.reduce();
		return new RationalComplexNumber(real, imag);
	}
	
	public String toString(){
		String s = i.value() >= 0? "" + r.toString() + "+  i(" + i.toString() + ")": "" + r.toString() + " (" + i.toString() + ")i";
		return s;
	}
}
public class RationalFraction {
    private int num;
    private int den;

    public RationalFraction() {
        this.num = 0;
        this.den = 1;
    }

    public RationalFraction(int num, int den) {
        this.num = num;
        this.den = den;
        reduce();
    }

    public int getNum() {
    	return num;
    }

    public int getDen() {
    	return den;
    }

    public void reduce() {
        int gcd = findGCD(Math.abs(num), den);
        num /= gcd;
        den /= gcd;
        if (den < 0) {
            num = -num;
            den = -den;
        }
    }

    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public RationalFraction add(RationalFraction f) {
    	RationalFraction rf = new RationalFraction(this.num * f.getDen() + f.getNum() * this.den, this.den * f.getDen());
        return rf;
    }

    public void add2(RationalFraction f) {
        this.num = this.num * f.getDen() + f.getNum() * this.den;
        this.den = this.den * f.getDen();
        reduce();
    }

    public RationalFraction sub(RationalFraction f) {
    	RationalFraction rf = new RationalFraction(this.num * f.getDen() - f.getNum() * this.den, this.den * f.getDen());
        return rf;
    }

    public void sub2(RationalFraction f) {
        this.num = this.num * f.getDen() - f.getNum() * this.den;
        this.den = this.den * f.getDen();
        reduce();
    }

    public RationalFraction mult(RationalFraction f) {
    	RationalFraction rf = new RationalFraction(this.num * f.getNum(), this.den * f.getDen());
        return rf;
    }

    public void mult2(RationalFraction f) {
        this.num = this.num * f.getNum();
        this.den = this.den * f.getDen();
        reduce();
    }

    public RationalFraction div(RationalFraction f) {
    	RationalFraction rf = new RationalFraction(this.num * f.getDen(), this.den * f.getNum());
        return rf;
    }

    public void div2(RationalFraction f) {
        this.num = this.num * f.getDen();
        this.den = this.den * f.getNum();
        reduce();
    }

    public String toString() {
        return this.num + "/" + this.den;
    }

    public double value() {
        return (double) this.num / this.den;
    }

    public boolean equals(RationalFraction f) {
        return this.num == f.getNum() && this.den == f.getDen();
    }

    public int numberPart() {
        return this.num / this.den;
    }
}
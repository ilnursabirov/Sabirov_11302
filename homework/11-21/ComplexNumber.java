public class ComplexNumber {
    private double r;
    private double i;

    public ComplexNumber() {
        this.r = 0;
        this.i = 0;
    }

    public ComplexNumber(double r, double i) {
        this.r = r;
        this.i = i;
    }

    public double getR() {
        return r;
    }

    public double getI() {
        return i;
    }

    public ComplexNumber add(ComplexNumber cn) {
        return new ComplexNumber(this.r + cn.getR(), this.i + cn.getI());
    }

    public void add2(ComplexNumber cn) {
        this.r += cn.getR();
        this.i += cn.getI();
    }

    public ComplexNumber sub(ComplexNumber cn) {
        return new ComplexNumber(this.r - cn.getR(), this.i - cn.getI());
    }

    public void sub2(ComplexNumber cn) {
        this.r -= cn.getR();
        this.i -= cn.getI();
    }

    public ComplexNumber multNumber(double num) {
        return new ComplexNumber(this.r * num, this.i * num);
    }

    public void multNumber2(double num) {
        this.r *= num;
        this.i *= num;
    }

    public ComplexNumber mult(ComplexNumber cn) {
        double newR = this.r * cn.getR() - this.i * cn.getI();
        double newI = this.r * cn.getI() + this.i * cn.getR();
        return new ComplexNumber(newR, newI);
    }

    public void mult2(ComplexNumber cn) {
        this.r = this.r * cn.getR() - this.i * cn.getI();
        this.i = this.r * cn.getI() + this.i * cn.getR();
    }

    public ComplexNumber div(ComplexNumber cn) {
        double den = cn.getR() * cn.getR() + cn.getI() * cn.getI();
        double newR = (this.r * cn.getR() + this.i * cn.getI()) / den;
        double newI = (this.i * cn.getR() - this.r * cn.getI()) / den;
        return new ComplexNumber(newR, newI);
    }

    public void div2(ComplexNumber cn) {
        double den = cn.getR() * cn.getR() + cn.getI() * cn.getI();
        this.r = (this.r * cn.getR() + this.i * cn.getI()) / den;
        this.i = (this.i * cn.getR() - this.r * cn.getI()) / den;
    }

    public double length() {
        return Math.sqrt(this.r * this.r + this.i * this.i);
    }

    public String toString() {
        if (this.i >= 0) {
            return this.r + " + " + this.i + " * i";
        } else {
            return this.r + " - " + Math.abs(this.i) + " * i";
        }
    }

    public double arg() {
        return Math.atan2(this.i, this.r);
    }

    public ComplexNumber pow(double power) {
        double length = Math.pow(this.length(), power);
        double arg = power * this.arg();
        double newR = length * Math.cos(arg);
        double newI = length * Math.sin(arg);
        return new ComplexNumber(newR, newI);
    }

    public boolean equals(ComplexNumber cn) {
        return this.r == cn.getR() && this.i == cn.getI();
    }
}
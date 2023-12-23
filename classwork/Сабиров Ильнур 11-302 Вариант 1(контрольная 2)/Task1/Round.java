public class Round {
	
	private double x;
	private double y;
	private double r;
	private double pi = 3.14;
	private double ploshad;
	private double dlina;

	public Round() {
		this.x = 0.0;
		this.y = 0.0;
		this.r = 0.0;
		this.dlina = 0.0;
		this.ploshad = 0.0;
	}

	public Round(double x, double y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public double getx() {
		return x;
	}

	public double gety() {
		return y;
	}

	public double getr() {
		return r;
	}

	public double dlina() {
		return 2 * this.pi * this.r;
	}

	public double ploshad() {
		return this.pi * this.r * this.r;
	}

	public double izmPloshad(double proc) {
		return this.ploshad() * (proc / 100);
	}

	public boolean equals(Round k) {
		if (this.x == x && this.y == y && this.r == r) {
			return true;
		} else {
			return false;
		}
	}

	public double plSek(double alpha) {
		return this.ploshad() * (alpha / 360.0);
	}

	public int otnoshenie(Round k) {
		double rasst = Math.sqrt(Math.abs(this.x - x) * Math.abs(this.x - x) + Math.abs(this.y - y) * Math.abs(this.y - y));
		if (rasst < this.r + r) {
			return -1;
		} else if (rasst == Math.abs(this.r - r)) {
			return -2;
		} else if (rasst == 0 && (this.r == r)) {
			return 0;
		} else if (rasst == this.r + r) {
			return 1;
		} else if (rasst > this.r + r) {
			return 2;
		} else {
			return 3;
		}
	}

	public String toString() {
		return "Координаты центра: x: " + this.x + ";  " + "y: " + this.y + ";  " + "Радиус: " + this.r;
	}

}












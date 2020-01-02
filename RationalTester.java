public class RationalTester{
	public static void main(String args[]) {
		Rational trial = new Rational(5,6);
		try {
			Rational test = new Rational(6, 0);
			System.out.println(test);
		}
		catch(illegalDenomenatorException e) {
			System.out.println("Can't set a denomenator to zero");
		}
		Rational one = new Rational(5,5);
		Rational other = new Rational(6,7);
		Rational tricky = new Rational(0,6);
		System.out.println(trial);
		System.out.println(other);
		System.out.println(one.decimalValue());
		System.out.println(trial.divideBy(other));
		System.out.println(trial.times(other));
		System.out.println(trial.pow(3));
		System.out.println(other.decimalValue());
		System.out.println(trial.plus(other));
		System.out.println(trial.minus(other));
		System.out.println(other.minus(trial));
		System.out.println(trial.reciprocal());
		try {
			System.out.println(tricky.reciprocal());
		}
		catch(illegalDenomenatorException e) {
			System.out.println("catching IllegalDenominatorException - it works!!!!");
		}
	}

}
class Rational{
	private int numerator;
	private int denomenator;
	public Rational(int n, int d) {
		if(d == 0)throw new illegalDenomenatorException();
		denomenator = d;
		numerator = n;
	}
	public Rational(){
		numerator = 0;
		denomenator = 1;
	}
	public Rational(int n) {
		numerator = n;
		denomenator = 1;
	}

	public int getNumerator() {
		return numerator;
	}
	public int getDenomenator() {
		return denomenator;
	}
	public void setDenomenator (int d){
		if(d == 0) throw new illegalDenomenatorException();
		denomenator = d;
	}
	public void setNumerator(int n) {
		numerator = n;
	}
	public double decimalValue() {
		if(denomenator == 0) throw new illegalDenomenatorException();
		double decimal = (double) (this.numerator)/(double) (this.denomenator);
		return  decimal;
	}
	public String toString() {
		return this.numerator + "/" + this.denomenator;
	}

	public Rational plus(Rational other) {
		if(this.denomenator == other.denomenator) {
			Rational plus = new Rational(this.numerator + other.numerator, this.denomenator);
			return  plus;
		}
		else {
			int new_denomenator = this.denomenator*other.denomenator;
			int first_numerator = this.numerator*other.denomenator;
			int second_numerator = other.numerator*this.denomenator;
			int new_numerator = first_numerator + second_numerator;
			Rational plus = new Rational(new_numerator, new_denomenator);
			return  plus;
		}

	}

	public Rational minus(Rational other) {
		if(this.denomenator == other.denomenator) {
			Rational minus = new Rational(this.numerator - other.numerator, this.denomenator);
			return  minus;
		}
		else {
			int new_denomenator = this.denomenator*other.denomenator;
			int first_numerator = this.numerator*other.denomenator;
			int second_numerator = other.numerator*this.denomenator;
			int new_numerator = first_numerator - second_numerator;
			Rational minus = new Rational(new_numerator, new_denomenator);
			return minus;
		}
	}
	public Rational times(Rational other) {
		 Rational times = new Rational((this.numerator*other.numerator), this.denomenator*other.denomenator);
		 return  times;
	}
	public Rational divideBy(Rational other) {
		Rational divide = new Rational(this.numerator*other.denomenator, this.denomenator*other.numerator);
		return divide;
	}
	public Rational pow(int x) {
		Rational pow = new Rational(this.numerator, this.denomenator);
		for(int i = 1;i < x; i++) {
			pow.numerator *= this.numerator;
			pow.denomenator *= this.denomenator;
		}
		return  pow;
	}
	public boolean equals(Rational other) {
		if((this.numerator == other.numerator) && (this.denomenator == other.denomenator)) return true;
		return false;
	}
	public Rational reciprocal(){
		if(this.numerator == 0) throw new illegalDenomenatorException();
		Rational reciprocal = new Rational(this.denomenator, this.numerator);
		return reciprocal;
	}
}
class illegalDenomenatorException extends RuntimeException {
	public illegalDenomenatorException() {
		super("Denominator cannot be zero");
	}
}

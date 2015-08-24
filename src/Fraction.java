/**
 * Fraction class
 * represents fractions, reduced to lowest terms
 * able to manipulate two fractions (add, subtract, multiply, divide)
 * able to compare two fractions and check if they are equal
 * able to find reciprocal
 * 
 * @author Allison
 * created: 8/18/15
 * last modified: 8/23/15 
 */

public class Fraction {
	
	private int numerator;
	private int denominator;
	// how to deal with negative numbers?
	
    /** our Constructor
     * @param n the numerator
     * @param d the denomintor
     */
	
	public Fraction(int n, int d) {
		this.numerator = n;
		this.denominator = d;
	}
	
    // methods
	
	/** get methods
	 * should be immutable so no set methods
	 * @return current numerator and denominator
	 */
	
	public int getNumerator() {
		return this.numerator;
	}
	
	public int getDenominator() {
		return this.denominator;
	}
	
	/** 
	 * findGcd method calculates greatest common denominator between the numerator and denominator
	 * uses Euclid's algorithm to find GCD
	 * @param numerator 
	 * @param denominator
	 * @return a Fraction object in lowest terms
	 */
	
	//private?
	public int findGcd(int n, int d) {
		// variables necessary?
		int num1 = n;
		int num2 = d;
		
		while (num2 != 0) {
			int temp = num2;
			num2 = num1%num2;
			num1 = temp;
		}
		return num1;
	}
	
	/**
	 * reduce method reduces the Fraction into lowest terms using the findGcd method
	 * @return a Fraction object in lowest terms
	 */
	public Fraction reduce() {
		int gcd = findGcd(this);
		
		int n = this.numerator/gcd;
		int d = this.denominator/gcd;
		
		Fraction f = new Fraction(n,d);
		return f;
	}
	
	/**
	 * getReciprocal method
	 * returns reciprocal of fraction
	 * @return Fraction object with denominator and numerator switched
	 */
	
	public Fraction getReciprocal() {
		return new Fraction(denominator, numerator);
	}
	
	// basic operations for 2 fractions
	
	/**
	 * add method finds the sum of two fractions 
	 * @param f2 second fraction being added
	 * @return the sum of two fractions in lowest terms
	 */
	
	public Fraction add(Fraction f2) {
		Fraction sum = new Fraction();
		
		//cross multiply
		this.numerator *= f2.getDenominator();
		this.denominator *= f2.getDenominator();
		f2.getDenominator() *= this.denominator;
		f2.getNumerator() *= this.denominator;
		
		sum.numerator = this.numerator+f2.getNumerator();
		sum.denominator = this.denominator*f2.getDenominator();
		
		sum.reduce();
		return sum;
		*/
	}
	
	/**
	 * subtract method finds the difference between two fractions
	 * @param f2 second method being subtracted to or from
	 * @return the difference between two fractions in lowest terms
	 */
	
	public Fraction subtract(Fraction f2) {
		Fraction difference = new Fraction();
		
		this.numerator *= f2.getDenominator();
		this.denominator *= f2.getDenominator();
		f2.getDenominator() *= this.denominator;
		f2.getNumerator() *= this.denominator;
		
		difference.numerator = this.numerator - f2.getNumerator();
		difference.denominator = this.denominator + f2.getDenominator();
		
		difference.reduce();
		return difference;
	}
	
	/**
	 * multiply method finds the product of two fractions
	 * @param f2 second fraction being multiplied
	 * @return the product of two fractions in lowest terms
	 */
	
	public Fraction multiply(Fraction f2) {
		Fraction product = new Fraction();
		product.numerator = this.numerator*f2.getNumerator();
		product.denominator = this.denominator*f2.getDenominator();
		
		product.reduce();
		return product;
	}
	
	/**
	 * divide method finds the quotient of two fractions
	 * @param f2 second fraction being divided
	 * @return the quotient of two fractions in lowest terms
	 */
	public Fraction divide(Fraction f2) {
		Fraction quotient = new Fraction();
		Fraction f2Reciprocal = new Fraction();
		f2Reciprocal = f2.getReciprocal();
		
		quotient.numerator = this.numerator*f2Reciprocal.getDenominator();
		quotient.denominator = this.denominator*f2Reciprocal.getNumerator();
		
		quotient.reduce();
		return quotient;
	}
	
	/**
	 * equals method
	 * compares two fractions and sees if they are equal
	 * @param f2 other fraction
	 * @return true if both fractions are equal
	 */
	
	public boolean equals(Fraction f2) {
		return (this.numerator==f2.numerator) && (this.denominator==f2.denominator);
	}
	
	/**
	 * toString method
	 * converts fraction to a string
	 */
	
	public String toString() {
		String str = "Your fraction: " + numerator +"/"+ denominator;
	}
	
}

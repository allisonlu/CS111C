/**
 * Fraction class
 * represents fractions, reduced to lowest terms
 * able to manipulate two fractions (add, subtract, multiply, divide)
 * able to compare two fractions and check if they are equal
 * able to find reciprocal
 * 
 * @author Allison
 * created: 8/18/15
 * last modified: 
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
	
	// reduce (private?? return type??)
	/** first using Euclid's algorithm to find GCD
	 * @param numerator 
	 * @param denominator
	 * @return a fraction in lowest terms
	 */
	
	// needs editing
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
	
	public Fraction reduce() {
		int gcd = findGcd(this);
		
		int n = this.numerator/gcd;
		int d = this.denominator/gcd;
		
		Fraction f = new Fration(n,d);
		return f;
	}
	
	// basic operations for 2 fractions
	public Fraction add(Fraction f2) {
		Fraction sum = new Fraction();
		sum.numerator = this.numerator*f2.denominator;
		sum.denominator = this.denominator*f2.denominator;
		
		sum.reduce();
		return sum;
	}
	
	public Fraction subtract(Fraction f2) {
		Fraction difference = new Fraction();
		difference.numerator = this.numerator*f2.denominator;
		difference.denominator = this.denominator*f2.denominator;
		
		difference.reduce();
		return difference;
	}
	
	public Fraction multiply(Fraction f2) {
		int newNum = this.getNumerator()*f2.getNumerator();
		int newDenom = this.getDenominator()*f2.getDenominator();
		
		Fraction f5 = new Fraction(n3, d3);
		return f5;
	}
	
	public Fraction divide(Fraction f2) {
		
	}
	
	// find reciprocal
	
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

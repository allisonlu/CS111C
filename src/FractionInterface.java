/**
 * interface for Fraction class
 * 
 * @author Allison
 * created: 8/23/15
 * last modified: 8/23/15
 */
public interface FractionInterface {
	public Fraction add(Fraction f);
	public Fraction subtract(Fraction f);
	public Fraction multiply(Fraction f);
	public Fraction divide(Fraction f);
	public boolean equals(Fraction f);
	public Fraction getReciprocal();
}

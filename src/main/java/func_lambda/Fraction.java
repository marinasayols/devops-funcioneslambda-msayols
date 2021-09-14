package func_lambda;

import java.util.Objects;

/**
 * Conceptos: Las fracciones propias son aquellas cuyo numerador es menor que el denominador
 * <p>
 * Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador
 * <p>
 * Dos fracciones son equivalentes cuando el producto de extremos (numerador de la primera
 * por denominador de la segunda) es igual al
 * producto de medios (denominador de la primera por el numerador de la segunda)
 * <p>
 * Las fracciones irreducibles son aquellas que no se pueden simplificar, esto sucede
 * cuando el numerador y el denominador son primos entre
 * sí
 * <p>
 * Reducir varias fracciones a común denominador consiste en convertirlas en
 * otras equivalentes que tengan el mismo denominador
 * <p>
 * Comparar fracciones
 * <p>
 * Suma fracciones: En primer lugar se reducen los denominadores a
 * común denominador, y se suman o se restan los numeradores de las
 * fracciones equivalentes obtenidas
 * <p>
 * Multiplicación: La multiplicación de dos fracciones es otra fracción que tiene:
 * Por numerador el producto de los numeradores. Por
 * denominador el producto de los denominadores.
 * <p>
 * La división de dos fracciones es otra fracción que tiene: Por numerador
 * el producto de los extremos. Por denominador el producto de los
 * medios. Invertir fraccion
 */

public class Fraction {

    private int numerator;

    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return this.numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) this.numerator / this.denominator;
    }

    public boolean isProper() {
        return this.numerator < this.denominator;
    }

    int calculateGDC(int numerator, int denominator) {
        if (numerator % denominator == 0) {
            return denominator;
        } else {
            return calculateGDC(denominator, numerator % denominator);
        }
    }

    void reduce() {
        int gdc = calculateGDC(this.numerator, this.denominator);
        this.numerator /= gdc;
        this.denominator /= gdc;
    }

    public Fraction division(Fraction f2) {
        return new Fraction(
                (int) this.numerator * f2.getDenominator(),
                (int) this.denominator * f2.getNumerator());
    }

    public Fraction multiplication(Fraction f2) {
        return new Fraction(
                (int) this.numerator * f2.getNumerator(),
                (int) this.denominator * f2.getDenominator());
    }

    public Fraction addition(Fraction f2) {
        int n = (this.numerator * f2.getDenominator()) +
                (this.denominator * f2.getNumerator());
        int d = this.denominator * f2.getDenominator();
        return new Fraction(n, d);
    }

    public Fraction subtraction(Fraction f2) {
        int n = (this.numerator * f2.getDenominator()) -
                (this.denominator * f2.getNumerator());
        int d = this.denominator * f2.getDenominator();
        return new Fraction(n, d);
    }

    public boolean isNegative() {
        return this.numerator < 0 || this.denominator < 0;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}

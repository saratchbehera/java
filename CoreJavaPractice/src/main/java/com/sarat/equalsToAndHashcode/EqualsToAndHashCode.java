package com.sarat.equalsToAndHashcode;

import java.util.Objects;

class Abc {

    private double re, im;

    public Abc(double re, double im) {
        this.re = re;
        this.im = im;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abc abc = (Abc) o;
        return Double.compare(abc.re, re) == 0 &&
                Double.compare(abc.im, im) == 0;
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
}

public class EqualsToAndHashCode {

    public static void main(String[] args) {
        Abc c1 = new Abc(10, 15);
        Abc c2 = new Abc(10, 15);
        System.out.println("1st object hashcode :: "+ c1.hashCode());
        System.out.println("2nd object hashcode :: "+ c2.hashCode());

        if (c1.equals(c2)) {
            System.out.println("Equal ");
        } else {
            System.out.println("Not Equal ");
        }
    }

}

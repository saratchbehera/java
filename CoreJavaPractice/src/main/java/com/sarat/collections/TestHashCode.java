package com.sarat.collections;

import java.util.HashSet;
import java.util.Set;

public class TestHashCode {

    public static void main(String[] args) {

        Set<ABC> set = new HashSet<>();
        ABC abc=new ABC("S");
        System.out.println(abc.hashCode());
        ABC abcd=new ABC("A");
        System.out.println(abcd.hashCode());

        set.add(abc);
        set.add(abcd);
        ABC abcs=new ABC("S");
        set.add(abcd);
        System.out.println(set);

    }

    static final int hash(Object key) {
        System.out.println(key.hashCode()^(key.hashCode() >>> 16));
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}

class ABC{
    String a;

    public ABC(String a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "ABC{" +
                "a='" + a + '\'' + " hashCode="+this.hashCode()+
                '}';
    }
}

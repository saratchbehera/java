package com.sarat.collections;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestEqualsAndHaseCodeInHashMap {

    Map<Integer, AA> map = new HashMap<>();


}

class AA {
    int id;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AA aa = (AA) o;
        return id == aa.id &&
                Objects.equals(name, aa.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AA(int id, String name) {
        this.id = id;
        this.name = name;
    }


}

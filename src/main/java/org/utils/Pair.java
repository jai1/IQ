package org.utils;

public class Pair<T extends Comparable<T>> {
    T first;
    T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Pair)) {
            return false;
        }

        Pair<T> other = (Pair<T>) o;
        return other != null && first.compareTo(other.first) == 0 && second.compareTo(other.second) == 0;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

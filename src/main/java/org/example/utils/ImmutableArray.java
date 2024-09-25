package org.example.utils;

public final class ImmutableArray<T> {
    private final T[] array;

    public ImmutableArray(T[] array) {
        this.array = array.clone();
    }

    public T get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }
}

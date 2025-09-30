package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MULTIPLIER = 2;
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public MateStack() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newArray = (T[]) new Object[array.length * MULTIPLIER];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void push(T value) {
        if (size == array.length) {
            resize();
        }
        array[size++] = value;
    }

    public T peek() {
        if (size > 0) {
            return array[size - 1];
        } else {
            throw new EmptyStackException();
        }
    }

    public T pop() {
        if (size > 0) {
            T value = array[--size];
            array[size] = null;
            return value;
        } else {
            throw new EmptyStackException();
        }
    }

    public int size() {
        return size;
    }
}

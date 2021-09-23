package ArrayList;

import java.util.Iterator;

public class ArrayList<T> implements Iterable<T> {

    private int len = 0;
    private int capacity = 0;
    private T[] arr;

    public ArrayList() {
        this(16);
    }

    public ArrayList(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return this.len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T elem) {
        arr[index] = elem;
    }

    public void clear(){
        for(int i =0;i<arr.length;i++){
            arr[i] = null;
        }
        len = 0;
    }

    public void add(T elem) {

        if (len - 1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else {
                capacity *= 2;
            }
            T newArr[] = (T[]) new Object[capacity];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[len+1]= elem;
        len++;
    }

    public void remove(int index){
        arr[index] = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public T next() {
                index++;
                return arr[index];
            }
        };
    }
}


public class MyArrayList<T> implements MyList<T> {
    private T[] arr;
    private int size;

    public MyArrayList() {
        arr = (T[]) new Object[5];
        size = 0;
    }
    @Override
    public void addElement(T data) {
        //some pretty code goes here
    }

    public void addLast(T data) {
        if (size == arr.length) {
            return;
        }
        arr[size++] = data;
    }

    public T getLast() {
        if (size == 0) {
            return null; // or throw an exception
        }
        return (T) arr[size - 1];
    }

    public void addFirst(T data) {
        add(0, data);
    }


    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null; // Clear the reference to the last element
        size--; // Decrement the size
    }

    public void removeLast() {
        if (size == 0) {
            return; // or throw an exception
        }
        arr[size - 1] = null;
        size--;
    }

    public int size() {
        return size;
    }

    public T getFirst() {
        if (size == 0) {
            return null; // or throw an exception
        }
        return arr[0];
    }

    public void removeFirst() {
        if (size == 0) {
            return; // or throw an exception
        }
        // Shift all elements to the left to remove the first element
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null; // clear the reference to the last element
        size--; // decrement the size
    }

    public void printLst() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public void add(int i, T data) {
        if (size < arr.length) {
            arr[size++] = data;
        }
    }


    public void set(int index, T data) {// Check if the index is out of bounds
        if (index < 0 || index >= size) {
            return; // perform any other action as needed
        }
        arr[index] = data; // the element at the specified index
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null; // throw an exception, depending on your requirements
        }
        return arr[index]; // return the element at the specified index

    }
    public void clear() {
        arr = (T[]) new Object[5];
        size = 0;
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == object) {
                return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] == object) {
                return i;
            }
        }

        return -1;
    }
    public Object[] toArray() {
        Object[] newarr = new Object[size];

        for (int i = 0; i < size; i++) {
            newarr[i] = arr[i];
        }

        return newarr;
    }

    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == object) {
                return true;
            }
        }
        return false;
    }

    public void sort() {
        T t;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable)arr[j]).compareTo(arr[j + 1]) > 0) {
                    t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }
}


public class MyStack<T> {

    private MyArrayList<T> arr;

    public MyStack() {
        arr = new MyArrayList<>();
    }

    public void push(T data) {
        arr.addLast(data); // Adding an element to the end of the list
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        T last = arr.getLast();
        arr.removeLast();
        return last;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return arr.getLast();
    }

    public boolean isEmpty() {
        return arr.size()==0;
    }
}
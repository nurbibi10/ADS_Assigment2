public class MyQueue<T>{
    private MyArrayList<T> arr;

    public MyQueue() {
        arr = new MyArrayList<>();
    }

    public void enQueue(T data) {
        arr.addLast(data);
    }

    public T deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        T first = arr.getFirst();
        arr.removeFirst();
        return first;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return arr.getFirst();
    }

    public boolean isEmpty() {
        return arr.size() == 0;
    }
}
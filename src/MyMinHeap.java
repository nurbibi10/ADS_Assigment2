public class MyMinHeap<T> {
    private MyArrayList<T> arr;

    public MyMinHeap() {
        arr = new MyArrayList<>();
    }

    public boolean isEmpty() {
        return arr.size() == 0;
    }

    public T getMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return arr.getFirst();
    }

    public T extractMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        T min = arr.getFirst();
        arr.set(0, arr.getLast());
        arr.removeLast();

        if (arr.size() != 0) {
            heapify(0);
        }

        return min;
    }

    public void insert(T data) {
        arr.add(0, data);
        traverseUp(arr.size() - 1);
    }

    public void printLst() {
        arr.printLst();
    }

    private void heapify(int index) {
        checkIndex(index);
        int rightIndex = rightChildOf(index);
        int leftIndex = leftChildOf(index);
        int minIndex = index;

        if (rightIndex < arr.size() && ((Comparable)arr.get(rightIndex)).compareTo(arr.get(minIndex)) < 0) {
            minIndex = rightIndex;
        }

        if (leftIndex < arr.size() && ((Comparable)arr.get(leftIndex)).compareTo(arr.get(minIndex)) < 0) {
            minIndex = leftIndex;
        }

        if (minIndex != index) {
            swap(index, minIndex);
            heapify(minIndex);
        }
    }

    private void traverseUp(int index) {
        checkIndex(index);
        int parentIndex = parentOf(index);

        while (index > 0 && ((Comparable)arr.get(index)).compareTo(arr.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = parentOf(index);
        }
    }

    private int leftChildOf(int index) {
        return 2 * index + 1;
    }

    private int rightChildOf(int index) {
        return 2 * index + 2;
    }

    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        T temp = arr.get(index2);
        arr.set(index2, arr.get(index1));
        arr.set(index1, temp);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= arr.size()) {
            throw new NoSuchElementException("Index is not correct");
        }
    }


}

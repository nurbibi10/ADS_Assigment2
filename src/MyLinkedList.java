import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void addElement(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
        }
        else {
            Node<T> currentNode = head;
            while (currentNode.next != null) currentNode = currentNode.next;
            currentNode.next = newNode;
        }
        size++;
    }
    public void add(T data) {
        addLast(data);
    }
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node<T> newNode = new Node<>(item);
            Node<T> current = getNodeAtIndex(index - 1);
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    private Node<T> getNodeAtIndex(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    private boolean isEmpty() {
        return size == 0;
    }
    public void set(int index, T item) {
        checkIndex(index);
        Node<T> current = getNodeAtIndex(index);
        current.data = item;
    }

    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        Node<T> current = getNodeAtIndex(index);
        return current.data;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.data;
    }

    private boolean checkIndex(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        return true;
    }

    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            head = head.next;
        }
        else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<T> current = getNodeAtIndex(size - 2);
            current.next = null;
            tail = current;
        }
        size--;
    }

    public void sort() {
        // Implement sorting logic if needed
    }

    public int indexOf(Object object) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        Node<T> current = head;
        int lastIndex = -1;
        int index = 0;
        while (current != null) {
            if (current.data.equals(object)) {
                lastIndex = index;
            }
            current = current.next;
            index++;
        }
        return lastIndex;
    }

    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }


}

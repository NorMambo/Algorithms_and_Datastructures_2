package Task1;

public class Node<T> {

    // ATTRIBUTES
    private Node next;
    private Node prev;
    private final T data;

    // CONSTRUCTOR
    public Node(T data) {
        this.next = null;
        this.prev = null;
        this.data = data;
    }

    // METHODS
    public void setNext(Node node) {
        this.next = node;
    }

    public void setPrev(Node node) {
        this.prev = node;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getPrev() {
        return this.prev;
    }

    public T getData() {
        return data;
    }
}

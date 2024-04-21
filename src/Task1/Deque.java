package Task1;

import java.util.NoSuchElementException;

public class Deque implements Iterable<Node>{

    // ATTRIBUTES
    private Node front;
    private Node back;
    private int count;

    // CONSTRUCTOR
    public Deque() {
        this.front = null;
        this.back = null;
        this.count = 0;
    }

    // METHODS
    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void addFirst(Node node) {
        if (this.count == 0) {
            this.front = node;
            this.back = node;
        } else {
            node.setNext(this.front);
            this.front.setPrev(node);
            this.front = node;
        }
        this.count++;
    }

    public void addLast(Node node) {
        if (this.count == 0) {
            this.front = node;
        } else {
            node.setPrev(this.back);
            this.back.setNext(node);
        }
        this.back = node;
        this.count++;
    }

    public Node removeFirst() {
        if (this.size() == 1) {
            Node tmp = this.front;
            this.front = null;
            this.back = null;
            count--;
            return tmp;
        } else if (this.size() > 1) {
            Node tmp = this.front;
            this.front = this.front.getNext();
            this.front.setPrev(null);
            count--;
            return tmp;
        } else {
//            System.out.println("Can't remove more, Deque size is " + this.size() + "\n");
            throw new Error("Can't remove more, Deque size is " + this.size() + "\n");
        }
    }

    public Node removeLast() {
        if (this.size() == 1) {
            Node tmp = this.back;
            this.front = null;
            this.back = null;
            count--;
            return tmp;
        } else if (this.size() > 1){
            Node tmp = this.back;
            this.back = this.back.getPrev();
            this.back.setNext(null);
            count--;
            return tmp;
        } else {
//            System.out.println("Can't remove more, Deque size is " + this.size() + "\n");
            throw new Error("Can't remove more, Deque size is " + this.size() + "\n");
        }
    }

    public Node getFront() {
        return this.front;
    }

    public Node getBack() {
        return this.back;
    }

    @Override
    public java.util.Iterator iterator() {
        return new Iterator();
    }

    private class Iterator implements java.util.Iterator<Node> {

        private Node nextNode = front;
        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public Node next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node node = nextNode;
            nextNode = nextNode.getNext();
            return node;
        }
    }

    public void printDequeInfo() {

        Node i = this.front;
        String noNode = "null";

        while(i != null) {

            if (i.getPrev() == null && i.getNext() == null) {
                System.out.println("Data: " + i.getData() + " - Prev Data: " + noNode + " - Next Data: " + noNode);
                i = i.getNext();

            } else if (i.getPrev() == null) {
                System.out.println("Data: " + i.getData() + " - Prev Data: " + noNode + " - Next Data: " + i.getNext().getData());
                i = i.getNext();

            } else if (i.getNext() == null) {
                System.out.println("Data: " + i.getData() + " - Prev Data: " + i.getPrev().getData() + " - Next Data:: " + noNode);
                i = i.getNext();

            } else {
                System.out.println("Data: " + i.getData() + " - Prev Data: " + i.getPrev().getData() + " - Next Data:: " + i.getNext().getData());
                i = i.getNext();
            }
        }

        if (!isEmpty()) {
            System.out.println("\nFIRST IN DEQUE: " + getFront().getData());
            System.out.println("LAST IN DEQUE: " + getBack().getData());
        }
        System.out.println("\nDEQUE IS EMPTY: " + isEmpty());
        System.out.println("DEQUE SIZE: " + size());
        System.out.println("\n\n----------------------------------");
    }
}

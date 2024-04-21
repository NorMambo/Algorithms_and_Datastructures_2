package Task1;

public class Test {
    public static void main(String[] args) {
        //TEST
        Deque deque = new Deque();
        System.out.println("\nTEST:\n");

        deque.printDequeInfo();
        System.out.println("ADD FIRST\n");
        deque.addFirst(new Node(1));
        deque.printDequeInfo();

        System.out.println("ADD LAST\n");
        deque.addLast(new Node("QQQ"));
        deque.printDequeInfo();

        System.out.println("ADD FIRST\n");
        deque.addFirst(new Node(0.201));
        deque.printDequeInfo();

        System.out.println("ADD LAST\n");
        deque.addLast(new Node(30));
        deque.printDequeInfo();

        System.out.println("ADD FIRST\n");
        deque.addFirst(new Node("hello"));
        deque.printDequeInfo();

        System.out.println("ADD LAST\n");
        deque.addLast(new Node('h'));
        deque.printDequeInfo();

        System.out.println("REMOVE FIRST\n");
        Node n1 = deque.removeFirst();
        System.out.println("REMOVED DATA: " + n1.getData());
        deque.printDequeInfo();

        System.out.println("REMOVE LAST\n");
        Node n2 = deque.removeLast();
        System.out.println("REMOVED DATA: " + n2.getData());
        deque.printDequeInfo();

        System.out.println("REMOVE FIRST\n");
        Node n3 = deque.removeFirst();
        System.out.println("REMOVED DATA: " + n3.getData());
        deque.printDequeInfo();

        System.out.println("REMOVE LAST\n");
        Node n4 = deque.removeLast();
        System.out.println("REMOVED DATA: " + n4.getData());
        deque.printDequeInfo();

        System.out.println("REMOVE FIRST\n");
        Node n5 = deque.removeFirst();
        System.out.println("REMOVED DATA: " + n5.getData());
        deque.printDequeInfo();

        System.out.println("REMOVE LAST\n");
        Node n6 = deque.removeLast();
        System.out.println("REMOVED DATA: " + n6.getData());
        deque.printDequeInfo();

        // UNCOMMENT TO CRASH WITH EXCEPTION FOR REMOVING FROM THE EMPTY DEQUE
//        System.out.println("REMOVE FIRST\n");
//        Node n7 = deque.removeFirst();
//        System.out.println("REMOVED DATA: " + n7.getData());
//        deque.printDequeInfo();

        System.out.println("TEST ITERATOR:\n");
        System.out.println("ADDING 6 NODES TO DEQUE:\n");

        deque.addFirst(new Node('c'));
        deque.addFirst(new Node("HELLO"));
        deque.addFirst(new Node(7));
        deque.addFirst(new Node(99));
        deque.addFirst(new Node(0.99999));
        deque.addFirst(new Node(11));
        deque.printDequeInfo();

        for (Node node : deque) {
            System.out.println(node.getData());
        }
    }
}

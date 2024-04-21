package Task4;

public class Test {
    public static void main(String[] args) throws Exception {
        BSTree BSTree = new BSTree(2);
        BSTree.add(1);
        BSTree.add(7);
        BSTree.add(5);
        BSTree.add(12);
        BSTree.add(6);
        BSTree.add(3);
        BSTree.add(4);
        BSTree.add(9);
        BSTree.add(14);
        BSTree.add(8);
        BSTree.add(10);
        System.out.println("\nORIGINAL TREE");
        BSTree.walk();
        System.out.println();

        System.out.println("\n---------- HEIGHT 2 ----------\n");
        System.out.println(BSTree.height(2));
        System.out.println("\n---------- HEIGHT 4 ----------\n");
        System.out.println(BSTree.height(4));
        System.out.println("\n--------- SIZE ---------\n");
        System.out.println(BSTree.size());

        System.out.println("\n---------- TEST CONTAINS ----------\n");
        System.out.println("3\t" + BSTree.contains(3));
        System.out.println("4\t" + BSTree.contains(4));
        System.out.println("2\t" + BSTree.contains(2));
        System.out.println("7\t" + BSTree.contains(7));
        System.out.println("6\t" + BSTree.contains(6));
        System.out.println("4\t" + BSTree.contains(4));
        System.out.println("5\t" + BSTree.contains(5));
        System.out.println("12\t" + BSTree.contains(12));
        System.out.println("9\t" + BSTree.contains(9));
        System.out.println("8\t" + BSTree.contains(8));
        System.out.println("10\t" + BSTree.contains(10));
        System.out.println("14\t" + BSTree.contains(14));
        System.out.println("11\t" + BSTree.contains(11));
        System.out.println("-1\t" + BSTree.contains(-1));

        System.out.println("\n---------- REMOVE 2 ----------");
        BSTree.remove(2);
        System.out.println("\nMODIFIED TREE");
        BSTree.walk();
        System.out.println(BSTree.contains(2));
        System.out.println("\nCONTAINS 2: " + BSTree.contains(2));

        System.out.println("\n---------- REMOVE 5 ----------");
        BSTree.remove(5);
        System.out.println("\nMODIFIED TREE");
        BSTree.walk();
        System.out.println("\nCONTAINS 5: " + BSTree.contains(5));

        System.out.println("\n--------- HEIGHT 5 ---------\n");
        System.out.println(BSTree.height(5));
        System.out.println("\n--------- HEIGHT 2 ---------\n");
        System.out.println(BSTree.height(2));
        System.out.println("\n--------- HEIGHT 9 ---------\n");
        System.out.println(BSTree.height(9));
        System.out.println("\n--------- HEIGHT 12 ---------\n");
        System.out.println(BSTree.height(12));
        System.out.println("\n--------- HEIGHT 4 ---------\n");
        System.out.println(BSTree.height(4));

        System.out.println("\n--------- SIZE ---------\n");
        System.out.println(BSTree.size());
//
        System.out.println("\n--------- ITERATE ---------\n");

//         TEST WITH TREE FROM SLIDES (for the iterators)
//        BinarySearchTree BST2 = new BinarySearchTree();
//
//        BST2.root = new Node(0);
//        BST2.root.left = new Node(1);
//        BST2.root.left.left = new Node(3);
//        BST2.root.left.right = new Node(4);
//
//        BST2.root.right = new Node(2);
//        BST2.root.right.left = new Node(5);
//        BST2.root.right.right = new Node(6);


        System.out.println("\nITERATE:");
        for (BSTNode i : BSTree) {
            System.out.println(i.val);
        }

        int kthLargest = 2;
        System.out.println("\nREMOVE: " + kthLargest + "th Largest value:");
        BSTree.removeKthLargest(kthLargest);

        System.out.println("\nITERATE:");
        for (BSTNode i : BSTree) {
            System.out.println(i.val);
        }
        System.out.println("\nCONTAINS 12: " + BSTree.contains(12));

        BSTree b = new BSTree();
        for (BSTNode n : b) {
            System.out.println(n.val);
        }
    }
}

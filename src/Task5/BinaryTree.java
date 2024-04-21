package Task5;

public class BinaryTree {
    BinaryTreeNode root;

    public BinaryTree(){}

    public BinaryTree(int val){
        root = new BinaryTreeNode(val);
    }

    // USED TO COMPARE THIS TREE WITH ANOTHER TREE.
    public boolean isIsomorphic(BinaryTree tree2) {
        return _isIsomorphic(root, tree2.root);
    }

    // HELPER METHOD.
    // CHECK IF 2 NODES OF 2 DIFFERENT TREES ARE ISOMORPHIC.
    // IF THEY HAVE THE SAME VALUE THE NODES ARE ISOMORPHIC SO RECURSIVELY CHECK THE NODES OF THE NEXT LEVEL.
    public boolean _isIsomorphic(BinaryTreeNode current1, BinaryTreeNode current2) {

        // BOTH ARE NULL -> ISOMORPHIC
        if (current1 == null && current2 == null)
            return true;
        // ONE IS NULL THE OTHER ISN'T -> NOT ISOMORPHIC
        if (current1 == null || current2 == null)
            return false;
        // THEY DON'T HAVE THE SAME VALUE -> NOT ISOMORPHIC
        if (current1.val != current2.val)
            return false;
        // THE NODES ARE ISOMORPHIC -> CHECK THE NEXT LEVEL NODES
        return (_isIsomorphic(current1.left,current2.left) && _isIsomorphic(current1.right, current2.right)
                || _isIsomorphic(current1.left, current2.right) && _isIsomorphic(current1.right, current2.left));
    }


    public static void main(String[] args) {

        BinaryTree one = new BinaryTree(0);
        BinaryTree two = new BinaryTree(0);

        one.root.right = new BinaryTreeNode(2);
        two.root.right = new BinaryTreeNode(1);

        one.root.left = new BinaryTreeNode(1);
        two.root.left = new BinaryTreeNode(2);

        one.root.right.right = new BinaryTreeNode(10);
        two.root.left.left = new BinaryTreeNode(10);

        // TRUE
        System.out.println(one.isIsomorphic(two));

        // ADD ELEMENT THAT REMOVES THE ISOMORPHIC PROPERTY
        one.root.right.right.right = new BinaryTreeNode(1000);

        // NOW FALSE
        System.out.println(one.isIsomorphic(two));
    }
}

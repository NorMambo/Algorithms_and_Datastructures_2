package Task6;

public class AVLTree {
    AVLNode root;

    public AVLTree() {
        root = null;
    }

    public AVLTree(int val) {
        root = new AVLNode(val);
    }

    public void add(int val) {
        root = _add(root, val);
    }

    public AVLNode _add(AVLNode n, int val) {

        if (n == null)
            return new AVLNode(val);

        if (n.val > val)
            n.left = _add(n.left, val);
        else if (n.val < val)
            n.right = _add(n.right, val);

        return _balance(n);
    }

    public AVLNode _balance(AVLNode n) {
        if (n == null)
            return n;
        if (_height(n.left) - _height(n.right) > 1) {
            if (_height(n.left.left) >= _height(n.left.right))
                n = _rotate_left(n);
            else
            n = _double_left(n);
        } else if (_height(n.right) - _height(n.left) > 1)
            if (_height(n.right.right) >= _height(n.right.left))
                n = _rotate_right(n);
            else
                n = _double_right(n);

        n.height = Math.max(_height(n.left), _height(n.right)) + 1;
        return n;
    }

    public int _height(AVLNode n) {
        if (n == null)
            return -1;
        return n.height;
    }

    public AVLNode _rotate_left(AVLNode r2) {
        AVLNode r1 = r2.left;
        r2.left = r1.right;
        r1.right = r2;
        r2.height = Math.max(_height(r2.left), _height(r2.right)) + 1;
        r1.height = Math.max(_height(r1.left), r2.height) + 1;
        return r1;
    }

    public AVLNode _double_left(AVLNode n) {
        n.left = _rotate_right(n.left);
        return _rotate_left(n);
    }

    public AVLNode _rotate_right(AVLNode r2) {
        AVLNode r1 = r2.right;
        r2.right = r1.left;
        r1.left = r2;
        r2.height = Math.max(_height(r2.left), _height(r2.right)) + 1;
        r1.height = Math.max(_height(r1.left), r2.height) + 1;
        return r1;
    }

    public AVLNode _double_right(AVLNode n) {
        n.right = _rotate_left(n.right);
        return _rotate_right(n);
    }

    public void delete(int val) {
        root = _delete(root, val);
    }
    public AVLNode _delete(AVLNode n, int val) {
        if (n == null)
            return null;

        if (n.val > val)
            n.left = _delete(n.left, val);
        else if (n.val < val)
            n.right = _delete(n.right, val);
        else {
            if (n.right == null)
                return n.left;
            if (n.left == null)
                return n.right;
            n.val = _min(n.right);
            n.right = _delete(n.right, n.val);
        }
        return _balance(n);
    }

    private int _min(AVLNode n) {
        if(n.left == null)
            return n.val;
        else
            return _min(n.left);
    }

    public boolean contains(int val) {
        return _contains(root, val);
    }

    public boolean _contains(AVLNode n, int val) {
        if (n == null)
            return false;
        if (n.val > val)
            return _contains(n.left, val);
        else if (n.val < val)
            return _contains(n.right, val);
        else
            return true;
    }


    public void printPreorder() {
        _preorder(root);
    }
    public void _preorder(AVLNode n) {
        if (n != null) {
            System.out.println("Value: " + n.val);
            System.out.println("Height: " + n.height);
            if (n.left != null)
                System.out.println("Left: " + n.left.val);
            else
                System.out.println("Left: none");
            if (n.right != null)
                System.out.println("Right: " + n.right.val);
            else
                System.out.println("Right: none");
            System.out.println("\n");
            _preorder(n.left);
            _preorder(n.right);
        }
    }

    // TEST THE TREE WITH EXAMPLE FROM SLIDES
    public static void main(String[] args) {
        AVLTree t = new AVLTree();
        t.add(3);
        t.add(2);
        t.printPreorder();
        System.out.println("----");
        t.add(1);
        t.printPreorder();

    }

}

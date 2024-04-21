package Task4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BSTree implements Iterable<BSTNode> {
    public BSTNode root;

    public BSTree(int val) {
        root = new BSTNode((val));
    }

    public BSTree() {}

    public void add(int val) {
        root = _add(val, root);
    }
    private BSTNode _add(int val, BSTNode current) {
        if(current==null)
            return new BSTNode(val);
        if(val > current.val)
            current.right = _add(val, current.right);
        if(val < current.val)
            current.left = _add(val, current.left);
        return current;
    }

    public int height(int val) {
        BSTNode n = root.getNode(val);
        if (n != null)
            return n.height();
        else
            return -1;
    }

    public int size() {
        return root.size(root);
    }

    public void remove(int val) {
        root.remove(val, root);
    }

    public boolean contains(int val) {
        return _contains(root, val);
    }

    public boolean _contains(BSTNode n, int val) {
        if (n == null)
            return false;
        if (n.val > val)
            return _contains(n.left, val);
        else if (n.val < val)
            return _contains(n.right, val);
        else
            return true;
    }
    public void removeKthLargest(int kthLargest) throws Exception {
        root.removeKthLargest(size() - (kthLargest-1), root);
    }

    public void walk() {
        if (root != null)
            root.walk();
        else
            System.out.println("TREE IS EMPTY");
    }

    /*
    UNCOMMENT THE KIND OF ITERATOR YOU WANT TO USE BELOW (AND COMMENT OUT THE OTHER ONES).
     */
    @Override
    public Iterator iterator() {
        return new inOrderIterator(root);
//        return new preOrderIterator(root.firstNode);
//        return new postOrderIterator(root.firstNode);
    }

    private class inOrderIterator implements Iterator {

        Stack<BSTNode> stack;

        public inOrderIterator(BSTNode root) {
            stack = new Stack<>();
            goLeftmost(root);
        }

        public void goLeftmost(BSTNode current) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public BSTNode next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            BSTNode current = stack.pop();

            if (current.right != null) {
                goLeftmost(current.right);
            }
            return current;
        }
    }

    private class preOrderIterator implements Iterator {
        Stack<BSTNode> stack;

        public preOrderIterator(BSTNode root) {
            stack = new Stack<>();
            stack.push(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public BSTNode next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            BSTNode current = stack.peek();
            stack.pop();

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            return current;
        }
    }

    private class postOrderIterator implements Iterator {

        Stack<BSTNode> stack;
        BSTNode current;

        public postOrderIterator(BSTNode root) {
            stack = new Stack<>();
            goLeftmost(root);
        }
        public void goLeftmost(BSTNode current) {
            while(current != null) {
                stack.push(current);
                stack.push(current);
                current = current.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public BSTNode next() {

            if (!hasNext())
                throw new NoSuchElementException();

            while(true) {

                goLeftmost(current);
                current = stack.pop();
                if(hasNext() && stack.peek() == current)
                    current = current.right;
                else {
                    BSTNode n = current;
                    current = null;
                    return n;
                }
            }
        }
    }

}

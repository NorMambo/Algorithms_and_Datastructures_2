package Task4;

import java.util.Stack;

public class BSTNode {
    public int val;
    public BSTNode left;
    public BSTNode right;

    public BSTNode(int val) {
        this.val = val;
    }
    public BSTNode() {}

    public int size(BSTNode BSTNode) {

        if (BSTNode == null) {
            return 0;
        } else {
            return size(BSTNode.left) + 1 + size(BSTNode.right);
        }
    }

    int height() {

        int leftHeight = -1;
        int rightHeight = -1;
        if (left != null) {
            leftHeight = left.height();
        }
        if (right != null) {
            rightHeight = right.height();
        }
        if (leftHeight > rightHeight)
            return (leftHeight +1);
        else
            return (rightHeight+1);
    }

    public BSTNode getNode(int val) {
        BSTNode BSTNode = null;
        if (this.val != val) {
            if (val < this.val && left != null) {
//                if (BSTNode == null)
                BSTNode = left.getNode(val);
            }
            if (val > this.val && right != null) {
                if (BSTNode == null) {
                    BSTNode = right.getNode(val);
                }
            }
        } else {
            BSTNode = this;
        }
        return BSTNode;
    }

    public BSTNode remove(int val, BSTNode current) {

        if (current == null){
            return null;
        }

        if (val < current.val) {
            current.left = remove(val,current.left);

        } else if (val > current.val) {
            current.right = remove(val, current.right);

        } else if(current.left != null && current.right != null) {
            current.val = findMin( current.right ).val;
            current.right = remove( current.val, current.right);

        } else {
            current = (current.left != null) ? current.left : current.right;
        }
        return current;

    }

     private BSTNode findMin(BSTNode BSTNode) {
        if(BSTNode == null)
            return null;
        else if(BSTNode.left == null)
            return BSTNode;
        return findMin( BSTNode.left );
    }

    // FOR ITERATORS AND REMOVE KTH LARGEST
    public void goLeftmost(BSTNode current, Stack stack) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
    }

    public boolean hasNext(Stack stack) {
        return !stack.isEmpty();
    }

    public void removeKthLargest(int kthLargest, BSTNode firstBSTNode) throws Exception {
        BSTNode root = firstBSTNode;
        Stack<BSTNode> stack = new Stack<>();

        BSTNode current = firstBSTNode;
        goLeftmost(current, stack);
        int i = 1;
        while (i != kthLargest+1 && hasNext(stack)) {
            current = stack.pop();

            if (current.right != null) {
                goLeftmost(current.right, stack);
            }
            if (i == kthLargest) {
                System.out.println("About to remove: " + current.val);
                remove(current.val, root);
                return;
            }
            i++;
        }
        throw new Exception("There is no kth largest value");
    }

    public void walk() {
        System.out.println("\nVAL: " + val);
        if (left != null)
            System.out.println("LEFT: " + left.val);
        else
            System.out.println("LEFT: none");
        if (right != null)
            System.out.println("RIGHT: " + right.val);
        else
            System.out.println("RIGHT: none");
        if (left != null) {
            left.walk();
        }
        if (right != null) {
            right.walk();
        }
    }
}

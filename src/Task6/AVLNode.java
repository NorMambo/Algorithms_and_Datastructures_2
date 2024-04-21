package Task6;

public class AVLNode {
    int val;
    AVLNode left;
    AVLNode right;
    int height = 0;

    public AVLNode(int val) {
        this.val = val;
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
}

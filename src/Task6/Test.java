package Task6;

import SupportClasses.Timer;
import Task4.BSTree;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {

        // TREES
        BSTree BST = new BSTree(0);
        AVLTree AVL = new AVLTree(0);

        // TIMER
        Timer t = new Timer();

        // BOUND FOR RANDOM INSERTS/DELETES
        int lowBound = 1;
        int highBound = 1000001;
        int lowBound2 = 1000001;
        int highBound2 = 2000001;
        int lowBound3 = 2000001;
        int highBound3 = 3000001;

        // ARRAYLISTS OF RANDOM INTEGERS
        ArrayList<Integer> addValues1 = new ArrayList<>();
        ArrayList<Integer> addValues2 = new ArrayList<>();
        ArrayList<Integer> addValues3 = new ArrayList<>();
        ArrayList<Integer> removeValues1 = new ArrayList<>();
        ArrayList<Integer> removeValues2 = new ArrayList<>();
        ArrayList<Integer> removeValues3 = new ArrayList<>();


        // CREATE 1.000.000 RANDOM INTEGERS
        for (int j = 0; j < 1000000; j++) {
            int rnd = (int) Math.floor(Math.random() * ((highBound - lowBound) + 1) + lowBound);
            addValues1.add(rnd);
        }

        // CREATE 1.000.000 RANDOM INTEGERS
        for (int j = 0; j < 1000000; j++) {
            int rnd = (int) Math.floor(Math.random() * ((highBound2 - lowBound2) + 1) + lowBound2);
            addValues2.add(rnd);
        }
        // CREATE 1.000.000 RANDOM INTEGERS
        for (int j = 0; j < 1000000; j++) {
            int rnd = (int) Math.floor(Math.random() * ((highBound3 - lowBound3) + 1) + lowBound3);
            addValues3.add(rnd);
        }
        // CREATE 500.000 RANDOM INTEGERS
        for (int j = 0; j < 500000; j++) {
            int rnd = (int) Math.floor(Math.random() * ((highBound - lowBound) + 1) + lowBound);
            removeValues1.add(rnd);
        }
        // CREATE 500.000 RANDOM INTEGERS
        for (int j = 0; j < 500000; j++) {
            int rnd = (int) Math.floor(Math.random() * ((highBound - lowBound) + 1) + lowBound);
            removeValues2.add(rnd);
        }
        // CREATE 500.000 RANDOM INTEGERS
        for (int j = 0; j < 500000; j++) {
            int rnd = (int) Math.floor(Math.random() * ((highBound - lowBound) + 1) + lowBound);
            removeValues3.add(rnd);
        }

        double add1TimeBST;
        double add2TimeBST;
        double add3TimeBST;
        double remove1TimeBST;
        double remove2TimeBST;
        double remove3TimeBST;
        double contains1TimeBST;
        double contains2TimeBST;
        double contains3TimeBST;

        double add1TimeAVL;
        double add2TimeAVL;
        double add3TimeAVL;
        double remove1TimeAVL;
        double remove2TimeAVL;
        double remove3TimeAVL;
        double contains1TimeAVL;
        double contains2TimeAVL;
        double contains3TimeAVL;

        //----------------------- BST -------------------------

        // TIME 1st ADD OPERATION BST
        add1TimeBST = t.timeFunction(() -> {
            // BST ADD AND REMOVE THE RANDOM INTEGERS
            for (int l = 0; l < addValues1.size(); l++) {
                BST.add(addValues1.get(l));
            }
            return null;
        });
        // TIME 1st REMOVE OPERATION BST
        remove1TimeBST = t.timeFunction(() -> {
            for (int l = 0; l < removeValues1.size(); l++) {
                BST.remove(removeValues1.get(l));
            }
            return null;
        });
        // TIME 1st CONTAINS OPERATION BST
        contains1TimeBST = t.timeFunction(() -> {
            for (int l = 0; l < 1000000; l++) {
                BST.contains(l);
            }
            return null;
        });
        int bstHeight1 = BST.height(BST.root.val);
        // TIME 2nd ADD OPERATION BST
        add2TimeBST = t.timeFunction(() -> {
            // BST ADD AND REMOVE THE RANDOM INTEGERS
            for (int l = 0; l < addValues2.size(); l++) {
                BST.add(addValues2.get(l));
            }
            return null;
        });
        // TIME 2nd REMOVE OPERATION BST
        remove2TimeBST = t.timeFunction(() -> {
            for (int l = 0; l < removeValues2.size(); l++) {
                BST.remove(removeValues2.get(l));
            }
            return null;
        });
        // TIME 2nd CONTAINS OPERATION BST
        contains2TimeBST = t.timeFunction(() -> {
            for (int l = 1000000; l < 2000000; l++) {
                BST.contains(l);
            }
            return null;
        });
        int bstHeight2 = BST.height(BST.root.val);
        // TIME 3rd ADD OPERATION BST
        add3TimeBST = t.timeFunction(() -> {
            // BST ADD AND REMOVE THE RANDOM INTEGERS
            for (int l = 0; l < addValues3.size(); l++) {
                BST.add(addValues3.get(l));
            }
            return null;
        });
        // TIME 3rd REMOVE OPERATION BST
        remove3TimeBST = t.timeFunction(() -> {
            for (int l = 0; l < removeValues3.size(); l++) {
                BST.remove(removeValues3.get(l));
            }
            return null;
        });
        // TIME 3rd CONTAINS OPERATION BST
        contains3TimeBST = t.timeFunction(() -> {
            for (int l = 2000000; l < 3000000; l++) {
                BST.contains(l);
            }
            return null;
        });
        int bstHeight3 = BST.height(BST.root.val);
        //----------------------- AVL -------------------------
        // TIME 1st ADD OPERATION AVL
        add1TimeAVL = t.timeFunction(() -> {
            for (int l = 0; l < addValues1.size(); l++) {
                AVL.add(addValues1.get(l));
            }
            return null;
        });
        // TIME 1st REMOVE OPERATION AVL
        remove1TimeAVL = t.timeFunction(() -> {
            for (int l = 0; l < removeValues1.size(); l++) {
                AVL.delete(removeValues1.get(l));
            }
            return null;
        });
        // TIME 1st CONTAINS OPERATION AVL
        contains1TimeAVL = t.timeFunction(() -> {
            for (int l = 0; l < 1000000; l++) {
                AVL.contains(l);
            }
            return null;
        });
        int avlHeight1 = AVL._height(AVL.root);
        // TIME 2nd ADD OPERATION AVL
        add2TimeAVL = t.timeFunction(() -> {
            for (int l = 0; l < addValues2.size(); l++) {
                AVL.add(addValues2.get(l));
            }
            return null;
        });
        // TIME 2nd REMOVE OPERATION AVL
        remove2TimeAVL = t.timeFunction(() -> {
            for (int l = 0; l < removeValues2.size(); l++) {
                AVL.delete(removeValues2.get(l));
            }
            return null;
        });
        // TIME 2nd CONTAINS OPERATION AVL
        contains2TimeAVL = t.timeFunction(() -> {
            for (int l = 1000000; l < 2000000; l++) {
                AVL.contains(l);
            }
            return null;
        });
        int avlHeight2 = AVL._height(AVL.root);

        // TIME 2nd ADD OPERATION AVL
        add3TimeAVL = t.timeFunction(() -> {
            for (int l = 0; l < addValues3.size(); l++) {
                AVL.add(addValues3.get(l));
            }
            return null;
        });
        // TIME 3rd REMOVE OPERATION BST
        remove3TimeAVL = t.timeFunction(() -> {
            for (int l = 0; l < removeValues3.size(); l++) {
                AVL.delete(removeValues3.get(l));
            }
            return null;
        });
        // TIME 3rd CONTAINS OPERATION AVL
        contains3TimeAVL = t.timeFunction(() -> {
            for (int l = 2000000; l < 3000000; l++) {
                AVL.contains(l);
            }
            return null;
        });
        int avlHeight3 = AVL._height(AVL.root);

        String unit = " ms";
        // PRINT TIMES
        System.out.println("OPERATION TIMES BST/AVL:");
        System.out.println("\n1st ADD BST: " + add1TimeBST + unit);
        System.out.println("1st ADD AVL: " + add1TimeAVL + unit);

        System.out.println("\n1st REMOVE BST: " + remove1TimeBST + unit);
        System.out.println("1st REMOVE AVL: " + remove1TimeAVL + unit);

        System.out.println("\nCONTAINS 0 - 1.000.000 BST: " + contains1TimeBST + unit);
        System.out.println("CONTAINS 0 - 1.000.000 AVL: " + contains1TimeAVL + unit);

        System.out.println("\nHEIGHT BST: " + bstHeight1);
        System.out.println("HEIGHT AVL: " + avlHeight1);

        System.out.println("\n2nd ADD BST: " + add2TimeBST + unit);
        System.out.println("2nd ADD AVL: " + add2TimeAVL + unit);

        System.out.println("\n2nd REMOVE BST: " + remove2TimeBST + unit);
        System.out.println("2nd REMOVE AVL: " + remove2TimeAVL + unit);

        System.out.println("\nCONTAINS 0 - 1.000.000 BST: " + contains2TimeBST + unit);
        System.out.println("CONTAINS 0 - 1.000.000 AVL: " + contains2TimeAVL + unit);

        System.out.println("\nHEIGHT BST: " + bstHeight2);
        System.out.println("HEIGHT AVL: " + avlHeight2);

        System.out.println("\n3rd ADD BST: " + add3TimeBST + unit);
        System.out.println("3rd ADD AVL: " + add3TimeAVL + unit);

        System.out.println("\n3rd REMOVE BST: " + remove3TimeBST + unit);
        System.out.println("3rd REMOVE AVL: " + remove3TimeAVL + unit);

        System.out.println("\nCONTAINS 0 - 1.000.000 BST: " + contains3TimeBST + unit);
        System.out.println("CONTAINS 0 - 1.000.000 AVL: " + contains3TimeAVL + unit);

        System.out.println("\nHEIGHT BST: " + bstHeight3);
        System.out.println("HEIGHT AVL: " + avlHeight3);
    }

}

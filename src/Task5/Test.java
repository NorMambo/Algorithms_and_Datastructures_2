package Task5;

import SupportClasses.CSVReaderWriter;
import SupportClasses.Timer;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {

        ArrayList<BinaryTree> trees = new ArrayList<>();
        ArrayList<Integer> sizes = new ArrayList<>();

        // CREATE 1000 BINARY TREES WITH SAME ROOT.
        for (int i = 0; i < 1000; i++) {
            BinaryTree tree = new BinaryTree(1);
            trees.add(tree);
        }

        int factor = 1;
        // ADD NODES TO 2 TREES AT A TIME (ALWAYS 5 MORE NODES THAN THE 2 PREVIOUS TREES)
        for (int i = 0; i < trees.size(); i+=2) {

            BinaryTree t = trees.get(i);
            t.root.left = new BinaryTreeNode(1);
            t.root.right = new BinaryTreeNode(1);
            BinaryTreeNode n = t.root.left;
            BinaryTreeNode m = t.root.right;

            BinaryTree t2 = trees.get(i+1);
            t2.root.left = new BinaryTreeNode(1);
            t2.root.right = new BinaryTreeNode(1);
            BinaryTreeNode n2 = t2.root.left;
            BinaryTreeNode m2 = t2.root.right;

            for (int j = 0; j < factor*5; j++) {

                n.left = new BinaryTreeNode(1);
                n = n.left;
                m.right = new BinaryTreeNode(1);
                m = m.right;

                n2.left = new BinaryTreeNode(1);
                n2 = n2.left;
                m2.right = new BinaryTreeNode(1);
                m2 = m2.right;
            }

            // 3 BECAUSE EVERY TREE HAS ALREADY 3 NODES BEFORE THE PREVIOUS FOR LOOP
            sizes.add(3+(factor*5));
            factor++;
        }

        Timer t = new Timer();
        ArrayList<Double> times = new ArrayList<>();

        // For every 2 instances of BT find 10 times the minimum run time of 10 runs of .isIsomorphic().
        // Then take the average of the 10 minimum values. This is the run time of 2 instances.
        for (int i = 0; i < trees.size(); i+=2) {

            BinaryTree b1 = trees.get(i);
            BinaryTree b2 = trees.get(i+1);

            // MINIMUMS WILL CONTAIN 10 MINIMUM RUNNING TIMES OF BinaryTree.isIsomorphic(BinaryTree2)
            ArrayList<Double> minimums = new ArrayList<>();

            // FIND 10 .isIsomorphic MINIMUM RUN TIMES WITH THE CURRENT INSTANCE OF THE 2 TREES
            for (int j = 0; j < 10; j++) {

                double min = 0;
                double time;

                // RUN BinaryTree1.isIsomorphic(BinaryTree2) 10 TIMES
                // BUT ONLY TAKE THE MINIMUM TIME OF THE 10 TIMES
                for (int k = 0; k < 10; k++) {

                    // TIME EXECUTION OF .UNION
                    time = t.timeFunction(() -> {
                        b1.isIsomorphic(b2);
                        return null;
                    });
                    if (k == 0) {
                        min = time;
                    } else {
                        if (time < min) {
                            min = time;
                        }
                    }
                }
                // ADD THE SMALLEST RUNNING TIME TO MINIMUMS
                minimums.add(min);
            }

            // MINIMUMS NOW CONTAINS 10 SHORTEST RUN TIMES OF THE .isIsomorphic() FUNCTION
            // TAKE THE AVERAGE OF THOSE 10 RUN TIMES
            double sum = 0;
            for (Double time : minimums) {
                sum+=time;
            }
            double avg_min = sum/minimums.size();

            // ADD THE RUN TIME AVERAGE_VALUE TO THE TIMES
            times.add(avg_min);
        }

        //PRINT TIMES
        System.out.println("isIsomorphic() TIMES:");
        for (int i = 0; i < times.size(); i++) {
            System.out.println("size: " + sizes.get(i) + " --> " + times.get(i) + " nanoseconds");
        }


//        CSVReaderWriter readerWriter = new CSVReaderWriter();
//        readerWriter.writeToFile(times, sizes, "src/Task5/BinaryTree_500.csv");
    }
}

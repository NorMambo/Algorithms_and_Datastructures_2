## TASKS:
1) Deque implementation
2) Random Queue implementation
3) Left Child Right Sibling tree implementation
4) Binary Search Tree implementation
5) Check isomorphism of 2 binary trees
6) AVL Tree implementation
7) Huffman coding

## NOTES:
- I use JDK 21
------------------------------------------------------------------------------------------------------------
- Tasks 1, 3 and 4 have a Test class where one can test the cases and make sure everything works.
------------------------------------------------------------------------------------------------------------
- Task 2, 5 and 6 have a main method inside the tree class to test that the code works. The
Test classes in the task5/task6 packages contain the test that gets the results used in the report.
------------------------------------------------------------------------------------------------------------
- Task 7 has a main method inside the Huffman class. There are 2 files that you can test by simply changing
the source path from "src/Task7/text2.txt" to "src/Task7/text.txt".

ADDITIONAL: the printout of all the codes is a bit strange in the case of the newline char
because the "\n" character is actually printed out as a new line.

ADDITIONAL: the ReadFile class adds a new line to the frequency list every time the reader finishes reading a line of text.
As a consequence, if the file you are trying to read only contains 1 line, the ReadFile class will also add a newline to the frequency list.
If the file you are trying to read is empty, you will get no result.
------------------------------------------------------------------------------------------------------------
EXTRAS:
- In task 3, adding a node to an existing node creates an actual empty file in the system. Therefore, in the
tree structure, the added file could appear as a left child on the 1st run and as a right sibling if you run
the program again.
It happens to me because I use MACOS, which apparently puts the hidden file ".DS_Store" always in first
position in any folder (after at least 1 file is created in that folder).
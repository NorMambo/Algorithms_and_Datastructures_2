package Task7;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {

    private PriorityQueue<HuffmanNode> nodes;
    private HashMap<Character, String> codes;
    private HuffmanNode root;

    public Huffman() {
        nodes = new PriorityQueue<>();
    }

    private void addNodesFromFile(ReadFile rf) throws IOException {
        for (Map.Entry<Character, Integer> entry : rf.getFrequencyList().entrySet()) {
            nodes.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }
    }

    public void createTreeAssignCodes(ReadFile rf) throws IOException {

        addNodesFromFile(rf);

        if (!nodes.isEmpty()) { // if ReadFile read at least one character
            while (nodes.size() != 1) {
                HuffmanNode n1 = nodes.poll();
                HuffmanNode n2 = nodes.poll();
                HuffmanNode p = new HuffmanNode(null, n1.frequency + n2.frequency);
                p.left = n1;
                p.right = n2;
                nodes.add(p);
            }

            root = nodes.poll();
            codes = assignCodes(root);

        } else {
            System.out.println("The file you tried to read is empty");
        }
    }

    public HashMap<Character, String> assignCodes(HuffmanNode root) {

        HashMap<Character, String> huffCodes = new HashMap<>();
        _assignCodes(root, "", huffCodes); // the code is empty and will be completed by descending the tree.
        // 0's will be added to the code when going left and 1's will be added when going right (recursively).
        // The code is complete and unique when a leaf node is reached (it will be assigned to the huffCodes hashmap
        // along with the char contained in the leaf node
        return huffCodes;
    }
    private void _assignCodes(HuffmanNode root, String code, HashMap<Character, String> huffmanCodes) {
        if (root == null) {
            return;
        }
        // assign the code at leaf node
        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.data, code);
        }
        // if not leaf node, try going left and add a 0 to the final code (will return if root.left is null)
        _assignCodes(root.left, code + "0", huffmanCodes);

        // if not leaf node, try going right and add a 1 to the final code (will return if root.right is null)
        _assignCodes(root.right, code + "1", huffmanCodes);
    }

    public void getAllCodes() { // getting all the codes
        if (codes != null) {
            for (Map.Entry<Character, String> e : codes.entrySet()) {
                System.out.println("char: " + e.getKey() + " | huffcode: " + e.getValue());
            }
        }
    }

    public void getCodeFor(char c) { // getting a specific code
        if (codes != null) {
            if (c == '\n')
                System.out.println("Get code for: \\n");
            else
                System.out.println("Get code for: " + c);
        System.out.println(codes.get(c));
        }
    }


    public static void main(String[] args) throws IOException {
        ReadFile rf = new ReadFile("src/Task7/text2.txt");
        Huffman hf = new Huffman();
        hf.createTreeAssignCodes(rf);
        hf.getAllCodes();
        System.out.println();
        hf.getCodeFor('t');
        hf.getCodeFor('#');
        hf.getCodeFor('\n');

    }
}

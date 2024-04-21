package Task7;


public class HuffmanNode implements Comparable<HuffmanNode>{
    Character data;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(Character data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return Integer.compare(this.frequency, o.frequency);
    }
}

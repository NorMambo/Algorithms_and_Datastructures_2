package Task7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadFile {
    private final BufferedReader reader;
    HashMap<Character, Integer> frequencyList;

    public ReadFile (String path) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(path));
    }

    public HashMap<Character, Integer> getFrequencyList() throws IOException {
        frequencyList = new HashMap<>();
        String line;
        while((line = this.reader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {

                frequencyList.putIfAbsent(line.charAt(i), 0);

                if (frequencyList.containsKey(line.charAt(i))) {
                    frequencyList.put(line.charAt(i), frequencyList.get(line.charAt(i)) + 1);
                }

            }
            char newlineChar = '\n';
            frequencyList.putIfAbsent(newlineChar, 0);
            frequencyList.put(newlineChar, frequencyList.get(newlineChar) + 1);
        }
        return frequencyList;
    }


}

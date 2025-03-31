import java.util.Map;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fisier = "src/cuvinte.txt";
        Map<String, Integer> contor = new HashMap<>();

        try {
            File file = new File(fisier);
            Scanner sc = new Scanner(file);

            while(sc.hasNext()) {
                String line = sc.next();
                String[] words = line.split(" ");
                for (String word : words) {
                    if (!contor.containsKey(word)) {
                        contor.put(word, 1);
                    } else {
                        contor.put(word, contor.get(word) + 1);
                    }
                }
            }
            for (String word : contor.keySet()) {
                System.out.println(word + " " + contor.get(word));
            }

        } catch (FileNotFoundException e) {
            System.out.println("eroare");
        }
    }
}

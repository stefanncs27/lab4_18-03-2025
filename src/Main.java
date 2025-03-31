import java.util.Map;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fisier = "src/cuvinte.txt";
        String fisierPersoane = "src/persoane.txt";
        Map<String, Integer> contor = new HashMap<>();
        Map<String, Integer> contorPersoane = new HashMap<>();

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

        try {
            File filePersoane = new File(fisierPersoane);
            Scanner scPersoane = new Scanner(filePersoane);
            while (scPersoane.hasNext()) {
                String line = scPersoane.nextLine().trim();
                if (!line.isEmpty()) {
                    if (!contorPersoane.containsKey(line)) {
                        contorPersoane.put(line, 1);
                    } else {
                        contorPersoane.put(line, contorPersoane.get(line) + 1);
                    }
                }
            }
            for (String person : contorPersoane.keySet()) {
                if (contorPersoane.get(person) > 3) {
                    System.out.println(person + " apare de " + contorPersoane.get(person) + " ori");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("eroare");
        }
    }
}

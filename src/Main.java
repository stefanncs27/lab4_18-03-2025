import java.util.Map;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fisier = "src/cuvinte.txt";//cream fisier pt cuvinte
        String fisierPersoane = "src/persoane.txt";//cream fisier pt persoane
        //cream doua mapuri pt a numara cuvintele si persoanele din fisiere
        Map<String, Integer> contor = new HashMap<>();
        Map<String, Integer> contorPersoane = new HashMap<>();

        //citim fisierul cu cuvinte
        try {
            File file = new File(fisier);//obiect de tip fisier pt cuvinte
            Scanner sc = new Scanner(file);// scanner pt a citi fisierul

            //citim fiecare cuvant
            while(sc.hasNext()) {
                String line = sc.next();//citim un cuvant
                String[] words = line.split(" ");//impartim linia cu un saptiu intre cuvinte

                //numaram aparitiile cuvintelor
                for (String word : words) {
                    if (!contor.containsKey(word)) {
                        contor.put(word, 1);
                    } else {
                        contor.put(word, contor.get(word) + 1);//daca cuv exista creste contorul cu 1
                    }
                }
            }
            for (String word : contor.keySet()) {
                System.out.println(word + " " + contor.get(word));//afisam cuvantul si nr de aparitii
            }

        } catch (FileNotFoundException e) {
            System.out.println("eroare");
        }

        //citim fisierul cu persoane
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
                if (contorPersoane.get(person) > 3) {//daca persoana apare de mai mul de 3 ori afisam
                    System.out.println(person + " apare de " + contorPersoane.get(person) + " ori");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("eroare");
        }
    }
}

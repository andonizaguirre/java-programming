package dictionary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SaveableDictionary {

    private Map<String, String> words;
    private String file;

    public SaveableDictionary() {
        this.words = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this();
        this.file = file;
    }

    public void add(String word, String translation) {
        if (!this.words.containsKey(word)) {
            this.words.put(word, translation);
            this.words.put(translation, word);
        }
    }

    public String translate(String word) {
        return this.words.get(word);
    }

    public void delete(String word) {
        String translation = this.translate(word); // Auxiliary variable
        this.words.remove(word);
        this.words.remove(translation);
    }

    public boolean load() {
        try (Scanner fileReader = new Scanner(Paths.get(this.file))) {
//            Files.lines(Paths.get(this.file))
//                    .map(l -> l.split(":"))
//                    .forEach(parts -> {
//                        this.words.put(parts[0], parts[1]);
//                        this.words.put(parts[1], parts[0]);
//                    });
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                this.words.put(parts[0], parts[1]);
                this.words.put(parts[1], parts[0]);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(this.file);
            this.saveWords(writer); // This methods writes the lines too
            writer.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void saveWords(PrintWriter writer) throws IOException {
        List<String> saved = new ArrayList<>();
        this.words.keySet().stream().forEach(word -> {
            if (!saved.contains(word)) {
                writer.println(word + ":" + words.get(word));
                saved.add(word);
                saved.add(words.get(word));
            }
        });
    }
}

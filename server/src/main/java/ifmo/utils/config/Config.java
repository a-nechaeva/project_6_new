package ifmo.utils.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;
public class Config {
    private Hashtable<String, String> configHashtable;

    public Config(String fileName) {
        File config = new File(fileName);
        if (config.exists()) {
            this.configHashtable = readFile(config);
        }
    }

    public String get(String key) {
        return configHashtable.get(key);
    }

    private Hashtable<String, String> readFile(File config) {
        Hashtable<String, String> configHashtable = new Hashtable<>();
        try (Scanner scanner = new Scanner(config)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Skipping comments and lines without "Key=Value"
                if (line.startsWith("#") || !line.contains("=")) {
                    continue;
                }
                String[] split = line.split("=", 2);
                if (split.length < 2) continue;
                configHashtable.put(split[0], split[1]);
            }
        } catch (FileNotFoundException ignored) {
            // Ignoring this, because file was existence checked
        }
        return configHashtable;
    }
}

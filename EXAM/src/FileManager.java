import java.io.*;
import java.util.List;

public class FileManager {
    public static void saveBooks(List<CategoryComponent> categories, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(categories);
            LoggerSingleton.getLogger().info("Books saved to " + filename);
        } catch (IOException e) {
            LoggerSingleton.getLogger().severe("Error saving books: " + e.getMessage());
        }
    }

    public static List<CategoryComponent> loadBooks(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            LoggerSingleton.getLogger().info("Books loaded from " + filename);
            return (List<CategoryComponent>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            LoggerSingleton.getLogger().severe("Error loading books: " + e.getMessage());
            return null;
        }
    }
}
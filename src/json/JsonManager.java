package json;

import collection.CollectionManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dragon.*;
import java.io.*;
import java.util.List;

public class JsonManager {
    public static String filePath = System.getenv("Json_file");
    private static final GsonBuilder builder = new GsonBuilder();
    private static final Gson gson = builder
            .serializeNulls()
            .setPrettyPrinting()
            .enableComplexMapKeySerialization()
            .create();
    public static void fromJsonToCollection() {
        if (filePath != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                CollectionManager.createCollection();
                List<Dragon> Dragon = gson.fromJson(reader, new TypeToken<List<Dragon>>() {
                }.getType());
                if (Dragon.size() > 0) for (Dragon dragon : Dragon) {
                    CollectionManager.addJsonObject(dragon);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (SecurityException e) {
                System.out.println("Недостаточно прав для открытия файла.");
            } catch (NullPointerException e) {
                System.out.println("В файле нет объектов");
            } catch (com.google.gson.JsonSyntaxException e) {
                System.out.println("Ошибка в содержании файла " + e.getMessage());
            }
        } else {
            System.out.println("Переменная окружения не выставлена");
        }
    }
    public static void collectionToJson() {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            gson.toJson(CollectionManager.getLinkedList(), writer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
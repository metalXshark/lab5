
import console.ConsoleManager;
import json.JsonManager;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonManager.fromJsonToCollection();
        ConsoleManager console = new ConsoleManager();
        console.start();
    }
}


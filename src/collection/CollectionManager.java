package collection;

import commands.manager.CommandManager;
import commands.manager.CreateObject;
import dragon.Color;
import dragon.Dragon;
import dragon.Person;
import json.JsonManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.*;

public class CollectionManager {
    private static LinkedList<Dragon> collection;
    private static ZonedDateTime creationDate;
    private static final ArrayList<Color> color = new ArrayList<>(List.of(Color.values()));
    private static final Set<String> group_names = new HashSet<>();

    public static void createCollection() {
        if (collection == null) {
            collection = new LinkedList<>();
            creationDate = ZonedDateTime.now();
        }
    }
    public static LinkedList<Dragon> getLinkedList() {
        return collection;
    }
    public static void addJsonObject(Dragon dragon) {
        collection.add(dragon);
    }

    public static boolean checkID(Long ID) {
        for (Dragon dragon : CollectionManager.getLinkedList()) {
            if(dragon.getId().equals(ID)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkColor() {
        for (Dragon dragon : CollectionManager.getLinkedList()) {
            if(dragon.getColor().equals(color.get(0))){
                return true;
            }
        }
        return false;
    }

    public static void info() {
        System.out.println("Тип коллекции – " + collection.getClass().getName());
        System.out.println("Дата инициализации коллекции – " + creationDate);
        System.out.println("Количество элементов в коллекции – " + collection.size());
    }
    public static void show() {
        collection.forEach(CollectionManager::getInfo);
    }
    public static void getInfo(Dragon dragon) {
        System.out.println("ID элемента коллекции   –  " + dragon.getId());
        System.out.println("Имя дракона             –  " + dragon.getName());
        System.out.println("Координаты дракона      -  " + "X - " + dragon.getCoordinates().getX() + "; Y - " + dragon.getCoordinates().getY());
        System.out.println("Дата создания элемента  –  " + dragon.getCreationDate());
        System.out.println("Возраст дракона         –  " + dragon.getAge());
        System.out.println("Цвет дракона            –  " + dragon.getColor());
        System.out.println("Тип дракона             –  " + dragon.getType());
        System.out.println("Характер дракона        –  " + dragon.getCharacter());
        System.out.println("Убийца дракона          –  " + dragon.getKiller().getName());
        System.out.println("---------------------------------------------------------");
    }
    public static void getInfoKiller(Person person) {
        System.out.println("ID паспорта –  " + person.getPassportID());
        System.out.println("Имя убийцы  –  " + person.getName());
        System.out.println("Рост        –  " + person.getHeight());
        System.out.println("Вес         –  " + person.getWeight());
        System.out.println("Цвет глаз   –  " + person.getEyeColor());
        System.out.println("---------------------------------------------");
    }

    public static void add(Dragon dragon) {
        collection.add(dragon);
    }

    public static void clear(){
        collection.clear();
        System.out.println("Коллекция успешно очищена");
    }
    public static void update(String ID) {
        Long dragonID;
        try {
            dragonID = Long.parseLong(ID);
            if (checkID(dragonID)) {
                Dragon updateDragon = CreateObject.createDragon();
                collection.forEach(Dragon -> {
                    if (Dragon.getId().equals(dragonID)) {
                        Dragon.setName(updateDragon.getName());
                        Dragon.setCoordinates(updateDragon.getCoordinates());
                        Dragon.setAge(updateDragon.getAge());
                        Dragon.setColor(updateDragon.getColor());
                        Dragon.setType(updateDragon.getType());
                        Dragon.setCharacter(updateDragon.getCharacter());
                        Dragon.setKiller(updateDragon.getKiller());
                    }
                });
                System.out.println("Элемент с ID - " + ID + " успешно обновлен");
            } else {
                System.out.println("Элемента с таким ID нет в коллекции.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Команда не выполнена. Вы ввели некорректный аргумент.");
        }
    }
    public static void save(){
        JsonManager.collectionToJson();
        System.out.println("Коллекция успешно сохранена");
    }

    public static void remove_by_id(String ID) {
        Long dragonID;
        try {
            dragonID = Long.parseLong(ID);
            if (checkID(dragonID)) {
                Iterator<Dragon> i = collection.iterator();
                while (i.hasNext()) {
                    Dragon dragon = i.next();
                    if (dragon.getId().equals(dragonID)) {
                        i.remove();
                    }
                }
                System.out.println("Элемент с ID - " + ID + " успешно удален");
            } else {
                System.out.println("Элемента с таким ID нет в коллекции.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Команда не выполнена. Вы ввели некорректный аргумент.");
        }
    }
    public static void exit(){
        System.exit(0);
    }
    public static void remove_first(){
        if (collection.size() > 0) {
            collection.remove(collection.getFirst());
            System.out.println("Удален первый элемент коллекции");
        } else {
            System.out.println("Коллекция пуста.");
        }
    }
    public static void remove_head(){
        if (collection.size() > 0) {
            getInfo(collection.getFirst());
            collection.remove(collection.getFirst());
            System.out.println("Удален первый элемент коллекции");
        } else {
            System.out.println("Коллекция пуста.");
        }
    }
    public static void history(){
        System.out.println("Последние вызванные команды: ");
        try {
            for (int i = 0; i < 14; i++) {
                System.out.println(CommandManager.getCommandHistory().get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("За время работы было вызвано менее 14 команд");
        }
    }
    public static void min_by_color(){
        if (checkColor()){
            Iterator<Dragon> i = collection.iterator();
            while (i.hasNext()) {
                Dragon dragon = i.next();
                if (dragon.getColor().equals(color.get(0))) {
                    getInfo(dragon);
                }
            }
        } else {
            System.out.println("Объекта с цветом " + color.get(0) + " не существует");
        }
    }
    public static void group_counting_by_name(){
        for (Dragon dragon : CollectionManager.getLinkedList()) {
            int k = 0;
            String name = dragon.getName();
            Iterator<Dragon> i = collection.iterator();
            while (i.hasNext()) {
                Dragon dragon1 = i.next();
                if (dragon1.getName().equals(name)) {
                    k += 1;
                }
            }
            String f = name + ": " + k;
            group_names.add(f);
        }
        System.out.println(group_names);
    }
    public static void print_field_ascending_killer(){
        for(Dragon dragon : CollectionManager.getLinkedList()) {
            getInfoKiller(dragon.getKiller());
        }
    }
    public static void execute_script(String file){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("===============================================================\n" + line);
                CommandManager.executeCommand(line.split(" "));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            System.out.println("Недостаточно прав для открытия файла.");
        } catch (NullPointerException e) {
            System.out.println("Файл пуст");
        }
    }
}

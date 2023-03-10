package commands.manager;

import dragon.*;

import java.util.Scanner;

public class CreateObject {
    public static Dragon createDragon(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя дракона: ");
        String name =  in.nextLine().trim();
        while(name.equals("")) {
            System.out.print("#Error (Данное поле не может быть пустым.)\nВведите имя дракона: ");
            name = in.nextLine().trim();
        }
        Scanner flt = new Scanner(System.in);
        System.out.print("Введите местоположение дракона:\nX - ");
        Float x = null;
        while (x == null){
            try {
                x = Float.parseFloat(flt.nextLine().trim());
                while (x <= -572) {
                    System.out.print("#Error (Значение поля должно быть больше -572.)\nX - ");
                    x = Float.parseFloat(flt.nextLine().trim());
                }
            } catch (NumberFormatException e){
                System.out.println("#Error (Вы ввели неподходящее значение.)\nX - ");
                x = null;
            }
        }
        Scanner lng = new Scanner(System.in);
        System.out.print("Y - ");
        Long y = null;
        while (y == null){
            try {
                y = Long.parseLong(lng.nextLine().trim());
            } catch (NumberFormatException e){
                System.out.println("#Error (Вы ввели неподходящее значение.)\nY - ");
                y = null;
            }
        }
        System.out.print("Введите возраст дракона: ");
        Long age = null;
        while (age == null){
            try {
                age = Long.parseLong(lng.nextLine().trim());
                while (age < 0) {
                    System.out.print("#Error (Значение поля должно быть больше 0.)\nВведите возраст дракона: ");
                    age = Long.parseLong(lng.nextLine().trim());
                }
            } catch (NumberFormatException e){
                System.out.println("#Error (Вы ввели неподходящее значение.)\nY - ");
                age = null;
            }
        }
        System.out.print("(BLUE, ORANGE, WHITE, BROWN)\nВведите цвет дракона из представленных: ");
        Color color = null;
        while (color == null){
            try {
                color = Color.valueOf(in.nextLine().trim());
            } catch (IllegalArgumentException e){
                System.out.println("#Error (Вы ввели несуществующее значение из представленных.)\nВведите цвет дракона: ");
                color = null;
            }
        }
        System.out.print("(UNDERGROUND, AIR, FIRE)\nВведите тип дракона из представленных: ");
        DragonType type = null;
        while (type == null){
            try {
                type = DragonType.valueOf(in.nextLine().trim());
            } catch (IllegalArgumentException e){
                System.out.println("#Error (Вы ввели несуществующее значение из представленных.)\nВведите тип дракона: ");
                type = null;
            }
        }
        System.out.print("(GOOD, CHAOTIC, CHAOTIC_EVIL, FICKLE)\nВведите характер дракона из представленных: ");
        DragonCharacter character = null;
        while (character == null){
            try {
                character = DragonCharacter.valueOf(in.nextLine().trim());
            } catch (IllegalArgumentException e){
                System.out.println("#Error (Вы ввели несуществующее значение из представленных.)\nВведите характер дракона: ");
                character = null;
            }
        }
        System.out.print("Введите имя убийцы дракона: ");
        String nameKiller = in.nextLine().trim();
        while(nameKiller.equals("")) {
            System.out.print("#Error (Данное поле не может быть пустым.)\nВведите имя убийцы дракона: ");
            nameKiller = in.nextLine().trim();
        }
        System.out.print("Введите рост убийцы: ");
        Long height = null;
        while (height == null){
            try {
                height = Long.parseLong(lng.nextLine().trim());
                while (height < 0) {
                    System.out.print("#Error (Значение поля должно быть больше 0.)\nВведите рост убийцы: ");
                    height = Long.parseLong(lng.nextLine().trim());
                }
            } catch (NumberFormatException e){
                System.out.println("#Error (Вы ввели неподходящее значение.)\nY - ");
                height = null;
            }
        }
        System.out.print("Введите вес убийцы: ");
        Long weight = null;
        while (weight == null){
            try {
                weight = Long.parseLong(lng.nextLine().trim());
                while (weight < 0) {
                    System.out.print("#Error (Значение поля должно быть больше 0.)\nВведите вес убийцы: ");
                    weight = Long.parseLong(lng.nextLine().trim());
                }
            } catch (NumberFormatException e){
                System.out.println("#Error (Вы ввели неподходящее значение.)\nY - ");
                weight = null;
            }
        }
        System.out.print("Введите ID паспорта убийцы: ");
        String passportID = in.nextLine().trim();
        while(passportID.equals("") || passportID.length() > 44) {
            System.out.print("#Error (Данное поле не может быть пустым, а так же длинна строки не должна превышать 44-х.)\nВведите ID паспорта убийцы: ");
            passportID = in.nextLine().trim();
        }
        System.out.print("(BLUE, ORANGE, WHITE, BROWN)\nВведите цвет глаз убийцы из представленных: ");
        Color eyecolor = null;
        while (eyecolor == null){
            try {
                eyecolor = Color.valueOf(in.nextLine().trim());
            } catch (IllegalArgumentException e){
                System.out.println("#Error (Вы ввели несуществующее значение из представленных.)\nВведите цвет глаз убийцы: ");
                eyecolor = null;
            }
        }

        Coordinates coordinates =  new Coordinates(x, y);
        Person killer = new Person(nameKiller, height, weight, passportID, eyecolor);
        Dragon dragon = new Dragon(name, coordinates, age, color, type, character, killer);
        return dragon;
    }
}

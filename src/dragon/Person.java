package dragon;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private long height; //Значение поля должно быть больше 0
    private long weight; //Значение поля должно быть больше 0
    private String passportID; //Длина строки не должна быть больше 44, Поле может быть null
    private Color eyeColor; //Поле не может быть null


    public Person(String name, long height, long weight, String passportID, Color eyeColor){
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.passportID = passportID;
        this.eyeColor = eyeColor;
    }
    public String getName() {
        return name;
    }
    public long getHeight() {
        return height;
    }
    public long getWeight() {
        return weight;
    }
    public String getPassportID() {
        return passportID;
    }
    public Color getEyeColor() {
        return eyeColor;
    }

}

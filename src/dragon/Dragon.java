package dragon;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class Dragon {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long age; //Значение поля должно быть больше 0
    private Color color; //Поле может быть null
    private DragonType type; //Поле не может быть null
    private DragonCharacter character; //Поле может быть null
    private Person killer; //Поле может быть null

    public Dragon(String name, Coordinates coordinates, long age, Color color, DragonType type, DragonCharacter character, Person killer){
        this.id = generateID();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date();
        this.age = age;
        this.color = color;
        this.type = type;
        this.character = character;
        this.killer = killer;
    }
    public String getName() {
        return name;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public Long getAge() {
        return age;
    }
    public Color getColor() {
        return color;
    }
    public DragonType getType() {
        return type;
    }
    public DragonCharacter getCharacter() {
        return character;
    }
    public Person getKiller() {
        return killer;
    }
    public Long getId() {
        return id;
    }
    public static long generateID() {
        long x = new Random().nextLong();
        if(x <= 0){
            long y = x - (2 * x);
            return y;
        }
        return x;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public void setAge(Long age) {
        this.age = age;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setType(DragonType type) {
        this.type = type;
    }
    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }
    public void setKiller(Person killer) {
        this.killer = killer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dragon dragon = (Dragon) o;
        return id.equals(dragon.id) && Objects.equals(name, dragon.name);
    }

}

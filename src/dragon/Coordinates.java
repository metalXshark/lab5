package dragon;

public class Coordinates {
    private float x; //Значение поля должно быть больше -572, Поле не может быть null
    private long y; //Поле не может быть null
    public Coordinates(float x, long y){
        this.x = x;
        this.y = y;
    }
    public Float getX() {
        return x;
    }
    public Long getY() {
        return y;
    }

}

package T6ExpresionesRegulares;

public class Punto {
    private int x;
    private int y;

    @Override
    public String toString() {
        return "Punto{" +
                "x=" + this.x +
                ", y=" + this.y +
                '}';
    }

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

}

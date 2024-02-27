package shapeclasssuper;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);

    }

    public double getSide() {
        return this.getLength();
    }

    public void setSide(double side) {
        this.setLength(side);
        this.setSide(side);
    }

    @Override
    public String toString() {
        return "Square[" + super.toString() + "]";
    }
}
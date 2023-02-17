package Vehicle;

public class Car extends Vehicle {
    String name;
    boolean electric;
    int price;

    public Car(String name, boolean electric, int price) {
        this.name = name;
        this.electric = electric;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public boolean isElectric() {
        return electric;
    }

    public int getPrice() {
        return price;
    }

}

package Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class Bike extends Vehicle{
 String name;
 int price;

    public Bike(String name, int price) {
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}



package Branch;

import Vehicle.Bike;

import java.util.ArrayList;

public class Branches {
    String name;
    ArrayList<Bike> bikes;

    public Branches(String name, ArrayList<Bike> bikes) {
        this.name = name;
        this.bikes = bikes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(ArrayList<Bike> bikes) {
        this.bikes = bikes;
    }

    public Bike searchBike(String name) {
        Bike b=null;
        for (Bike bike : bikes) {
            if (bike.getName().equals(name)) {
                b=bike;
            }
        }return b;
    }

    public boolean removeBike(String name) {
        boolean result = false;
        Bike bikeToRemove = searchBike(name);
        if (bikeToRemove == null) {
            System.out.println("False Bike Name.");
        } else {
            bikes.remove(bikeToRemove);
            result = true;
        }
        return result;
    }


    public void addBike(Bike bike) {
        bikes.add(bike);
    }
}


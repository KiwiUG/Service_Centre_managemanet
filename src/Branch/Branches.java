package Branch;

import Vehicle.Bike;
import Vehicle.Car;
import Vehicle.Vehicle;

import java.util.ArrayList;

public class Branches {
    String name;
    ArrayList<Bike> bikes;
    ArrayList<Car> cars;

    public Branches(String name, ArrayList<Bike> bikes, ArrayList<Car> cars) {
        this.name = name;
        this.bikes = bikes;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Bike> getBikes() {
        return bikes;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public Bike searchBike(String name) {
        Bike b = null;
        for (Bike bike : bikes) {
            if (bike.getName().equals(name)) {
                b = bike;
            }
        }
        return b;
    }

    public Car searchCar(String name) {
        Car c = null;
        for (Car car : cars) {
            if (car.getName().equals(name)) {
                c = car;
            }
        }
        return c;
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

    public boolean removeCar(String name) {
        boolean result = false;
        Car carToRemove = searchCar(name);
        if (carToRemove == null) {
            System.out.println("False Car Name.");
        } else {
            cars.remove(carToRemove);
            result = true;
        }
        return result;
    }

    public void addBike(Bike bike) {
        bikes.add(bike);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public static void buyVehicle(Branches cb, String v_name) {

        for (Bike b : cb.getBikes()) {
            String bike_name = b.getName();
            if (bike_name.equals(v_name)) {
                System.out.println("Name: " + b.getName() + " \nPrice: " + b.getPrice() + "\nWarrenty: " + b.getWarrenty() + "\nMaintainance Service:" + b.getMaintainance());
            }
        }
        for (Car c : cb.getCars()) {
            String car_name = c.getName();

            boolean electric = c.isElectric();
            String type;
            if (electric) {
                type = "electric car, ";
            } else {
                type = "non-electric car,";
            }
            if (car_name.equals(v_name)) {
                System.out.println("You have ordered a "+type + c.getName() + " of Price: " + c.getPrice() + "\nServices you get with the Car: " + "\nWarrenty: " + c.getWarrenty() + "\nMaintainance Service:" + c.getMaintainance());
            }
        }
    }
}


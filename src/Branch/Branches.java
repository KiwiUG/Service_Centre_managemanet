package Branch;

import Vehicle.Bike;
import Vehicle.Car;
import Vehicle.Vehicle;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Branches {
    String name;
    ArrayList<Bike> bikes;
    static ArrayList<Car> cars;

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

    public static Boolean buyVehicle(Branches cb, String v_name) {

        Scanner sc = new Scanner(System.in);

        boolean bill = false;

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
                System.out.println("Confirm(Y/N)?");
                String confirm = sc.next();
                if(confirm.equals("Y")){
                    bill = true;
                }
            }
        }
        return bill;
    }

    public static void generateBill(Branches b,String v_name,String c_name) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        Date date = new Date();
        double subtotal = 0;
        double vat = 0;
        double total = 0;


        // Print bill header
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|                     CAR SALES RECEIPT                    |");
        System.out.println("+---------------------------------------------------------+");
        System.out.printf("| Date:          %s                               |\n", date.toString());
        System.out.println("|                                                         |");
        System.out.println("| CUSTOMER INFORMATION:                                   |");
        System.out.printf("| Name:          "+c_name+                              "|\n");
        System.out.println("|                                                         |");
        System.out.println("| PRODUCT INFORMATION:                                    |");
        System.out.println("|                                                         |");
        System.out.println("| Make/Model          Electric      Price (excluding VAT) |");
        System.out.println("| -------------------- ---------- ----------------------- |");

        // Print each car in the bill
        for (Car car : cars) {
            boolean electric = car.isElectric();
            String type;
            if (electric) {
                type = "electric car ";
            } else {
                type = "non-electric car";
            }

            System.out.printf("| "+car.getName()+ "                    "+type+"       "+car.getPrice()+"   |\n");
            subtotal += car.getPrice();
        }

        // Calculate and print totals
        vat = subtotal * 0.13;
        total = subtotal + vat;
        System.out.println("|                                                         |");
        System.out.printf("| SUBTOTAL:                                          "+subtotal+" |\n");
        System.out.printf("| VAT (13%%):                                        "+vat+" |\n");
        System.out.printf("| TOTAL:                                             "+total+" |\n");
        System.out.println("|                                                         |");
        System.out.println("| THANK YOU FOR YOUR PURCHASE!                             |");
        System.out.println("+---------------------------------------------------------+");
    }

}


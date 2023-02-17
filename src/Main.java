import Branch.Branches;
import Vehicle.Bike;
import Vehicle.Car;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Branches> branches = new ArrayList<>();
        ArrayList<Bike> bikes = new ArrayList<>();
        ArrayList<Car> cars = new ArrayList<>();
        Branches currentbranch=null;

        Scanner sc = new Scanner(System.in);
        boolean end = false;

        while (!end) {
            System.out.println("\n");
            System.out.println("1. Add Branch");
            System.out.println("2. Add Bike or Car to Branch");
            System.out.println("3. Search for Bike or Car in Branch");
            System.out.println("4. Remove Bike or Car from Branch");
            System.out.println("5. Display all Branches and their Vehicle");
            System.out.println("6. End from admin side.");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter the branch name: ");
                    String branchName = sc.next();

                    Branches branch = new Branches(branchName, bikes, cars);
                    branches.add(branch);
                    System.out.println("Branch added successfully!");
                    break;

                case 2:
                    currentbranch=branch_search(branches);

                    if (currentbranch == null) {
                        System.out.println("Branch not found!");
                        break;
                    }


                    System.out.print("Enter Vehicle type: ");
                    String Vtype = sc.next();
                    if (Vtype.equals("bike")) {
                        System.out.print("Enter the bike name: ");
                        String bikeName = sc.next();
                        System.out.print("Enter the bike price: ");
                        int bikePrice = sc.nextInt();
                        Bike bike = new Bike(bikeName, bikePrice);
                        currentbranch.addBike(bike);
                        System.out.println("Bike added to branch successfully!");
                    } else if (Vtype.equals("car")) {

                        System.out.print("Enter the car name: ");
                        String carName = sc.next();
                        System.out.print("Is it a electric car?(true/false)");
                        boolean cartype = sc.nextBoolean();
                        System.out.print("Enter the car price: ");
                        int carPrice = sc.nextInt();
                        Car car = new Car(carName, cartype, carPrice);
                        currentbranch.addCar(car);
                        System.out.println("Car added to branch successfully!");

                    }
                    break;

                case 3:
                    currentbranch=branch_search(branches);

                    if (currentbranch == null) {
                        System.out.println("Branch not found!");
                        break;
                    }

                    System.out.print("Enter the bike or car name to search: ");
                    String searchVehicleName = sc.next();
                    Bike searchBike = currentbranch.searchBike(searchVehicleName);
                    Car searchCar = currentbranch.searchCar(searchVehicleName);
                    if (searchBike != null) {
                        System.out.println("Bike found in branch: " + searchBike.getName() + " with price: " + searchBike.getPrice());
                    } else if (searchCar != null) {
                        System.out.println("Car found in branch: " + searchCar.getName() + " with price: " + searchCar.getPrice());
                    }
                    break;

                case 4:
                    currentbranch=branch_search(branches);

                    if (currentbranch == null) {
                        System.out.println("Branch not found!");
                        break;
                    }

                    System.out.print("Enter the bike or car name to remove: ");
                    String removeVehicleName = sc.next();
                    boolean removed = currentbranch.removeBike(removeVehicleName);
                    removed = currentbranch.removeCar(removeVehicleName);
                    if (!removed) {
                        System.out.println("Bike or Car not found in branch!");
                        break;
                    }
                    System.out.println("Bike or Car removed from branch successfully!");
                    break;
                case 5:
                    for (Branches s : branches) {
                        System.out.println("Branch Name: " + s.getName());
                        System.out.println("\nBikes:");
                        for (Bike b : s.getBikes()) {
                            System.out.println("Name: " + b.getName() + "\t Price: " + b.getPrice());
                        }
                        System.out.println("\nCars:");
                        for (Car c : s.getCars()) {
                            System.out.println("Name: " + c.getName() + "\t Price: " + c.getPrice() + " \tElectric:" + c.isElectric());
                        }
                    }
                    break;
                case 6:
                    end = true;
                    break;
                default:
                    System.out.println("Invalid choice, try again");
                    break;
            }
        }
        end = false;
        System.out.println("------------------------------User Side--------------------------------");
        while (!end) {
            System.out.println("\n");
            System.out.println("1. View all Branches");
            System.out.println("2. View all Vehicles in a branch");
            System.out.println("3. Buy a Vehicle");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (Branches s : branches) {
                        System.out.println("\nBranch Name: " + s.getName());
                    }
                    break;
                case 2:
                    currentbranch=branch_search(branches);

                    if (currentbranch == null) {
                        System.out.println("Branch not found!");
                        break;
                    }

                    for (Bike b : currentbranch.getBikes()) {
                        System.out.println("Name: " + b.getName() + "\tPrice: " + b.getPrice());
                    }
                    System.out.println("\nCars:");
                    for (Car c : currentbranch.getCars()) {
                        System.out.println("Name: " + c.getName() + "\tPrice: " + c.getPrice() + "\tElectric:" + c.isElectric());
                    }
                    break;
                case 3:
                    if (currentbranch == null) {
                        System.out.println("Branch not found!");
                        break;
                    }

                    System.out.print("Enter the vehicle name: ");
                    String vehicleName = sc.next();
                    Branches.buyVehicle(currentbranch, vehicleName);
                    break;
                case 4:
                    end = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }

    }
    public static Branches branch_search(ArrayList<Branches> branches){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the branch name: ");
        String currentbranchName = sc.next();
        Branches currentbranch = null;
        for (Branches s : branches) {
            if (s.getName().equals(currentbranchName)) {
                currentbranch = s;
                break;
            }
        }
        return currentbranch;
    }
}




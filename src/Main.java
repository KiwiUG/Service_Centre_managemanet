import Branch.Branches;
import Vehicle.Bike;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Branches> branches = new ArrayList<>();
        ArrayList<Bike> bikes = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        boolean end = false;

        while (!end) {
            System.out.println("\n");
            System.out.println("1. Add Branch");
            System.out.println("2. Add Bike to Branch");
            System.out.println("3. Search for Bike in Branch");
            System.out.println("4. Remove bike from Branch");
            System.out.println("5. Display all Branches and their Bikes");
            System.out.println("6. End");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter the branch name: ");
                    String branchName = sc.next();

                    Branches branch = new Branches(branchName, bikes);
                    branches.add(branch);
                    System.out.println("Showroom added successfully!");
                    break;

                case 2:
                    System.out.print("Enter the branch name: ");
                    String currentbranchName = sc.next();
                    Branches currentbranch = null;
                    for (Branches s : branches) {
                        if (s.getName().equals(currentbranchName)) {
                            currentbranch = s;
                            break;
                        }
                    }
                    if (currentbranch == null) {
                        System.out.println("Branch not found!");
                        break;
                    }

                    System.out.print("Enter the bike name: ");
                    String bikeName = sc.next();
                    System.out.print("Enter the bike price: ");
                    int bikePrice = sc.nextInt();
                    Bike bike = new Bike(bikeName, bikePrice);
                    currentbranch.addBike(bike);
                    System.out.println("Bike added to branch successfully!");
                    break;
                case 3:
                    System.out.print("Enter the branch name: ");
                    currentbranchName = sc.next();
                    currentbranch = null;
                    for (Branches s : branches) {
                        if (s.getName().equals(currentbranchName)) {
                            currentbranch = s;
                            break;
                        }
                    }
                    if (currentbranch == null) {
                        System.out.println("Branch not found!");
                        break;
                    }

                    System.out.print("Enter the bike name to search: ");
                    String searchBikeName = sc.next();
                    Bike searchBike = currentbranch.searchBike(searchBikeName);
                    if (searchBike != null) {
                        System.out.println("Bike found in branch: " + searchBike.getName() + " with price: " + searchBike.getPrice());
                    }
                    break;

                case 4:
                    System.out.print("Enter the branch name: ");
                    currentbranchName = sc.next();
                    currentbranch = null;
                    for (Branches s : branches) {
                        if (s.getName().equals(currentbranchName)) {
                            currentbranch = s;
                            break;
                        }
                    }
                    if (currentbranch == null) {
                        System.out.println("Branch not found!");
                        break;

                    }
                    System.out.print("Enter the bike name to remove: ");
                    String removeBikeName = sc.next();
                    boolean removed = currentbranch.removeBike(removeBikeName);
                    if (!removed) {
                        System.out.println("Bike not found in showroom!");
                        break;
                    }
                    System.out.println("Bike removed from showroom successfully!");
                    break;
                case 5:
                    for (Branches s : branches) {
                        System.out.println("Showroom: " + s.getName());
                        bikes = s.getBikes();
                        if (bikes.isEmpty()) {
                            System.out.println("No bikes in this showroom");
                            continue;
                        }
                        for (Bike b : bikes) {
                            System.out.println("Bike: " + b.getName() + " with price: " + b.getPrice());
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
    }
}



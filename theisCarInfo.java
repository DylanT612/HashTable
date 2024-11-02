/*
I certify, that this computer program submitted by me is all of my own work.
Signed: Dylan Theis 10/11/2024

Author: Dylan Theis 
Date: Fall 2024
Class: CSC420
Project: Car Hashtable
Description: Create a hash table that will hold information about randomly generated Car objects. The
CarInformation (CarInfo) object will have its own hashCode() function.
*/

import java.util.*;

// CarInfo class to hold the car details
class theisCarInfo {
    // Variables
    private String make;
    private String type;
    private Object owner;
    private String licenseState;
    private String licensePlate;

    // Constructor for object
    public theisCarInfo(String make, String type, Object owner, String licenseState, String licensePlate) {
        this.make = make;
        this.type = type;
        this.owner = owner;
        this.licenseState = licenseState;
        this.licensePlate = licensePlate;
    }

    // Hashcode method
    @Override
    public int hashCode() {
        // Combine the license plate and state, and take modulo 100
        // Gives concatenated string numerical value then continuously take out 100 until val of 0-99 left
        return (licensePlate + licenseState).hashCode() % 100;
    }

    // toString that returns object information
    @Override
    public String toString() {
        return owner + " - " + licensePlate + " " + licenseState + " " + make + " " + type;
    }

    // Generate a random car
    public static theisCarInfo generateRandomCar() {
        String[] makes = {"Ford", "Chevy", "Buick", "Jeep", "Honda", "Toyota", "Hyundai", "Kia"};
        String[] types = {"Truck", "Sedan", "SUV", "Coupe", "Van"};
        String[] states = {"MN", "FL", "CA", "TX", "WI", "NY", "ND", "SD"};

        // Load first names from file and place names into a list
        List<String> firstNames = new ArrayList<>(List.of("Mark", "George", "Bob", "Ras", "Alli", "Bruno",
                "Chris", "Koby", "Lucas", "Dylan", "Diego", "Martin", "Victor", "Andre", "Johnny"));
        // Load last names from a file and place names into a list
        List<String> lastNames = new ArrayList<>(List.of("Rash", "Bush", "Lund", "Garnach", "Fernan", "Erik", "Main",
                "Maguire", "Martinez", "Dall", "Shawcross", "Dinho", "Ronaldo", "Lindy", "Evan", "Saka"));

        // Generate names using the firstNames and lastNames from lists
        Set<String> listOfNames = generateNames(firstNames, lastNames, 180);

        Object[] arrayNames = listOfNames.toArray();

        Random rand = new Random();
        String make = makes[rand.nextInt(makes.length)];
        String type = types[rand.nextInt(types.length)];
        Object owner = arrayNames[rand.nextInt(arrayNames.length)];
        String state = states[rand.nextInt(states.length)];
        String plate = generateRandomPlate();

        return new theisCarInfo(make, type, owner, state, plate);
    }

    // Generate random alphanumeric license plate
    private static String generateRandomPlate() {
        // Usable chars
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder plate = new StringBuilder();
        Random rand = new Random();
        // A plate consists of 6 random characters
        for (int i = 0; i < 6; i++) {
            plate.append(chars.charAt(rand.nextInt(chars.length())));
        }
        // Return plate
        return plate.toString();
    }

    // Generate names method
    private static Set<String> generateNames(List<String> firstNames, List<String> lastNames, int numberOfNames) {
        // Make a new set(to avoid duplicates) with our generated names
        Set<String> generatedNames = new HashSet<>();
        Random random = new Random();

        // While our generated names is still less than our required names
        while (generatedNames.size() < numberOfNames) {
            // Select random first name
            String firstName = firstNames.get(random.nextInt(firstNames.size()));
            // Select random last name
            String lastName = lastNames.get(random.nextInt(lastNames.size()));
            // Add first name and last name together in the set as a generated name
            generatedNames.add(firstName + " " + lastName);
        }

        return generatedNames;
    }

}

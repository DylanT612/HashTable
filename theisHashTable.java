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

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Create hashtable class
public class theisHashTable {
    public static void main(String[] args) {
        // Print Information
        System.out.println("Dylan Theis - theisd@csp.edu");
        System.out.println("I certify that this is my own work.");

        // Create hashtable to store car information
        Hashtable<Integer, ArrayList<theisCarInfo>> carTable = new Hashtable<>();

        // Generate 100 car objects
        for (int i = 0; i < 100; i++) {
            // For each index generate random car in car info class
            theisCarInfo car = theisCarInfo.generateRandomCar();
            // Get hashcode for the car
            int hashCode = Math.abs(car.hashCode());

            // If the hash code value already exists, add the car to the list for that index
            carTable.computeIfAbsent(hashCode, key -> new ArrayList<>()).add(car);
        }

        // Since the hashtable is unsorted, sort the Hashtable by using an arraylist and sorting the list
        List<Integer> sortedIndices = new ArrayList<>(carTable.keySet());
        Collections.sort(sortedIndices);

        // Displaying the contents of the Hashtable in sorted order of hash codes
        for (int i = 0; i < 100; i++) {
            // For each index print index
            System.out.println("Index is: " + i);
            // Then if the hashtable also has index
            if (carTable.containsKey(i)) {
                // Print the car info of the index
                for (theisCarInfo car : carTable.get(i)) {
                    System.out.println("\tCar is: " + car);
                }
            }
        }
    }
}

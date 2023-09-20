package phocas;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Parse the NDJSON file and get all people
            People allPeople = NDJSONParser.parseNDJSONFile(".\\jsonfiles\\data.ndjson");
            
            // Create a Country object
            Country country = new Country(allPeople);

            // Create an instance of RetrieveInformation
            RetrieveInformation info = new RetrieveInformation();

            // Find the oldest person
            People oldestPerson = info.getMaxAge(allPeople);
            info.printOldestPerson(oldestPerson);
            System.out.println();

            // Calculate and print the average age
            float averageAge = info.getAverageAge(allPeople);
            System.out.printf("Average Age: %.2f%n", averageAge);
            System.out.println();

            // Print the youngest person per country
            info.printYoungestPersonsByCountry(country);

            // Print the average age per country
            info.printAverageAgeByCountry(country);
            System.out.println();

            // Count of people per age ranges in New Zealand
            String countryName = "New Zealand";
            info.printAgeRangesCount(allPeople, countryName, country);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

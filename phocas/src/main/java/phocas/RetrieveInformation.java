package phocas;

import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.lang.Math;

public class RetrieveInformation {

	People maxAges;
	People minAges;
	
	public People getMaxAge(People allPeople) {
	    int currentMaxAge = 0;
	    maxAges = new People();
	    
	    for (int i = 0; i < allPeople.size(); i++) {
	        int age = allPeople.get(i).getAge();
	        if (age > currentMaxAge) {
	            currentMaxAge = age;
	            maxAges = new People(); // Start fresh when a new higher age is found
	            maxAges.addPerson(allPeople.get(i));
	        } else if (age == currentMaxAge) {
	            maxAges.addPerson(allPeople.get(i)); // Add persons with the same age
	        }
	    }
	    
	    return maxAges;
	}
	
	public People getMinAge(People people) {
		int currentMinAge = 999;
		minAges = new People();

		for (int i = 0; i < people.size(); i++) {
	        int age = people.get(i).getAge();
	        if (age < currentMinAge) {
	            currentMinAge = age;
	            minAges = new People(); // Start fresh when a new lower age is found
	            minAges.addPerson(people.get(i));
	        } else if (age == currentMinAge) {
	            minAges.addPerson(people.get(i)); // Add persons with the same age
	        }
	    }
	    
	    return minAges;		
	}
	
	public float getAverageAge(People allPeople) {
        int sum = 0;
        
        for (Person person : allPeople) { // Directly iterate over the allPeople list
            sum += person.getAge();
        }

        if (allPeople.size() > 0) {
            return (float) sum / allPeople.size();
        } else {
            return -1; // list is empty 
        }
    }
	
	
	public void printOldestPerson(People maxAges) {
		//if one print the oldest person
		//else say more than one person are the same age, then print people
		
		if (maxAges.size() == 1) {
			System.out.println("The oldest person is:");
			maxAges.printAllPeople();
		} else {
			System.out.println("More than one person share the same age. The oldest people are as follows...");
			maxAges.printAllPeople();
		}
	}
	
	
	public void printYoungestPerson(People minAges) {
		//if one print the youngest person
		//else say more than one person are the same age, then print people
		if (minAges.size() == 1) {
			System.out.println("The youngest person is:");
			minAges.printAllPeople();
			System.out.println();

		} else {
			System.out.println("More than one person share the same age. The youngest people are as follows...");
			minAges.printAllPeople();
			System.out.println();
		}
	}
	
	
	public void printYoungestPersonsByCountry(Country country) {
	    // Get all distinct country names from the countryPeopleMap
	    Set<String> countries = country.getAllCountries();

	    for (String countryName : countries) {
	        System.out.println("In " + countryName + ":");
	        
	        // Retrieve the People object for the current country
	        People peopleOfCountry = country.getPeopleByCountry(countryName);
	        
	        // Calculate the youngest age among the people in the current country
	        People minAges = getMinAge(peopleOfCountry);
	        printYoungestPerson(minAges);
	        
	    }
	}
	
	public void printAverageAgeByCountry(Country country) {
	    // Get all distinct country names from the countryPeopleMap
	    Set<String> countries = country.getAllCountries();

	    for (String countryName : countries) {
	        
	        // Retrieve the People object for the current country
	        People peopleOfCountry = country.getPeopleByCountry(countryName);
	        
	        // Calculate the average age for the people in the current country
	        float averageAge = getAverageAge(peopleOfCountry);
	        
	        // Print the average age for the current country
	        System.out.printf("In " + countryName + " the average age is : %.2f%n", averageAge);
	    }
	}
	

	public void printAgeRangesCount(People allPeople, String countryName, Country country) {
	    People peopleOfCountry = country.getPeopleByCountry(countryName);

	    int lowerBound = 0;
	    int incrementAmount = 10;
	    int totalPeople = 0;

	    // Find the maximum age in the country's population
	    int maxAge = 0;
	    for (Person person : peopleOfCountry) {
	        int age = person.getAge();
	        if (age > maxAge) {
	            maxAge = age;
	        }
	    }

	    System.out.println("For country: " + countryName);

	    while (lowerBound <= maxAge) {
	        int upperBound = lowerBound + incrementAmount;
	        int count = 0;

	        for (Person person : peopleOfCountry) {
	            int age = person.getAge();
	            if (age >= lowerBound && age < upperBound) {
	                count++;
	                totalPeople++;
	            }
	        }

	        System.out.println("Count of people in age range " + lowerBound + " => " + upperBound + " is " + count);

	        lowerBound += incrementAmount;
	    }
	    
	    System.out.println("Total people from " + countryName + " is " + totalPeople);
	}
	
}

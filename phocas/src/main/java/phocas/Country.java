package phocas;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;


public class Country {
	
	People allPeople;
    private Map<String, People> countryPeopleMap;
	
    
    // Construct the country object and create a hashmap that stores country: <list of people from country>
	public Country(People allPeople) {
		countryPeopleMap = new HashMap<>();
		
		for (Person person : allPeople) {
			String country = person.getCountry();
			People peopleInCountry = countryPeopleMap.get(country);
			
			if (peopleInCountry == null) {
				peopleInCountry = new People();
				countryPeopleMap.put(country, peopleInCountry);
			}
			
			peopleInCountry.addPerson(person);
		}
	}
	
	// Returns the list of people that are from a country by searching for the designated country
    public People getPeopleByCountry(String country) {
        return countryPeopleMap.get(country);
    }

    // Get all distinct country names
    public Set<String> getAllCountries() {
        return countryPeopleMap.keySet();
    }
}

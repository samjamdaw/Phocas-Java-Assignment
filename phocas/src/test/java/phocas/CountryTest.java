package phocas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;

public class CountryTest {

    private Country country;
    private People allPeople;

    @Before
    public void setUp() {
        // Create sample Person objects
        Person person1 = new Person("John", "Doe", "USA", 30);
        Person person2 = new Person("Jane", "Smith", "Canada", 25);
        Person person3 = new Person("Alice", "Johnson", "USA", 28);

        allPeople = new People();
        allPeople.addPerson(person1);
        allPeople.addPerson(person2);
        allPeople.addPerson(person3);

        country = new Country(allPeople);
    }

    @Test
    public void testGetPeopleByCountry() {
        // Retrieve the People for a specific country
        People usaPeople = country.getPeopleByCountry("USA");
        People canadaPeople = country.getPeopleByCountry("Canada");
        People nzPeople = country.getPeopleByCountry("New Zealand");

        // Check if People for USA are not null and contain the expected results
        assertNotNull(usaPeople);
        assertTrue(usaPeople.size() > 0);
        assertTrue(usaPeople.get(0).getCountry().equals("USA"));

        // Check if People for Canada are not null and contain the expected results
        assertNotNull(canadaPeople);
        assertTrue(canadaPeople.size() > 0);
        assertTrue(canadaPeople.get(0).getCountry().equals("Canada"));

        // Check if People for nz are null
        assertNull(nzPeople);
    }

    @Test
    public void testGetAllCountries() {
        // Get all distinct country names from the Country object
        Set<String> countries = country.getAllCountries();

        // Check if the set of countries contains the expected country names
        assertTrue(countries.contains("USA"));
        assertTrue(countries.contains("Canada"));
        assertTrue(!countries.contains("New Zealand"));
    }
}


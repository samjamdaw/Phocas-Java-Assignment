package phocas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RetrieveInformationTest {

    private RetrieveInformation retrieveInformation;
    private People testPeople;
    private Country testCountry;

    @Before
    public void setUp() {
        // Initialize objects for testing
        retrieveInformation = new RetrieveInformation();
        testPeople = new People();
        testCountry = new Country(testPeople);

        testPeople.addPerson(new Person("Alice", "Smith", "New Zealand", 30));
        testPeople.addPerson(new Person("Bob", "Sanchez", "Brazil", 25));
        testPeople.addPerson(new Person("Charlie", "Lee", "Korea", 28));
    }

    @Test
    public void testGetMaxAge() {
        People maxAges = retrieveInformation.getMaxAge(testPeople);
        assertEquals(30, maxAges.get(0).getAge()); // The oldest should be 30 
    }

    @Test
    public void testGetMinAge() {
        People minAges = retrieveInformation.getMinAge(testPeople);
        assertEquals(25, minAges.get(0).getAge()); // The youngest should be 25 
    }

    @Test
    public void testGetAverageAge() {
        float averageAge = retrieveInformation.getAverageAge(testPeople);
        assertEquals(27.67, averageAge, 0.01); // Approximate average age (rounded to two decimal places)
    }

}

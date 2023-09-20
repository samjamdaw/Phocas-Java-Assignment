package phocas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class PeopleTest {

    private People people;

    @Before
    public void setUp() {
        // Initialize the People object before each test
        people = new People();
    }

    @Test
    public void testAddPerson() {
        Person person = new Person("John", "Doe", "USA", 30);

        people.addPerson(person);

        // Check if the size of People has increased
        assertEquals(1, people.size());
    }

    @Test
    public void testGetPerson() {
        // Create sample Person objects
        Person person1 = new Person("John", "Doe", "USA", 30);
        Person person2 = new Person("Jane", "Smith", "Canada", 25);

        people.addPerson(person1);
        people.addPerson(person2);

        // Check if we can retrieve the first person
        assertEquals(person1, people.get(0));

        // Check if we can retrieve the second person
        assertEquals(person2, people.get(1));
    }

    @Test
    public void testIterator() {
        // Create sample Person objects
        Person person1 = new Person("John", "Doe", "USA", 30);
        Person person2 = new Person("Jane", "Smith", "Canada", 25);

        // Add the persons to the People object
        people.addPerson(person1);
        people.addPerson(person2);

        // Initialize an iterator
        Iterator<Person> iterator = people.iterator();

        // Check if the iterator has the first person
        assertTrue(iterator.hasNext());
        assertEquals(person1, iterator.next());

        // Check if the iterator has the second person
        assertTrue(iterator.hasNext());
        assertEquals(person2, iterator.next());

        // Ensure there are no more elements
        assertTrue(!iterator.hasNext());
    }
}


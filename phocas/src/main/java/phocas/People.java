package phocas;

import java.util.ArrayList;
import java.util.Iterator;

public class People implements Iterable<Person>{
	
	ArrayList<Person> allPeople;
	
	public People() {
        allPeople = new ArrayList<>();
    }
	

	// Prints all people in a nicer format. I opted to keep firstName/lastName descriptors for more detail
	public void printAllPeople() {
        for (Person person : allPeople) {
            System.out.println("First Name: " + person.getfName()
            + ", Last Name: " + person.getlName()
            + ", Country: " + person.getCountry()
            + ", Age: " + person.getAge());
        }
    }
	
	
	public Person get(int i) {
		return allPeople.get(i);
	}
	
	public int size() {
		return allPeople.size();
	}

	
	public void addPerson(Person person) {
		allPeople.add(person);
	}
	
    // Implement the Iterable interface by providing an iterator
    public Iterator<Person> iterator() {
        return allPeople.iterator();
    }

}

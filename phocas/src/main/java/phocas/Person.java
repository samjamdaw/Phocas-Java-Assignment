package phocas;

public class Person {
	String fName;
	String lName;
	String country;
	int age;
	
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAge() {
		return age;
	}
	public Person() {
		// To allows construction without any attributes
	}
	
	// Constructor for JUnit testing
	public Person(String fName, String lName, String country, int age) {
		this.fName = fName;
		this.lName = lName;
		this.country = country;
		this.age = age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
    @Override
    public String toString() {
        return "Person{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                '}' + "\n"; // Add a newline character at the end
    }
}

package phocas;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NDJSONParser {

    public static People parseNDJSONFile(String filePath) throws IOException {
        // Create an ObjectMapper to read JSON data
        ObjectMapper objectMapper = new ObjectMapper();
               
    	People allPeople = new People();

        // Open the NDJSON file for reading
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse each line as a JSON object
                JsonNode jsonNode = objectMapper.readTree(line);
                
                String firstName = jsonNode.get("firstName").asText();
                String lastName = jsonNode.get("lastName").asText();
                String country = jsonNode.get("country").asText();
                int age = jsonNode.get("age").asInt();
                
                Person person = new Person();
                person.setfName(firstName);
                person.setlName(lastName);
                person.setCountry(country);
                person.setAge(age);

                allPeople.addPerson(person);

            }
        }
        return allPeople;
    }
}


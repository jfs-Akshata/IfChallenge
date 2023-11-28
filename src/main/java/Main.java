import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;


public class Main {

    public static void main(String[] args) throws FileNotFoundException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        try {

            // JSON file to Java object

            // JSON string to Java object
            IfStatement staff2 = mapper.readValue(new File("a2.json"), IfStatement.class);
            String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff2);

            System.out.println(prettyStaff1);


        } catch (IOException e) {
            e.printStackTrace();
        }






    }
}

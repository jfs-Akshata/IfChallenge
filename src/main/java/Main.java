import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/**
 * The Main class of the application.
 * This class is responsible for loading a JSON representation of an IfStatement,
 * evaluating it, and printing the result.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            IfStatement ifStatement = mapper.readValue(new File("condition.json"), IfStatement.class);
            boolean result = ifStatement.evaluate("abc", 2);
            System.out.println("Result: " + result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

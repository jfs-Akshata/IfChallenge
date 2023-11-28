import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Scanner;

/**
 * The Main class of the application.
 * This class is responsible for loading a JSON representation of an IfStatement,
 * evaluating it, based on default value or user input value and printing the result.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, JsonProcessingException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to use the default values? (y/n)");
        String useDefault = scanner.nextLine().trim().toLowerCase();

        String a = "abc";
        int b = 2;

        if (!useDefault.equals("y")) {
            System.out.println("Enter value for 'a' (string):");
            a = scanner.nextLine();

            System.out.println("Enter value for 'b' (integer):");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter an integer value for 'b':");
                scanner.next();
            }
            b = scanner.nextInt();
        }

        ObjectMapper mapper = new ObjectMapper();

        try {
            IfStatement ifStatement = mapper.readValue(new File("condition.json"), IfStatement.class);
            boolean result = ifStatement.evaluate(a, b);
            System.out.println("Result: " + result);

        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}


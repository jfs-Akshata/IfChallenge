
# Logical Expression Evaluator

## Overview

This Java project is designed to evaluate logical expressions defined in JSON format. It utilizes the Jackson library for JSON processing to convert JSON data into Java objects. The core functionality revolves around evaluating if-else statements based on the conditions specified in the JSON file.

## Features

- Parses JSON representations of logical expressions.
- Evaluates if-else statements with support for binary and logical operators.


## JSON Format
The project uses a specific JSON format to represent logical expressions. Here are some examples:

- Simple if else statement
```agsl
{
  "condition": {
    "binaryExpression": {
      "operator": "==",
      "left": { "identifier": { "name": "a" } },
      "right": { "literal": { "value": "abc" } }
    }
  },
  "consequent": { "value": true },
  "alternates": [
    { "consequent": { "value": false } }
  ]
}
```

- Nested if-else Statement
```agsl
{
  "condition": { /* condition */ },
  "consequent": { /* consequent */ },
  "alternates": [
    {
      "condition": { /* another condition */ },
      "consequent": { /* consequent */ },
      "alternates": [ /* further nesting */ ]
    }
  ]
}
```

- Representing below if else statements into `IfChallenge/condition.json`

```agsl
   if(a=="abc" && b>4)
        then 
            true
   else
        if(b<10)
            then 
                true
   else 
        false
```

## Design and Data Structure
The project consists of data structure :

- IfStatement and Alternates: Represents an if-else statement.
- Condition: Represents a condition in the if-else statement.
- BinaryExpression and LogicalExpression: Handle the evaluation of binary and logical conditions.
- Identifier and Literal: Represent parts of an expression.

## Prerequisites

To run this project, you need:

- Java JDK 8 or higher.
- Maven for dependency management and building the project.

## Installation

1. **Clone the Repository**

    ```
    git clone [https://github.com/jfs-Akshata/IfChallenge.git]
    ```

2. **Navigate to the Project Directory**

    ```
    cd [IfChallenge]
    ```

3. **Build the Project with Maven**

    ```
    mvn clean install
    ```

   This command will compile the project and download the necessary dependencies.

## Usage

1. **Define Your Logical Expression**

   Edit the `condition.json` file to define your logical expression. The file should be structured according to the expected JSON format for logical expressions.

2. **Run the Application**

   After building the project, you can run the application using the following command:

    ```
    java -jar target/IfElse-1.0-SNAPSHOT.jar
    ```

   Or compile .java `javac JavaFileName.java` file and run 
   ```agsl
      java Main
   ```
   

3. **View the Result**

   The evaluation result of your logical expression will be printed in the console.

## References

- https://help.eclipse.org/latest/index.jsp?topic=%2Forg.eclipse.jdt.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fjdt%2Fcore%2Fdom%2FASTParser.html
- https://astexplorer.net/
- https://github.com/fkling/astexplorer
- https://www.jointjs.com/demos/abstract-syntax-tree
- https://stackoverflow.com/questions/16127985/what-is-javascript-ast-how-to-play-with-it?rq=4
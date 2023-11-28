
# Logical Expression Evaluator

## Overview

- This Java project is designed to evaluate logical expressions defined in JSON format.
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
- The logical expression, following an Abstract Syntax Tree (AST) reference, has been formatted into JSON and stored in a file named `condition.json`.
- It utilizes the Jackson library for JSON processing to convert JSON data into Java objects. 
- The core functionality revolves around evaluating if-else statements based on the conditions specified in the JSON file.

## Features

- Parses JSON representations `condition.json` of logical expressions.
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

This project is composed of several key components that work together to represent and evaluate logical expressions typically found in programming languages:

### IfStatement and Alternates

- **IfStatement**: Represents an 'if' statement within a logical expression. It contains a condition that is evaluated to either true or false. Based on this evaluation, the `IfStatement` dictates the flow of logic, determining whether to execute the 'then-part' or the 'else-part' of the statement.
- **Alternates**: These are the 'else-if' and 'else' components of an if-else statement structure. They are evaluated if the main `IfStatement` condition evaluates to false. This mechanism allows for chaining multiple if-else conditions together, with the last alternate often representing the final 'else' block, executed if all previous conditions are false.

### Condition

- Represents a single condition within an if-else statement. It might be a simple comparison (like checking if a variable equals a certain value) or a more complex expression involving multiple operands and operators, which are handled by `BinaryExpression` and `LogicalExpression`.

### BinaryExpression and LogicalExpression

- **BinaryExpression**: Manages conditions involving two operands with a binary operator, such as `a > b` or `a == b`. The operands can be variables, literals, or more complex expressions.
- **LogicalExpression**: Handles logical operations that involve one or more conditions, typically using logical operators like AND (`&&`) and OR (`||`). An example could be an expression like `(a > b) && (c < d)`.

### Identifier and Literal

- **Identifier**: Typically a variable name or placeholder in an expression. For instance, in `a > 5`, 'a' is an identifier whose value is determined at runtime.
- **Literal**: Represents constant values in expressions. Unlike identifiers, literals do not change. For example, in `a == 10`, '10' is a literal.

### Summary

These components provide a structured and hierarchical approach to parsing and understanding the logic defined in a given expression, enabling the representation and evaluation of complex logical expressions found in programming languages.

## Prerequisites

To run this project, you need:

- Java JDK 8 or higher.
- Maven for dependency management and building the project.

## Installation

1. **Clone the Repository**

    ```
    git clone https://github.com/jfs-Akshata/IfChallenge.git
    ```

2. **Navigate to the Project Directory**

    ```
    cd IfChallenge
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
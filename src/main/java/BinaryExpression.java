import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.BiPredicate;

/**
 * Represents a binary expression in a logical or arithmetic context.
 * Supports various operators like ==, <, >, <=, >=, and !=.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
class BinaryExpression {
    private String operator;
    private Expression left;
    private Expression right;

    /**
     * Evaluates the binary expression based on the operator and the values of the left and right expressions.
     *
     * @param a The string value for variable 'a', if used in the expression.
     * @param b The integer value for variable 'b', if used in the expression.
     * @return The result of the binary expression evaluation.
     */
    public boolean evaluate(String a, int b) {
        Object leftValue = left.evaluate(a, b);
        Object rightValue = right.evaluate(a, b);

        if (leftValue == null || rightValue == null) {
            return false;
        }

        // Equality
        if ("==".equals(operator)) {
            return leftValue.equals(rightValue);
        }
        // Less than
        else if ("<".equals(operator)) {
            return compareNumbers(leftValue, rightValue, (x, y) -> x < y);
        }
        // Greater than
        else if (">".equals(operator)) {
            return compareNumbers(leftValue, rightValue, (x, y) -> x > y);
        }
        // Less than or equal to
        else if ("<=".equals(operator)) {
            return compareNumbers(leftValue, rightValue, (x, y) -> x <= y);
        }
        // Greater than or equal to
        else if (">=".equals(operator)) {
            return compareNumbers(leftValue, rightValue, (x, y) -> x >= y);
        }
        // Not equal
        else if ("!=".equals(operator)) {
            return !leftValue.equals(rightValue);
        }

        return false; // Default return for unrecognized operators
    }

    /**
     * Compares two numeric values based on a given comparator.
     *
     * @param leftValue   The value from the left-hand side expression.
     * @param rightValue  The value from the right-hand side expression.
     * @param comparator  A BiPredicate representing the comparison operation.
     * @return The result of the comparison.
     */
    private boolean compareNumbers(Object leftValue, Object rightValue, BiPredicate<Integer, Integer> comparator) {
        if (leftValue instanceof Integer && rightValue instanceof Integer) {
            return comparator.test((int) leftValue, (int) rightValue);
        }
        return false; // Return false if there is a type mismatch
    }
}
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a condition in a logical expression.
 * A condition can be either a binary expression or a logical expression.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
class Condition {
    // A binary expression representing a condition, e.g., a > 5
    private BinaryExpression binaryExpression;

    // A logical expression representing a condition, e.g., a > 5 && b < 10
    private LogicalExpression logicalExpression;

    /**
     * Evaluates the condition based on the contained binary or logical expression.
     *
     * @param a The string value for variable 'a', if used in the condition.
     * @param b The integer value for variable 'b', if used in the condition.
     * @return The result of the condition evaluation.
     */
    public boolean evaluate(String a, int b) {

        if (binaryExpression != null) {
            return binaryExpression.evaluate(a, b);
        } else if (logicalExpression != null) {
            return logicalExpression.evaluate(a, b);
        }
        return false;
    }
}
